package com.atguigu.springbootcache.service;

import com.atguigu.springbootcache.bean.Employee;
import com.atguigu.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "emp1")//缓存公共配置抽取
@EnableCaching //需要手动加这个注解才开启缓存
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;


    //缓存数据
    @Cacheable(value = "emp1",key = "#id")
    public Employee getEmpSingle(Integer id){
        System.out.println("service(getEmpSingle)模块执行了");
        Employee empById = employeeMapper.getEmpById(id);
        return empById;
    }

    //执行方法，更新缓存
    @CachePut(value = "emp1"/*,key = "#employee.id"*/)
    public Employee updateEmpSingle(Employee employee){
        System.out.println("更新数据");
        employeeMapper.updateEmpById(employee);
        return employee;
    }
    //清除数据 allEntries = true 清空所有缓存
    @CacheEvict(value = "emp1"/*,key = "#id"*/ /*,allEntries = true*/)
    public void delEmp(Integer id){
        System.out.println("清除缓存");
//        employeeMapper.delEmpById(id);
    }



}
