package testWithPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicElementPage;
import utils.Driver;

public class ThreadSleepExample {

    @Test
    public void threadSleep() throws InterruptedException {
        DynamicElementPage dynamicElementPage = new DynamicElementPage();
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/1");
        dynamicElementPage.startBtn.click();
        Thread.sleep(7000);

        String actualText = dynamicElementPage.helloText.getText();

        Assert.assertEquals(actualText, "Hello World!");
    }
}
