package loginPage;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class LoginTests2 extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    //test case 5
    @Test
    public void testInvalidCredential(){
        var loginPage= baseHomePage.clickJoinUs();
        loginPage.setEmail("makrina@gmail.com");
        loginPage.setPassword("Route1@1258");
        loginPage.clickLogin();
        assertTrue(loginPage.validateMessage(),"message was not displayed");

    }

    //test case 6
    @Test
    public void testEmptyLogin(){
        var loginPage= baseHomePage.clickJoinUs();
        loginPage.setEmail("");
        loginPage.setPassword("");
        loginPage.clickLogin();

        softAssert.assertEquals(loginPage.getEmailMessage(),"البريد الإلكتروني مطلوب","message email is incorrect");
        softAssert.assertEquals(loginPage.getPasswordMessage(),"كلمة المرور مطلوبة","message password is incorrect");
        softAssert.assertAll();


    }
}
