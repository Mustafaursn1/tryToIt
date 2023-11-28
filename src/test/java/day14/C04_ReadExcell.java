package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcell {
/*
1.Dosya yolunu bir String degiskene atayalim
2.FileInputstream objesi olusturup, parametre olarak dosya yolunu girelim
3.Workbook objesi olusturalim, parameter olarak fileInputStream objesini girelim
4.WorkbookFactory. create(fileInputStream)
5-Region sutununu yazdiralim
 */

    @Test
    public void readExcel() throws IOException {

        //1.Dosya yolunu bir String degiskene atayalim
        String filePath = "src/resources/ÜlkelerTest.xlsx";

        //2.FileInputstream objesi olusturup, parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(filePath);
        // 3.Workbook objesi olusturalim, parameter olarak fileInputStream objesini girelim
        //4.WorkbookFactory. create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //5-ingilzce  sutununu yazdiralim
        int lastRow = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println(lastRow);



        for (int i = 0; i <= lastRow; i++) {
            String englishNameOfAllCountries=workbook.getSheet("Sheet1").
                    getRow(i).
                    getCell(0).
                    toString();
            System.out.println(englishNameOfAllCountries);
        }



    }
}

