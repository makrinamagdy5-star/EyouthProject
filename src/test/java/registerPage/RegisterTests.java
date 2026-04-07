package registerPage;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class RegisterTests extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    //test case 4
    @Test
    public void testRegisteration(){
    var registerPage= baseHomePage.clickJoinUs().clickCreateAccount();
    registerPage.setUsername("");
    registerPage.setEmail("makrinamagdy5@gmail.com");
    registerPage.selectCountry();
    registerPage.selectCity();
    registerPage.selectGender();
    registerPage.setPhoneNumber();
    registerPage.setPassword();
    registerPage.setConfirmationPassword();
    registerPage.clickAgree();
    registerPage.clickCreateAccount();

    //assert required name message
    softAssert.assertEquals(registerPage.validateMessageName(),"الاسم مطلوب","message is incorrect");

    //assert url
    softAssert.assertTrue(registerPage.getUrl().contains("register"));

    softAssert.assertAll();



    }

}
