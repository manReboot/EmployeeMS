package com.candela.ms.controller;

import com.candela.ms.bean.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ApiGateWay extends RouteBuilder  {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json);

        rest("/get").get("/{id}")
                .param().name("id").required(true).endParam()
               .to("bean:com.candela.ms.service.EmpService?method=getEmployeer(${header.id})").outType(Employee.class);

              rest().post("/insert").type(Employee.class)
                .to("bean:com.candela.ms.service.EmpService?method=insertEmployee");
  }
}
