package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import smartBear.SmartBear;

import java.util.List;

public class EditsInSmartBear {

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

    //    Task 2 — Edit order
//1. Open browser and login to SmartBear
//2. Click to edit button from the right for “Steve Johns”
// 3. Change the name to “ your favorite actor/ sport star”
// 4. Click Update
//5. Assert “your actor name” is in the list
    @Test
    public void editOrder() {
        String givenName = "Steve Johns";
        SmartBear.loginToSmartBear(driver);
        WebElement editBtn = driver.findElement(By.xpath("//table[@class=\"SampleTable\"]/tbody/tr/td[.='" + givenName + "']/../td[13]"));
        editBtn.click();

        WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.clear();
        customerName.sendKeys("Jim Carrey");

        WebElement updateBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_UpdateButton"));
        updateBtn.click();

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@class=\"SampleTable\"]/tbody/tr/td[2]"));

        for (WebElement name : allNames) {
//            if (name.getText().equals("Jim Carrey")) {
//                Assert.assertEquals(name.getText(), "Jim Carrey", "The name is not in the list");
//            } else {
//                Assert.fail();
//            }
                    Assert.assertEquals( name.getText(), "Paul Brown");

        }
    }

//    Task 3 — Create a method called removeName()
//1. Accept two parameters: Webdriver, String name
//2. Method will remove the given name from the list of SmartBear
//3. Create a new TestNG test, and call your method
//4. Assert that your method removed the given name

    public void removeName(WebDriver driver, String giveName) {
        SmartBear.loginToSmartBear(driver);
        WebElement nameToBeDeletedCheckbox = driver.findElement(By.xpath("//table[@class=\"SampleTable\"]/tbody/tr/td[.='" + giveName + "']/../td[1]"));
        nameToBeDeletedCheckbox.click();

        WebElement deleteSelected = driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete"));
        deleteSelected.click();

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@class=\"SampleTable\"]/tbody/tr/td[2]"));

        for (WebElement name : allNames) {
//            Assert.assertNotEquals(giveName, name.getText());
            Assert.assertFalse(name.getText().equals(giveName));
        }

    }

    @Test
    public void verifyRemove() {
        removeName(driver,"Bob Feather");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
