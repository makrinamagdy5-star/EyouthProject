package powerBiPage;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PowerBiTests extends BaseTest {
    //test case  2 course details
    @Test
    public void validateCourseDetails(){
        var powerBICoursePage=baseHomePage.clickallCourses().clickPowerCourse();
        assertTrue(powerBICoursePage.isDisplayedMessage(),"content message is not found");

    }

}
