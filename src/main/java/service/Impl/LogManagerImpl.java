package service.Impl;

import org.springframework.stereotype.Service;
import service.Interface.LogManagerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("LogManagerService")
public class LogManagerImpl implements LogManagerService {
    @Override
    public List<String> getOperList() {
        return null;
    }

    @Override
    public List<String> getOperList(int count) {
        return null;
    }

    @Override
    public List<String> getObilPicOptionValue() {
        return null;
    }

    @Override
    public List<String> getObilPicOptionValue(int count) {
        return null;
    }

    @Override
    public Map<String, String> getProductChangeValue() {
        return null;
    }

    @Override
    public Map<String, String> getProductChangeValue(int count) {
        return null;
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
