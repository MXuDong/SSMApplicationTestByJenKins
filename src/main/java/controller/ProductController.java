package controller;

import model.ProductInfo;
import org.apache.commons.io.FileUtils;
import org.eclipse.core.internal.runtime.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.Interface.ProductMangerService;
import util.ExcelUtil.ExcelRead;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Resource(name = "ProductManagerImpl")
    ProductMangerService productMangerService;

    @RequestMapping(value = {"/ProductList"})
    public ModelAndView getProductList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productAmount");

        List<String> productHeader = new ArrayList<String>();
        productHeader.add("#");
        productHeader.add("产品名称");
        productHeader.add("产品价格");
        productHeader.add("产品库存");
        productHeader.add("产品库存状态");
        productHeader.add("产品详细描述");
        modelAndView.addObject("ProductHeader", productHeader);

        List<List<String>> productInfo = productMangerService.getProductInfos();
        modelAndView.addObject("ProductInfo", productInfo);

        //设置页面信息标题
        modelAndView.addObject("PageHeader", "全部产品信息");

        return modelAndView;
    }

    @RequestMapping(value = {"/lessProductList"})
    public ModelAndView getLessProductList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productAmount");

        List<String> productHeader = new ArrayList<String>();
        productHeader.add("#");
        productHeader.add("产品名称");
        productHeader.add("产品价格");
        productHeader.add("产品库存");
        productHeader.add("产品库存状态");
        productHeader.add("产品详细描述");
        modelAndView.addObject("ProductHeader", productHeader);

        List<List<String>> productInfo = productMangerService.getLessProducts(-1);
        modelAndView.addObject("ProductInfo", productInfo);

        //设置页面信息标题
        modelAndView.addObject("PageHeader", "告急商品信息");

        return modelAndView;
    }

    @RequestMapping(value = {"/moreProductList"})
    public ModelAndView getMoreProductList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productAmount");

        List<String> productHeader = new ArrayList<String>();
        productHeader.add("#");
        productHeader.add("产品名称");
        productHeader.add("产品价格");
        productHeader.add("产品库存");
        productHeader.add("产品库存状态");
        productHeader.add("产品详细描述");
        modelAndView.addObject("ProductHeader", productHeader);

        List<List<String>> productInfo = productMangerService.getMoreProducts(-1);
        modelAndView.addObject("ProductInfo", productInfo);

        //设置页面信息标题
        modelAndView.addObject("PageHeader", "冗余产品信息");

        return modelAndView;
    }

    @RequestMapping(value = "info", params = {"id"})
    public ModelAndView getProductInfo(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productInfo");

        Map<String, String> productInfo = productMangerService.getProductMoreInfo(id);
        modelAndView.addObject("ProductInfo", productInfo);

        Map<String, String> productPicInfos = productMangerService.getProductPicInfo(id);
        modelAndView.addObject("xAxisData", productPicInfos.get("xAxisData"));
        modelAndView.addObject("seriesData", productPicInfos.get("seriesData"));
        modelAndView.addObject("startValue", productPicInfos.get("startValue"));
        modelAndView.addObject("minValue", productPicInfos.get("minValue"));
        modelAndView.addObject("maxValue", productPicInfos.get("maxValue"));
        modelAndView.addObject("productXAxisData", productPicInfos.get("productXAxisData"));
        modelAndView.addObject("productSeriesData", productPicInfos.get("productSeriesData"));

        return modelAndView;
    }

    @RequestMapping("/addProducts")
    public ModelAndView addProductPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addProductInfo");

        return modelAndView;
    }

    @RequestMapping(value = "/addOneProduct.up", method = RequestMethod.POST)
    public String addProductPageByOne(
            @RequestParam("productName") String productName,
            @RequestParam("productPrice") Double productPrice,
            @RequestParam("productCount") Integer productCount,
            @RequestParam("productMaxCount") Integer productMaxCount,
            @RequestParam("productMinCount") Integer productMinCount,
            @RequestParam("productDisc") String productDisc,
            HttpSession session
    ) {
        ProductInfo productInfo = new ProductInfo();
        if (productName != null) {
            productInfo.setProductName(productName);
        }
        if (productPrice != null) {
            productInfo.setProductPrice(productPrice);
        }
        if (productCount != null) {
            productInfo.setProductCount(productCount);
        }
        if (productMaxCount != null) {
            productInfo.setProductMaxCount(productMaxCount);
        }
        if (productMinCount != null) {
            productInfo.setProductMinCount(productMinCount);
        }
        if (productDisc != null) {
            productInfo.setProductDesc(productDisc);
        }
        productInfo.setProductPic(0);

        int userId = (int) session.getAttribute("userInfoId");

        int productId = productMangerService.addProductInfo(productInfo, userId);

        return "redirect:/product/info?id=" + productId;
    }

    @RequestMapping(value = "/updateProductPic", method = RequestMethod.POST)
    public String updateProductPic(@RequestParam("file") MultipartFile file, @RequestParam("productId") String productId) {
        if (!file.isEmpty()) {

            String path = "E:\\Work Space\\Intellij WorkSpace\\SSMApplicationTestByJenKins\\src\\main\\webapp\\WEB-INF\\pic";

            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

            //不符合要求
            if (!(suffix.equalsIgnoreCase("jpg"))) {
                return "redirect:/product/info?id=" + productId;
            }

            try {

                //这里将上传得到的文件保存至 d:\\temp\\file 目录
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path,
                        productId + "." + suffix));
                productMangerService.updateProductInfo(productId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/product/info?id=" + productId;
    }

    @RequestMapping(value = "/uploadMoreProducts", method = RequestMethod.POST)
    public String uploadProducts(@RequestParam("file") MultipartFile file, HttpSession session) {
        if (!file.isEmpty()) {
            String path = "E:\\Work Space\\Intellij WorkSpace\\SSMApplicationTestByJenKins\\src\\main\\webapp\\WEB-INF\\pic\\";
            //获取后缀
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path,
                        suffix + "." + suffix));
                ExcelRead excelRead = new ExcelRead(productMangerService, path + suffix + "." + suffix, (int) session.getAttribute("userInfoId"));
                Map<String, Object> res = excelRead.doRead();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/changeProductCount", method = RequestMethod.POST)
    public String changeProductCount(@RequestParam(value = "productID") String productID, @RequestParam(value = "productCount", defaultValue = "-1") int productCount, HttpSession session) {
        if (productCount != -1) {
            productMangerService.updateProductInfoC(productID, productCount, (int) session.getAttribute("userInfoId"));
        }
        return "redirect:/product/info?id=" + productID;
    }

    @RequestMapping(value = "/changeProductPrice", method = RequestMethod.POST)
    public String changeProductPrice(String productID, @RequestParam(value = "productPrice", defaultValue = "-1") double productPrice, HttpSession session) {
        productMangerService.updateProductInfoP(productID, productPrice, (int) session.getAttribute("userInfoId"));

        return "redirect:/product/info?id=" + productID;
    }
}
