package service.Impl;

import org.springframework.stereotype.Service;
import service.Interface.LogManagerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("LogManagerImpl")
public class LogManagerImpl implements LogManagerService {
    @Override
    public List<String> getOperList() {
        List<String> operList = new ArrayList<String>();

        operList.add("2018-5-25 13:24.18 [星期五]:产品[\"龙虾\"]价格发生变动[\"上涨\"] 6.0元");

        return operList;
    }

    @Override
    public Map<String, String> getObilPicOptionValue() {
        Map<String, String> productChangeMap = new HashMap<String, String>();

        String obillPicXAxisData = "'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun', 'A', 'B'";
        String obillPicSeriesData = "820, 932, 901, 934, 1290, 1330, 1320, 540, 7852";
        productChangeMap.put("xAxis", obillPicXAxisData);
        productChangeMap.put("data", obillPicSeriesData);

        return productChangeMap;
    }


    @Override
    public Map<String, String> getProductChangeValue() {
        Map<String, String> productChangeMap = new HashMap<String, String>();

        String obillPicXAxisData = "'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'";
        String obillPicSeriesData = "820, 932, 1290, 1330, 1320, 540, 320";
        productChangeMap.put("xAxis", obillPicXAxisData);
        productChangeMap.put("data", obillPicSeriesData);

        return productChangeMap;
    }

    @Override
    public Map<String, String> getProductBingPic() {
        Map<String, String> productBingPic = new HashMap<String, String>();
        String productNames = "'海绵宝宝', '皮皮虾', '蟹老板', '章鱼哥', '鲸鱼', '贝克'";
        String productBingData = "{value:1200, name:'海绵宝宝'},{value:1200, name:'皮皮虾'}," +
                "{value:300, name:'蟹老板'},{value:456, name:'章鱼哥'}," +
                "{value:986, name:'鲸鱼'},{value:321, name:'贝克'}";
        productBingPic.put("legendData", productNames);
        productBingPic.put("seriesData", productBingData);

        return productBingPic;
    }

    @Override
    public List<List<String>> getAllLogInfo() {
        List<List<String>> allLogInfos = new ArrayList<List<String>>();

        //该部分调用Action 完成
        List<String> logInfo = new ArrayList<String>();
        logInfo.add("1");
        logInfo.add("Root");
        logInfo.add("产品价格上涨");
        logInfo.add("2018-11-4 22:02:23 [周日]");
        logInfo.add("产品价格变动");
        logInfo.add("鲸鱼价格");
        logInfo.add("6.0元（人民币）");

        allLogInfos.add(logInfo);

        return allLogInfos;
    }

    @Override
    public List<List<String>> getAllChangePriceInfo() {
        List<List<String>> priceChangeLogs = new ArrayList<List<String>>();

        List<String> changeLogs = new ArrayList<String>();
        changeLogs.add("1");
        changeLogs.add("Root");
        changeLogs.add("鲸鱼");
        changeLogs.add("2018-11-4 22:02:23 [周日]");
        changeLogs.add("上涨");
        changeLogs.add("6.0元（人民币）");

        priceChangeLogs.add(changeLogs);

        return priceChangeLogs;
    }

    @Override
    public List<List<String>> getAllChangeCountInfo() {

        List<List<String>> countChangeLogs = new ArrayList<List<String>>();

        List<String> changeLogs = new ArrayList<String>();
        changeLogs.add("1");
        changeLogs.add("Root");
        changeLogs.add("鲸鱼");
        changeLogs.add("2018-11-4 22:02:23 [周日]");
        changeLogs.add("上涨");
        changeLogs.add("70");

        countChangeLogs.add(changeLogs);

        return countChangeLogs;
    }

    @Override
    public List<List<String>> getAllObillInfo() {
        List<List<String>> obillOperatorInfos = new ArrayList<List<String>>();

        List<String> obillLog = new ArrayList<String>();
        obillLog.add("1");
        obillLog.add("Root");
        obillLog.add("2018-11-4 22:02:23 [周日]");
        obillLog.add("5200.0元（人民币）");
        obillLog.add("收入");

        obillOperatorInfos.add(obillLog);

        return obillOperatorInfos;
    }
}
