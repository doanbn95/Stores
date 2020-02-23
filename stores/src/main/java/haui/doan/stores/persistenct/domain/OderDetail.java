package haui.doan.stores.persistenct.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "order_details")
@Data
public class OderDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id",insertable = false,updatable = false)
    private Long orderId;

    @Column(name = "product_id",insertable = false,updatable = false)
    private Long productId;

    @Column(name = "quantity")
    private int quantity;

}
