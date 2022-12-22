package configurationExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.Config;

public class ConfigTest {

    @Test
    public void testConfig() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(Config.getProperty("urlSmartBear"));
        WebElement username = driver.findElement(By.cssSelector("input[name*=\"username\"]"));
        WebElement password = driver.findElement(By.cssSelector("div>input[name*=\"password\"]"));
        WebElement loginBtn =  driver.findElement(By.cssSelector("input[class*=\"button\"]"));

        username.sendKeys(Config.getProperty("login"));
        password.sendKeys(Config.getProperty("pass"));
        loginBtn.click();


    }

}
