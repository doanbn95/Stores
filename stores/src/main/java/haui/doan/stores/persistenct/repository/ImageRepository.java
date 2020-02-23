package haui.doan.stores.persistenct.repository;

import haui.doan.stores.persistenct.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findImageByNameIs(String name);
}
