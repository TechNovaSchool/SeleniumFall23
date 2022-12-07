import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) {
        //        Task#2
//        1.Open Chrome browser
//        2.Go to https://www.technovaschool.com/
//        3.Verify URL contains : technovaschool
//        4.Verify title expected: IT School Online | Tech Nova School

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.technovaschool.com/");

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "technovaschool";

        if(actualURL.contains(expectedURL)){
            System.out.println("Test Pass");
        }
        else{
            System.out.println("Test Fail");
        }
        System.out.println(driver.getTitle());

        String actualTitle = driver.getTitle();
        String expectedTitle = "IT School Online | Tech Nova School";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test for title pass");
        }
        else {
            System.out.println("Test for title fail");
        }



    }
}
