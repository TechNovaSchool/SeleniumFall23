import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task11 {
    public static void main(String[] args) {
//        1. Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        2. Go to https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
//        3. Verify Checkbox 2 is Checked

        if (driver.findElement(By.xpath("(//input)[2]")).isSelected()){
            System.out.println("Test 1 Pass");
        }
        else{
            System.out.println("Test 1 fail");
        }

//        4. Click on check-box 1
        driver.findElement(By.xpath("(//input)[1]")).click();
//        5. Verify CheckboxOne is Checked

        if (driver.findElement(By.xpath("(//input)[1]")).isSelected()){
            System.out.println("Test 2 Pass");
        }
        else{
            System.out.println("Test 2 fail");
        }
    }
}
