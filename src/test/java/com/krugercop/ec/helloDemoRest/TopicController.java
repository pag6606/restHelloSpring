package com.krugercop.ec.helloDemoRest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.krugercop.ec.helloDemoRest.model.Topic;
import com.krugercop.ec.helloDemoRest.service.TopicService;

@RunWith(SpringRunner.class)
@WebMvcTest(com.krugercop.ec.helloDemoRest.controller.TopicController.class)
public class TopicController {
	
	@Autowired
	MockMvc mock;

	@MockBean
	TopicService service;

	
	/**
	 * 
	 * Test with mockito MVC architecture 
	 */
	@Test
	public void getTopicWithId() throws Exception {
		Mockito.when(service.getTopic("1")).thenReturn(new Topic("1", "Core Java", "Learn in depth the details and get certified"));
		 
		MvcResult result =  mock.perform(get("/topic/1")).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}
	
	@Test
	public void postTopicWith() throws Exception {
		String content = "{"+
				 "\"id\": \"1\","+
				    "\"name\": \"Core Java\"," +
				    "\"description\": \"Learn in depth the details and get certified\" }";
	
		Mockito.when(service.addTopic(new Topic("1","Angular", "Learn the web UI"))).thenReturn(true);
		MvcResult result =  mock.perform(post("/topic").contentType(MediaType.APPLICATION_JSON).
							content(content)).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}
}
