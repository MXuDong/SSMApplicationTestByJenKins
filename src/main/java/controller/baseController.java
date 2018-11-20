package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import service.Interface.LogManagerService;
import service.Interface.ObillManagerService;
import service.Interface.ProductMangerService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class baseController {

    @Autowired@Resource(name = "ProductManagerImpl")
    ProductMangerService productMangerService;
    @Autowired@Resource(name = "ObillManagerService")
    ObillManagerService obillManagerService;
    @Autowired@Resource(name = "LogManagerImpl")
    LogManagerService logManagerService;

    @RequestMapping(value = {"/", "/index", "Home"})
    public ModelAndView baseIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        //假数据

//        创建操作列表
        List<String> opers = logManagerService.getOperList();
        modelAndView.addObject("Opers", opers);

//        库存告急
        List<String> lessProduct = productMangerService.getLessProducts();
        modelAndView.addObject("LessProduct", lessProduct);

//        库存冗余
        List<String> moreProduct = productMangerService.getMoreProducts();
        modelAndView.addObject("MoreProduct", moreProduct);

//        收入支出折线图
        Map<String, String> obillPicOptionValue = logManagerService.getObilPicOptionValue();
        modelAndView.addObject("ObillPicOptionValue", obillPicOptionValue);

//       产品总量变化折线图
        Map<String, String> productOptionValue = logManagerService.getProductChangeValue();
        modelAndView.addObject("ProductOptionValue", productOptionValue);

//        产品总量饼图
        Map<String, String> productBingPic = logManagerService.getProductBingPic();
        modelAndView.addObject("ProductBingPic", productBingPic);
        return modelAndView;
    }

    @RequestMapping("/about")
    public ModelAndView turnAboutPage(){
        return new ModelAndView("about");
    }

    @RequestMapping("/login")
    public ModelAndView turnLoginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping("/doLogin")
    public String login(String userName, String password, HttpSession session){
        session.setAttribute("userInfoId", 1);
        return "redirect:/";
    }

    @RequestMapping("/doLogOut")
    public String logOut(HttpSession session){
        session.setAttribute("userInfoId", null);

        return "redirect:/";
    }

    @RequestMapping("/account")
    public ModelAndView turnToAccountPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");

        Map<String, String> accountAttribute = obillManagerService.getAccountAttribute();

        List<Map<String, String>> accountInfo = obillManagerService.getAccountInfos();

        modelAndView.addObject("changeInfors", accountInfo);
        modelAndView.addObject("accountAttribute", accountAttribute);
        return modelAndView;
    }
}
