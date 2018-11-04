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

        return modelAndView;
    }
}
