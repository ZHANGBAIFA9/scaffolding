package com.afiab.scaffolding.api.enums;


import com.afiab.scaffolding.api.common.CodeManager;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 11:09
 * @Description:
 */
public enum BusinessEnumCode {

    HEADER_INFO_NOT_FOUND("777", "头部信息缺失", "头部信息缺失"),
    UNKNOW_ERROR("888", "未知错误"),
    UNKNOW_EXCEPTION("999","未知异常"),

    ;


    private String code;
    /**
     * 提示给前端的信息
     */
    private String message;

    private String info;

    BusinessEnumCode(String code, String message) {
        this.code = CodeManager.SystemCode.CODE_RD + CodeManager.SubSystemCode.CODE_RD_SUB + code;
        this.message = message;
    }

    BusinessEnumCode(String code, String message,String info) {
        this.code = CodeManager.SystemCode.CODE_RD + CodeManager.SubSystemCode.CODE_RD_SUB + code;
        this.message = message;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "BusinessEnumCode{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
