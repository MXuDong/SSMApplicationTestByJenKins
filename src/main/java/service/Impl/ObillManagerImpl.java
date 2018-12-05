package service.Impl;

import dao.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.Interface.ObillManagerService;
import util.LogFactory;
import util.StringFormatUtil;

import java.util.*;

@Service("ObillManagerService")
public class ObillManagerImpl implements ObillManagerService {

    @Autowired
    ObillInfoMapper obillInfoMapper;
    @Autowired
    LogBaseInfoMapper logBaseInfoMapper;
    @Autowired
    LogChangeProductCountMapper logChangeProductCountMapper;
    @Autowired
    ProductInfoMapper productInfoMapper;

    @Override
    public Map<String, Object> getAccountAttribute() {
        //生成结果集
        Map<String, Object> accountAttribute = new HashMap<String, Object>();

        List<ObillInfo> obillInfos = obillInfoMapper.selectAllOrderByTimeDesc();

        String lastOperationTime_str = "";
        double totalChangeMoney = 0;

        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(new Date());

        List<Map<String, String>> accountInfos = new ArrayList<Map<String, String>>();

        if(obillInfos.size() > 0){
            Calendar lastOperationTime = Calendar.getInstance();
            lastOperationTime.setTime(obillInfos.get(0).getObillTime());
            lastOperationTime_str = StringFormatUtil.formatProductInfoToString(StringFormatUtil.StringFormatType.FORMAT_TYPE_FORMAT_DATA, lastOperationTime.getTime());

            List<LogBaseInfo> logBaseInfos = logBaseInfoMapper.selectAllProductCountLog();

            double totalManey = 0;
            int count = 0;
            for(LogBaseInfo L : logBaseInfos){

                Calendar oldTime = Calendar.getInstance();
                oldTime.setTime(L.getLogTime());

                if(oldTime.get(Calendar.DAY_OF_YEAR) < lastOperationTime.get(Calendar.DAY_OF_YEAR)){
                    continue;
                }

                if(oldTime.get(Calendar.DAY_OF_YEAR) >= nowTime.get(Calendar.DAY_OF_YEAR)){
                    continue;
                }
                LogChangeProductCount logChangeProductCount = logChangeProductCountMapper.selectByBaseLogId(L.getLogId());
                ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(logChangeProductCount.getProductId());
                Map<String, String> accountInfo = new HashMap<String, String>();

                int oldCount = logChangeProductCount.getProductOldCount();
                int newCount = logChangeProductCount.getProductNewCount();
                double changeRes = (oldCount - newCount) * logChangeProductCount.getProductOldPrice();

                accountInfo.put("numberOfThisInfo", Integer.toString(++count));
                accountInfo.put("productName", productInfo.getProductName());
                accountInfo.put("changeType", oldCount > newCount ? "出库":"入库");
                accountInfo.put("changeCount", Integer.toString(newCount - oldCount));
                accountInfo.put("changeTimePrice", Double.toString(logChangeProductCount.getProductOldPrice()));
                accountInfo.put("changeTime", StringFormatUtil.formatProductInfoToString(StringFormatUtil.StringFormatType.FORMAT_TYPE_FORMAT_DATA, L.getLogTime()));
                accountInfo.put("changeRes", Double.toString(changeRes));

                accountInfos.add(accountInfo);
                totalManey += changeRes;
            }
            totalChangeMoney = totalManey;
        }else {
            lastOperationTime_str = "从未结账！";
            List<LogBaseInfo> logBaseInfos = logBaseInfoMapper.selectAllProductCountLog();

            double totalManey = 0;

            int count = 0;
            for(LogBaseInfo L : logBaseInfos){

                Calendar oldTime = Calendar.getInstance();
                oldTime.setTime(L.getLogTime());

                if(oldTime.get(Calendar.DAY_OF_YEAR) >= nowTime.get(Calendar.DAY_OF_YEAR)){
                    continue;
                }

                LogChangeProductCount logChangeProductCount = logChangeProductCountMapper.selectByBaseLogId(L.getLogId());
                ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(logChangeProductCount.getProductId());
                Map<String, String> accountInfo = new HashMap<String, String>();

                int oldCount = logChangeProductCount.getProductOldCount();
                int newCount = logChangeProductCount.getProductNewCount();
                double changeRes = (oldCount - newCount) * logChangeProductCount.getProductOldPrice();

                accountInfo.put("numberOfThisInfo", Integer.toString(++count));
                accountInfo.put("productName", productInfo.getProductName());
                accountInfo.put("changeType", oldCount > newCount ? "出库":"入库");
                accountInfo.put("changeCount", Integer.toString(newCount - oldCount));
                accountInfo.put("changeTimePrice", Double.toString(logChangeProductCount.getProductOldPrice()));
                accountInfo.put("changeTime", StringFormatUtil.formatProductInfoToString(StringFormatUtil.StringFormatType.FORMAT_TYPE_FORMAT_DATA, L.getLogTime()));
                accountInfo.put("changeRes", Double.toString(changeRes));

                accountInfos.add(accountInfo);
                totalManey += changeRes;
            }
            totalChangeMoney = totalManey;
        }

        accountAttribute.put("totalChangeMoney", Double.toString(totalChangeMoney));
        accountAttribute.put("lastChangeTime", lastOperationTime_str);


        accountAttribute.put("accountInfos", accountInfos);
        return accountAttribute;
    }

    @Override
    public void doSubmitObill(int userId) {
        Date date = new Date();
        ObillInfo obillInfo = new ObillInfo();
        Map<String, Object> resultMap = getAccountAttribute();
        obillInfo.setObillTime(date);
        obillInfo.setObillMoney(Double.parseDouble((String) resultMap.get("totalChangeMoney")));

        if(obillInfo.getObillMoney() == 0){
            return ;
        }

        obillInfoMapper.insert(obillInfo);
        LogBaseInfo logBaseInfo = LogFactory.makeLogBaseInfo(LogFactory.OperationObill, userId,Integer.toString(obillInfo.getObill()));
        logBaseInfoMapper.insert(logBaseInfo);
    }
}
