package com.afiab.scaffolding.server.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.Log;
/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 14:18
 * @Description: 重写 CustomSlf4jImpl 屏蔽trace日志，防止日志干扰
 */
@Slf4j
public class CustomSlf4jImpl implements Log{
    public CustomSlf4jImpl(String clazz) {
        // Do Nothing
    }

    @Override
    public boolean isDebugEnabled() {
        return true;

    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void error(String s, Throwable e) {
        log.error(s, e);
    }

    @Override
    public void error(String s) {
        log.error(s);
    }

    @Override
    public void debug(String s) {
        //提升debug等级，sql至少要打印出来，方便问题定位
        log.info(s);
    }

    @Override
    public void trace(String s) {
        log.trace(s);
    }

    @Override
    public void warn(String s) {
        log.warn(s);
    }
}
