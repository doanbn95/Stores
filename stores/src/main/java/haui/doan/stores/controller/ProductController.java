package haui.doan.stores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/admin/product")
public class ProductController {

    @GetMapping(value = "/list")
    public ModelAndView viewListForm(){
        ModelAndView mav= new ModelAndView();
        System.out.println("View form");
        mav.setViewName("admin/product/list");
        return mav;
    }
    @GetMapping(value = "/create")
    public ModelAndView viewCreateForm(){
        ModelAndView mav= new ModelAndView();
        System.out.println("View form");
        mav.setViewName("admin/product/create");
        return mav;
    }


}
