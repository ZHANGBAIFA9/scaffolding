package com.afiab.scaffolding.server.controller;


import com.afiab.scaffolding.api.common.R;
import com.afiab.scaffolding.api.common.annotation.RequestLog;
import com.afiab.scaffolding.api.common.response.PageRespDTO;
import com.afiab.scaffolding.api.constants.Swagger2Config;
import com.afiab.scaffolding.api.dto.response.StuRespDTO;
import com.afiab.scaffolding.server.service.StuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 15:09
 * @Description:
 */
@Slf4j
@Api(tags = {Swagger2Config.TEST_API})
@RestController
@RequestMapping("/test")
public class TestController {

    private final StuService stuService;

    public TestController(StuService stuService) {
        this.stuService = stuService;
    }

    @RequestLog
    @ApiOperation(value = "测试接口")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public R<PageRespDTO<List<StuRespDTO>>> listStu() {
        return R.success(stuService.getUsers());
    }
}
