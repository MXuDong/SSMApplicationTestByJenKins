package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class baseController {

    @RequestMapping(value = {"/", "/index", "Home"})
    public ModelAndView baseIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        //假数据

//        创建操作列表
        List<String> opers = new ArrayList<String>();
        opers.add("2018-5-25 13:24.18 [星期五]:产品[\"龙虾\"]价格发生变动[\"上涨\"] 6.0元");
        modelAndView.addObject("Opers", opers);

//        库存告急
        List<String> lessProduct = new ArrayList<String>();
        lessProduct.add("产品:[\"龙虾\"] 库存不足 [剩余数量 :\"99\"]");
        modelAndView.addObject("LessProduct", lessProduct);

//        库存冗余
        List<String> moreProduct = new ArrayList<String>();
        moreProduct.add("产品:[\"龙虾\"] 库存冗余 [剩余数量 :\"99\"]");
        modelAndView.addObject("MoreProduct", moreProduct);

//        产品总量变化折线图
        List<String> monthOfProductChange = new ArrayList<String>();


        return modelAndView;
    }
}
