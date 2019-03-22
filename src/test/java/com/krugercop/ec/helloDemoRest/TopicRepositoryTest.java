package com.krugercop.ec.helloDemoRest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.krugercop.ec.helloDemoRest.dao.TopicRepository;
import com.krugercop.ec.helloDemoRest.model.Topic;
/*
@RunWith(SpringRunner.class)
@DataJpaTest
public class TopicRepositoryTest {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	TopicRepository topicRepository;

	@Test
	public void testSaveTopic() {
		Topic topic = new Topic("300", "C#", "Learn Microsoft Framework");
		Topic savedInDb = entityManager.persist(topic);
		Topic fromDB = topicRepository.findById("3").get();
		assertThat(fromDB).isEqualTo(savedInDb);
	}
	
	@Test
	public void testTopicById() {
		Topic topic = new Topic("100", "ReactJS", "Learn Facebook Framework");
		Topic savedInDb = entityManager.persist(topic);
		Topic fromDB = topicRepository.findById("1").get();
		assertThat(fromDB).isEqualTo(savedInDb);
	}
	
	
}
*/
