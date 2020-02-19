package haui.doan.stores.persistenct.repository;

import haui.doan.stores.persistenct.domain.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
