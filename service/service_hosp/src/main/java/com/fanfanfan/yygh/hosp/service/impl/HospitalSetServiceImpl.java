package com.fanfanfan.yygh.hosp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fanfanfan.yygh.common.exception.YyghException;
import com.fanfanfan.yygh.hosp.repository.HospitalRepository;
import com.fanfanfan.yygh.model.hosp.Hospital;
import com.fanfanfan.yygh.model.hosp.HospitalSet;
import com.fanfanfan.yygh.hosp.mapper.HospitalSetMapper;
import com.fanfanfan.yygh.hosp.service.HospitalSetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 医院设置表 服务实现类
 * </p>
 *
 * @author fanfanfan
 * @since 2022-08-29
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {

    @Autowired
    private HospitalSetMapper hospitalSetMapper;



    @Override
    public String getSignKey(String hoscode) {
        QueryWrapper<HospitalSet> hospitalSetQueryWrapper = new QueryWrapper<>();
        hospitalSetQueryWrapper.eq("hoscode",hoscode);
        HospitalSet hospital=hospitalSetMapper.selectOne(hospitalSetQueryWrapper);
        if (null==hospital){
          throw new YyghException(20001,"失败");
      }
      return hospital.getSignKey();
    }


}
