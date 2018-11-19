package service.Impl;

import org.springframework.stereotype.Service;
import service.Interface.ObillManagerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ObillManagerService")
public class ObillManagerImpl implements ObillManagerService {
    @Override
    public Map<String, String> getAccountAttribute() {
        Map<String, String> accountAttribute = new HashMap<String, String>();
        accountAttribute.put("totalChangeMoney", "盈利 + 360");
        accountAttribute.put("lastChangeTime", "2018-09-22 13:01:01");
        return accountAttribute;
    }

    @Override
    public List<Map<String, String>> getAccountInfos() {
        List<Map<String, String>> accountInfos = new ArrayList<Map<String, String>>();

        Map<String, String> accountInfo = new HashMap<String, String>();
        accountInfo.put("numberOfThisInfo", "1");
        accountInfo.put("productName", "鲸鱼");
        accountInfo.put("changeType", "出库");
        accountInfo.put("changeCount", "-7");
        accountInfo.put("changeTimePrice", "56.5");
        accountInfo.put("changeTime", "2016-5-22 15:56:04");
        accountInfo.put("changeRes", "360");

        accountInfos.add(accountInfo);

        return accountInfos;
    }
}
