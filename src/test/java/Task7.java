import com.github.dockerjava.api.model.Task;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task7 {
    public static void main(String[] args) {
//        Task #7 --> Zero Bank header verification
//        1. Open a Chrome browser
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
//        2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
//        3. Check header textExpected --> "Log in to ZeroBank"
        String textExpected = "Log in to ZeroBank";
        String actualHeader = driver.findElement(By.tagName("h3")).getText();

        if(actualHeader.equals(textExpected)){
            System.out.println("Test Pass");
        }
        else{
            System.out.println("Test fails");
        }
        // 4.CLose the session
//        driver.close();
    }
}
