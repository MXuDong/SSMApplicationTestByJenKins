package service.Impl;

import dao.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.Interface.LogManagerService;
import util.StringFormatUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("LogManagerImpl")
public class LogManagerImpl implements LogManagerService {

    @Autowired
    UserInfosMapper userInfosMapper;
    @Autowired
    LogBaseInfoMapper logBaseInfoMapper;
    @Autowired
    LogChangeProductCountMapper logChangeProductCountMapper;
    @Autowired
    LogChangeProductPriceMapper logChangeProductPriceMapper;
    @Autowired
    ProductInfoMapper productInfoMapper;

    @Override
    public List<String> getOperList() {
        List<String> operList = new ArrayList<String>();

        int count = 0;
        List<LogBaseInfo> logBaseInfos = logBaseInfoMapper.selectAll();
        for (LogBaseInfo logBaseInfo : logBaseInfos) {
            operList.add(logBaseInfo.toLessInfo(userInfosMapper));
            count++;
            if (count > 5) {
                break;
            }
        }
        if (count == 6) {
            operList.add("等 共有" + logBaseInfos.size() + "条信息");
        }

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

        List<LogBaseInfo> logBaseInfos = logBaseInfoMapper.selectAll();
        List<List<String>> allLogInfos = new ArrayList<List<String>>();

        int count = 0;
        List<String> logInfo;
        UserInfos userInfos;
        for (LogBaseInfo logBaseInfo : logBaseInfos) {
            logInfo = new ArrayList<String>();

            //添加序列
            count++;
            logInfo.add(Integer.toString(count));

            //添加操作用户
            userInfos = userInfosMapper.findUserById(logBaseInfo.getLogAboutUser());
            logInfo.add(userInfos.getUserName());

            //添加详细信息
            int logType = logBaseInfo.getLogType();
            switch (logType) {
                case 0: {
                    logInfo.add("基本日志信息");
                    logInfo.add(StringFormatUtil.formatProductInfoToString(StringFormatUtil.FORMAT_TYPE_FORMAT_DATA, logBaseInfo.getLogTime()));
                    logInfo.add("添加产品信息");
                    logInfo.add(logBaseInfo.getLogWhat());
                    logInfo.add("无");
                    break;
                }
                case 1: {
                    logInfo.add("产品库存变动");
                    logInfo.add(StringFormatUtil.formatProductInfoToString(StringFormatUtil.FORMAT_TYPE_FORMAT_DATA, logBaseInfo.getLogTime()));
                    LogChangeProductCount logChangeProductCount = logChangeProductCountMapper.selectByBaseLogId(logBaseInfo.getLogId());
                    ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(logChangeProductCount.getProductId());
                    logInfo.add(logBaseInfo.getLogWhat());
                    logInfo.add("[" + productInfo.getProductName() + "]库存");
                    logInfo.add(logChangeProductCount.getProductOldCount() + "-->" + logChangeProductCount.getProductNewCount());
                    break;
                }
                case 2: {
                    logInfo.add("产品价格变动");
                    logInfo.add(StringFormatUtil.formatProductInfoToString(StringFormatUtil.FORMAT_TYPE_FORMAT_DATA, logBaseInfo.getLogTime()));
                    LogChangeProductPrice logChangeProductPrice = logChangeProductPriceMapper.selectByBoasLogId(logBaseInfo.getLogId());
                    ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(logChangeProductPrice.getProductId());
                    logInfo.add(logBaseInfo.getLogWhat());
                    logInfo.add("[" + productInfo.getProductName() + "]价格");
                    logInfo.add(logChangeProductPrice.getProductOldPrice() + "元-->" + logChangeProductPrice.getProductNewPrice() + "元");
                    break;
                }
                default: {
                    logInfo.add("1");
                    logInfo.add("Root");
                    logInfo.add("产品价格上涨");
                    logInfo.add("2018-11-4 22:02:23 [周日]");
                    logInfo.add("产品价格变动");
                    logInfo.add("鲸鱼价格");
                    logInfo.add("6.0元（人民币）");
                    break;
                }
            }
            allLogInfos.add(logInfo);
        }
        //该部分调用Action 完成
        return allLogInfos;
    }

    @Override
    public List<List<String>> getAllChangePriceInfo() {
        List<LogChangeProductPrice> logChangeProductPrices = logChangeProductPriceMapper.selectAll();
        List<List<String>> priceChangeLogs = new ArrayList<List<String>>();

        int count = 0;
        for(LogChangeProductPrice logChangeProductPrice : logChangeProductPrices){
            List<String> changeLogs = new ArrayList<String>();
            changeLogs.add(Integer.toString(++count));

            LogBaseInfo logBaseInfo = logBaseInfoMapper.selectByLogId(logChangeProductPrice.getLogId());
            changeLogs.add(userInfosMapper.findUserById(logBaseInfo.getLogAboutUser()).getUserName());
            changeLogs.add(productInfoMapper.selectByPrimaryKey(logChangeProductPrice.getProductId()).getProductName());
            changeLogs.add(StringFormatUtil.formatProductInfoToString(StringFormatUtil.FORMAT_TYPE_FORMAT_DATA, logBaseInfo.getLogTime()));
            changeLogs.add(logChangeProductPrice.getProductOldPrice() > logChangeProductPrice.getProductNewPrice()?"下降" : "上涨");
            changeLogs.add(logChangeProductPrice.getProductOldPrice() + "元-->" + logChangeProductPrice.getProductNewPrice() + "元");
            priceChangeLogs.add(changeLogs);
        }
        return priceChangeLogs;
    }

    @Override
    public List<List<String>> getAllChangeCountInfo() {

        List<LogChangeProductCount> logChangeProductPrices = logChangeProductCountMapper.selectAll();
        List<List<String>> countChangeInfos = new ArrayList<List<String>>();

        int count = 0;
        for(LogChangeProductCount logChangeProductCount : logChangeProductPrices){
            List<String> changeLogs = new ArrayList<String>();
            changeLogs.add(Integer.toString(++count));

            LogBaseInfo logBaseInfo = logBaseInfoMapper.selectByLogId(logChangeProductCount.getLogId());
            changeLogs.add(userInfosMapper.findUserById(logBaseInfo.getLogAboutUser()).getUserName());
            changeLogs.add(productInfoMapper.selectByPrimaryKey(logChangeProductCount.getProductId()).getProductName());
            changeLogs.add(StringFormatUtil.formatProductInfoToString(StringFormatUtil.FORMAT_TYPE_FORMAT_DATA, logBaseInfo.getLogTime()));
            changeLogs.add(logChangeProductCount.getProductOldCount() > logChangeProductCount.getProductNewCount()?"出库" : "入库");
            changeLogs.add(logChangeProductCount.getProductOldCount() + "-->" + logChangeProductCount.getProductNewCount());
            countChangeInfos.add(changeLogs);
        }
        return countChangeInfos;
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
