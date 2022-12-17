package testNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class FirstPracticeTestNG {


    @BeforeClass
    public void setUp(){
        System.out.println("This is Before class running");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is Before method running ");
    }

    @Test
    public void b_firstTest(){
        System.out.println("The first Test is running");
    }

    @Test
    public void a_secondTest() {
        System.out.println("The second Test is running");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is After method running");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is After Class running");
    }

    @Test
    public void c_thirdTest() {
        System.out.println("The third Test is running");

        String actualValue;
        String expectedValue;
// here code fails
//        if("winter".equals("winter")) {
//            System.out.println("Test Pass");
//        }
//        else {
//            System.out.println("Test Failed");
//        }
//
//        Assert.assertEquals("one","1","String comparison failed");
//        Assert.assertEquals(1,1);
//        Assert.assertTrue(true);

    }



}
