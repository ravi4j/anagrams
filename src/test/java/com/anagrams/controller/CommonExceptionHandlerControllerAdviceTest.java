package com.anagrams.controller;

import com.anagrams.service.IAnagramService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CommonExceptionHandlerControllerAdviceTest {

	private static final String URL_PREFIX = "/anagrams/";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IAnagramService service;


	@Test
	public void whenNoHandlerForHttpRequest_thenNotFound() throws Exception {
		String url = URL_PREFIX + "/a";
		this.mockMvc.perform(get(url)).andDo(print()).andExpect(status().isNotFound()).andExpect(
				content().string(containsString("No handler found for ")));
	}

	@Test
	public void whenServerInternalErrorForHttpRequest_thenInternalError() throws Exception {
		doThrow(new RuntimeException("Exception...")).when(service).isAnagram(anyString() , anyString());
		String url = URL_PREFIX + "/string/string";
		this.mockMvc.perform(get(url)).andExpect(status().isInternalServerError()).andExpect(
				content().string(containsString("Exception...")));
	}

}
