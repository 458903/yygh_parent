package com.fanfanfan.yygh.hosp.controller.admin;

import com.fanfanfan.yygh.common.result.R;
import com.fanfanfan.yygh.hosp.service.HospitalService;
import com.fanfanfan.yygh.vo.hosp.HospitalQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags =  "医院接口")
@RestController
@RequestMapping("/admin/hosp/hospital")
@CrossOrigin
public class HospitalController {

    //注入service
    @Autowired
    private HospitalService hospitalService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public R index(@PathVariable Integer page, @PathVariable Integer limit, HospitalQueryVo hospitalQueryVo) {
        //调用方法
        return R.ok().data("pages",hospitalService.selectPage(page, limit, hospitalQueryVo));
    }
}