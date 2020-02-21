package haui.doan.stores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/advertise")
public class AdvertiseController {

    @GetMapping("/list")
    public ModelAndView viewAdvertise(){
        ModelAndView mav= new ModelAndView();
        mav.setViewName("/admin/advertise/list");
        return mav;
    }
}
