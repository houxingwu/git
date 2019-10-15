package com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.PrintWriter;

@Controller
@RequestMapping("api/business/")
@Api(value="商业化接口",tags = "接口信息")
public class BusinessController {

    @RequestMapping(value = "goods_info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "获取商品信息", httpMethod = "GET",response = GoodsDto.class)
    public GoodsDto getDeskTopInfo(PrintWriter out, @Valid @ApiParam(value = "params", required = true) GoodsReq req, BindingResult bindingResult) throws Exception {
        GoodsDto goodsDto = new GoodsDto();
        if (bindingResult.hasErrors()) {
            goodsDto.setGoodsId(2);
            goodsDto.setGoodsName("上好佳");
        } else {
            goodsDto.setGoodsId(1);
            goodsDto.setGoodsName("浪味仙");
        }
        return  goodsDto;
    }
}