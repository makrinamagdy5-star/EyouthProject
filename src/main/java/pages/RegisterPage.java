package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private By nameField=By.id("name");
    private By emailField=By.id("email");
    private By countryField=By.xpath("(//button[starts-with(@aria-controls, 'radix-')])[1]");
    private By cityfield=By.xpath("(//button[starts-with(@aria-controls, 'radix-')])[2]");
    private By genderField=By.xpath("(//button[starts-with(@aria-controls, 'radix-')])[3]");
   // private By phoneNumberField=By.xpath("//select[@aria-label='Phone number country']");
    private By phoneNumberCountryField=By.xpath("//select[@aria-label='Phone number country']");
    private By numberField=By.id("phone");
    private By passwordField=By.id("password");
    private By confirmationPasswordFielf=By.id("confirm_password");
    private By agreeButton=By.id("terms");
    private By createAccountButton=By.cssSelector("button[type='submit']");
    private By nameRequiredMessage=By.xpath("//p[contains(text(),'الاسم مطلوب')]");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    //username
    public void setUsername(String userName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(userName);
    }
    //email
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    //country
    public void selectCountry(){
       driver.findElement(countryField).click();
        // Wait for the options to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By countryOption = By.xpath("//*[contains(@role, 'option')]//span[contains(text(), 'مصر')] | //div[contains(text(), 'مصر')]");

        try {
            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(countryOption));

            // Attempt standard click first
            option.click();
        } catch (Exception e) {
            //JavaScript Fallback if standard click is blocked
            WebElement option = driver.findElement(countryOption);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
        }


    }
    //city
    public void selectCity(){
        driver.findElement(cityfield).click();
        // Wait for the options to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By cityOption = By.xpath("//*[contains(@role, 'option')]//span[contains(text(), 'الإسكندرية')] | //div[contains(text(), 'الإسكندرية')]");

        try {
            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(cityOption));

            // Attempt standard click first
            option.click();
        } catch (Exception e) {
            //JavaScript Fallback if standard click is blocked
            WebElement option = driver.findElement(cityOption);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
        }

    }

    //gender
    public void selectGender(){
        driver.findElement(genderField).click();
        // Wait for the options to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By genderOption = By.xpath("//*[contains(@role, 'option')]//span[contains(text(), 'انثى')] | //div[contains(text(), 'انثى')]");

        try {
            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(genderOption));

            // Attempt standard click first
            option.click();
        } catch (Exception e) {
            //JavaScript Fallback if standard click is blocked
            WebElement option = driver.findElement(genderOption);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
        }
    }
    //select phone country
//    public void selectPhoneCountry(){
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberCountryField));
////        Select phoneCountryDropdown= new Select(driver.findElement(phoneNumberCountryField));
////        phoneCountryDropdown.selectByVisibleText("Ecuador");
//        String countryValue = "EG";
//        WebElement selectElement = driver.findElement(phoneNumberCountryField);
//
//// Use JavaScript to set the value
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change'))",
//                selectElement, countryValue);
//    }
    //phone number
    public void setPhoneNumber(){

        WebElement phoneInput = driver.findElement(numberField);

        // Click to focus
        phoneInput.click();

        // Clear any pre-filled value
        phoneInput.clear();

        // Type the number
        Actions actions = new Actions(driver);
        actions.moveToElement(phoneInput)
                .click()
                .sendKeys("01027256096")
                .perform();
    }

    //password
    public void setPassword(){
        driver.findElement(passwordField).sendKeys("Route@123");
    }
    //password confirmation
    public void setConfirmationPassword(){
        driver.findElement(confirmationPasswordFielf).sendKeys("Route@123");
    }

    //agree button
    public void clickAgree(){

        WebElement termsCheckbox = driver.findElement(agreeButton);

        //scroll into element
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
                termsCheckbox
        );

        try {
            termsCheckbox.click(); // Try normal click first
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsCheckbox); // Fallback
        }

}
    //click create
    public void clickCreateAccount(){
        WebElement createButton=driver.findElement(createAccountButton);
        //scroll into element
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
                createButton
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountButton));
        createButton.click();
    }

    //validate name is required
    public String validateMessageName(){
        return driver.findElement(nameRequiredMessage).getText();

    }

    //validate url
    public String getUrl(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("register"));
        return driver.getCurrentUrl();
    }
}
