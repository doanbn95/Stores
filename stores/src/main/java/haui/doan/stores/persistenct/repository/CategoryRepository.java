package haui.doan.stores.persistenct.repository;

import haui.doan.stores.persistenct.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    //Find Category by name and deleted
    Category findCategoryByNameEqualsAndDeletedIs(String categoryName, int deleted);

    //Find Category by deleted
    List<Category> findCategoriesByDeletedIs(int deleted);
}
