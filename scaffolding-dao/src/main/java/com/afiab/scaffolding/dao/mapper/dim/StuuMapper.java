package com.afiab.scaffolding.dao.mapper.dim;


import com.afiab.scaffolding.dao.core.mapper.BaseMapper;
import com.afiab.scaffolding.dao.entity.StuuPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 13:54
 * @Description:
 */
@Mapper
@Repository
public interface StuuMapper extends BaseMapper<StuuPO> {
}
