package world.sai.steward.core.user;

import javax.persistence.*;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by sai on 2016. 3. 18..
 */
@Getter
@Setter
@Entity(name="USR")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="AGE")
    private Integer age;

    @Column(name="LOGIN_ID")
    private String loginId;

    @Column(name="BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

}
