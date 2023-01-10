package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBaseReport {
    protected static ExtentReports extentReports; // extent rapora ilk atamayı yapar
    protected static ExtentTest extentTest ;//test failed veya pass gibi bilgileri kaydeder.
    protected static ExtentHtmlReporter extentHtmlReporter; // html raporu düzenler

    // test işlemine baslamadan hemen önce(test metodundan önce değil , tüm test işleminden önce)
    @BeforeTest(alwaysRun = true)
    public void setUpTest(){
        extentReports =  new ExtentReports();// raporlamayı baslatır
        // rapor olustuktan sonra raporumuz nereye eklensin istiyorsanız buraya yazıyorsunuz

        String date =  new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir")+ "/test-output/Rapor"+date+".html";
        //olusturmak istediğimiz raporu (html formatında) baslatıyoruz, file path ile dosya yolunu belirliyoruz

        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);

        // istediğiniz bilgileri buraya ekleyebilirsiniz
        extentReports.setSystemInfo("Enviroment","QA");
        extentReports.setSystemInfo("Browser",ConfigReader.getProperty("browser"));// chrome vs
        extentReports.setSystemInfo("Automation Engineer","Turgay");
        extentHtmlReporter.config().setDocumentTitle("Son test");
        extentHtmlReporter.config().setReportName("TestNG Reports");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) { // eğer test basarısız olursa
            String screenshotLocation = ReusableMethod.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());


        }else if (result.getStatus()==ITestResult.SKIP){// eger test calıstırılmadan gecilmezse
            extentTest.skip("Test case is skipped: " + result.getName());

        }
        // Driver.closeDriver();
    }

    // raporlamayı sonlandırmak icin
    @AfterTest(alwaysRun = true)
    public void tearDownTest(){
        extentReports.flush();
    }

}
