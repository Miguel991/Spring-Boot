package com.hmc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hmc.model.Person;
import com.hmc.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
	
	private static final Log log = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Juan",45));
		people.add(new Person("Jose",34));
		people.add(new Person("Antonio",23));
		people.add(new Person("Maria",12));
		log.info("Hello from getlistpeople()");
		
		return people;
	}

}
