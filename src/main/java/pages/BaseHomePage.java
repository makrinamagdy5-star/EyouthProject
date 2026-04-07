package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseHomePage {
    private WebDriver driver;
    private By searchLocator=By.cssSelector("input[type='search']");
    private By searchResult=By.xpath("//*[contains(text(),'كيف تنضم إلى البنك')]");
    private By joinUsButton=By.xpath("//a[normalize-space()='أنضم لنا الان']");
    private By facebookLink =By.xpath("//a[@href='https://www.facebook.com/EYouthLearning/']//*[name()='svg']");
    private By linikedinLink =By.xpath("//a[contains(@href,'linkedin')]");
    private By instagramLinik=By.xpath("//a[contains(@href,'instagram')]");
    private By allcoursesLink=By.xpath("//a[@class='font-light']");

    public BaseHomePage(WebDriver driver) {
        this.driver = driver;
    }
//search
    public void search(String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchLocator));
        WebElement inputSearch=driver.findElement(searchLocator);
        inputSearch.sendKeys(text);


    }

    public JoinaBankPage clickSearchResult(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));

        wait.until(ExpectedConditions.textToBePresentInElement(result, "كيف تنضم"));

        wait.until(ExpectedConditions.elementToBeClickable(result));

        result.click();

        return new JoinaBankPage(driver);
    }

    //join us
    public LoginPage clickJoinUs(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(joinUsButton));
        ((JavascriptExecutor) driver).executeScript(
                "window.scrollBy(0, 700);");

        wait.until(ExpectedConditions.elementToBeClickable(button));

        try {
            button.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }

        return new LoginPage(driver);
    }

    //facebook
    public FacebookPage clickFacebookLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement facebookLinkElement = wait.until(ExpectedConditions.presenceOfElementLocated(facebookLink));

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                facebookLinkElement
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(facebookLinkElement)).click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", facebookLinkElement);
        }

        return new FacebookPage(driver);
    }

    //linikedin
    public LinikedinPage clickLinikedinLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement linikedinLinkElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(linikedinLink)
        );

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                linikedinLinkElement
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(linikedinLink)).click();
        } catch (Exception e) {
            WebElement freshElement = driver.findElement(linikedinLink);
            js.executeScript("arguments[0].click();", freshElement);
        }

        return new LinikedinPage(driver);
    }

    //instagram
    public InstagramPage clickInstagramLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement instagramLinkElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(instagramLinik)
        );

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                instagramLinkElement
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(instagramLinik)).click();
        } catch (Exception e) {
            WebElement freshElement = driver.findElement(instagramLinik);
            js.executeScript("arguments[0].click();", freshElement);
        }

        return new InstagramPage(driver);
    }

    //click all courses link
    public Coursespage clickallCourses(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(allcoursesLink));
        driver.findElement(allcoursesLink).click();
        return new Coursespage(driver);
    }


}
