package com.afiab.scaffolding.api.common.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 11:34
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageReqDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int DEFAULT_PAGE_INDEX = 1;
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int MAX_PAGE_SIZE = 9999;
    /**
     * 起始页
     */
    @ApiModelProperty(value = "起始页")
    private int pageIndex = 1;
    /**
     * 每页条数
     */
    @ApiModelProperty(value = "每页条数")
    private int pageSize;
    /**
     * 偏移量
     */
    @ApiModelProperty(value = "偏移量")
    private int offset;

    public int getPageIndex() {
        return this.pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getOffset() {
        return this.offset;
    }
}
