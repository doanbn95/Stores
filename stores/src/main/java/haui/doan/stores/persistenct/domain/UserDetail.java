package haui.doan.stores.persistenct.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "userdetail")
@Data
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birth_day")
    private String birthDay;

    @Column(name = "image_source")
    private String imageSource;
}
