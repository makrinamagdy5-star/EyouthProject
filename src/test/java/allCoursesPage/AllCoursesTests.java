package allCoursesPage;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AllCoursesTests extends BaseTest {
    SoftAssert softAssert=new SoftAssert();

    //test case 11
    @Test
    public void testCardContains(){
        var coursesPage=baseHomePage.clickallCourses();
        softAssert.assertTrue(coursesPage.isCourseImageDisplayed(),"Image is not displayed");
        Assert.assertTrue(coursesPage.isTitleCardDisplayed(), "Title card is not displayed");
        Assert.assertTrue(coursesPage.isInstructorNameDisplayed(), "Instructor name is not displayed");
        Assert.assertTrue(coursesPage.isSubscribeButtonDisplayed(), "Subscribe button is not displayed");
        softAssert.assertAll();


    }
}
