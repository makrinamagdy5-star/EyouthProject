package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By emailField=By.id("email");
    private By passwordField=By.id("password");
    private By loginButton=By.cssSelector("button[type='submit']");
    private By createAccount=By.xpath("//a[normalize-space()='إنشاء حساب جديد']");
    private By invalidLohinMessage=By.xpath("//p[@class='text-center ms-1 mt-1.5 w-full text-sm text-[red]']");
    private By emailrequiredMessage=By.xpath("//p[contains(text(),'البريد الإلكتروني مطلوب')]");
    private By passwordRequiredMessage=By.xpath("//p[contains(text(),'كلمة المرور مطلوبة')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public RegisterPage clickCreateAccount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccount));
        driver.findElement(createAccount).click();
        return new RegisterPage(driver);
    }

    //enter email
    public void setEmail(String email){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
    }

    //enter password
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    //login
    public DashboardPage clickLogin(){
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

    public boolean validateMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLohinMessage));
        return driver.findElement(invalidLohinMessage).isDisplayed();
    }

    //get email message
    public String getEmailMessage(){
        return driver.findElement(emailrequiredMessage).getText();
    }

    //get password message
    public String getPasswordMessage(){
        return driver.findElement(passwordRequiredMessage).getText();
    }

}
