package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BaseHomePage;
import utils.WindowManager;

public class BaseTest {
    private WebDriver driver;
    protected BaseHomePage baseHomePage;
    protected WindowManager windowManager;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void loginPage(){
        driver.get("https://eyouthlearning.com");
        baseHomePage =new BaseHomePage(driver);
        windowManager=new WindowManager(driver);


    }
//   @AfterClass
//    public void tearDown(){
//       driver.close();  //close tab if there is many tabs
//    }
}
