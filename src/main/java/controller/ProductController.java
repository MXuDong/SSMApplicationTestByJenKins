package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        productBody.add("1"); //id
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
        productBody.add("1"); //id
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
        productBody.add("1"); //id
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

    @RequestMapping(value = "info", params = {"id"})
    public ModelAndView getProductInfo(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productInfo");
        Map<String, String> productInfo = new HashMap<String, String>();
        productInfo.put("productName", "鲸鱼");
        productInfo.put("productPrice", "9.6元（人民币）");
        productInfo.put("productCount", "1000");
        productInfo.put("productPic", "../pic/1.jpg");
        productInfo.put("productType", "测试版");
        productInfo.put("productDisc", "这里是产品的描述");
        productInfo.put("productMaxCount", "2000");
        productInfo.put("productMinCount", "1");
        productInfo.put("productStatus", "正常");
        modelAndView.addObject("ProductInfo", productInfo);

        //横坐标
        String xAxisData = "'2018-9-1', '2018-9-2', '2018-9-3', '2018-9-4'";
        modelAndView.addObject("xAxisData", xAxisData);

        //数据
        String seriesData = "1250,4356,724,8985";
        modelAndView.addObject("seriesData", seriesData);

        //横坐标开始数据
        String startValue = "'2018-9-2'";
        modelAndView.addObject("startValue", startValue);

        //最小值
        String minValue = "1000";
        modelAndView.addObject("minValue", minValue);

        //最大值
        String maxValue = "5000";
        modelAndView.addObject("maxValue", maxValue);

        String productXAxisData = "'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun', 'A', 'B'";
        modelAndView.addObject("productXAxisData", productXAxisData);

        String productSeriesData = "820, 932, 901, 934, 1290, 1330, 1320, 540, 7852";
        modelAndView.addObject("productSeriesData", productSeriesData);


        return modelAndView;

    }

    @RequestMapping("/addProducts")
    public ModelAndView addProductPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addProductInfo");

        List<String> typeList = new ArrayList<String>();
        typeList.add("默认类型");
        typeList.add("标准类型");
        typeList.add("抽象类型");
        modelAndView.addObject("typeList", typeList);

        return modelAndView;
    }

    @RequestMapping(value = "/addOneProduct.up", method = RequestMethod.POST)
    public String addProductPageByOne(
            @RequestParam("productName") String productName,
            @RequestParam("productPrice") Double productPrice,
            @RequestParam("productCount")Integer productCount,
            @RequestParam("productMaxCount")Integer productMaxCount,
            @RequestParam("productMinCount")Integer productMinCount,
            @RequestParam("productType")String productType,
            @RequestParam("productDisc")String productDisc
    ){
        if(productName != null) System.out.println(productName);
        if(productPrice != null) System.out.println(productPrice);
        if(productCount != null) System.out.println(productCount);
        if(productMaxCount != null) System.out.println(productMaxCount);
        if(productMinCount != null) System.out.println(productMinCount);
        if(productType != null) System.out.println(productType);
        if(productDisc != null) System.out.println(productDisc);

        return "redirect:/product/info?id=1";
    }
}
