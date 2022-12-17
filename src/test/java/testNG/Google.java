package testNG;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.security.Key;

public class Google {
    WebDriver driver;
    Faker faker = new Faker();

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void verifyTitle(){
        String searchValue = faker.lorem().word();
        WebElement searchBar = driver.findElement(By.cssSelector("input[name='q']"));

        searchBar.sendKeys(searchValue, Keys.ENTER);
        String actualTile = driver.getTitle();
        String expectedTitle = searchValue;

        Assert.assertTrue(actualTile.contains(expectedTitle), "Title is wrong");

    }
    @Ignore
    @Test
    public void verifyTitle2(){
        String searchValue = faker.lorem().word();
        WebElement searchBar = driver.findElement(By.cssSelector("input[name='q']"));

        searchBar.sendKeys(searchValue, Keys.ENTER);
        String actualTile = driver.getTitle();
        String expectedTitle = "fail";

        Assert.assertTrue(actualTile.contains(expectedTitle), "Title is wrong");

    }
}
