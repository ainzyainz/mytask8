import myPerson.Person;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class MockPeople {


    public static Person testPerson1() {
        return Person.builder()
                .age(11)
                .salary(11.1)
                .passport("passport1")
                .address("address1")
                .dateOfBirthday(Date.valueOf("2001-01-01"))
                .dateTimeCreate(new Timestamp(System.currentTimeMillis()))
                .timeToLunch(Time.valueOf("11:11:11"))
                .letter("1111")
                .build();
    }

    public static Person testPerson2() {
        return Person.builder()
                .age(22)
                .salary(22.2)
                .passport("passport2")
                .address("address2")
                .dateOfBirthday(Date.valueOf("2002-02-02"))
                .dateTimeCreate(new Timestamp(System.currentTimeMillis()))
                .timeToLunch(Time.valueOf("22:22:22"))
                .letter("2222")
                .build();
    }
}

