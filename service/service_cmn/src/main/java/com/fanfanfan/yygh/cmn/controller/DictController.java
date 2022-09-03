package com.fanfanfan.yygh.cmn.controller;


import com.fanfanfan.yygh.cmn.service.DictService;
import com.fanfanfan.yygh.common.result.R;
import com.fanfanfan.yygh.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 组织架构表 前端控制器
 * </p>
 *
 * @author fanfanfan
 * @since 2022-09-02
 */
@CrossOrigin
@Api(tags = "字典设置接口")
@RestController
@RequestMapping("/admin/cmn")
public class DictController {
    @Autowired
    private DictService dictService;

    //根据数据id查询子数据列表
    @ApiOperation(value = "根据数据id查询子数据列表")
    @GetMapping("findChildData/{id}")
    public R findChildData(@PathVariable Long id) {
        List<Dict> list = dictService.findChlidData(id);
        return R.ok().data("list",list);
    }

    @ApiOperation(value="导出")
    @GetMapping(value = "/exportData")
    public void exportData(HttpServletResponse response) {
        dictService.exportData(response);
    }
    @ApiOperation(value = "导入")
    @PostMapping("importData")
    public R importData(MultipartFile file) {
        dictService.importDictData(file);
        return R.ok();
    }
}

