package haui.doan.stores.persistenct.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private int status;

    @Column(name = "created")
    private Date createdDate;

    @Column(name = "creator")
    private String creator;

    @Column(name = "updated")
    private Date updatedDate;

    @Column(name = "updater")
    private String updater;

    @Column(name = "delete_date")
    private Date deleteDate;

    @Column(name = "delete_person")
    private String deletePerson;
}
