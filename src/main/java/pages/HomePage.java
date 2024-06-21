package pages;

import constants.ConstantUrls;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){super(driver);}
    @FindBy(xpath = "//*[@id=\"c-p-bn\"]")
    private WebElement buttonCookies;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[5]/div/div[3]")//
    private WebElement buttonProfile;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[5]/div/form/input")
    private WebElement buttonSearch;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[5]/div/form/button")
    private WebElement buttonEnterSearch;
    @FindBy(xpath = "//*[@id=\"hUser\"]")
    private WebElement buttonNotAuthorizationProfile;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement buttonEmail;
    @FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[1]/button")
    private WebElement buttonEnterEmail;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement buttonPassword;
    @FindBy(xpath = "//*[@id=\"loginForm\"]/div/button")
    private WebElement buttonEnterPassword;
    @FindBy(xpath = "//*[@id=\"catalogue\"]/div[2]/div[3]/div/h1")
    private WebElement searchResultWomenShoes;
    @FindBy(xpath = "//*[@id=\"popup-container\"]/div/div/div[2]/a")
    private WebElement buttonToCloseAuthorization;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[5]/div/div[3]/ul/li[1]/a")
    private WebElement buttonPersonalData;
    @FindBy(xpath = "//*[@id=\"profile\"]/div[4]/div/div[2]")
    private WebElement textPersonalData;
    static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    public HomePage acceptCookies(){
        workWithElement.click(buttonCookies);
        return this;
    }
    //Tecт кейс 1 Перевірка коректної роботи домашньої сторінки
    public HomePage openHomePage(){
        driver.get(ConstantUrls.home_page);
        LOGGER.info("Відкрита домашня сторінка");
        return this;
    }
    //Tecт кейс 2 Присутність іконки для авторизації/реєстрації на сторінці  https://kasta.ua/
    public HomePage checkIfThereIsAnIconForAuthorization(){
        if (buttonProfile.isDisplayed()){
            System.out.println("На сторінці присютнє поле для авторизації/реєстрації користувача");
        }
        else {
            System.out.println("На сторінці не відображається поле для авторизації/реєстрації користувача");
        }
    return this;
    }
    //Tecт кейс 3 Спроба авторизації користувача за допомогою не вірного Email
    @SneakyThrows
    public HomePage invalidEmailAddress(){
        buttonNotAuthorizationProfile.click();
        Thread.sleep(2000);
        buttonEmail.click();
        Thread.sleep(2000);
        buttonEmail.sendKeys("546465");
        Thread.sleep(2000);
        buttonEnterEmail.click();
        buttonToCloseAuthorization.click();
        Thread.sleep(2000);
            if (buttonEmail.isDisplayed()){
                System.out.println("Невірно введений Email");
            } else {
                System.out.println("Відбувся перехід на сторінку вводу паролю");
            }
        buttonToCloseAuthorization.click();
            Thread.sleep(2000);
        return this;
    }
    //Tecт кейс 4 Спроба авторизації користувача за допомогою  Email
    @SneakyThrows
    public HomePage validEmailAddress(){
        buttonNotAuthorizationProfile.click();
        Thread.sleep(2000);
        buttonEmail.click();
        Thread.sleep(2000);
        buttonEmail.sendKeys("2daryachernata2@gmail.com");
        Thread.sleep(2000);
        buttonEnterEmail.click();
        Thread.sleep(2000);
        buttonPassword.sendKeys("111111");
        Thread.sleep(2000);
        buttonEnterPassword.click();
        Thread.sleep(2000);
        /*buttonProfile.click();
        Thread.sleep(2000);
        buttonPersonalData.click();
        Thread.sleep(5000);
            if (textPersonalData.isDisplayed()){
                System.out.println("Введені дані коректні, користувач успішно авторизувався");
            } else {
                System.out.println("Дані введено не коректно, користувач не має можливості авторизуватися");
            }*/
        LOGGER.info("Відкрита домашня сторінка авторизиваного користувача");
        return this;
    }
    //Tecт кейс 5 Перевірка роботи пошуку на сайті
    @SneakyThrows
    public HomePage searchProductOnTheSite(){
        buttonSearch.sendKeys("Жіноче взуття");
        Thread.sleep(2000);
        buttonEnterSearch.click();
            if (searchResultWomenShoes.isDisplayed()){
                System.out.println("Пошук відбувся успішно");
            } else {
                System.out.println("Стався збій пошуку");
            }
        return this;
    }

}
