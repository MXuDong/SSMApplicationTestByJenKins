import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestExcel {

    @Test
    public void testExcel() throws IOException, BiffException {
        File file = new File("C:\\Users\\Dong\\Desktop\\temp.xls");
        Workbook workbook = Workbook.getWorkbook(file);

        Sheet [] sheets = workbook.getSheets();

        System.out.println(sheets.length);

        if(sheets.length > 0){
            Sheet sheet = sheets[0];

            int row = sheet.getRows();
            int col = sheet.getColumns();

            System.out.println(row);
            System.out.println(col);

            for(int row_i = 1; row_i < row; row_i++){
                String productName = sheet.getCell(0, row_i).getContents();
                double productPrice = Double.parseDouble(sheet.getCell(1,row_i ).getContents());
                int productMaxCount = Integer.parseInt(sheet.getCell( 2, row_i).getContents());
                int productMinCount = Integer.parseInt(sheet.getCell( 3, row_i).getContents());
                int productCount = Integer.parseInt(sheet.getCell( 4, row_i).getContents());
                String desc = sheet.getCell(5, row_i).getContents();
            }
        }

        workbook.close();
    }
}
