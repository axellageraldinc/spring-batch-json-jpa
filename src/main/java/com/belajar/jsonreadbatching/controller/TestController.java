package com.belajar.jsonreadbatching.controller;

import com.belajar.jsonreadbatching.model.Person;
import com.belajar.jsonreadbatching.service.person.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/person")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private PersonService personService;

    @RequestMapping(
            value = "/dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> getAllDummyPerson(){
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setId("Ax");
        person.setName("Axell");
        person.setAge(20);
        personList.add(person);
        Person person1 = new Person();
        person1.setId("Rd");
        person1.setName("Radit");
        person1.setAge(21);
        personList.add(person1);
        Person person2 = new Person();
        person2.setId("Km");
        person2.setName("Komang");
        person2.setAge(20);
        personList.add(person2);
        return personList;
    }

    @RequestMapping(
            value = "/batch",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Map testJobLauncher() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        return personService.executeBatch();
    }

    @RequestMapping(
            value = "/real",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> getAllRealPerson(){
        return personService.getAllPerson();
    }

}
