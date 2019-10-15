package com.hou;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CxProcessEnum {

    LDSR("CX_LDSR", "轮对收入"),
    XCJD("CX_XCJD", "测量及修程鉴定"),
    CZCT("CX_ZCTX", "车轴穿透"),
    CLXX("CX_CLXX", "车轮镟修"),
    LDDJ("CX_LDFJ", "轮对分解"),
    JZJX("CX_JZJX", "旧轴加修"),
    JZLZJJG("CX_JZLZJJG", "旧轴轮座精加工"),
    XZSR("CX_XZSR", "新轴收入"),
    XZBJJG("CX_XZBJJG", "新轴半精加工"),
    XZJJG("CX_XZJJG", "新轴精加工"),
    CZCXMX("CX_CZCXMX", "车轴成型磨削"),
    LZMX("CX_LZMX", "轮座磨削"),
    ZJJC("CX_ZJJC", "中间检查"),
    CZCFTS("CX_CZCFTS", "车轴磁粉探伤"),
    CCCL("CX_CCCL", "车轴尺寸测量"),
    LDZZ("CX_LDZZ", "轮对组装"),
    LDCFTS("CX_LDCFTS", "轮对磁粉探伤"),
    LDZCPX("CX_LDCZCPX", "轮对支出偏心"),
    LDCCJC("CX_LDCCJC", "轮对尺寸检测"),
    LDLCQZ("CX_LDLCQZ", "轮对落成签章"),
    ZCXP("CX_ZCXP", "轴承选配"),
    ZCYZ("CX_ZCYZ", "轴承压装"),
    ZCMH("CX_ZCMH", "轴承磨合"),
    LZJG("CX_LZJG", "轮轴竣工"),
    LZZC("CX_LZZC", "轮轴支出"),
    CZDBF("CX_CZDBF","车轴待报废"),
    CZBF("CX_CZBF","车轴报废");

    private String processId;   //流程标识
    private String description; //流程说明


    public static String getDescription(String name) {
        return CxProcessEnum.valueOf(name).description;
    }

}