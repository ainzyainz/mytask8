package DAO;

import myPerson.Person;

import java.util.List;

public interface DAOPerson extends DAO<Person> {
    List<Person> findMoreThanAge(int value);
}
