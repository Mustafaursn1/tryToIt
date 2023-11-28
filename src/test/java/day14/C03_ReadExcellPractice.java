package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class C03_ReadExcellPractice {
    @Test
    public void readExcelTest1() throws IOException, InterruptedException {
/*
1.Girilen satirNo ve sutunNo degerlerini parametre olarak alip o cell`deki datayi konsola yazdiralim
2.sonucun konsolda yazan ile ayni oldugunu dogrulayalim
 */
       int satir=12;
       int sutun=2;

       String filePath="src/resources/ÜlkelerTest.xlsx";

       FileInputStream fis=new FileInputStream(filePath);
       Workbook workbook=WorkbookFactory.create(fis);
       String actualData=workbook.getSheet("Sheet1").
               getRow(12).
               getCell(3).
               toString();
        System.out.println(actualData);
        Assert.assertEquals(actualData,"Western Asia");



    }



}
