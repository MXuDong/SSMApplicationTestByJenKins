package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping(value = {"/ProductList"})
    public ModelAndView getProductList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productAmount");

        List<String> productHeader = new ArrayList<String>();
        productHeader.add("#");
        productHeader.add("产品名称");
        productHeader.add("产品价格");
        productHeader.add("产品库存");
        productHeader.add("产品库存状态");
        productHeader.add("产品类别");
        productHeader.add("产品详细描述");
        modelAndView.addObject("ProductHeader", productHeader);

        List<List<String>> productInfo = new ArrayList<List<String>>();
        List<String> productBody = new ArrayList<String>();
        productBody.add("1");
        productBody.add("鲸鱼");
        productBody.add("9元（人民币）");
        productBody.add("1000");
        productBody.add("正常");
        productBody.add("小菜");
        productBody.add("座头鲸，可以 做房子");

        productInfo.add(productBody);
        modelAndView.addObject("ProductInfo", productInfo);

        //设置页面信息标题
        modelAndView.addObject("PageHeader", "全部产品信息");

        return modelAndView;
    }

    @RequestMapping(value = {"/lessProductList"})
    public ModelAndView getLessProductList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productAmount");

        List<String> productHeader = new ArrayList<String>();
        productHeader.add("#");
        productHeader.add("产品名称");
        productHeader.add("产品价格");
        productHeader.add("产品库存");
        productHeader.add("产品库存状态");
        productHeader.add("产品类别");
        productHeader.add("产品详细描述");
        modelAndView.addObject("ProductHeader", productHeader);

        List<List<String>> productInfo = new ArrayList<List<String>>();
        List<String> productBody = new ArrayList<String>();
        productBody.add("1");
        productBody.add("鲸鱼");
        productBody.add("9元（人民币）");
        productBody.add("1000");
        productBody.add("告急");
        productBody.add("小菜");
        productBody.add("座头鲸，可以做房子");

        productInfo.add(productBody);
        modelAndView.addObject("ProductInfo", productInfo);

        //设置页面信息标题
        modelAndView.addObject("PageHeader", "告急商品信息");

        return modelAndView;
    }

    @RequestMapping(value = {"/moreProductList"})
    public ModelAndView getMoreProductList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productAmount");

        List<String> productHeader = new ArrayList<String>();
        productHeader.add("#");
        productHeader.add("产品名称");
        productHeader.add("产品价格");
        productHeader.add("产品库存");
        productHeader.add("产品库存状态");
        productHeader.add("产品类别");
        productHeader.add("产品详细描述");
        modelAndView.addObject("ProductHeader", productHeader);

        List<List<String>> productInfo = new ArrayList<List<String>>();
        List<String> productBody = new ArrayList<String>();
        productBody.add("1");
        productBody.add("鲸鱼");
        productBody.add("9元（人民币）");
        productBody.add("1000");
        productBody.add("冗余");
        productBody.add("小菜");
        productBody.add("座头鲸，可以做房子");

        productInfo.add(productBody);
        modelAndView.addObject("ProductInfo", productInfo);

        //设置页面信息标题
        modelAndView.addObject("PageHeader", "冗余产品信息");

        return modelAndView;
    }
}
