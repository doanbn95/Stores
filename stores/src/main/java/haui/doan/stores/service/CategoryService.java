package haui.doan.stores.service;

import haui.doan.stores.dto.request.CategoryRequest;
import haui.doan.stores.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    void createCategory(CategoryRequest request);

    void updateCategory(CategoryRequest request);

    void deleteCategory(Long id);

    CategoryResponse findCategoryById(Long id);

    List<CategoryResponse> getListCategoryByDeleted(int deleted);

    boolean checkCategoryNameExists(String categoryName, String categoryNameOld);

}
