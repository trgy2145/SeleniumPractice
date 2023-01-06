package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethod {

    public static void wait(int second){
        //throws yapma yoksa cagırdıgın yerdede throws yapman lazım
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            System.out.println("yeniden kontrol et..");
        }
    }

    public static void allPageSS(WebDriver driver) {
        TakesScreenshot tss = (TakesScreenshot) driver;


        // resmi son olarak kaydedeceğimiz dosyayı olustur
        // burda dosya yolu dinamic değil ,herzaman en son calıstırılanı kaydeder bundan
        // krtulmak icin tarih opsiyonu ekleyebilirsin
        LocalTime ltd =  LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String date = ltd.format(dtf);
        String filePath = "target/screenShot/allPage"+date+".jpeg";
        File allPageSS = new File(filePath);

        // tss objesini kullanıp ekran dosyasını gecici dosyaya kaydet

        File tempFile =  tss.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı ana dosyaya ekle

        try {
            FileUtils.copyFile(tempFile,allPageSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
