package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {
        //        1.Open Chrome browser
 //        2.Go to https://www.google.com
//        3.Verify title: Expected title is Google
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        String webAddress = "https://www.qa-env.google.com";

        driver.get(webAddress);

        if (driver.getTitle().equals("Google")) {
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Fails");
        }

        System.out.println(driver.getTitle());

    }
}
