package com.belajar.jsonreadbatching.service.person;

import com.belajar.jsonreadbatching.model.Person;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import java.util.List;
import java.util.Map;

public interface PersonService {
    Person savePerson(Person person);
    List<Person> getAllPerson();
    Person getPersonById(String id);
    Person updatePerson(String id, Person newPersonData);
    Person deletePerson(String id);
    Map executeBatch() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException;
}
