package com.afiab.scaffolding.api.common.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/15 13:54
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LogMessage {
    // 消息推送
    private String msg ;
}
