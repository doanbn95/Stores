package haui.doan.stores.persistenct.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "image_id", insertable = false, updatable = false)
    private Long imageId;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birth_day")
    private Date birthDay;

    @Column(name = "status")
    private int status;

    @Column(name = "deleted")
    private int deleted;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id", nullable = false)
    private Image image;

}
