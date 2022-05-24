package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class C01_Faker extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //facebook sayfasina gidip
        driver.get("https://www.facebook.com");
        //yeni kayit olustur butona basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //isim kutunu locate edip
        WebElement isimkutusu = driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));
        //geriye kalan alanlari tab ile dolasarak
        //formu doldurun

        Actions action = new Actions(driver);
        Faker faker=new Faker();
        String fakeMail=faker.internet().emailAddress();
        action.click(isimkutusu).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(fakeMail).
                sendKeys(Keys.TAB).
                sendKeys(fakeMail).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).
                sendKeys("Oca").
                sendKeys(Keys.TAB).
                sendKeys("1978").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                click().
                perform();

        Thread.sleep(15000);
    }
}