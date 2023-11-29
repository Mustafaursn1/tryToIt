package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcell {
    @Test
    public void readExcelTest1() throws IOException {
        String filePath = "src/resources/ÜlkelerTest.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fis);

        //Excel tablosundaki tüm tabloyu konsola yazdiriniz

        int lastRow = workbook.getSheet("Sheet1").getLastRowNum();

        for (int i = 0; i <= lastRow; i++) {
            String tümTablo = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString() + " ,"
                    + workbook.getSheet("Sheet1").getRow(i).getCell(1).toString() + " ,"
                    + workbook.getSheet("Sheet1").getRow(i).getCell(2).toString() + " ,"
                    + workbook.getSheet("Sheet1").getRow(i).getCell(3).toString() ;


            System.out.println(tümTablo);
        }




    }
}
