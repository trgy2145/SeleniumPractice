package day12_webtables_excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_WebTables extends TestBase {
    // https://demoqa.com/webtables

    @Test
    public void test01(){
    driver.get("https://demoqa.com/webtables");
        WebElement deneme =  driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])[3]"));
        System.out.println(deneme.getText());
    }
}
