package com.fanfanfan.yygh.cmn.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class test {
    private static List<Stu> data() {
        List<Stu> list = new ArrayList<Stu>();
        for (int i = 0; i < 10; i++) {
            Stu data = new Stu();
            data.setSno(i);
            data.setSname("张三"+i);
            list.add(data);
        }
        return list;
    }
    public static void main(String[] args) throws Exception {
        // 写法1
        String fileName = "F:\\11.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Stu.class).sheet("写入方法一").doWrite(data());
    }
}
