package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.Interface.LogManagerService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    LogManagerService logManagerService;

    @RequestMapping(value = {"", "/logManager"})
    public ModelAndView getIndexOfLog(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logManagerShow");

        List<String> logTableHeader = new ArrayList<String>();
        logTableHeader.add("#");
        logTableHeader.add("日志发起者");
        logTableHeader.add("日志记录内容");
        logTableHeader.add("日志发生时间");
        logTableHeader.add("日志类型");
        logTableHeader.add("关联对象");
        logTableHeader.add("关联数值");
        modelAndView.addObject("LogTableHeader", logTableHeader);

        List<List<String>> logTableInfo = logManagerService.getAllLogInfo();
        modelAndView.addObject("LogTableInfo", logTableInfo);

        //设置页面信息标题
        modelAndView.addObject("PageHeader", "全部日志信息");

        return modelAndView;
    }

    @RequestMapping("/productPriceLog")
    public ModelAndView getProductPriceLog(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logManagerShow");

        List<String> logTableHeader = new ArrayList<String>();
        logTableHeader.add("#");
        logTableHeader.add("日志发起者");
        logTableHeader.add("变动商品");
        logTableHeader.add("日志发生时间");
        logTableHeader.add("变动类型");
        logTableHeader.add("变动价格");
        modelAndView.addObject("LogTableHeader", logTableHeader);

        List<List<String>> logTableInfo = logManagerService.getAllChangePriceInfo();
        modelAndView.addObject("LogTableInfo", logTableInfo);

        //设置页面信息标题
        modelAndView.addObject("PageHeader", "价格变动日志信息");

        return modelAndView;
    }

    @RequestMapping("/productCountLog")
    public ModelAndView getProductCountLog(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logManagerShow");

        List<String> logTableHeader = new ArrayList<String>();
        logTableHeader.add("#");
        logTableHeader.add("日志发起者");
        logTableHeader.add("变动商品");
        logTableHeader.add("日志发生时间");
        logTableHeader.add("变动类型");
        logTableHeader.add("变动数量");
        modelAndView.addObject("LogTableHeader", logTableHeader);

        List<List<String>> logTableInfo = logManagerService.getAllChangeCountInfo();
        modelAndView.addObject("LogTableInfo", logTableInfo);

        //设置页面信息标题
        modelAndView.addObject("PageHeader", "产品数量变动信息日志");

        return modelAndView;
    }

    @RequestMapping("/obillLog")
    public ModelAndView getObillLog(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logManagerShow");

        List<String> logTableHeader = new ArrayList<String>();
        logTableHeader.add("#");
        logTableHeader.add("日志发起者");
        logTableHeader.add("结账日期");
        logTableHeader.add("结账金额");
        logTableHeader.add("结账类型");
        modelAndView.addObject("LogTableHeader", logTableHeader);

        List<List<String>> logTableInfo = logManagerService.getAllObillInfo();
        modelAndView.addObject("LogTableInfo", logTableInfo);

        //设置页面信息标题
        modelAndView.addObject("PageHeader", "账单操作信息日志");
        return modelAndView;
    }
}
