package com.fanfanfan.yygh.hosp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fanfanfan.yygh.common.result.R;
import com.fanfanfan.yygh.hosp.service.HospitalSetService;
import com.fanfanfan.yygh.hosp.utils.MD5;
import com.fanfanfan.yygh.model.hosp.Hospital;
import com.fanfanfan.yygh.model.hosp.HospitalSet;

import com.fanfanfan.yygh.vo.hosp.HospitalSetQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * <p>
 * 医院设置表 前端控制器
 * </p>
 * @author fanfanfan
 */
@CrossOrigin
@RestController
@Api(tags = "医院设置接口")
@RequestMapping("/admin/hosp/hospital-set")
public class HospitalSetController {
    @Autowired
    private HospitalSetService hospitalSetService;
    /**
     * 查询所有*
     * */
    @ApiOperation(value = "查询所有医院设置信息")
    @GetMapping("findAll")
    public R findAll() {
        List<HospitalSet> list = hospitalSetService.list();
        return R.ok().data("list",list);
    }
    /**
     * 删除
     * */
    @DeleteMapping("{id}")
    @ApiOperation(value = "根据医院设置id删除医院设置信息")
    public R removeById(@ApiParam(name = "id", value = "讲师ID", required = true)  @PathVariable String id){
         hospitalSetService.removeById(id);
         return R.ok();
    }
    /**
     * 分页
     * */
    @ApiOperation(value = "分页医院设置列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit){

        Page<HospitalSet> pageParam = new Page<>(page, limit);

        hospitalSetService.page(pageParam, null);
        List<HospitalSet> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }
    @ApiOperation(value = "带查询条件的医院设置分页信息")
    @PostMapping("{page}/{limit}")
    public R getHospitalSetPage(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable long page,
            @ApiParam(name = "limit", value = "每页显示几条", required = true)
            @PathVariable long limit,
            @ApiParam(name = "hospitalSetQueryVo", value = "封装查询条件Object", required = false)
            @RequestBody HospitalSetQueryVo hospitalSetQueryVo){

        Page pageParam= new Page(page,limit);
        QueryWrapper<HospitalSet> queryWrapper=new QueryWrapper<HospitalSet>();

        if(!StringUtils.isEmpty(hospitalSetQueryVo.getHosname())){
            queryWrapper.like("hosname",hospitalSetQueryVo.getHosname());
        }
        if(!StringUtils.isEmpty(hospitalSetQueryVo.getHoscode())){
            queryWrapper.eq("hoscode",hospitalSetQueryVo.getHoscode());
        }
        hospitalSetService.page(pageParam, queryWrapper);
        return R.ok().data("total",pageParam.getTotal()).data("rows",pageParam.getRecords());
    }
    /**
     * 新增save
     * */
    @ApiOperation(value = "新增医院设置")
    @PostMapping("saveHospSet")
    public R save(
            @ApiParam(name = "hospitalSet", value = "医院设置对象", required = true)
            @RequestBody HospitalSet hospitalSet){
        //设置状态 1 使用 0 不能使用
        hospitalSet.setStatus(1);
        //签名秘钥
        Random random = new Random();
        hospitalSet.setSignKey(MD5.encrypt(System.currentTimeMillis()+""+random.nextInt(1000)));
        hospitalSetService.save(hospitalSet);
        return R.ok();
    }
    /**
     * 根据id查询
     * */
    @ApiOperation(value = "根据ID查询医院设置")
    @GetMapping("getHospSet/{id}")
    public R getById(
            @ApiParam(name = "id", value = "医院设置ID", required = true)
            @PathVariable String id){
        HospitalSet my = hospitalSetService.getById(id);
        return R.ok().data("item",my);
    }
    /**
     * 根据id修改
     * */
    @ApiOperation(value = "根据ID修改医院设置")
    @PostMapping("updateHospSet")
    public R updateById(@ApiParam(name = "hospitalSet", value = "医院设置对象", required = true)
                        @RequestBody HospitalSet hospitalSet){
        hospitalSetService.updateById(hospitalSet);
        return R.ok();
    }
    /**
     *批量删除
     * */
    @ApiOperation(value = "批量删除医院设置")
    @DeleteMapping("batchRemove")
    public R batchRemoveHospitalSet(@RequestBody List<Long> idList) {
        hospitalSetService.removeByIds(idList);
        return R.ok();
    }
    /**
     * 锁定与解锁
     * */
    @ApiOperation(value = "医院设置锁定和解锁")
    @PutMapping("lockHospitalSet/{id}/{status}")
    public R lockHospitalSet(@PathVariable Long id,
                             @PathVariable Integer status) {
        //根据id查询医院设置信息
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        //设置状态
        hospitalSet.setStatus(status);
        //调用方法
        hospitalSetService.updateById(hospitalSet);
        return R.ok();
    }
}

