package com.afiab.scaffolding.dao.mapper.metadata;


import com.afiab.scaffolding.dao.core.mapper.BaseMapper;
import com.afiab.scaffolding.dao.entity.StuPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 13:14
 * @Description:
 */
@Mapper
@Repository
public interface StuMapper extends BaseMapper<StuPO> {
}
