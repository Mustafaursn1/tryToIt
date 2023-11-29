package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_PracticeReadExcell {
    /*
   1-Dosya yolunu bir String degiskene atayalim
   2 -FileInputStream objesi olusturup, parametre olarak dosya yolunu girelim
   3-Workbook objesi olusturalim, parameter olarak fileInputstream objesini girelim
   4-WorkbookFactory.create(fileInputStream)
   5-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin
     */
    @Test
    public void readExcel() throws IOException {
        String filePath="src/resources/ÜlkelerTest.xlsx";
        FileInputStream fis=new FileInputStream(filePath);

        Workbook workbook= WorkbookFactory.create(fis);

        int lastRow = workbook.getSheet("Sheet2").getLastRowNum();
        System.out.println(lastRow);
        int ecpextedLastRow=6;
        //Assert.assertEquals(ecpextedLastRow,lastRow+1);
        int kullanilanSatirSayisi=workbook.getSheet("Sheet2").getPhysicalNumberOfRows();//Kullanilan satir sayisini aliriz
        System.out.println("Kullanilan satir sayisi="+kullanilanSatirSayisi);
        int expectedKullanilanSatir=3;
        Assert.assertNotEquals(expectedKullanilanSatir,kullanilanSatirSayisi);


    }




}
