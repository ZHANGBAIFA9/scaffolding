package com.afiab.scaffolding.dao.core.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 13:18
 * @Description:
 */
public abstract class BaseDao implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 创建者
     */
    private String createdBy;

    /**
     * 创建时间
     */
    @Column(insertable = false, updatable = false)
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    /**
     * 更新者
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    @Column(insertable = false, updatable = false)
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdatedAt;

    public Long getId() {
        return id;
    }

    public BaseDao setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public BaseDao setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getCreateAt() {
        return createdAt;
    }

    public BaseDao setCreateAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public BaseDao setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public BaseDao setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
        return this;
    }
}

