package com.afiab.scaffolding.server.service.impl;

import com.afiab.scaffolding.api.common.message.LogMessage;
import com.afiab.scaffolding.server.service.MessageService;
import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.springframework.util.concurrent.ListenableFutureCallback;
/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/15 16:31
 * @Description:
 */
@Slf4j
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Value("${kafka.config.kafkaTopic}")
    private String kafkaTopic ;

    @Override
    public void sendMessageSync(String topic, Object msg) {
        String finalTopic = initKafkaTopic(topic);
        send(finalTopic,msg);
    }

    public void send(String topic,Object msg){
        log.info("SEND topic:{}, eventBody:{}",topic, msg);
        try {
            kafkaTemplate.send(topic, toJson(msg)).get(10, TimeUnit.SECONDS);
        } catch (Throwable throwable) {
            log.error("消息推送异常: Message: {}, Cause: {}", throwable.getMessage(), throwable.getCause());
        }
    }

    private String initKafkaTopic(String topic){
       return Objects.equals(topic,null)? kafkaTopic : topic ;
    }

    private String toJson(Object msg) {
        String eventBody = JSON.toJSONString(msg);
        return JSON.toJSONString(new LogMessage(eventBody));
    }


    @Override
    public void sendMessageAsync(String topic, Object msg) {
        String finalTopic = initKafkaTopic(topic);
        log.info("SEND topic:{}, eventBody:{}",finalTopic, msg);
        kafkaTemplate.send(finalTopic, toJson(msg))
                .addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("MessageServiceImpl.send消息发送失败 topic:[{}] msg:[{}]", finalTopic, msg, ex);
            }
            @Override
            public void onSuccess(Object result) {
                // todo: log
            }
        });
    }
}
