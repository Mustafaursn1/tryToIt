package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcellShortMethod {
    @Test
    public void readExcelTest1() throws IOException {
        // 7. Dosya yolunu bir String degiskene atayalim
        String filePath = "src/resources/ÜlkelerTest.xlsx";
        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(filePath); //oluturmus oldugumuz dosyayi sistemde isleme alir-->
        //--> dosyayi bulamama ihtimalinden dolayi eception firlatir
        // 9. Workbook objesi olusturalim,parameter olarak filenputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); //dosyayi bulamama ihtimalinden dolayi eception firlatir
        //workbook objesi ile fis objesi ile akisa aldigimiz dosyanizla bir excell dosyasi create eder
        // 11. Worksheet objesi olusturun workbook.getSheetAt(index)

        //12. Row objesi olusturun sheet.getRow(index)



        /*
        workbook objesi olusturdugumuz icin ilgili methodlara ulasarak kisaltmis olduk
         */
        String actualData = workbook.getSheet("Sheet1").
                getRow(13).
                getCell(3).
                toString();
        System.out.println(actualData);


    }
}
