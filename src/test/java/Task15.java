import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task15 {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String phoneNumber = faker.phoneNumber().cellPhone().replace(".","-");
        String emailAddress = faker.expression(firstName+lastName+"@gmail.com");
        String address = faker.address().streetAddress();
        String city = faker.address().cityName();
        String state = faker.address().stateAbbr();
        String zipCode = faker.address().zipCode().substring(0,5);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/test/newtours/register.php");

//       driver.findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys(faker.name().firstName());

        WebElement firstNameInput = driver
                .findElement(By
                        .xpath("//input[@name=\"firstName\"]"));
        WebElement lastNameInput = driver
                .findElement(By
                        .xpath("//input[@name=\"lastName\"]"));

        WebElement phoneInput = driver
                .findElement(By
                        .xpath("//input[@name=\"phone\"]"));
        WebElement emailInput = driver
                .findElement(By
                        .xpath("//input[@name=\"userName\"]"));

        WebElement addressInput = driver
                .findElement(By
                        .xpath("//input[@name=\"address1\"]"));

        WebElement cityInput = driver
                .findElement(By
                        .xpath("//input[@name=\"city\"]"));
        WebElement stateInput = driver
                .findElement(By
                        .xpath("//input[@name=\"state\"]"));
        WebElement postalCodeInput = driver
                .findElement(By
                        .xpath("//input[@name=\"postalCode\"]"));
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        phoneInput.sendKeys(phoneNumber);
        emailInput.sendKeys(emailAddress);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        stateInput.sendKeys(state);
        postalCodeInput.sendKeys(zipCode);

        WebElement countryDropdown = driver.findElement(By.xpath("//select[@name='country']"));

        Select select = new Select(countryDropdown);

//        select.selectByVisibleText("BARBADOS");
       //select.selectByIndex(2);
//        select.selectByValue("ARUBA");

         WebElement firstOption = select.getFirstSelectedOption();
        System.out.println(firstOption.getText());

        List<WebElement> dropdownOptions = select.getOptions();










    }
}
