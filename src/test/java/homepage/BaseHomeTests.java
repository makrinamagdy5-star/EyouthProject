package homepage;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseHomeTests extends BaseTest {

    //test case 1
    @Test
    public void testSearch(){
        baseHomePage.search("كيف تنضم الى البنك");
        var joinaBankPage=baseHomePage.clickSearchResult();
//        String title=joinaBankPage.getTitlePage();
//        System.out.println(title);
        assertTrue(joinaBankPage.getTitlePage().contains("كيف تنضم إلى البنك؟"),"title is incorrect");


    }

    // test case 8   verfiy facebook linik
    @Test
    public void testVerfiyFacebookLinik(){
        var facebookPage=baseHomePage.clickFacebookLink();
        windowManager.switchToTab("facebook");
        assertTrue(facebookPage.getUrl().contains("facebook.com"));


    }

    // test case 9   verfiy linikedin linik
    @Test
    public void testVerfiyLinikedinLinik(){
        var linikedinPage=baseHomePage.clickLinikedinLink();
        windowManager.switchToTab("linkedin");
        assertTrue(linikedinPage.getUrl().contains("linkedin.com"));
    }

    // test case 10  verfiy instagram linik
    @Test
    public void testVerfiyinstagramLinik(){
        var instagramPage=baseHomePage.clickInstagramLink();
        windowManager.switchToTab("instagram");
        assertTrue(instagramPage.getUrl().contains("instagram.com"));
    }



}
