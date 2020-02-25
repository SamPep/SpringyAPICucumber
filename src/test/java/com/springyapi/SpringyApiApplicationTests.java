package com.springyapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringyApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void returnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect((content().string(containsString("Welcome to the SpringyAPI!"))));
	}

	@Test
	public void returnUsers() throws Exception {
		this.mockMvc.perform(get("/users"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void returnUserCity() throws Exception {
		this.mockMvc.perform(get("/users/london"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void returnUserCityRadius() throws Exception {
		this.mockMvc.perform(get("/users/london-radius"))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
