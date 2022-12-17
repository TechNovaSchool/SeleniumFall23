package smartBear;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyOrderDate {
    public static void main(String[] args) {
//        TC#1. Open browser and login to smartbear software
//        2. Click on view all orders
//        3. Verify SusanMcLaren has order on date “01/05/2010”

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        SmartBear.loginToSmartBear(driver);

        WebElement susanDateInTable = driver.findElement(By.xpath("//td[.=\"Susan McLaren\"]/../td[5]"));

        String actualDate = susanDateInTable.getText();
        String expectedDate = "01/05/2010";

        if (actualDate.equals(expectedDate)) {
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Fail");
        }


  }



}
