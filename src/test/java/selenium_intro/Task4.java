package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {
    public static void main(String[] args) {
//            1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//2. Go to google.com
        driver.get("https://www.google.com");
//3. Write "apple" in search box
        driver.findElement(By.name("q")).sendKeys("apple", Keys.ENTER);
//4. Click google search button
//5. Verify title it should contain a word "apple"
        String expectedTitle = "apple";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Fail");
        }
    }
}
