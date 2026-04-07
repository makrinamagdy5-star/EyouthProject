package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PowerBICoursePage {
    private WebDriver driver;
    private By contentMessage=By.xpath("//h3[@class='text-primary-mainBlue text-22 mb-5 font-semibold']");


    public PowerBICoursePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayedMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(contentMessage));
       return driver.findElement(contentMessage).isDisplayed();
    }
}
