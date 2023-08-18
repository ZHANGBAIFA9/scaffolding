package com.afiab.scaffolding.api.common.message;

import java.io.Serializable;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 11:14
 * @Description:
 */
public class MessageSendResult implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private boolean isSuccess;
    private String messageId;
    private String errorMessage;
    public boolean isSuccess() {
        return isSuccess;
    }
    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
    public String getMessageId() {
        return messageId;
    }
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
