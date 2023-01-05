package testWithPOM.actions;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HoversOverPage;
import utils.Driver;

public class HoversOver {
    HoversOverPage hoversOverPage = new HoversOverPage();

    @BeforeClass
    public void setup() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void hovers() {
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(hoversOverPage.avatar1).perform();
        Assert.assertTrue(hoversOverPage.name1.isDisplayed());

        actions.moveToElement(hoversOverPage.avatar2).perform();
        Assert.assertTrue(hoversOverPage.name2.isDisplayed());

        actions.moveToElement(hoversOverPage.avatar3).perform();
        Assert.assertTrue(hoversOverPage.name3.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        Driver.quitDriver();
    }
}
