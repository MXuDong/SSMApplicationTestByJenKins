package util.ExcelUtil;

import dao.ProductInfoMapper;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import model.ProductInfo;
import service.Interface.ProductMangerService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExcelWrite {

    private ProductInfoMapper productInfoMapper;

    public ExcelWrite(ProductInfoMapper productInfoMapper){
        this.productInfoMapper = productInfoMapper;
    }

    public File doWrite(){
        File fille = new File("E:\\Work Space\\Intellij WorkSpace\\SSMApplicationTestByJenKins\\src\\main\\webapp\\WEB-INF\\pic\\downloadFile.xls");
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(fille);
            WritableSheet sheet = workbook.createSheet("sheet1", 0);

            sheet.addCell(new Label(0,0,"产品名称"));
            sheet.addCell(new Label(1,0,"产品总库存"));
            sheet.addCell(new Label(2,0,"产品价格"));
            sheet.addCell(new Label(3,0,"产品推荐最大值"));
            sheet.addCell(new Label(4,0,"产品推荐最小值"));
            sheet.addCell(new Label(5,0,"产品描述"));

            List<ProductInfo> productInfos = productInfoMapper.selectAll();
            int row = 1;
            for(ProductInfo productInfo : productInfos){
                sheet.addCell(new Label(0,row,productInfo.getProductName()));
                sheet.addCell(new Label(1,row,Integer.toString(productInfo.getProductCount())));
                sheet.addCell(new Label(2,row,Double.toString(productInfo.getProductPrice())));
                sheet.addCell(new Label(3,row,Integer.toString(productInfo.getProductMaxCount())));
                sheet.addCell(new Label(4,row,Integer.toString(productInfo.getProductMinCount())));
                sheet.addCell(new Label(5,row,productInfo.getProductDesc()));
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }

        return fille;
    }
}
