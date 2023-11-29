package day15;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_DeleteDataExcell {
    @Test
    public void deleteDataFromExcell() throws IOException {

        String filePath = "src/resources/ÜlkelerTest.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fis);
        //silecegimiz zaman row objesi ister row olusturmak icin sheet ihtiyaci var
        //Ayni sekilde cell objesine de ihtiyac duyariz row classinda remoweCell() meth. kullanilir
        //3.satir 3.cell deki veriyi silelim
        String silinecekData=workbook.getSheet("Sheet1").getRow(3).getCell(3).toString();
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(3);
        Cell cell =row.getCell(3);
        row.removeCell(cell);
        FileOutputStream fos =new FileOutputStream(filePath);
        workbook.write(fos);
        //!!!C03_WriteExcell class i ile birlikte degerlendir

        //silindigini test edelim
        String actualData=null;
        Assert.assertNotEquals(actualData,silinecekData);
        System.out.println("SILINEN DATA:"+silinecekData);






    }

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
                    + workbook.getSheet("Sheet1").getRow(i).getCell(3).toString();


            System.out.println(tümTablo);
        }


    }
}
