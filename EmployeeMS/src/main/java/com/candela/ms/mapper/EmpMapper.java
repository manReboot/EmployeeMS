package com.candela.ms.mapper;

import com.candela.ms.bean.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmpMapper {

    @Select("select * from Employee where ID = #{id}")
    Employee findId(int id);

    @Insert("insert into EMPLOYEE(NAME,POSITION) VALUES(#{name}, #{position})")
    boolean insert(Employee employee);

    @Update("update EMPLOYEE set NAME=#{name}, POSITION=#{post}")
    boolean update(Employee employee);
}
