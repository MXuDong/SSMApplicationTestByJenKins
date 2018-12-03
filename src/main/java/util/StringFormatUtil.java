package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static util.StringFormatUtil.StringFormatType.FORMAT_TYPE_LESS;

//格式化字符串
public class StringFormatUtil {

    public enum StringFormatType{
        FORMAT_TYPE_MORE,
        FORMAT_TYPE_LESS,
        FORMAT_TYPE_FORMAT_DATA,
        FORMAT_TYPE_FORMAT_DATA_ONLY_DAY
    }

    public static String formatProductInfoToString(StringFormatType type, Object infos){
        switch (type){
            case FORMAT_TYPE_LESS: case FORMAT_TYPE_MORE:return formatProductInfoLessOrMoreInfo(type, infos);
            case FORMAT_TYPE_FORMAT_DATA:return dateFormat((Date)infos);
            case FORMAT_TYPE_FORMAT_DATA_ONLY_DAY:return dateFormatOnlyDays((Date) infos);
            default:return null;
        }
    }

    private static String formatProductInfoLessOrMoreInfo(StringFormatType type, Object infos){
        List<String> productInfo = (List<String>) infos;
        String moreOrLessFlag = type == FORMAT_TYPE_LESS?"不足":"冗余";
        return "产品 : [\"" + productInfo.get(2) + "\"] 库存" + moreOrLessFlag + " [剩余数量 : \"" + productInfo.get(4) + "\"]";
    }

    private static String dateFormat(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss [E]");
        return simpleDateFormat.format(date);
    }

    private static String dateFormatOnlyDays(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        return simpleDateFormat.format(date);
    }
}