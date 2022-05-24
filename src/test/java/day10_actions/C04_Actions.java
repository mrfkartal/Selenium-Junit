package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

public class C04_Actions extends TestBase {
//    Yeni bir class olusturalim: MouseActions2
//1- https://demoqa.com/droppable adresine gidelim
//            2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
//3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

@Test
    public void test01(){
//    Yeni bir class olusturalim: MouseActions2
//1- https://demoqa.com/droppable adresine gidelim
driver.get("https://demoqa.com/droppable");

//- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    Actions action=new Actions(driver);

    WebElement tasinacakElement=driver.findElement(By.xpath("//div[@id='draggable']"));
    WebElement hedefElementi=driver.findElement(By.xpath("//div[@id='droppable'][1]"));
    action.dragAndDrop(tasinacakElement,hedefElementi).perform();

    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
WebElement sonucyaziElementi=driver.findElement(By.xpath("//div[@id='droppable']"));
    String expectedYazi="Dropped!";
    String actualYazi=sonucyaziElementi.getText();
    Assert.assertEquals(expectedYazi,actualYazi);

}
}
