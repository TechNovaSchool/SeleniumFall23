package smartBear;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SmartBear {
    public static void main(String[] args) {
//        TC    #1: Smartbear   software    link    verification
//        1.Open   browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
//        2.Go to  website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//        3.Enter username: "Tester"
//        4.Enter password: "test"
//        5.Click to Login button
//
//        driver.findElement(By.cssSelector("input[name*=\"username\"]")).sendKeys("Tester");
////        4. Enter Password: test
//        driver.findElement(By.cssSelector("div>input[name*=\"password\"]")).sendKeys("test");
////        5. Click "Sign In" button
//        driver.findElement(By.cssSelector("input[class*=\"button\"]")).click();

        loginToSmartBear(driver);
//        6. Print out count of all the links on landing page
        List<WebElement> links = driver.findElements(By.xpath("//body//a"));
        System.out.println(links.size());
//        7.Print out each link text on this page
        for (WebElement link: links){
            System.out.println(link.getText());
        }
//
//        Mini-Task:
//        1. Create a method called loginToSmartBear
//        2. This method simply logs in to SmartBear when you call it

    }
    public static void loginToSmartBear( WebDriver driver) {
        WebElement username = driver.findElement(By.cssSelector("input[name*=\"username\"]"));
        WebElement password = driver.findElement(By.cssSelector("div>input[name*=\"password\"]"));
        WebElement loginBtn =  driver.findElement(By.cssSelector("input[class*=\"button\"]"));

        username.sendKeys("Tester");
        password.sendKeys("test");
        loginBtn.click();
    }
}
