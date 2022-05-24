package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utulities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {
    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //  Iki metod icin de asagidaki adimlari test edin.
    @Test
    public void name() {

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement ItsgoneYaziElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        //WebElement ItsbackYaziElementi=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(ItsgoneYaziElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement ItsbackYaziElementi=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(ItsbackYaziElementi.isDisplayed());
    }

    @Test
    public void explicitWaitTesti() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement ItsgoneYaziElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(ItsgoneYaziElementi));
        Assert.assertTrue(ItsgoneYaziElementi.isDisplayed());


        YAzinin gorunur olmasini beklerken yazinin locate ini kullanmak sorun olusturur
         cunku henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir.
         (HTML KODLARI YAZAN DEVELOPER FARKLI UYGULAMALAR YAPABILIR)

         BU DURUMDA BEKLEME ISLEMI VE LOCATE I BIRLIKTE YAPMALIYIZ
*/

        WebElement ItsgoneYaziElementi=wait.until(ExpectedConditions.
                                    visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        Assert.assertTrue(ItsgoneYaziElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));

        Assert.assertTrue(itsBackElementi.isDisplayed());
    }
    }

