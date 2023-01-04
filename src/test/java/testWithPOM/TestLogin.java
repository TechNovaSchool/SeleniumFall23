package testWithPOM;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginSmartBearPage;
import utils.Config;
import utils.Driver;

public class TestLogin {

    LoginSmartBearPage loginPageSmartBear = new LoginSmartBearPage();

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get(Config.getProperty("urlSmartBear"));
    }

    @Test
    public void loginTest() {
       loginPageSmartBear.username.sendKeys(Config.getProperty("login"));
       loginPageSmartBear.password.sendKeys(Config.getProperty("pass"));
       loginPageSmartBear.loginBtn.click();
    }

}
