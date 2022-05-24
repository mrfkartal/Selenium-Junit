package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void test01(){
        /*
        herhangi bir web sitesine gidince veya
        bir websitesinde herhangi biri slem yaptigimizda ortaya cikan uyarilara
        alert diyoruz

        eger bir alert inspect yapilabiliyorsa o alert otomasyon ile kullanilabilir,
        bu tur alertlere HTML ALERT denir ve bunlar icin ekstra bir islem yapmaya
        gerek yoktur. tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz
           driver.get("https://www.facebook.com"); DA CIKAN ALERT GIBI

           ancak wb uygulamalarinda HTML alert yaninda java script alert de bulunablir
           js alertler locate edilemezler
           Seleniumda JS alertler icin ozel bir yontem gelistirmistir
  */


        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

            //alertte  OK TUSUNA BASINA
        driver.switchTo().alert().accept();

        //result kisminda "you succesfully clicked an alert"
        //yazdigini test edin

        String expectedResult="You succesfully clicked an alert";
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));

        String actualResultYazisi=sonucYaziElementi.getText();
        Assert.assertEquals(expectedResult,actualResultYazisi);
    }




}



