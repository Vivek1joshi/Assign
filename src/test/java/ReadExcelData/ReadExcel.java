package ReadExcelData;

import java.io.IOException;

public class ReadExcel {
    public static void main(String[] args) throws IOException {
        String excelSheetPath = System.getProperty("user.dir");
        ExcelDataConfig excel = new ExcelDataConfig(excelSheetPath+"\\TestData\\new.xls");
        System.out.println(excel.getData(1, 0, 0));
    }
}
