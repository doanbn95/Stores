package haui.doan.stores.persistenct.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "provide_id",insertable = false,updatable = false)
    private Long provideId;

    @Column(name = "image_id",insertable = false,updatable = false)
    private Long imageId;

    @Column(name = "category_id",insertable = false,updatable = false)
    private Long categoryId;

    @Column(name = "detail")
    private String detail;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private int status;

    @Column(name = "deleted")
    private int deleted;

    @OneToOne
    @JoinColumn(name = "provide_id", referencedColumnName = "id", nullable = false)
    private Provide provide;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id", nullable = false)
    private Image image;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

}
