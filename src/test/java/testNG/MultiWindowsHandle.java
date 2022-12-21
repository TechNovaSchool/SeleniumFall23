package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultiWindowsHandle {

  //1. Create a new class called : WindowHandlePractice
//2. Create new test and create setUps
//3. Go to https://the-internet.herokuapp.com/windows
//4. Assert title is “The Internet”
//5. Click on “Click Here” text
//6. Switch to the new Window
//7. Assert:Title is “New Window”

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void windowsHandle() {
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);

        String actualTile = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTile, expectedTitle,"The Title is incorrect");

        WebElement clickHereBtn = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereBtn.click();


        for(String window: driver.getWindowHandles()){
            if(!window.equals(mainWindow)){
                driver.switchTo().window(window);
            }
        }
        String secondWindow = driver.getWindowHandle();

        Assert.assertEquals(driver.getTitle(), "New Window");
        System.out.println(driver.getTitle());

        driver.switchTo().window(mainWindow);
    }

}
