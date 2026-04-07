package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JoinaBankPage {
    private WebDriver driver;

    public JoinaBankPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitlePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("كيف تنضم إلى البنك؟"));
        return driver.getTitle();
    }
}
