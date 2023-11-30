package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseBeforeAndAfterClass;

import java.io.File;
import java.io.IOException;

public class C02_JSExecutor extends TestBaseBeforeAndAfterClass {
    @Test
    public void test1() throws IOException {

        //Amazon a gidelim
        driver.get("https://amazon.com");

        //Asagidaki carrers butonunu görünceye kadar js ile scroll yaplaim
        WebElement carrers= driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",carrers);

        //carrer butonuna tiklayim
        jse.executeScript("arguments[0].click()",carrers);
        //sonra ekran fotografi cekelim
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver; //casting yaptik
        File tumSayfaResmi = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/allPage" + tarih + ".png"));

    }


}
