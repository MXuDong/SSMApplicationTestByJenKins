package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;
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

    @RequestMapping(value = {"/", "/index", "Home"})
    public ModelAndView baseIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        //假数据

//        创建操作列表
        List<String> opers = new ArrayList<String>();
        opers.add("2018-5-25 13:24.18 [星期五]:产品[\"龙虾\"]价格发生变动[\"上涨\"] 6.0元");
        modelAndView.addObject("Opers", opers);

//        库存告急
        List<String> lessProduct = productMangerService.getLessProducts();
        modelAndView.addObject("LessProduct", lessProduct);

//        库存冗余
        List<String> moreProduct = new ArrayList<String>();
        moreProduct.add("产品:[\"龙虾\"] 库存冗余 [剩余数量 :\"99\"]");
        modelAndView.addObject("MoreProduct", moreProduct);

//        收入支出折线图
        Map<String, String> obillPicOptionValue = new HashMap<String, String>();
        String obillPicXAxisData = "'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun', 'A', 'B'";
        String obillPicSeriesData = "820, 932, 901, 934, 1290, 1330, 1320, 540, 7852";

        obillPicOptionValue.put("xAxis", obillPicXAxisData);
        obillPicOptionValue.put("data", obillPicSeriesData);
        modelAndView.addObject("ObillPicOptionValue", obillPicOptionValue);

//       产品总量变化折线图
        Map<String, String> productOptionValue = new HashMap<String, String>();
        String productXAxis = "'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'";
        String productData = "820, 932, 1290, 1330, 1320, 540, 320";

        productOptionValue.put("xAxis", productXAxis);
        productOptionValue.put("data", productData);
        modelAndView.addObject("ProductOptionValue", productOptionValue);

//        产品总量饼图
        Map<String, String> productBingPic = new HashMap<String, String>();
        String productNames = "'海绵宝宝', '皮皮虾', '蟹老板', '章鱼哥', '鲸鱼', '贝克'";
        String productBingData = "{value:1200, name:'海绵宝宝'},{value:1200, name:'皮皮虾'}," +
                "{value:300, name:'蟹老板'},{value:456, name:'章鱼哥'}," +
                "{value:986, name:'鲸鱼'},{value:321, name:'贝克'}";
        productBingPic.put("legendData", productNames);
        productBingPic.put("seriesData", productBingData);
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

        Map<String, String> accountAttribute = new HashMap<String, String>();
        accountAttribute.put("totalChangeMoney", "盈利 + 360");
        accountAttribute.put("lastChangeTime", "2018-09-22 13:01:01");

        List<Map<String, String>> accountInfo = new ArrayList<Map<String, String>>();

        Map<String, String> infos = new HashMap<String, String>();
        infos.put("numberOfThisInfo", "1");
        infos.put("productName", "鲸鱼");
        infos.put("changeType", "出库");
        infos.put("changeCount", "-7");
        infos.put("changeTimePrice", "56.5");
        infos.put("changeTime", "2016-5-22 15:56:04");
        infos.put("changeRes", "360");

        accountInfo.add(infos);

        modelAndView.addObject("changeInfors", accountInfo);
        modelAndView.addObject("accountAttribute", accountAttribute);
        return modelAndView;
    }
}
