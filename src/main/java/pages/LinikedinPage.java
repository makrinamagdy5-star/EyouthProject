package pages;

import org.openqa.selenium.WebDriver;

public class LinikedinPage {
    private WebDriver driver;

    public LinikedinPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
