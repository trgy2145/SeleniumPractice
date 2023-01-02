package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

public class C01_DragAndDrop extends TestBase {
    @Test
    public void test01(){

        // https://demoqa.com/droppable adresine git
        driver.get("https://demoqa.com/droppable");

        // "Drag me" butonunu tutup "Drop here" kutusunun üstüne koyun.
        WebElement dragMeElement = driver.findElement(By.id("draggable"));
        WebElement dropHereElement = driver.findElement(By.id("droppable"));
        Actions actions =  new Actions(driver);
        actions.dragAndDrop(dragMeElement,dropHereElement).perform();
        ReusableMethod.wait(3);

        //"Drop here" yazısı yerine "Dropped!" oldugunu test edin
        WebElement droppedTextElement =  driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertTrue(droppedTextElement.isDisplayed());

    }
}
