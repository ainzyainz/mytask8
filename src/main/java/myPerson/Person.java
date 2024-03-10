package myPerson;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Builder
@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode

public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Integer age;

    @Column
    private Double salary;

    @Column
    private String passport;

    @Column
    private String address;

    @Column(name = "date_of_birthday")
    private Date dateOfBirthday;

    @Column (name = "time_to_lunch")
    private Time timeToLunch;

    @Column (name = "date_time_create")
    private Timestamp dateTimeCreate = new Timestamp(System.currentTimeMillis());

    @Column
    private String letter;
}
