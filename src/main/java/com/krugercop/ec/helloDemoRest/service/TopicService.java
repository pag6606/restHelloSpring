package com.krugercop.ec.helloDemoRest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krugercop.ec.helloDemoRest.dao.TopicRepository;
import com.krugercop.ec.helloDemoRest.model.Topic;

@Service
public class TopicService {

	@Autowired
	TopicRepository repository;

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		repository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		return repository.findById(id).get();
	}

	public boolean addTopic(Topic topic) {
		repository.save(topic);
		return true;
	}

	public void updateTopic(Topic topic) {
		repository.save(topic);
	}

	public void deleteTopic(String id) {
		repository.deleteById(id);
	}

}
