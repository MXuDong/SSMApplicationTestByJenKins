package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class baseController {

    @RequestMapping(value = {"/", "/index", "Home"}, params = )
    public ModelAndView baseIndex(){
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("UserInfor", null);

        return modelAndView;
    }
}
