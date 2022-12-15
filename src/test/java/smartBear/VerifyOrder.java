package smartBear;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class VerifyOrder {
    public static void main(String[] args) {
      Faker faker = new Faker();
//        Smartbear software order placing
//        1.Open   browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
//        2.Go to  website:    http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//        3.Enter username: "Tester"
//        4.Enter password: "test"
//        5.Click on Login button
        SmartBear.loginToSmartBear(driver);
//        6.Click on Order
        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();
        //7.Select familyAlbum from product, set quantity to 2
        WebElement dropDown = driver.findElement(By.xpath("//select[@ id=\"ctl00_MainContent_fmwOrder_ddlProduct\"]"));

        Select select = new Select(dropDown);
        select.selectByValue("FamilyAlbum");

        WebElement quantityBox = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]"));
//        quantityBox.clear();
        quantityBox.sendKeys(Keys.BACK_SPACE, "2");
        //8.Click to "Calculate"button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@ type=\"submit\"]"));
        calculateButton.click();

        //•Identify webElements: name, street, city, state, zip code
        WebElement customerNameInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_txtName\"]"));
        WebElement streetInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_TextBox2\"]"));
        WebElement cityInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_TextBox3\"]"));
        WebElement stateInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_TextBox4\"]"));
        WebElement zipCodeInput = driver.findElement(By.xpath("//input[@ id=\"ctl00_MainContent_fmwOrder_TextBox5\"]"));
//
        customerNameInput.sendKeys(faker.name().fullName());
        streetInput.sendKeys(faker.address().streetAddress());
        cityInput.sendKeys(faker.address().city());
        stateInput.sendKeys(faker.address().stateAbbr());
        zipCodeInput.sendKeys(faker.address().zipCode().substring(0,5));

        WebElement creditCard = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_0"));
//        10.Click on "visa" radio button

        creditCard.click();
        WebElement cardNumber = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]"));
        cardNumber.sendKeys(faker.finance().creditCard(CreditCardType.VISA).replaceAll("-",""));
        WebElement date = driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]"));
        date.sendKeys("12/12");
        //1234-1234-1234-1234.replaceAll("-", "")
//        11.Generate card number using JavaFaker
        WebElement processBtn = driver.findElement(By.xpath("//a[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]"));
        processBtn.click();
//        12.Click on "Process"

//        13. Verify success message "New order has been successfully added."
        WebElement msg = driver.findElement(By.xpath("//div[@class=\"buttons_process\"]/strong"));
        if (msg.isDisplayed()){
            System.out.println("Test Pass");
        }
        else {
            System.out.println("Test Fail");
        }

    }
}
