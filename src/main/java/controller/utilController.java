package controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/util")
public class utilController {

    @RequestMapping(value = "/obillLinePic", method = RequestMethod.GET)
    @ResponseBody
    public String getObillLinePic(){
        JSONObject jsonObject = new JSONObject();

        JSONObject xAxis = new JSONObject();
        xAxis.put("type", "category");
        JSONArray xAxixData = new JSONArray();
        xAxixData.add("Mon");
        xAxixData.add("Tue");
        xAxixData.add("Wed");
        xAxixData.add("Thu");
        xAxixData.add("Fri");
        xAxixData.add("Sat");
        xAxixData.add("Sun");
        xAxis.put("data", xAxixData);

        JSONObject yAxis = new JSONObject();
        yAxis.put("type", "value");

        JSONObject series = new JSONObject();
        JSONArray seriesData = new JSONArray();
        seriesData.add(820);
        seriesData.add(932);
        seriesData.add(901);
        seriesData.add(934);
        seriesData.add(1290);
        seriesData.add(1330);
        seriesData.add(1322);
        series.put("data", seriesData);
        series.put("type", "line");

        jsonObject.put("xAxis", xAxis);
        jsonObject.put("yAxis", yAxis);
        jsonObject.put("series", series);
        return jsonObject.toString();
    }
}
