package haui.doan.stores.controller;

import haui.doan.stores.constant.CommonConstants;
import haui.doan.stores.dto.request.UserRequest;
import haui.doan.stores.dto.response.ErrorResponse;
import haui.doan.stores.dto.response.UserResponse;
import haui.doan.stores.enums.RoleEnum;
import haui.doan.stores.persistenct.domain.Category;
import haui.doan.stores.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

/**
 * The controller for employee
 */
@Controller
@RequestMapping(value = "/admin/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ModelAndView getListEmployee() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/employee/list");
        return mav;
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity viewListUser() {
        List<UserResponse> users = userService.findUsers(RoleEnum.ROLE_EMPLOYEE, CommonConstants.DELETED.FALSE);
        return new ResponseEntity(users, HttpStatus.OK);
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
        request.setRole(RoleEnum.ROLE_EMPLOYEE.getRole());
        Map<String, Object> map = new HashMap<>();
        List<ErrorResponse> errors = new ArrayList<>();
        if (result.hasErrors()) {
            for (FieldError fieldError : result.getFieldErrors()) {
                errors.add(new ErrorResponse(fieldError.getField(), fieldError.getDefaultMessage()));
            }
        }
        if (!userService.checkUserNameExists(request.getUsername(), request.getUsernameOld())) {
            errors.add(new ErrorResponse("username", "Email đã tồn tại"));
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

    @GetMapping("/edit/{id}")
    public ModelAndView viewUser(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        UserResponse userResponse = userService.editUser(id);
        mav.addObject("userRespone", userResponse);
        mav.setViewName("/admin/employee/edit");
        return mav;

    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> updateEmployee(@Valid UserRequest request, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        List<ErrorResponse> errors = new ArrayList<>();
        if (result.hasErrors()) {
            for (FieldError fieldError : result.getFieldErrors()) {
                errors.add(new ErrorResponse(fieldError.getField(), fieldError.getDefaultMessage()));
            }
        }
        if (!userService.checkUserNameExists(request.getUsername(), request.getUsernameOld())) {
            errors.add(new ErrorResponse("username", "Email đã tồn tại"));
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
        userService.deleteUser(id);
    }

}
