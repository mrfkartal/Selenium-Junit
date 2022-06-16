package day13_cookies_webTables;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utulities.TestBase;


import java.util.List;

public class WebTables_StudentSession extends TestBase {

   @Test
   public void webTableTest(){
       //Bir Class olusturun D19_WebtablesHomework

       //  1. “https://demoqa.com/webtables” sayfasina gidin
       System.out.println("TASK1");
       driver.get("https://demoqa.com/webtables");

       //  2. Headers da bulunan department isimlerini yazdirin
       // //div[@class = 'rt-resizable-header-content']
       //div[@class = 'rt-tr-group']//div[@class='rt-td'][6]
       System.out.println("TASK2");
       System.out.println("--------");
       List <WebElement> headersList = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
       //headersList.stream().forEach(t->System.out.println(t.getText()));

       int departmentIndex = 0;
       for (int i = 0; i < headersList.size(); i++) {
           if (headersList.get(i).getText().equals("Department")) {
               departmentIndex = i;
           }
       }
       departmentIndex++;

       List <WebElement> departmentsList = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td']["+departmentIndex+"]"));
       departmentsList.
               stream().
               filter(t->!(t.getText().equals(" "))).
               forEach(t->System.out.println(t.getText()));

       //  3. 3. sutunun basligini yazdirin
       System.out.println("TASK3");
       System.out.println("--------");
       System.out.println(headersList.get(2).getText());

       //  4. Tablodaki tum datalari yazdirin
       // //div[@class = 'rt-tbody']
       System.out.println("TASK4");
       System.out.println("--------");
       WebElement tumtable = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
       System.out.println(tumtable.getText());

       //  5. Tabloda kac cell (data) oldugunu yazdirin
       // //div[@class = 'rt-tbody']//div[@class='rt-td']
       System.out.println("TASK5");
       System.out.println("--------");
       List<WebElement> tumCelller = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td']"));
       System.out.println(tumCelller.size());

       //  6. Tablodaki satir sayisini yazdirin
       //div[@class = 'rt-tr-group']
       System.out.println("TASK6");
       System.out.println("--------");
       List<WebElement> satirlar = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']"));
       System.out.println(satirlar.size());

       //  7. Tablodaki sutun sayisini yazdirin
       System.out.println("TASK7");
       System.out.println("--------");
       System.out.println(headersList.size());

        //  8. Tablodaki 3.kolonu yazdirin
        //div[@class = 'rt-tr-group']//div[@class='rt-td'][3]
        System.out.println("TASK8");
        System.out.println("--------");
        List <WebElement> kolon3 = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][3]"));
        kolon3.
                stream().
                forEach(t->System.out.println(t.getText()));

        ////  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //div[@class = 'rt-tr-group']//div[@class='rt-td'][1]
        //div[@class = 'rt-tr-group']//div[@class='rt-td'][5]
        System.out.println("TASK9");
        System.out.println("--------");
        List<WebElement> isimlerList = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][1]"));
        List<WebElement> salaryList = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][5]"));
        for (int i = 0; i < isimlerList.size(); i++) {
            if (isimlerList.get(i).getText().equals("Kierra")) {
                System.out.println(salaryList.get(i).getText());
            }
        }

        // 10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        System.out.println("TASK10");
        System.out.println("--------");
        int satir = 2;
        int sutun = 2;
        hucreYazdir(satir, sutun);
    }

    private void hucreYazdir(int satir, int sutun) {
        WebElement istenenHucre = driver.findElement(By.xpath("//div[@class='rt-tr-group']["+satir+"]//div[@class='rt-td']["+sutun+"]"));
        System.out.println(istenenHucre.getText());
    }
}