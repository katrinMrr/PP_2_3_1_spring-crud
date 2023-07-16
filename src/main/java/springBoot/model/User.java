package springBoot.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "gender")
    private String gender;

    public User() {
        this.birthday = Date.from(Instant.now());
    }

    public String getBirthday() {
        return birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void setBirthday(String birthday) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.birthday = simpleDateFormat.parse(birthday);
    }

}
