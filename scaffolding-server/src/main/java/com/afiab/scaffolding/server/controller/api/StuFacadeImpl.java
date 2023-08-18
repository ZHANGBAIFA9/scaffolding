package com.afiab.scaffolding.server.controller.api;

import com.afiab.scaffolding.api.common.R;
import com.afiab.scaffolding.api.common.annotation.NoneAuth;
import com.afiab.scaffolding.api.testFacade.StuFacade;
import com.afiab.scaffolding.server.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 15:19
 * @Description:
 */
@Slf4j
@RestController
public class StuFacadeImpl implements StuFacade {

    private StuService stuService;
    public StuFacadeImpl(StuService stuService) {
        this.stuService = stuService;
    }

    @NoneAuth
    @Override
    public R<List<String>> queryStu(String name) {
        return R.success(stuService.getUserName());
    }
}
