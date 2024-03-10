package DAO;

import myPerson.Person;
import utils.Const;
import utils.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonDaoImpl implements DAOPerson {

    private EntityManager entityManager;

    @Override
    public Person save(Person person) {
        startTransaction();
        entityManager.persist(person);
        finishTransaction();
        return person;
    }

    @Override
    public boolean delete(int id) {
        startTransaction();
        Person objectToRemove = entityManager.find(Person.class, id);
        if (null == objectToRemove) {
            finishTransaction();
            return false;
        }
        entityManager.remove(objectToRemove);
        finishTransaction();
        return true;
    }

    @Override
    public Person update(Person person) {
        startTransaction();
        entityManager.merge(person);
        finishTransaction();
        return person;
    }

    @Override
    public Person read(int id) {
        startTransaction();
        Person result = entityManager.find(Person.class, id);
        finishTransaction();
        return result;
    }

    @Override
    public List<Person> findMoreThanAge(int value) {
        startTransaction();
        Query query = entityManager.createNativeQuery(Const.SELECT_BY,Person.class);
        query.setParameter(1, value);
        List<Person> result = query.getResultList();
        finishTransaction();
        return result;
    }

    public void startTransaction(){
        entityManager = HibernateUtils.getEntityManager();
        entityManager.getTransaction().begin();
    }
    public void finishTransaction(){
        entityManager.getTransaction().commit();
    }
}
