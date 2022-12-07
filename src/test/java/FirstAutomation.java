import com.github.dockerjava.api.model.Task;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAutomation {
    //main or psvm
    public static void main(String[] args) {
        //this line will create connection between selenium and webdriver
        WebDriverManager.chromedriver().setup();
        //we create instance of chrome driver
        WebDriver driver = new ChromeDriver();
        // next line it will navigate to google website
        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());
        driver.get("https://www.etsy.com");

        driver.navigate().back();

       driver.navigate().forward();
       System.out.println(driver.getTitle());

       driver.close();
    }

//    Task #1
//        1.Open Chrome browser
//        2.Go to https://www.google.com
//        3.Verify title: Expected title is Google
//
//
//        Task#2
//        1.Open Chrome browser
//        2.Go to https://www.technovaschool.com/
//        3.Verify URL contains : technovaschool-skip
//        4.Verify title expected: IT School Online | Tech Nova School





}
