package com.vesta.common.enums;


public enum DriverTypeEnum {


    MYSQL("MYSQL", "mysql"),
    DORIS("DORIS", "doris");

    private String name;
    private String desc;


    DriverTypeEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }
}
