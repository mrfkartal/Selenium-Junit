package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //amazon anasayfaya gidip
        //account menusunden create a ist linkine tiklayalim
        driver.get("https://www.amazon.com");

        Actions action=new Actions(driver);

        WebElement accountlinki= driver.findElement(By.xpath("//*[text()='Account & Lists']"));

        action.moveToElement(accountlinki).perform();

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        Thread.sleep(5000);
    }

}
