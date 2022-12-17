package selenium_intro;

import com.github.dockerjava.api.model.Task;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task14 {
    public static void main(String[] args) {
//        Task #14 - Check all link on the page
//        Open Chrome browser
//        Go to https://www.technovaschool.com/
//        Count the number of the links on the web-page (expected 30)
//        Print out all the texts of the links on the page
//        Count the number of the links that doesn't have text (expected 19)

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.technovaschool.com/");
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.xpath("//body//a"));

        int linksOnPage = links.size();

        if(linksOnPage == 30){
            System.out.println("Test 1 Pass");
        }
        else {
            System.out.println("Test 1 Fail");
        }

        int linkWithoutText = 0;
        for(WebElement link:links){
            System.out.println(link.getText());
            if(link.getText().isEmpty()){
                linkWithoutText++;
            }
        }
        System.out.println(linkWithoutText);

        if(linkWithoutText == 16){
            System.out.println("Test 2 Pass");
        }
        else {
            System.out.println("Test 2 Fail");
        }




    }
}
