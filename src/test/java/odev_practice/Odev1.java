package odev_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");


        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@name='search_query']"));
        aramaKutusu.sendKeys("Neşet Ertaş - Gel Sevelim Sevileni Sevelim");
        aramaKutusu.submit();
        //driver.findElement(By.xpath("//img[@id='thumbnail']")).click();
        driver.findElement(By.xpath("//div[@id='title-wrapper']")).click();
        Thread.sleep(10000);
        //driver.findElement(By.xpath("//div[@id='ad-image:4']")).click();
        driver.findElement(By.xpath("//*[@id=\"video-title\"]")).click();

    }
}
