package com.krugercop.ec.helloDemoRest.dao;

import org.springframework.data.repository.CrudRepository;

import com.krugercop.ec.helloDemoRest.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>{

}
