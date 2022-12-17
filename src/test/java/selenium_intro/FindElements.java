package selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        List<WebElement> list = driver.findElements(By.xpath("//body//a"));

        int expectedValue = 19;
        int actualSize = list.size();
        System.out.println(actualSize);

        if(expectedValue == actualSize){
            System.out.println("Test Pass");
        }
        else{
            System.out.println("Test Fail");
        }
    }
}
