package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAndAfterClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class C04_GetScreenshot extends TestBaseBeforeAndAfterClass {
    @Test
    public void test1() throws IOException, InterruptedException {

        //amazon.com a gidip tüm sayfanin resmini alalim
        driver.get("https:zalando.com");



        /*
        Bir web sayfanin resmini alabilmek icin TakesScreenshoot class in obj olusturup
        gecici bir file class indan degiskene TakesScreenshoot `dan olusturdugum obj 'den getScreenShotAs()
        meth. kullanarak bir file olustururz
         */
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver; //casting yaptik
        File tumSayfaResmi = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/allPage" + tarih + ".png"));//png or jpeg tercih edilebilebilir

    }
}
