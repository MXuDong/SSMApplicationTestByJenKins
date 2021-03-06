package controller;


import dao.ProductInfoMapper;
import dao.UserInfosMapper;
import model.UserInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.Interface.LogManagerService;
import service.Interface.ObillManagerService;
import service.Interface.ProductMangerService;
import util.ExcelUtil.ExcelWrite;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    @Autowired
    ProductInfoMapper productInfoMapper;

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
    public String doAccount(HttpSession session) {
        int userId = (int) session.getAttribute("userInfoId");

        obillManagerService.doSubmitObill(userId);

        return "redirect:/";
    }

    @RequestMapping("/pic")
    public void getPic(String id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String path = "/usr/local/DevelopmentFiles/Tomcat/apache-tomcat-8.0.53/productFiles";
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

    @RequestMapping("/download/tempXls")
    public ResponseEntity<byte[]> getTempXls() {
        ResponseEntity<byte[]> response = null;
        String fileName = "/usr/local/DevelopmentFiles/Tomcat/apache-tomcat-8.0.53/productFiles/temp.xls";
        InputStream in = null;//将该文件加入到输入流之中
        try {
            in = new FileInputStream(new File(fileName));
            byte[] body = null;
            body = new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
            in.read(body);//读入到 输入流里面
            fileName = new String(fileName.getBytes("gbk"), "iso8859-1");//防止中文乱码

            HttpHeaders headers = new HttpHeaders();//设置响应头
            headers.add("Content-Disposition", "attachment;filename=" + fileName);
            HttpStatus statusCode = HttpStatus.OK;//设置响应吗
            response = new ResponseEntity<byte[]>(body, headers, statusCode);

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @RequestMapping("/download/allProductInfo")
    public ResponseEntity<byte[]> getAllProdectInformations(){
        ExcelWrite ew = new ExcelWrite(productInfoMapper);
        File file = ew.doWrite();
        ResponseEntity<byte[]> response = null;
        String fileName = "productInformation.xls";
        InputStream in = null;//将该文件加入到输入流之中
        try {
            in = new FileInputStream(file);
            byte[] body = null;
            body = new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
            in.read(body);//读入到 输入流里面
            fileName = new String(fileName.getBytes("gbk"), "iso8859-1");//防止中文乱码

            HttpHeaders headers = new HttpHeaders();//设置响应头
            headers.add("Content-Disposition", "attachment;filename=" + fileName);
            HttpStatus statusCode = HttpStatus.OK;//设置响应吗
            response = new ResponseEntity<byte[]>(body, headers, statusCode);

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        file.delete();

        return response;
    }
}
