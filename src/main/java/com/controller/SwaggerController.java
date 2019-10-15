package com.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description Swagger的使用
 * @Author
 * @Date 2019-09-27 11:39
 * @Version 1.0
 */
@Controller
@RequestMapping("/index")
@Api(value="商业化接口",tags = "接口信息",description = "商业相关接口")
public class SwaggerController {

}
