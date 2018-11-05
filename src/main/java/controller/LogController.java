package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/log")
public class LogController {

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

        List<List<String>> logTableInfo = new ArrayList<List<String>>();
        List<String> logTableBody = new ArrayList<String>();
        logTableBody.add("1");
        logTableBody.add("Root");
        logTableBody.add("产品价格上涨");
        logTableBody.add("2018-11-4 22:02:23 [周日]");
        logTableBody.add("产品价格变动");
        logTableBody.add("鲸鱼价格");
        logTableBody.add("6.0元（人民币）");
        logTableInfo.add(logTableBody);
        modelAndView.addObject("LogTableInfo", logTableInfo);

        //提示按钮是否可用
        modelAndView.addObject("ButtonIndex", 0);

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

        List<List<String>> logTableInfo = new ArrayList<List<String>>();
        List<String> logTableBody = new ArrayList<String>();
        logTableBody.add("1");
        logTableBody.add("Root");
        logTableBody.add("鲸鱼");
        logTableBody.add("2018-11-4 22:02:23 [周日]");
        logTableBody.add("上涨");
        logTableBody.add("6.0元（人民币）");
        logTableInfo.add(logTableBody);
        modelAndView.addObject("LogTableInfo", logTableInfo);
        modelAndView.addObject("ButtonIndex", 1);

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

        List<List<String>> logTableInfo = new ArrayList<List<String>>();
        List<String> logTableBody = new ArrayList<String>();
        logTableBody.add("1");
        logTableBody.add("Root");
        logTableBody.add("鲸鱼");
        logTableBody.add("2018-11-4 22:02:23 [周日]");
        logTableBody.add("上涨");
        logTableBody.add("70");
        logTableInfo.add(logTableBody);
        modelAndView.addObject("LogTableInfo", logTableInfo);
        modelAndView.addObject("ButtonIndex", 1);

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

        List<List<String>> logTableInfo = new ArrayList<List<String>>();
        List<String> logTableBody = new ArrayList<String>();
        logTableBody.add("1");
        logTableBody.add("Root");
        logTableBody.add("2018-11-4 22:02:23 [周日]");
        logTableBody.add("5200.0元（人民币）");
        logTableBody.add("收入");
        logTableInfo.add(logTableBody);
        modelAndView.addObject("LogTableInfo", logTableInfo);
        modelAndView.addObject("ButtonIndex", 1);

        return modelAndView;
    }
}
