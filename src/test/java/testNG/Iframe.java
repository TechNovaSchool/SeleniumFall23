package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Iframe {


//1. Create a new class called Iframe
//2. Create new test and create setUps
//3. Go to https://the-internet.herokuapp.com/iframe
//4. Assert : “Your content goes here. “Text is displayed”
//5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void iframePractice() throws InterruptedException {
        WebElement iframe = driver.findElement(By.cssSelector("#mce_0_ifr"));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);

        WebElement paragraph = driver.findElement(By.xpath("//body[.='Your content goes here.']"));

        Assert.assertTrue(paragraph.isDisplayed());

//        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        WebElement headerText = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(headerText.isDisplayed());

    }

}
