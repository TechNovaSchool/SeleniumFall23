import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectors {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
//
//        driver.findElement(By.cssSelector("#ctl00_MainContent_username"))
//                .sendKeys("Tester");
//        driver.findElement(By.cssSelector(".button")).click();
//        1. Open browser
//        2. Go to https://amazon.com/
        driver.get("https://amazon.com/");
//        3. Enter any search term
        driver.findElement(By.cssSelector(".nav-search-field>input"))
                .sendKeys("apple");
        driver.findElement(By.xpath("//myxpath")).click();
//        4. Click search button
        driver.findElement(By.cssSelector("input[type='submit']")).click();
//        5. Verify title contains the search term
        System.out.println(driver.getTitle().contains("apple"));
//        USE CSS SELECTOR TO LOCATE WEBELEMENT

    }
}
