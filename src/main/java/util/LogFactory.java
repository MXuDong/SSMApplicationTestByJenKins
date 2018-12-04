package util;

import model.LogBaseInfo;
import model.LogChangeProductCount;
import model.LogChangeProductPrice;
import model.LogObillOperation;

import java.util.Date;

public class LogFactory {

    /**
     *
     * @param logType
     * @param abouteUserId
     * @param logWhat
     * @return
     *
     * LogTypeList:
     * 0 base information
     * 1 change product count
     * 2 change product price
     */

    public static final int BaseInformaiton = 0;
    public static final int ChangeProductCount = 1;
    public static final int ChangeProductPrice = 2;
    public static final int OperationObill = 3;

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

    public static LogChangeProductPrice makeLogChangeProductPrice(int logId, int aboutProductId, int oldCount, double oldPrice, double newPrice){
        LogChangeProductPrice logChangeProductPrice = new LogChangeProductPrice();
        logChangeProductPrice.setLogId(logId);
        logChangeProductPrice.setProductId(aboutProductId);
        logChangeProductPrice.setProductNewPrice(newPrice);
        logChangeProductPrice.setProductOldPrice(oldPrice);
        logChangeProductPrice.setProductOldCount(oldCount);

        return logChangeProductPrice;
    }

    public static LogObillOperation makeLogObillOperation(int logId, int obillId){
        LogObillOperation logObillOperation = new LogObillOperation();

        logObillOperation.setLogId(logId);
        logObillOperation.setObillId(obillId);

        return logObillOperation;
    }
}
