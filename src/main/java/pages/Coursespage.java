package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Coursespage {
    private WebDriver driver;
    private By powerBiCourseCart =By.xpath("//section//div[1]//div[2]//button[1]");
    private By powerCourseDetails=By.xpath("//h3[contains(text(),'تحليل البيانات عبر Power BI')]");
    private By modal=By.xpath("//h3[@class='text-primary-darkBlue mb-4 text-base font-medium']");

    // course change management
    private By titleCard=By.xpath("//h3[contains(text(),'إدارة التغيير والعمل الجماعي')]");
    private By instructorName=By.xpath("//div[3]//h6[1]");
    private By subscribeButton=By.xpath("//div[3]//div[2]//button[1]");
    private By courseImage=By.xpath("//img[contains(@src,'Change%20Management%20and%20Team%20Working.png')]");


    public Coursespage(WebDriver driver) {
        this.driver = driver;
    }

    // click course subscription
    public CartPage clickSubscribeCourse(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(powerBiCourseCart));
//                try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1) Move mouse away to close hover popup
        actions.moveByOffset(300, 0).perform();   // move mouse away

        // 3) Scroll to button
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(powerBiCourseCart));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", button);

        // 4) Click button
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();

        //driver.findElement(powerBiCourseCart).click();
        return new CartPage(driver);
    }

    //click course details
    public PowerBICoursePage clickPowerCourse(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1) Move mouse away to close hover popup
        actions.moveByOffset(300, 0).perform();   // move mouse away

        // 3) Scroll to button
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(powerCourseDetails));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", button);

        // 4) Click button
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();

        // driver.findElement(powerCourseDetails).click();
        return new PowerBICoursePage(driver);
    }

    // course change management

    public boolean isCourseImageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(courseImage)
        );

        return image.isDisplayed();
    }
    public boolean isTitleCardDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(titleCard));
        return title.isDisplayed();
    }

    public boolean isInstructorNameDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement instructor = wait.until(ExpectedConditions.visibilityOfElementLocated(instructorName));
        return instructor.isDisplayed();
    }

    public boolean isSubscribeButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(subscribeButton));
        return button.isDisplayed();
    }


}
