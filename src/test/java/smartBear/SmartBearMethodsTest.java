package smartBear;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartBearMethodsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBear.loginToSmartBear(driver);
//        SmartBear.verifyOrder(driver,"Paul Brownrrrr");
        SmartBear.printNamesAndCities(driver);
    }
}
