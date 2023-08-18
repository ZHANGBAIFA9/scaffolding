package com.afiab.scaffolding.server.service;

import java.util.concurrent.ExecutionException;

import java.util.concurrent.TimeoutException;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/15 16:29
 * @Description:
 */
public interface MessageService {
    /**
     * 同步消息推送
     * @param topic
     * @param msg
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws TimeoutException
     */
    void sendMessageSync(String topic, Object msg);

    /**
     * 异步消息发送
     * @param topic
     * @param msg
     */
    void sendMessageAsync(String topic, Object msg);

}
