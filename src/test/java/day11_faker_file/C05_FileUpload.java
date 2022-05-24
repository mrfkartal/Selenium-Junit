package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.

        /*
         dosya yukleme islemini selnium ile yapma imkanimiz yok cunku web tabanli
         bir uygulama degil
        bu durumda sendKeys() imdadimiza yetisir
        eger chooseFile butonuna var olan bir dosyanin dosya yolunu yollarsaniz
        secme islemi otomatik olarak yapilmis olacaktir.
         */


        // 1.adim cjhoose file butonunu locate edelim
        WebElement dosyaSecButonu= driver.findElement(By.id("file-upload"));

        // 2.adim yuklenecek doyanin dosya yolunu olusturalim
        // biz masaustundeki text.txt dosyasini yukleyelim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim= "\\Desktop\\text.txt";
        String yuklenecekDosya= farkliKisim+ortakKisim;

        // 3. adim sendKeys ile dosya yolunu, secme butonuna yollayalim
        dosyaSecButonu.sendKeys(yuklenecekDosya);

        //Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement yaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());

        Thread.sleep(5000);
    }
}
