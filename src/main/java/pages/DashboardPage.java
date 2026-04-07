package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private By allcoursesButton=By.cssSelector("a[class='font-light']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public Coursespage clickAllCourses(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(allcoursesButton));
        driver.findElement(allcoursesButton).click();
        return new Coursespage(driver);
    }
}
