package haui.doan.stores.persistenct.repository;

import haui.doan.stores.persistenct.domain.Advertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Long> {

}
