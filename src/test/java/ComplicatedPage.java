import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComplicatedPage {
    //    Navigate to https://ultimateqa.com/complicated-page
//    Go to section Section of Random Stuff
//    Input Name (use Random value)
//    Input email
//    Input any messages
//    Add a logic to calculate sum of the 2 numbers(no hard coding please)
//    Input the value of sum
//    Click on submit button
    public static void main(String[] args) {
        //    Navigate to https://ultimateqa.com/complicated-page
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://ultimateqa.com/complicated-page");
//    Go to section Section of Random Stuff
//    Input Name (use Random value)
//        Input email
//    Input any messages
//    Add a logic to calculate sum of the 2 numbers(no hard coding please)
//    Input the value of sum
//    Click on submit button
        WebElement name = driver.findElement(By.xpath("//input[@id=\"et_pb_contact_name_0\"]"));
        WebElement emailAddress = driver.findElement(By.xpath("//input[@id=\"et_pb_contact_email_0\"]"));
        WebElement messageBox = driver.findElement(By.xpath("//textarea[@id=\"et_pb_contact_message_0\"]"));
        WebElement textOfNumbers = driver.findElement(By.xpath("//*[@id=\"et_pb_contact_form_0\"]//span[@class=\"et_pb_contact_captcha_question\"]"));
        WebElement sumOfTwoNumbers = driver.findElement(By.xpath("(//input[@class=\"input et_pb_contact_captcha\"])[1]"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"et_pb_contact_form_0\"]//button[@type=\"submit\"]"));

        name.sendKeys("Andrew");
        emailAddress.sendKeys("andrew@gmail.com");
        messageBox.sendKeys("This is message to you");

        String textValueOfNumbers = textOfNumbers.getText();
        System.out.println(textValueOfNumbers);

        int plusSign = textValueOfNumbers.indexOf("+");

        String numOne = textValueOfNumbers.substring(0, plusSign-1);
        String numTwo = textValueOfNumbers.substring(plusSign+2);

        int one = Integer.parseInt(numOne);
        int two = Integer.parseInt(numTwo);

        int sum = one + two;

        String totalAmount = Integer.toString(sum);
        //String.valueOf()

        sumOfTwoNumbers.sendKeys(totalAmount);
        submitButton.click();


        //indexOf()
        //for
        // 7 + 12
        //chartAt
        //substring
        //parseInt



//
    }
}
