package com.candela.ms.service;

import com.candela.ms.bean.Employee;
import com.candela.ms.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmpService {

    @Autowired
    EmpMapper empMapper;

    public Employee getEmployeer(String id)
    {
        return empMapper.findId(Integer.parseInt(id));
    }

    public Employee insertEmployee(Employee employee){
        boolean flag =  empMapper.insert(employee);
        employee.setOperation(false);
        return employee;
    }

    public Employee updateEmployee(Employee employee){
        boolean flag =  empMapper.update(employee);
        employee.setOperation(false);
        return employee;
    }

}
