package testNG;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertPractice {
    Faker faker = new Faker();
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void informationAlert() {
        WebElement jsAlert = driver.findElement(By.xpath("//button[.=\"Click for JS Alert\"]"));
        jsAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement result = driver.findElement(By.cssSelector("#result"));

        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void confirmationAlert() {
        WebElement confirmationAlert = driver.findElement(By.xpath("//button[.=\"Click for JS Confirm\"]"));
        confirmationAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        String expectedValue = "You clicked: Cancel";

        WebElement result = driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(result.getText(),expectedValue);
    }

    @Test
    public void promptAlert() {
        String myTextValue = faker.lorem().word();
        WebElement promptAlert = driver.findElement(By.xpath("//button[.=\"Click for JS Prompt\"]"));
        promptAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(myTextValue);
        alert.accept();

        WebElement result = driver.findElement(By.cssSelector("#result"));

        Assert.assertTrue(result.getText().contains(myTextValue));





    }
}
