package haui.doan.stores.persistenct.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "cost")
    private double cost;

    @Column(name = "quantity")
    private int quantity;

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

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", referencedColumnName = "product_id", nullable = false)
    private ProductDetail productDetail;
}
