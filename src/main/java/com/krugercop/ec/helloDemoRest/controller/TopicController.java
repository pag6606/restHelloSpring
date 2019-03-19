package com.krugercop.ec.helloDemoRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krugercop.ec.helloDemoRest.model.Topic;
import com.krugercop.ec.helloDemoRest.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	TopicService service;
	//reg expression 
	@GetMapping("/{id:[\\d]+}")
	public Topic getTopic(@PathVariable String id) {
		return service.getTopic(id);
	}
	@GetMapping(path="/topic", produces="application/xml")
	public Topic getTopicXML(String id) {
		return service.getTopic(id);
	}
	
	@PostMapping
	public String addTopic(@RequestBody Topic topic) {
		service.addTopic(topic);
		return "Topic added:"+ topic.toString();
	}
	
	@PutMapping
	public String updateTopic(@RequestBody Topic topic) {
		service.updateTopic(topic);
		return "Topic updated";
	}
	
	@DeleteMapping
	public String deleteTopic(@RequestParam String id ) {
		service.deleteTopic(id);
		return "Topic deleted";
	}
}
