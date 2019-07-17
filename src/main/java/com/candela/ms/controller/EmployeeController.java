package com.candela.ms.controller;

import com.candela.ms.bean.Employee;
import com.candela.ms.mapper.EmpMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ms/empservice")
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private EmpMapper empMapper;

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") String empid)
    {
        Employee emp = new Employee();
        ResponseEntity response = null;

        if( empid !=null && !empid.trim().equals(""))
        {
            emp = empMapper.findId(Integer.parseInt(empid));
            response =  new ResponseEntity(emp, HttpStatus.OK);
        }

        else
        {
            response = new ResponseEntity(emp, HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PostMapping("/insert")
    public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee)
    {
        ResponseEntity response = null;

        try
        {
            if(employee !=null )
            {
                logger.info("Inserting the record " + employee.toString());
                boolean flag = empMapper.insert(employee);
                employee.setOperation(flag);
                response = new ResponseEntity(employee,HttpStatus.OK);
                logger.info("update the record "+ employee.toString());
            }
        }
        catch(Exception ex)
        {
            logger.error("Failed to insert " + employee.toString());
            logger.error("Exception",ex);
        }

        return response;
    }

    @PostMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
        ResponseEntity response = null;

        try
        {
            if(employee !=null )
            {
                logger.info("Inserting the record " + employee.toString());
                boolean flag = empMapper.insert(employee);
                employee.setOperation(flag);
                response = new ResponseEntity(employee,HttpStatus.OK);
                logger.info("update the record "+ employee.toString());
            }
        }
        catch(Exception ex)
        {
            logger.error("Failed to insert " + employee.toString());
            logger.error("Exception",ex);
        }

        return response;
    }

}
