package com.krugercop.ec.helloDemoRest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krugercop.ec.helloDemoRest.model.Topic;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloDemoRestApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestIntegration {

	@LocalServerPort
	int port;

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	public void testGetTopicById() throws JsonProcessingException {
		String uri = "/topic/2";
		String jsonTopic = mapToJson(new Topic("2", "HTML5", "New HTML features updated"));
		String jsonResponse = restTemplate.getForObject(formFullURLWithPort(uri),String.class);
		assertThat(jsonResponse).isEqualTo(jsonTopic);
		
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
	private String formFullURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
