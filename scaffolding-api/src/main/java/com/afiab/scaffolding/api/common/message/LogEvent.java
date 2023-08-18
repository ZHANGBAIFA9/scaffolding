package com.afiab.scaffolding.api.common.message;

import lombok.Data;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/15 14:39
 * @Description:
 */
@Data
public class LogEvent {
    /**
     * 事件ID
     */
    private String eventId;

    /**
     * 请求事件时间戳
     */
    private Long eventTimestamp;

    /**
     * 请求URI
     */
    private String eventURI;

    /**
     * 所属应用编码
     */
    private String appCode;

    /**
     * 请求IP
     */
    private String eventIP;

    /**
     * 请求方法 GET POST PATCH DELETE
     */
    private String eventMethod;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * http 请求头
     */
    private Object header;

    /**
     * 请求信息
     */
    private Object request;

    /**
     * 接口返回信息
     */
    private Object response;


    /**
     * 错误信息
     */
    private Object error;

    /**
     * 额外信息 一般不做传输
     */
    private Object extension;
}
