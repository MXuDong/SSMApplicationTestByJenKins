package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class baseController {

    @RequestMapping(value = {"/", "/index", "Home"})
    public ModelAndView baseIndex(){
        return new ModelAndView("index");
    }
}
