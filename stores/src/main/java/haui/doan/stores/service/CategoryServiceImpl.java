package haui.doan.stores.service;

import haui.doan.stores.constant.CommonConstants;
import haui.doan.stores.dto.request.CategoryRequest;
import haui.doan.stores.dto.request.ImageRequest;
import haui.doan.stores.dto.response.CategoryResponse;
import haui.doan.stores.persistenct.domain.Category;
import haui.doan.stores.persistenct.domain.Image;
import haui.doan.stores.persistenct.repository.CategoryRepository;
import haui.doan.stores.persistenct.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    protected final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    private final ImageService imageService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, ImageService imageService) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.imageService = imageService;
    }

    @Override
    public void createCategory(CategoryRequest request) {
        //Image
        ImageRequest imageRequest = new ImageRequest();
        imageRequest.setId(request.getImageId());
        imageRequest.setImage(request.getImage());
        Image image = imageService.saveImage(imageRequest);
        //Category
        Category category = new Category();
        category.setId(request.getId());
        category.setContent(request.getContent());
        category.setName(request.getName());
        category.setImage(image);
        category.setImageId(image.getId());
        category.setDeleted(CommonConstants.DELETED.FALSE);
        category.setStatus(request.getStatus());
        //Save
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(CategoryRequest request) {
        //Image
        ImageRequest imageRequest = new ImageRequest();
        imageRequest.setId(request.getImageId());
        imageRequest.setImage(request.getImage());
        Image image = imageService.updateImage(imageRequest);
        //Category
        Category category = new Category();
        category.setId(request.getId());
        category.setName(request.getName());
        category.setContent(request.getContent());
        category.setStatus(request.getStatus());
        category.setDeleted(request.getDeleted());
        category.setImageId(image.getId());
        category.setImage(image);
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.getOne(id);
        //Change deleted status
        category.setDeleted(CommonConstants.DELETED.TRUE);
        categoryRepository.save(category);
    }

    @Override
    public CategoryResponse findCategoryById(Long id) {
        Category category = categoryRepository.getOne(id);
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setContent(category.getContent());
        response.setName(category.getName());
        response.setImageId(category.getImageId());
        response.setImageUrl(category.getImage().getUrl());
        response.setStatus(category.getStatus());
        response.setDeleted(category.getDeleted());
        response.setNameOld(category.getName());
        int size = productRepository.countProductsByCategoryIdIs(category.getId());
        response.setSize(size);
        return response;
    }

    @Override
    public List<CategoryResponse> getListCategoryByDeleted(int deleted) {
        //Get list category deleted is false
        List<Category> categories = categoryRepository.findCategoriesByDeletedIs(deleted);
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        //Change category to category Response
        categories.forEach(category -> {
            CategoryResponse response = new CategoryResponse();
            response.setId(category.getId());
            response.setContent(category.getContent());
            response.setName(category.getName());
            response.setImageId(category.getImageId());
            response.setImageUrl(category.getImage().getUrl());
            response.setStatus(category.getStatus());
            response.setDeleted(category.getDeleted());
            response.setNameOld(category.getName());
            int size = productRepository.countProductsByCategoryIdIs(category.getId());
            response.setSize(size);
            categoryResponses.add(response);
        });
        return categoryResponses;
    }

    @Override
    public boolean checkCategoryNameExists(String categoryName, String categoryNameOld) {
        Category flag = categoryRepository.findCategoryByNameEqualsAndDeletedIs(categoryName, CommonConstants.DELETED.FALSE);
        if (StringUtils.isEmpty(categoryNameOld)) {
            return flag == null;
        } else {
            return categoryName.equals(categoryNameOld) || flag == null;
        }
    }
}
