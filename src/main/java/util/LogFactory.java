package util;

import model.LogBaseInfo;
import model.LogChangeProductCount;

import java.util.Date;

public class LogFactory {
    public static LogBaseInfo makeLogBaseInfo(int logType, int abouteUserId, String logWhat){
        LogBaseInfo logBaseInfo = new LogBaseInfo();
        logBaseInfo.setLogTime(new Date());
        logBaseInfo.setLogType(logType);
        logBaseInfo.setLogAboutUser(abouteUserId);
        logBaseInfo.setLogWhat(logWhat);

        return logBaseInfo;
    }

    public static LogChangeProductCount makeLogChangeProductCount(int logId, int aboutProductId, int oldCount, double oldPrice, int newCount){
        LogChangeProductCount logChangeProductCount = new LogChangeProductCount();
        logChangeProductCount.setLogId(logId);
        logChangeProductCount.setProductId(aboutProductId);
        logChangeProductCount.setProductNewCount(newCount);
        logChangeProductCount.setProductOldCount(oldCount);
        logChangeProductCount.setProductOldPrice(oldPrice);

        return logChangeProductCount;
    }
}
