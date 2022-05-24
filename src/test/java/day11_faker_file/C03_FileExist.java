package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test1() {

        System.out.println(System.getProperty("user.dir"));
        //bana ıcınde oldugum projenın dosya yolunu (path) verır
        //C:\Users\ömer\IdeaProjects\com.Batch59JUnit


        System.out.println(System.getProperty("user.home"));
        //C:\Users\ömer yani benim bilgisayarimin bana ozel kismini verdi

        //C:\Users\ömer\Downloads
        //C:\Users\ömer\IdeaProjects\com.Batch59JUnit\src/test/java/day05_JUnit


        //homePath + "/Dowloads


        //MAsaustumuzdeki text dosyamizin varligini test edin
        //"C:\Users\ömer\Desktop/text.txt"

        String dosyaYolu=System.getProperty("user.home")+ "\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

        /*
        bilgisayarimizdaki bir dosyanin varlgini test etmek icin once o dosyaya
        ulasmamiz gerekir
       java da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
       Her bilgisayarin kullanci adi farkli olacagindan masustu dosya yolu  da
       birbirinden  farkli olacakatir
       Testlerimizin tum bilgisayarlrda calismasi icin dosya yolunu dinamik yapmak
       zorundatyiz
*/
       //Bunun icin
       //her bilgisauarin birbirinden farkli olan yolunu bulmak icin
       String farkkliKisim=System.getProperty("user.home");

       //herkesin bilgisayarinda ortak olan kisim ise
       String ortakKisim="\\Desktop\\text.txt";

       String masaustudosyAyolu=farkkliKisim+ortakKisim;

        ///System.out.println(Files.exists(Paths.get(masaustudosyAyolu)));

        Assert.assertTrue(Files.exists(Paths.get(masaustudosyAyolu)));

    }
}
