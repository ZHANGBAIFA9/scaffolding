package com.afiab.scaffolding.dao.core.entity;

import tk.mybatis.mapper.annotation.LogicDelete;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 13:19
 * @Description:
 */
public class DeleteableDao extends BaseDao {
    @LogicDelete
    private Integer isDel;

    public Integer getIsDel() {
        return isDel;
    }

    public DeleteableDao setIsDel(Integer isDel) {
        this.isDel = isDel;
        return this;
    }
}
