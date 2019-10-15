package com.controller;

import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;

public class GoodsReq extends BaseInfoRequest {

    @ApiParam(name = "goodsType", value = "商品类别", required = true)
    @NotNull
    private Integer goodsType;

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    @Override
    public String toString() {
        return "GoodsReq{" +
                "goodsType=" + goodsType +
                '}';
    }
}