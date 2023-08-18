package com.afiab.scaffolding.api.dto.response;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 15:37
 * @Description:
 */
@Data
public class StuRespDTO implements Serializable {
    @ApiModelProperty(value = "主键id")
    private Long id;
    @ApiModelProperty(value = "名字")
    private String name;
    @ApiModelProperty(value = "stuJson形式")
    private String stuJson ;
    @ApiModelProperty(value = "创建人code")
    private String createdBy;
    @ApiModelProperty("创建时间")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    @ApiModelProperty(value = "更新人")
    private String updatedBy;
    @ApiModelProperty("更新时间")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    @ApiModelProperty("数据库更新时间")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdatedAt;
}
