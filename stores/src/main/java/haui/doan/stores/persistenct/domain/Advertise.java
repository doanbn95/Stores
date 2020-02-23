package haui.doan.stores.persistenct.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "advertises")
@Data
public class Advertise extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "image_id",insertable = false,updatable = false)
    private Long imageId;

    @Column(name = "link")
    private String link;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private int status;
}
