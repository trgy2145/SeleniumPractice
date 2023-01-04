package day10_fileTests;

import org.junit.Test;

public class C01_FileInputStream {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));
        // o anda calısan dosyanın yolunu verir.
        // C:\Users\trgy2\OneDrive\Masaüstü\SeleniumPractice\com.JunitExercise

        System.out.println(System.getProperty("user.home"));
        // kullanıcının temel path ini verir.
        //C:\Users\trgy2
        //C:\Users\trgy2   masa üstüne gitmek istersen buna + onedriver\masaüstü eklemek yeterli olacak

        // kodlarımızın dinamik olması yani kişinin pc deki kullanıcı adı gibi detaylara takılmaması icin
        // file testlerinde kullanıcalacak dosya yolunu user.home... calıstıgı pc den alacak sekilde olustururuz.

        String dynamicPath = System.getProperty("user.home") +"\\OneDrive\\Masaüstü\\selenium.txt";

    }
}
