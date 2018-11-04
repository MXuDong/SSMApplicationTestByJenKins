package controller;

import model.UserInfoType;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import util.LinePicInfo;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Controller
public class baseController {

    @RequestMapping(value = {"/", "/index", "Home"})
    public ModelAndView baseIndex(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("index");

        UserInfoType userInfoType = (UserInfoType) session.getAttribute("UserInfoType");

        //假数据

//        创建操作列表
        List<String> opers = new ArrayList<String>();
        opers.add("2018-5-25 13:24.18 [星期五]:产品[\"龙虾\"]价格发生变动[\"上涨\"] 6.0元");
        session.setAttribute("Opers", opers);

//        库存告急
        List<String> lessProduct = new ArrayList<String>();
        lessProduct.add("产品:[\"龙虾\"] 库存不足 [剩余数量 :\"99\"]");
        session.setAttribute("LessProduct", lessProduct);

//        库存冗余
        List<String> moreProduct = new ArrayList<String>();
        moreProduct.add("产品:[\"龙虾\"] 库存冗余 [剩余数量 :\"99\"]");
        session.setAttribute("MoreProduct", moreProduct);

        return modelAndView;
    }
}
