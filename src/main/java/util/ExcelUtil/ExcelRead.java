package util.ExcelUtil;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import model.ProductInfo;
import service.Interface.ProductMangerService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelRead {
    private ProductMangerService productMangerService;
    private String filePath = "";
    private int userId;

    public ExcelRead(ProductMangerService productMangerService, String filePath, int userId) {
        this.productMangerService = productMangerService;
        this.filePath = filePath;
        this.userId = userId;
    }

    public Map<String, Object> doRead() {
        File file = new File(filePath);
        Workbook workbook = null;
        List<String> resError = new ArrayList<String>();
        List<Integer> resId = new ArrayList<Integer>();
        try {
            workbook = Workbook.getWorkbook(file);
            Sheet[] sheets = workbook.getSheets();

            if (sheets.length > 0) {
                Sheet sheet = sheets[0];

                int row = sheet.getRows();

                for (int row_i = 1; row_i < row; row_i++) {
                    String productName = sheet.getCell(0, row_i).getContents();
                    double productPrice = Double.parseDouble(sheet.getCell(1, row_i).getContents());
                    int productMaxCount = Integer.parseInt(sheet.getCell(2, row_i).getContents());
                    int productMinCount = Integer.parseInt(sheet.getCell(3, row_i).getContents());
                    int productCount = Integer.parseInt(sheet.getCell(4, row_i).getContents());
                    String desc = sheet.getCell(5, row_i).getContents();

                    if(productMaxCount < productMinCount || productMaxCount < 0 || productMinCount < 0){
                        resError.add("非法最大值最小值: 第" + row_i + "行" );
                        continue;
                    }
                    if(productCount < 0){
                        resError.add("非法总量:第" + row_i + "行");
                        continue;
                    }
                    if(productPrice < 0){
                        resError.add("非法价格:第" + row_i + "行");
                        continue;
                    }

                    ProductInfo productInfo = new ProductInfo();
                    productInfo.setProductPic(0);
                    productInfo.setProductName(productName);
                    productInfo.setProductPrice(productPrice);
                    productInfo.setProductMaxCount(productMaxCount);
                    productInfo.setProductMinCount(productMinCount);
                    productInfo.setProductCount(productCount);
                    productInfo.setProductDesc(desc);

                    productMangerService.addProductInfo(productInfo, userId);

                    resId.add(productInfo.getProductId());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        Map<String, Object> res = new HashMap<>();
        res.put("Errors", resError);
        res.put("ids", resId);
        if(workbook != null){
            workbook.close();
        }

        file.delete();

        return res;
    }
}
