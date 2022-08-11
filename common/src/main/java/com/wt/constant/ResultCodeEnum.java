package com.wt.constant;

/**
 * 返回枚举
 */
public enum ResultCodeEnum {
    SUCCESS("200","SUCCESS"),
    ERROR("500","ERROR"),

    /* 权限校验失败 */
    INVALID_TOKEN("400","令牌无效"),
    USER_TOKEN_EXPIRED("401","token过期,请重新登陆"),
    USER_NO_PERMISSION("403","抱歉,您没有权限访问"),
    USER_NO_ROLE("403","用户没有访问权限"),
    USER_DOES_NOT_EXIST("450","用户不存在"),
    USER_PASSWORD_ERROR("451","用户名或密码错误"),


    ;
    private String code;

    private String mes;




    ResultCodeEnum(String code, String mes){
        this.code=code;
        this.mes=mes;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
