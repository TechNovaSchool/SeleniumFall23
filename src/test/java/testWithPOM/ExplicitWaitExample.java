package testWithPOM;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicElementPage;
import utils.Driver;

import java.time.Duration;

public class ExplicitWaitExample {

    @Test
    public void explicitWait() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/1");
        DynamicElementPage dynamicElementPage = new DynamicElementPage();

        dynamicElementPage.startBtn.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dynamicElementPage.helloText));



        String str = dynamicElementPage.helloText.getText();

        Assert.assertEquals(str, "Hello World!");

    }
}
