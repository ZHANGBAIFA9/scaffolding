package com.afiab.scaffolding.server.aop;


import com.afiab.scaffolding.api.common.message.LogEvent;
import com.afiab.scaffolding.server.service.MessageService;
import com.afiab.scaffolding.server.utils.HttpProxyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/15 11:21
 * @Description:
 */
@Slf4j
@Aspect
@Component
public class LogAOPAspect {
    @Autowired
    private HttpServletRequest bindRequest;
    @Autowired
    private MessageService messageService;

    @Pointcut("@annotation(com.afiab.scaffolding.api.common.annotation.RequestLog) && ("+
            "@annotation(org.springframework.web.bind.annotation.RequestMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PatchMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping))")
    private void method() {
    }

    @Around("method()")
    public Object after(ProceedingJoinPoint joinPoint) {
        LogEvent logEvent = new LogEvent();
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();

            logEvent.setEventId(UUID.randomUUID().toString());
            logEvent.setEventTimestamp(System.currentTimeMillis());
            logEvent.setAppCode(System.getProperty("APP_CODE"));

            HashMap<String, Object> request = new HashMap<>(8);
            Object[] args = joinPoint.getArgs();
            Method method = signature.getMethod();
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                Object arg = args[i];
                request.put(parameter.getName(), arg);
            }
            logEvent.setRequest(request);
            //获取返回对象
            Object response = joinPoint.proceed();
            try {
                httpServletRequestHandler(logEvent, bindRequest);
            } catch (Throwable ignore) {
            }
            logEvent.setResponse(response);
            return response;
        } catch (Throwable ignore) {

        } finally {
            // 发送消息
            messageService.sendMessageAsync(null,logEvent);
        }
        return null;
    }

    /**
     * 内聚 request 处理
     *
     * @param logEvent
     * @param bindRequest
     */
    private static void httpServletRequestHandler(
            LogEvent logEvent, HttpServletRequest bindRequest) {

        logEvent.setEventURI(bindRequest.getRequestURI());
        logEvent.setEventIP(HttpProxyUtil.getIpAddress(bindRequest));
        logEvent.setEventMethod(bindRequest.getMethod());

        Enumeration<String> headerNames = bindRequest.getHeaderNames();
        HashMap<String, String> headers = new HashMap<>(16);
        while (headerNames.hasMoreElements()) {
            String element = headerNames.nextElement();
            headers.put(element, bindRequest.getHeader(element));
        }
        logEvent.setHeader(headers);
        String userCode = headers.get("usercode");
        logEvent.setUserCode(userCode != null ? userCode : headers.get("userCode"));

    }

}
