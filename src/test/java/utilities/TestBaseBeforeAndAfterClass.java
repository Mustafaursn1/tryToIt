package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeAndAfterClass {

    protected static WebDriver driver;
    protected static String tarih;//screenShoot a kullanmak icn bunu yaptik.

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        LocalDateTime localeDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        //date formata aldik dosya adinda noktalama kabül etmeyecgi icin bunu yaptik
        System.out.println(localeDateTime);
        tarih = localeDateTime.format(dateTimeFormatter);



    }


    @AfterClass
    public static void tearDown() {
        //driver.quit();
        if (driver != null) {
            driver.quit();
        }
    }

}
