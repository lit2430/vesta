package com.vesta.common.parse;

import com.alibaba.fastjson2.JSONObject;
import com.vesta.common.domain.ApiThreadLocal;
import com.vesta.common.enums.ErrorCodeEnum;
import com.vesta.common.enums.HttpRequestEnum;
import com.vesta.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;


@Slf4j
public class ApiParseParam {


    /**
     * parse api  request params
     *
     * @param request
     * @param
     * @return
     */

    public static void parse(HttpServletRequest request) {
        Map<String, Object> result = null;
        String requestURI = request.getRequestURI();
        String method = request.getMethod().toLowerCase(Locale.ROOT);
        HttpRequestEnum enums = HttpRequestEnum.getMethodEnum(method);
        if (enums == null) {
            throw new ApiException(ErrorCodeEnum.FAIL, "Api http request method not found.");
        }
        switch (enums) {
            case GET:
                GetParseParam getInstance = GetParseParam.getInstance();
                result = getInstance.parse(request);
                break;
            case POST:
                PostParseParam postInstance = PostParseParam.getInstance();
                result = postInstance.parse(request);
                break;
            case PUT:
                PutParseParam putInstance = PutParseParam.getInstance();
                result = putInstance.parse(request);
                break;
        }
        ApiThreadLocal apiThreadLocal = new ApiThreadLocal(requestURI, result);
        apiThreadLocal.set();
    }


    abstract static class ParseParam {
        public abstract <T> Map<String, T> parse(HttpServletRequest request);
    }


    static class GetParseParam extends ParseParam {
        private GetParseParam() {
        }

        private static GetParseParam getClass = null;

        public static GetParseParam getInstance() {
            if (getClass == null) {
                getClass = new GetParseParam();
            }
            return getClass;
        }

        /**
         * parse get request params
         *
         * @param request
         * @param <T>
         * @return
         */
        @Override
        public <T> Map<String, T> parse(HttpServletRequest request) {
            Map<String, T> paramMap = new HashMap<>();
            if (request == null) {
                return paramMap;
            }
            Enumeration<String> paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String key = paramNames.nextElement();
                String value = request.getParameter(key);
                paramMap.put(key, (T) value);
            }
            return paramMap;
        }
    }


    static class PostParseParam extends ParseParam {
        private PostParseParam() {
        }

        private static PostParseParam postClass = null;

        public static PostParseParam getInstance() {
            if (postClass == null) {
                postClass = new PostParseParam();
            }
            return postClass;
        }


        /**
         * parse post request params
         *
         * @param request
         * @param <T>
         * @return
         */
        @Override
        public <T> Map<String, T> parse(HttpServletRequest request) {
            Map<String, T> paramMap = new HashMap<>();
            if (request == null) {
                return paramMap;
            }
            try {
                String paramsStr = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
                JSONObject paramObj = JSONObject.parseObject(paramsStr);
                Set<String> keySet = paramObj.keySet();
                for (String key : keySet) {
                    paramMap.put(key, (T) paramObj.get(key));
                }
            } catch (IOException e) {
                log.error("Lacus api post params parse error.");
                e.printStackTrace();
            }
            return paramMap;
        }
    }


    static class PutParseParam extends ParseParam {
        private PutParseParam() {
        }

        private static PutParseParam putClass = null;

        public static PutParseParam getInstance() {
            if (putClass == null) {
                putClass = new PutParseParam();
            }
            return putClass;
        }


        /**
         * parse put request params
         *
         * @param request
         * @param <T>
         * @return
         */
        @Override
        public <T> Map<String, T> parse(HttpServletRequest request) {
            PostParseParam postParseParam = PostParseParam.getInstance();
            return postParseParam.parse(request);
        }
    }


}
