package com.controller;

import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BaseInfoRequest {

    @ApiParam(name = "version", value = "接口版本号", defaultValue = "1.0", required = true, allowableValues = "1.0")
    @Pattern(regexp = "1.0", message = "version filed must equal 1.0")
    protected String version;

    @ApiParam(name = "format", value = "接口响应格式[json,jsonp]", required = true, defaultValue = "json", allowableValues = "json,jsonp")
    @NotNull
    protected String format;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "BaseInfoRequest{" +
                "version='" + version + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}