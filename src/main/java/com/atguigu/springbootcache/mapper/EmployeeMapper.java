package com.atguigu.springbootcache.mapper;

import com.atguigu.springbootcache.bean.Employee;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Case;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Repository;

@Repository
//@EnableCaching //在接口定义没用，只能在实现/结果类上面使用！
public interface EmployeeMapper {


    @Select("select * from employee where Id=#{id}")
    Employee getEmpById(Integer id);

    @Delete("delete from employee where id=#{id}")
    void delEmpById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    void updateEmpById(Employee employee);

    @Insert("insert into employee(lastName, email, gender, d_id)  values(#{lastName},#{email},#{gender},#{dId}) ")
    void insertEmp(Employee employee);


}
