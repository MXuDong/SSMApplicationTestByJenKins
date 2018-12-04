package controller;

import dao.UserInfosMapper;
import model.UserInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.Interface.LogManagerService;
import service.Interface.ObillManagerService;
import service.Interface.ProductMangerService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.Map;

@Controller
public class baseController {

    @Autowired
    @Resource(name = "ProductManagerImpl")
    ProductMangerService productMangerService;
    @Autowired
    @Resource(name = "ObillManagerService")
    ObillManagerService obillManagerService;
    @Autowired
    @Resource(name = "LogManagerImpl")
    LogManagerService logManagerService;
    @Autowired
    UserInfosMapper userInfosMapper;

    @RequestMapping(value = {"/", "/index", "Home"})
    public ModelAndView baseIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        //假数据

//        创建操作列表
        List<String> opers = logManagerService.getOperList();
        modelAndView.addObject("Opers", opers);

        Map<String, Object> accountRes = obillManagerService.getAccountAttribute();
        modelAndView.addObject("accountAttribute", accountRes);

//        库存告急
        List<String> lessProduct = productMangerService.getLessProducts();
        modelAndView.addObject("LessProduct", lessProduct);

//        库存冗余
        List<String> moreProduct = productMangerService.getMoreProducts();
        modelAndView.addObject("MoreProduct", moreProduct);

//        产品总量饼图
        Map<String, String> productBingPic = logManagerService.getProductBingPic();
        modelAndView.addObject("ProductBingPic", productBingPic);
        return modelAndView;
    }

    @RequestMapping("/about")
    public ModelAndView turnAboutPage() {
        return new ModelAndView("about");
    }

    @RequestMapping("/login")
    public ModelAndView turnLoginPage() {
        return new ModelAndView("login");
    }

    @RequestMapping("/doLogin")
    public String login(String userName, String password, HttpSession session) {
        UserInfos userInfos = userInfosMapper.findUserByName(userName);

        if (userInfos != null) {
            if (userInfos.getUserPassword().equals(password)) {
                session.setAttribute("userInfoId", userInfos.getUserId());
            }
        }
        return "redirect:/";
    }

    @RequestMapping("/doLogOut")
    public String logOut(HttpSession session) {
        session.setAttribute("userInfoId", null);

        return "redirect:/";
    }

    @RequestMapping("/account")
    public ModelAndView turnToAccountPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");

        Map<String, Object> accountAttribute = obillManagerService.getAccountAttribute();

        modelAndView.addObject("accountAttribute", accountAttribute);
        return modelAndView;
    }

    @RequestMapping("/doAccount")
    public String doAccount(HttpSession session){
        int userId = (int) session.getAttribute("userInfoId");

        obillManagerService.doSubmitObill(userId);

        return "redirect:/";
    }

    @RequestMapping("/pic")
    public void getPic(String id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String path = "E:\\Work Space\\Intellij WorkSpace\\SSMApplicationTestByJenKins\\src\\main\\webapp\\WEB-INF\\pic\\";
        File file = new File(path + id + ".jpg");
        if (!file.exists()) {
            file = new File(path + "default.jpg");
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            int length = inputStream.read(data);
            inputStream.close();

            httpServletResponse.setContentType("image/png");

            OutputStream stream = httpServletResponse.getOutputStream();
            stream.write(data);
            stream.flush();
            stream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
