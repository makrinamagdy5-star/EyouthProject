package pages;

import org.openqa.selenium.WebDriver;

public class InstagramPage {
    private WebDriver driver;

    public InstagramPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
