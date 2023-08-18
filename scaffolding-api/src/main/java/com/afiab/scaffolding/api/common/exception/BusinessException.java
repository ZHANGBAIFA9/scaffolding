package com.afiab.scaffolding.api.common.exception;


import com.afiab.scaffolding.api.enums.BusinessEnumCode;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 11:09
 * @Description:
 */
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = -3593919652547622028L;
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BusinessEnumCode getBusinessEnumCode() {
        return businessEnumCode;
    }

    public void setBusinessEnumCode(BusinessEnumCode businessEnumCode) {
        this.businessEnumCode = businessEnumCode;
    }

    /**
     * 提示给前端的信息
     */
    private BusinessEnumCode businessEnumCode;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(BusinessEnumCode code) {
        super(code.getMessage());
        this.businessEnumCode = code;
    }

    public BusinessException(BusinessEnumCode code, String tipData) {
        super(code.getMessage());
        this.businessEnumCode = code;
        this.message = tipData;
    }

    public BusinessException(BusinessEnumCode code, Throwable cause) {
        super(code.getMessage(),cause);
        this.businessEnumCode = code;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    protected BusinessException(String message, Throwable cause,
                                boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
