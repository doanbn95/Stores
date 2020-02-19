package haui.doan.stores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/admin")
public class HomeController {

    @GetMapping(value = "/home")
    public ModelAndView viewHome(){
        ModelAndView mav= new ModelAndView();
        mav.setViewName("admin/admin");
        return mav;
    }

    @GetMapping(value = "/profile")
    public ModelAndView viewProfile(){
        ModelAndView mav= new ModelAndView();
        mav.setViewName("admin/profile");
        return mav;
    }
}
