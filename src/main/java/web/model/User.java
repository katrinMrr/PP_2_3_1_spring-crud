package web.model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "gender")
    private String gender;

    public User() {
        this.birthday = Date.from(Instant.now());
    }


    public User(String name, Date birthday, String gender) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void setBirthday(String birthday) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.birthday = simpleDateFormat.parse(birthday);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                '}';
    }
}
