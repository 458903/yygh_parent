package com.fanfanfan.yygh.hosp.repository;

import com.fanfanfan.yygh.model.hosp.Department;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DepartmentRepository extends MongoRepository<Department,String> {
    Department getDepartmentByHoscodeAndDepcode(String hoscode, String depcode);


}