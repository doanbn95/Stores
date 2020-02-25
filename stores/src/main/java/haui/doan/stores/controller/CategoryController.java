package haui.doan.stores.controller;

import haui.doan.stores.constant.CommonConstants;
import haui.doan.stores.dto.request.CategoryRequest;
import haui.doan.stores.dto.response.CategoryResponse;
import haui.doan.stores.dto.response.ErrorResponse;
import haui.doan.stores.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //Model and view
    @GetMapping(value = "")
    public ModelAndView viewList() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/category/list");
        return mav;
    }

    @GetMapping(value = "/create")
    public ModelAndView viewCreateForm() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/category/create");
        mav.addObject("category", new CategoryRequest());
        return mav;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView viewEditForm(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        CategoryResponse categoryResponse = categoryService.findCategoryById(id);
        mav.setViewName("/admin/category/edit");
        mav.addObject("category", categoryResponse);
        return mav;
    }

    //Get du lieu
    @GetMapping("/list")
    @ResponseBody
    public List<CategoryResponse> getListCategory() {
        return categoryService.getListCategoryByDeleted(CommonConstants.DELETED.FALSE);
    }

    //Save du lieu
    @PostMapping("/create")
    @ResponseBody
    public Map<String, Object> createCategory(@Valid CategoryRequest request, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        List<ErrorResponse> errors = new ArrayList<>();
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(fieldError -> errors.add(new ErrorResponse(fieldError.getField(), fieldError.getDefaultMessage())));
        }
        if (!categoryService.checkCategoryNameExists(request.getName(), request.getNameOld())) {
            errors.add(new ErrorResponse("name", "Category existed!"));
        }
        if (errors.isEmpty()) {
            categoryService.createCategory(request);
            map.put("status", 200);
        } else {
            map.put("satus", 101);
            map.put("errors", errors);
        }
        return map;
    }

    @PostMapping("/edit")
    @ResponseBody
    public Map<String, Object> updateCategory(@Valid CategoryRequest request, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        List<ErrorResponse> errors = new ArrayList<>();
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(fieldError -> errors.add(new ErrorResponse(fieldError.getField(), fieldError.getDefaultMessage())));
        }
        if (!categoryService.checkCategoryNameExists(request.getName(), request.getNameOld())) {
            errors.add(new ErrorResponse("name", "Category existed!"));
        }
        if (errors.isEmpty()) {
            categoryService.updateCategory(request);
            map.put("status", 200);
        } else {
            map.put("satus",101);
            map.put("errors", errors);
        }
        return map;
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public Map<String, Object> deleteCategory(@PathVariable("id") Long id) {
        Map<String, Object> map = new HashMap<>();
        CategoryResponse category = categoryService.findCategoryById(id);
        if (category == null) {
            map.put("status", 404);
        } else if (category.getDeleted() == CommonConstants.DELETED.TRUE) {
            map.put("status", 500);
            map.put("error", "Category is deleted");
        } else {
            categoryService.deleteCategory(id);
            map.put("status", 200);
        }
        return map;
    }
}
