package com.afiab.scaffolding.api.common.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 11:15
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseReqDto implements Serializable {

    protected Long id;
    /**
     * 操作人：默认系统登录人
     */
    protected Long creater;

    /**
     * 启用,禁用(0启用，1禁用)
     */
    protected Long disabled;

    /**
     * 修改时间
     */
    protected Date modifyTime;

    protected String remark;

    @Override
    public String toString() {
        return "BaseDto{" +
                "id=" + id +
                ", creater=" + creater +
                ", disabled=" + disabled +
                ", modifyTime=" + modifyTime +
                ", remark='" + remark + '\'' +
                '}';
    }

}
