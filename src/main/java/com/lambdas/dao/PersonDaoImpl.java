package com.lambdas.dao;

import com.lambdas.model.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addPerson(Person person) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(person);
        tx.commit();
        session.close();
    }

    @Override
    public Person getPerson(String email) {
        Session session = sessionFactory.openSession();

        Person person = (Person)session.createQuery("from Person p where p.email = :email")
                .setParameter("email", email)
                .uniqueResult();
        session.close();
        return person;
    }

    @Override
    public List<Person> getPersons() {
        Session session = sessionFactory.openSession();
        List<Person> personList = session.createQuery("from Person p").list();
        session.close();
        return personList;
    }
}
