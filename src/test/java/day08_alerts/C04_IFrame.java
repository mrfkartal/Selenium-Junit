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
public class C04_IFrame {
    //  ● Bir class olusturun: IframeTest
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
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //   ● Bir metod olusturun: iframeTest
        //      ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin
        //      ve  konsolda    yazdirin.
        WebElement baslikElementi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());

        //      ○ Text Box’a “Merhaba Dunya!” yazin.
        // textbox'i dogru olarak locate etmemize ragmen driver bulamadi
        // bunun uzerine HTML kodlari inceleyince
        // textbox'in aslinda bir IFrame icerisinde oldugunu gorduk
        // bu durumda once iframe'i locate edip
        // switchTo() ile o iFrame'e gecmeliyiz

        WebElement iFrameElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);
        WebElement textkutusu= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textkutusu.clear();
        textkutusu.sendKeys("Mehaba Dunya");

        //      ○ TextBox’in altinda bulunan “Elemental Selenium”
        //      linkinin textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
        // link yazi elementini dogru locate etmemize ragmen yazdirmadi
        // cunku yukarida iFrame'e gecis yapmistik
        // once oradan cikmamiz lazim
        driver.switchTo().defaultContent();
        WebElement linkYaziElementi=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());
        Thread.sleep(5000);
    }
}
