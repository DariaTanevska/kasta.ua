package pages;

import functions.WaitersClass;
import functions.WorkWithElementClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(WebDriver driver) {
        this.driver = driver;
        waiters = new WaitersClass(driver);
        workWithElement = new WorkWithElementClass(driver);
        PageFactory.initElements(driver,this);
    }

    protected WebDriver driver;
    protected WaitersClass waiters;
    protected WorkWithElementClass workWithElement;
}

