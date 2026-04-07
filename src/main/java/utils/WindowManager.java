package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager {
    private WebDriver driver;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
    }
    // to  switch to new tab
    public void switchToTab(String urlName){
        Set<String> windowHandles=driver.getWindowHandles();
        System.out.println("No of Tabs : "+windowHandles.size());
        for(String windowHandle:windowHandles){
            System.out.println("Switchig To : "+windowHandle);
            driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().contains(urlName)){
                break;
            }
        }
    }
}
