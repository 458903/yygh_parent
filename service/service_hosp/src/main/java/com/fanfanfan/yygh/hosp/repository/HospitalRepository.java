package com.fanfanfan.yygh.hosp.repository;

import com.fanfanfan.yygh.model.hosp.Hospital;

import com.fanfanfan.yygh.model.hosp.HospitalSet;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HospitalRepository extends MongoRepository<Hospital,String> {

    Hospital getHospitalByHoscode(String hoscode);
}