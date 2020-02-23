package haui.doan.stores.controller;

import haui.doan.stores.constant.CommonConstants;
import haui.doan.stores.dto.request.UserRequest;
import haui.doan.stores.dto.response.ErrorResponse;
import haui.doan.stores.enums.RoleEnum;
import haui.doan.stores.persistenct.domain.User;
import haui.doan.stores.service.ImageService;
import haui.doan.stores.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The controller for employee
 */
@Controller
@RequestMapping(value = "/admin/employee")
public class EmployeeController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<User>> getListEmployee() {
        List<User> users = userService.findUsersByDeletedAndRole(RoleEnum.ROLE_EMPLOYEE, CommonConstants.DELETED.FALSE);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/create")
    public ModelAndView viewCreateEmployee() {
        ModelAndView mav = new ModelAndView();
        UserRequest userRequest = new UserRequest();
        mav.setViewName("/admin/employee/create");
        mav.addObject("userForm", userRequest);
        return mav;
    }

    @PostMapping("/create")
    @ResponseBody
    public Map<String, Object> createEmployee(@Valid UserRequest request, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        List<ErrorResponse> errors = new ArrayList<>();
        if (result.hasErrors()) {
            for (FieldError fieldError : result.getFieldErrors()) {
                errors.add(new ErrorResponse(fieldError.getDefaultMessage(), fieldError.getField()));
            }
        }
        if (errors.isEmpty()) {
            userService.createUser(request);
            map.put("status", 200);
        } else {
            map.put("status", 101);
            map.put("errros", errors);
        }
        return map;
    }

    @PostMapping("/update")
    public Map<String, Object> updateEmployee(@Valid UserRequest request, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        List<ErrorResponse> errors = new ArrayList<>();
        if (result.hasErrors()) {
            for (FieldError fieldError : result.getFieldErrors()) {
                errors.add(new ErrorResponse(fieldError.getDefaultMessage(), fieldError.getField()));
            }
        }
        if (errors.isEmpty()) {
            userService.updateUser(request);
            map.put("status", 200);
        } else {
            map.put("status", 101);
            map.put("errros", errors);
        }
        return map;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {

    }

}
