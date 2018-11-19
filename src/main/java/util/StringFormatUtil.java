package util;

import java.util.List;

//格式化字符串
public class StringFormatUtil {
    public static final byte FORMAT_TYPE_MORE = 1;
    public static final byte FORMAT_TYPE_LESS = 2;

    public static String formatProductInfoToString(int type, Object infos){
        switch (type){
            case FORMAT_TYPE_LESS: case FORMAT_TYPE_MORE:return formatProductInfoLessOrMoreInfo(type, infos);
            default:return null;
        }
    }

    private static String formatProductInfoLessOrMoreInfo(int type, Object infos){
        List<String> productInfo = (List<String>) infos;
        String moreOrLessFlag = type == FORMAT_TYPE_LESS?"不足":"冗余";
        return "产品 : [\"" + productInfo.get(2) + "\"] 库存" + moreOrLessFlag + " [剩余数量 : \"" + productInfo.get(4) + "\"]";
    }
}
