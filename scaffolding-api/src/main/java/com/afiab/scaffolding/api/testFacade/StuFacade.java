package com.afiab.scaffolding.api.testFacade;


import com.afiab.scaffolding.api.common.R;
import com.afiab.scaffolding.api.constants.Swagger2Config;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/7/25 14:53
 * @Description: 对外业务接口
 */
@Api(tags = {Swagger2Config.OPEN_API})
@RequestMapping("/open")
public interface StuFacade {

    @ApiOperation(value = "测试对外接口demo") //  接口标记 ,tags = {Swagger2Config.OPEN_API}
    @GetMapping("/test/stu")
    R<List<String>> queryStu(@RequestParam(value = "name",required = false) String name);
}
