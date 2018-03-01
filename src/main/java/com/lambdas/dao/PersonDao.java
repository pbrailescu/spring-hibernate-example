package com.lambdas.dao;

import com.lambdas.model.Person;

import java.util.List;

public interface PersonDao {
    void addPerson(Person person);
    Person getPerson(String email);
    List<Person> getPersons();
}
