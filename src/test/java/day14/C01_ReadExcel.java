package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    /*
         Read Excel Class Work
      1. apache poi dependency'i pom file'a ekleyelim
      2. Java klasoru altinda resources klasoru olusturalim
      3. Excel dosyamizi resources klasorune ekleyelim
      4. excelAutomation isminde bir package olusturalim
      5. ReadExcel isminde bir class olusturalim
      6. readExcel() method olusturalim
      7. Dosya yolunu bir String degiskene atayalim
      8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
      9. Workbook objesi olusturalim,parameter olarak filenputStream objesini girelim
      10. WorkbookFactory.create(fileInputStream)
      11. Worksheet objesi olusturun workbook.getSheetAt(index)
      12. Row objesi olusturun sheet.getRow(index)
      13. Cell objesi olusturun row.getCell(index)
     */

    @Test
    public void readExcelTest1() throws IOException {
       // 7. Dosya yolunu bir String degiskene atayalim
        String filePath = "src/resources/ÜlkelerTest.xlsx";
        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(filePath); //oluturmus oldugumuz dosyayi sistemde isleme alir-->
        //--> dosyayi bulamama ihtimalinden dolayi eception firlatir
        // 9. Workbook objesi olusturalim,parameter olarak filenputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis); //dosyayi bulamama ihtimalinden dolayi eception firlatir
        //workbook objesi ile fis objesi ile akisa aldigimiz dosyanizla bir excell dosyasi create eder
        // 11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheetAt(0);//Excell deki calisacagimiz sayfayi seciyoruz index de kabul eder
        //12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(14);

        Cell cell=row.getCell(3);//Satir secimi yapildiktan sonra hücre secimi bu sekilde yapilir

        System.out.println(cell);

        //14-->3  Australia/Oceania oldugunu dogrulayin
        String expectedData="Australia/Oceania";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData,actualData);







    }

}
