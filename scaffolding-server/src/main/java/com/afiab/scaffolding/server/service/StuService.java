package com.afiab.scaffolding.server.service;


import com.afiab.scaffolding.api.dto.response.StuRespDTO;

import java.util.List;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 15:20
 * @Description:
 */
public interface StuService {
    // 测试接口
    List<String> getUserName();

    List<StuRespDTO> getUsers();
}
