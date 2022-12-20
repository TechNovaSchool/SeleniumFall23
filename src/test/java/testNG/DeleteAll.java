package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import smartBear.SmartBear;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeleteAll {

    //    Task DeleteAll
//1. Open a chrome browser
//2. Go to :http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
// 3. Enter username : “Tester”
// 4. Enter password: “test”
// 5. Click on logon button
//6. Click checkAll
//7. Click “Delete Selected”
//8. Assert “List of orders is empty. In order to add new order use  this link.” text is displayed
    WebDriver driver;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void deleteAllEntries() {
        SmartBear.loginToSmartBear(driver);
        WebElement checkAllBtn = driver.findElement(By.cssSelector("a[id*=\"btnCheckAll\"]"));
        checkAllBtn.click();
        driver.navigate().refresh();
        WebElement deleteBtn = driver.findElement(By.cssSelector("input[id*=\"btnDelete\"]"));
        deleteBtn.click();


        WebElement message = driver.findElement(By.cssSelector("#ctl00_MainContent_orderMessage"));

        Assert.assertTrue(message.isDisplayed());
    }

    @Test
    public void deleteOrder(String givenName) {
        SmartBear.loginToSmartBear(driver);
        givenName = "Samuel Clemens";

        WebElement checkBox = driver.findElement(By.xpath("//table[@class=\"SampleTable\"]/tbody/tr/td[.='" + givenName + "']/../td[1]"));
        checkBox.click();


        WebElement deleteBtn = driver.findElement(By.cssSelector("input[id*=\"btnDelete\"]"));
        deleteBtn.click();
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@class=\"SampleTable\"]/tbody/tr/td[2]"));
        for (WebElement names : allNames) {
            Assert.assertNotEquals(givenName, names.getText());
        }
    }


    @AfterClass
    public void tearDown() {
       driver.quit();
    }

}
