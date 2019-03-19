package com.krugercop.ec.helloDemoRest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.krugercop.ec.helloDemoRest.model.Topic;
import com.krugercop.ec.helloDemoRest.service.TopicService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloDemoRestApplicationTests {

	@Autowired
	TopicService service;

	@Test
	public void testAllTopics() {
		List<Topic> topic = service.getAllTopics();
		System.out.println(topic);
		assertEquals(2, topic.size());
	}

	@Test
	public void testGetTopic() {
		Topic topic = service.getTopic("2");
		assertEquals("HTML5", topic.getName());
	}

	@Test
	public void testAddTopic() {
		service.addTopic(new Topic("99", "HTML5", "Learn new features"));
		
		service.deleteTopic("99");
		List<Topic> list = service.getAllTopics();
		assertEquals(2, list.size());
	}
	
	@Test
	public void testUpdateTopic() {
		Topic topic = service.getTopic("1");
		topic.setDescription("Learn in depth the details and get certified");
		service.updateTopic(topic);
		List<Topic> list = service.getAllTopics();
		assertEquals("Learn in depth the details and get certified", list.get(1).getDescription());
	}
	
	@Test
	public void testDeleteTopic() {
		service.addTopic(new Topic("100", "Spring", "learn new features"));
		service.deleteTopic("100");
		List<Topic> list = service.getAllTopics();
		assertEquals(2, list.size());
	}


}
