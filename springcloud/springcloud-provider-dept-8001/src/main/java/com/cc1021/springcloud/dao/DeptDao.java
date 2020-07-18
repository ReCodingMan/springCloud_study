package com.cc1021.springcloud.dao;

import com.cc1021.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public class DeptDao {

    public boolean addDept(Dept dept);

    public Dept queryById(long id);

    public List<Dept> queryAll();

}
