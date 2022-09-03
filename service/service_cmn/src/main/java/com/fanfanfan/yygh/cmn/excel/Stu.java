package com.fanfanfan.yygh.cmn.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Stu {
    //设置表头名称
    @ExcelProperty("学生编号")
    private int sno;

    //设置表头名称
    @ExcelProperty("学生姓名")
    private String sname;
}
