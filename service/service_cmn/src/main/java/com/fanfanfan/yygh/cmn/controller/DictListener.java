package com.fanfanfan.yygh.cmn.controller;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fanfanfan.yygh.cmn.mapper.DictMapper;
import com.fanfanfan.yygh.model.cmn.Dict;
import com.fanfanfan.yygh.vo.cmn.DictEeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DictListener extends AnalysisEventListener<DictEeVo> {

    @Autowired
    private DictMapper dictMapper;

    //一行一行读取
    @Override
    public void invoke(DictEeVo dictEeVo, AnalysisContext analysisContext) {
        //调用方法添加数据库
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictEeVo,dict);

        QueryWrapper<Dict> queryWrapper = new QueryWrapper<Dict>();
        queryWrapper.eq("id", dict.getId());
        Integer count = dictMapper.selectCount(queryWrapper);

        if(count>0){
            dictMapper.updateById(dict);
        }else{
            dictMapper.insert(dict);
        }
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}