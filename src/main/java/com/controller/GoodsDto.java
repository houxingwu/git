package com.controller;

import com.alibaba.fastjson.annotation.JSONType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JSONType(orders={"goodsId","goodsName"})
//表示对类进行说明，用于参数用实体类接收
@ApiModel(value = "goods",description = "商品信息")
public class GoodsDto {

    @ApiModelProperty(value = "商品ID",name = "goods_id")
    private Integer goodsId;
    /**
     * @ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改
     */
    @ApiModelProperty(value = "商品名称",name = "goods_name")
    private String goodsName;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public String toString() {
        return "GoodsDto{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }
}