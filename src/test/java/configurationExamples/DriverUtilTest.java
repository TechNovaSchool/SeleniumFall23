package configurationExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Config;
import utils.Driver;

public class DriverUtilTest {

    @BeforeClass
    public void testDriver() {
        Driver.getDriver().get(Config.getProperty("urlSmartBear"));
    }
    @Test
    public void testConfig() {
        WebElement username = Driver.getDriver().findElement(By.cssSelector("input[name*=\"username\"]"));
        WebElement password = Driver.getDriver().findElement(By.cssSelector("div>input[name*=\"password\"]"));
        WebElement loginBtn =  Driver.getDriver().findElement(By.cssSelector("input[class*=\"button\"]"));

        username.sendKeys(Config.getProperty("login"));
        password.sendKeys(Config.getProperty("pass"));
        loginBtn.click();
    }

    @AfterClass
    public void tearDown() {
        Driver.quitDriver();
    }
}
