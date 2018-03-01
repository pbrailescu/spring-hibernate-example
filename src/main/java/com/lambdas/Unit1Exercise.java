package com.lambdas;

import com.lambdas.configuration.ExerciseConfiguration;
import com.lambdas.dao.PersonDao;
import com.lambdas.dao.PersonDaoImpl;
import com.lambdas.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Unit1Exercise {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExerciseConfiguration.class);
        PersonDao personDao = context.getBean(PersonDao.class);
        Person person = new Person("Petrut", "Brailescu", "petrutbrailescu@gmail.com");
        personDao.addPerson(person);

        System.out.println(personDao.getPerson("petrutbrailescu@gmail.com"));

    }
}
