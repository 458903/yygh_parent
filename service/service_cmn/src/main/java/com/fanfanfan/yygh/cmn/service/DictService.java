package com.fanfanfan.yygh.cmn.service;

import com.fanfanfan.yygh.model.cmn.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 组织架构表 服务类
 * </p>
 *
 * @author fanfanfan
 * @since 2022-09-02
 */
public interface DictService extends IService<Dict> {
    //根据数据id查询子数据列表
    List<Dict> findChlidData(Long id);
    /**
     * 导出
     * @param response
     */
    void exportData(HttpServletResponse response);
    void importDictData(MultipartFile file);
}
