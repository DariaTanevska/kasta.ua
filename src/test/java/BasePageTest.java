import driver.DriverSetUp;
import functions.WaitersClass;
import functions.WorkWithElementClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;
import pages.HomePage;
import pages.ProductCategoryPage;
import pages.ProductPage;

public class BasePageTest {
    protected WebDriver driver = DriverSetUp.startDriver();
    protected WaitersClass waiters= new WaitersClass(driver);
    protected WorkWithElementClass workWithElement = new WorkWithElementClass(driver);
    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected ProductCategoryPage productCategoryPage = new ProductCategoryPage(driver);
    protected ProductPage productPage =new ProductPage(driver);
    @BeforeSuite
    public void driverInit(){
        driver = DriverSetUp.startDriver();
    }
    @AfterSuite
    public void stopDriver(){
        driver.quit();
    }

}
