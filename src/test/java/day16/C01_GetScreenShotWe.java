package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAndAfterClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Watchable;

public class C01_GetScreenShotWe extends TestBaseBeforeAndAfterClass {

    @Test
    public void test1() throws IOException {
        //amazon.com sayfasina gidelim
        driver.get("https://amazon.com");
        //Nutella aratalim
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Nutella", Keys.ENTER);
        //Arama sonucunun resmini alalim

        WebElement aramaSonucu = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(aramaSonucu.isDisplayed());
        File nutellaAramaSonucu = aramaSonucu.getScreenshotAs(OutputType.FILE);

        //sadece web elementin resmini alacaksak TakeScreeShoot class dan obj olusturmaya gerek yok
        // Locate edile WE direkt gecici bir file a atip FileUtils ile kopyalayip yolunu(-path) belirtiriz
        FileUtils.copyFile(nutellaAramaSonucu, new File("target/ekranGoruntusuWe/" + tarih + "WebEss.Jpeg"));


    }
}
