package testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testRegularAssertion() {

        Assert.assertTrue(2==2);
        System.out.println("This is a middle line");
        Assert.assertEquals("Monday", "Monday");
    }

    @Test
    public void testSoftAssertion(){
        softAssert.assertEquals(5,8);
        System.out.println("This is soft assert example");
    }

    @AfterMethod
    public void tearDown() {
        softAssert.assertAll();
    }
}
