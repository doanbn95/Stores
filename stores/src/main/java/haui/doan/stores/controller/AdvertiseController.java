package haui.doan.stores.controller;

import haui.doan.stores.dto.request.AdvertiseRequest;
import haui.doan.stores.dto.response.AdvertiseResponse;
import haui.doan.stores.dto.response.ErrorResponse;
import haui.doan.stores.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/advertise")
public class AdvertiseController {

    private final AdvertiseService advertiseService;

    @Autowired
    public AdvertiseController(AdvertiseService advertiseService) {
        this.advertiseService = advertiseService;
    }

    //view model and view
    @GetMapping(value = "")
    public ModelAndView viewList() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/advertise/list");
        return mav;
    }

    @GetMapping(value = "/create")
    public ModelAndView viewCreateAdvertise() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/advertise/create");
        mav.addObject("advertise", new AdvertiseRequest());
        return mav;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView viewEditForm(@PathVariable("id") Long id) {
        AdvertiseResponse response = advertiseService.editAdvertise(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/advertise/edit");
        mav.addObject("advertise", response);
        return mav;
    }

    //Get du lieu

    @GetMapping(value = "/list")
    public List<AdvertiseResponse> getListAdvertise() {
        return advertiseService.findAdvertises();
    }

    //Save du lieu
    public Map<String, Object> createAdvertise(@Valid AdvertiseRequest request, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        List<ErrorResponse> errors = new ArrayList<>();
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(fieldError -> {
                errors.add(new ErrorResponse(fieldError.getField(), fieldError.getDefaultMessage()));
            });
        }
        if (errors.isEmpty()) {
            advertiseService.createAdvertise(request);
            map.put("status", 200);
        }
        return map;
    }

    public Map<String, Object> updateAdvertise(@Valid AdvertiseRequest request, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        List<ErrorResponse> errors = new ArrayList<>();
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(fieldError -> {
                errors.add(new ErrorResponse(fieldError.getField(), fieldError.getDefaultMessage()));
            });
        }
        if (errors.isEmpty()) {
            advertiseService.updateAdvertise(request);
            map.put("status", 200);
        }
        return map;
    }

    public Map<String, Object> deleteAdvertise(Long id) {
        Map<String, Object> map = new HashMap<>();
        advertiseService.deleteAdvertise(id);
        map.put("status", 200);
        return map;
    }

}
