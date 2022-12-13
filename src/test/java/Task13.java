import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task13 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/radio-button");
        driver.findElement(By.xpath("//label[@for=\"impressiveRadio\"]")).click();
        System.out.println(driver.findElement(By.xpath("//span[.=\"Impressive\"]")).isDisplayed());

        WebElement noRadio = driver.findElement(By.xpath("//label[@for=\"noRadio\"]"));

        if(!(noRadio.isSelected())){
            System.out.println("Test Pass");
        }
        else{
            System.out.println("Test fail");
        }

        if(!noRadio.isDisplayed()){
            System.out.println("Test Pass");
        }
        else{
            System.out.println("Test fail");
        }


    }
}
