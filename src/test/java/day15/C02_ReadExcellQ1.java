package day15;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class C02_ReadExcellQ1 {
    /*
      Yeni bir test method olusturalim readExcel2( )
      1.satirdaki 2.hucreye gidelim ve yazdiralim
      I.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
      3.satir 4.cell'in afganistan'in  cografik yerini "South-Central Asia" belirtigini dogrulayin

      Fiziki olarak kullanilan satir sayisini bulun
      Ingilize Ulke isimleri ve cografik bölgelerini f bir map olarak kaydedelim
     */

    @Test
    public void readExcel2() throws IOException {

        String filePath = "src/resources/ÜlkelerTest.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        //I.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim

        String secondCell = workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();
        System.out.println(secondCell);
        //3.satir 4.cell'in afganistan'in  cografik yerini "South-Central Asia" belirtigini dogrulayin
        String actualData = workbook.getSheet("Sheet1").getRow(2).getCell(3).toString();
        String expectedData = "South-Central Asia";
        Assert.assertEquals(expectedData, actualData);
        // Fiziki olarak kullanilan satir sayisini bulun
        int kullanilanSatirSay = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("Kullanilan Satir Sayisi:" + kullanilanSatirSay);
        //Ingilize Ulke isimleri ve cografik bölgelerini f bir map olarak kaydedelim
        Map<String, String> dataMap = new HashMap<>();


        for (int i = 0; i <= kullanilanSatirSay; i++) {
            Row currentRow = workbook.getSheet("Sheet1").getRow(i);

            if (currentRow != null) {
                Cell countryCell = currentRow.getCell(0);
                Cell regionCell = currentRow.getCell(3);

                if (countryCell != null && regionCell != null) {
                    String country = countryCell.toString();
                    String region = regionCell.toString();
                    dataMap.put(country, region);
                    dataMap.forEach((anahtar, deger) -> System.out.println(anahtar + ": " + deger));
                }

            }

        }

        System.out.println("Map boyutu:" + dataMap.size());






    }
}
