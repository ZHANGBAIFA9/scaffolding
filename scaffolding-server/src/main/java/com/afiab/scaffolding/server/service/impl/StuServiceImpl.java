package com.afiab.scaffolding.server.service.impl;

import com.afiab.scaffolding.api.dto.response.StuRespDTO;
import com.afiab.scaffolding.dao.mapper.metadata.StuMapper;
import com.afiab.scaffolding.server.service.StuService;
import com.afiab.scaffolding.server.service.convert.StuConvert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 15:21
 * @Description:
 */
@Service
public class StuServiceImpl implements StuService {

    private final StuMapper stuMapper;
    private final StuConvert stuConvert ;

    public StuServiceImpl(StuMapper stuMapper,
                          StuConvert stuConvert) {
        this.stuMapper = stuMapper;
        this.stuConvert = stuConvert ;
    }

    @Override
    public List<String> getUserName() {
        return stuConvert.convertResps(stuMapper.selectAll()).stream()
//                .filter(stu -> {
//                    return stu.equals("tom");
//                })
                .map(stu->stu.getName())
                .collect(Collectors.toList());

    }

    @Override
    public List<StuRespDTO> getUsers() {
        return stuConvert.convertResps(stuMapper.selectAll());
    }
}
