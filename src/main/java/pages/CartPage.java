package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private By coursePowerBi=By.partialLinkText("Power BI");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCourseText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(coursePowerBi));
        return driver.findElement(coursePowerBi).getText();
    }
}
