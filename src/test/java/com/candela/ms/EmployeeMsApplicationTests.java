package com.candela.ms;

import com.candela.ms.bean.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeMsApplicationTests {

    @Autowired
	private MockMvc mockMvc;

	@DisplayName("Test get the record the json object")
	@Test(timeout=10000)
	public void getRecord()
	{
		try
		{
			mockMvc.perform(
					MockMvcRequestBuilders
					.get("/ms/empservice/get/2")
					.accept(MediaType.APPLICATION_JSON_UTF8))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("JACK"));
		}

		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail("There is unexpected excception");
		}
	}

	@DisplayName("Test to do insert")
	@Test(timeout = 10000)
	public void insertRecord()
	{
		Employee employee = new Employee("Kalai123","Test Position");

		try
		{
            mockMvc.perform(
                    MockMvcRequestBuilders
			.post("/ms/empservice/insert")
			.accept(MediaType.APPLICATION_JSON_UTF8)
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.content(new ObjectMapper().writeValueAsString(employee)))
			.andDo(print())
			.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.operation")
			.value(true));

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail("There is unexpected excception");
		}
	}

	@DisplayName("Test to do update")
	@Test(timeout = 10000)
	public void updateRecord()
	{
		Employee employee = new Employee("1", "TestInsert123","Test Position");

		try
		{
		    mockMvc.perform(
			MockMvcRequestBuilders
					.post("/ms/empservice/update")
					.accept(MediaType.APPLICATION_JSON_UTF8)
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(new ObjectMapper().writeValueAsString(employee)))
			.andDo(print())
			.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.operation")
			.value(true));

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Assert.fail("There is unexpected excception");
		}
	}



}
