import myPerson.Person;
import DAO.PersonDaoImpl;
import org.junit.Assert;
import org.junit.Test;



public class PeopleTest {

    PersonDaoImpl personDaoImpl = new PersonDaoImpl();


    @Test
    public void save() {
        Person person = MockPeople.testPerson1();
        personDaoImpl.save(person);
        Person expected = personDaoImpl.read(person.getId());
        asserts(person,expected);
    }


    @Test
    public void updateTest(){
        Person person = MockPeople.testPerson1();
        personDaoImpl.save(person);
        person.setAge(32);
        personDaoImpl.update(person);
        Person expected = personDaoImpl.read(person.getId());
        asserts(person,expected);
    }

    @Test
    public void readTest(){
        Person person = MockPeople.testPerson1();
        personDaoImpl.save(person);

        Person readPerson = personDaoImpl.read(person.getId());

        asserts(readPerson,person);
    }
    @Test
    public void deleteTest(){
        Person person = MockPeople.testPerson1();
        personDaoImpl.save(person);
        Assert.assertTrue(personDaoImpl.delete(person.getId()));

    }

    private void asserts(Person person1, Person result) {
        Assert.assertEquals(result.getAge(), person1.getAge());
        Assert.assertEquals(result.getAddress(), person1.getAddress());
        Assert.assertEquals(result.getPassport(), person1.getPassport());
        Assert.assertEquals(result.getDateOfBirthday(), person1.getDateOfBirthday());
        Assert.assertEquals(result.getDateTimeCreate(), person1.getDateTimeCreate());
        Assert.assertEquals(result.getLetter(), person1.getLetter());
    }

}
