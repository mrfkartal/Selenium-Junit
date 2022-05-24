package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthetication {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); adresine gidin.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }
}
