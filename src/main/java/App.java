import myPerson.Person;
import DAO.PersonDaoImpl;
import utils.Const;
import utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtils.getEntityManager();

        Person personMoreThan24 = Person.builder()
                .age(24)
                .salary(1.1)
                .passport("1")
                .address("1")
                .dateOfBirthday(Date.valueOf("1111-01-01"))
                .dateTimeCreate(Timestamp.valueOf("1111-01-01 01:01:01"))
                .timeToLunch(Time.valueOf("01:01:01"))
                .letter("1111")
                .build();

        Person personLessThan24 = Person.builder()
                .age(20)
                .salary(2.2)
                .passport("2")
                .address("2")
                .dateOfBirthday(Date.valueOf("2222-02-02"))
                .dateTimeCreate(Timestamp.valueOf("2222-02-02 02:02:02"))
                .timeToLunch(Time.valueOf("02:02:02"))
                .letter("2222")
                .build();

        PersonDaoImpl personDao = new PersonDaoImpl();

   /*     personDao.save(personLessThan24);
        personDao.save(personMoreThan24);
*/
        List<Person> people = personDao.findMoreThanAge(Const.AGE_VALUE);

        System.out.println(people);
        for(Person temp : people){
            System.out.println(temp);
        }


    }
}
