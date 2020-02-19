package haui.doan.stores.persistenct.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "productdetail")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "ram")
    private String ram;

    @Column(name = "cpu")
    private String cpu;

    @Column(name = "hdd")
    private String hdd;

    @Column(name = "color")
    private String color;

    @Column(name = "power")
    private double power;

    @Column(name = "screen")
    private String screen;
    @Column(name = "mouse")
    private String mouse;

    @Column(name = "image_source")
    private String imageSource;
}
