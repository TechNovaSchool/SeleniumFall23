package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task5 {
    public static void main(String[] args) {

//        Task #5 -- Basic login authentication
//        1. Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        2. Go to :
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
//        3. Enter username : Tester
        driver.findElement(By.cssSelector("input[name*=\"username\"]")).sendKeys("Tester");
//        4. Enter Password: test
        driver.findElement(By.cssSelector("div>input[name*=\"password\"]")).sendKeys("test");
//        5. Click "Sign In" button
        driver.findElement(By.cssSelector("input[class*=\"button\"]")).click();

//        6. Verify title equals --> expected Web Orders
        System.out.println(driver.getTitle().contains("Web Orders"));
    }
}
