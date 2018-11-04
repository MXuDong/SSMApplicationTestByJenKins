package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//        产品类别总量饼图
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
}
