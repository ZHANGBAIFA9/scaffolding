package com.afiab.scaffolding.server.service.convert.qualifier;

import com.afiab.scaffolding.dao.entity.StuPO;
import com.alibaba.fastjson.JSON;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 15:39
 * @Description: mapstruct 特殊转换方法声明
 */
@Named("ExtendMapper")
@Component("ExtendMapper")
public class ExtendMapper {

    // list 转 json
    @Named("translatorStr")
    public String translatorStr(StuPO stu) {
        if (null == stu) {
            return null;
        }
        List<String> stus = new ArrayList<>();
        stus.add(stu.getName());
        stus.add(stu.getCreatedBy());
        return JSON.toJSONString(stus);
    }
}
