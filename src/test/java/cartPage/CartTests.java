package cartPage;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTests extends BaseTest {

    //test case 7
    @Test
    public void testValidateItemCart(){
        var loginPage=baseHomePage.clickJoinUs();
        loginPage.setEmail("makrinamagdi@gmail.com");
        loginPage.setPassword("Route@123");
        var dashboardPage =loginPage.clickLogin();
        var cartPage= dashboardPage.clickAllCourses().clickSubscribeCourse();
        String courseName=cartPage.getCourseText();
        System.out.println(courseName);
        assertTrue(cartPage.getCourseText().contains("Power BI"));
    }
}
