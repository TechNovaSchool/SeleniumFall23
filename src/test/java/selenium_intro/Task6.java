package selenium_intro;

import com.github.dockerjava.api.model.Task;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class Task6 {
    public static void main(String[] args) {
//        Task #6 -- Etsy Title Verification
//        1. Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
//        3. Search for gift box
        driver.findElement(By.id("global-enhancements-search-query"))
                .sendKeys("gift box", Keys.ENTER);
//        4. Verify title --> expected Gift box - Etsy

        if(driver.getTitle().equals("Gift box - Etsy")){
            System.out.println("Pass");
        }
        else {
            System.out.println("Fails");
        }
    }
}
