package pages;

import constants.ConstantUrls;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductCategoryPage extends BasePage {
    public ProductCategoryPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"c-p-bn\"]")
    private WebElement buttonCookies;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[8]/div[1]/a[1]")
    private WebElement buttonUp;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[8]/div[1]/a[2]/div")
    private WebElement buttonDown;
    @FindBy(xpath = "//*[@id=\"OmFmZmlsaWF0aW9uemhpbmthbQ\"]/a")
    private WebElement buttonWomen;
    @FindBy(xpath = "//*[@id=\"OmtpbmR2aXNoaXZhbmth\"]/a")
    private WebElement buttonVishivanka;
    @FindBy(xpath = "//*[@id=\"OnNpemUxM3w0NC00Ng\"]/a")
    private WebElement buttonSize;
    @FindBy(xpath = "//*[@id=\"17588182:584\"]/div/div/div[2]/div")
    private WebElement addedButtonFavorite;
    @FindBy(xpath = "//*[@id=\"hWish\"]")
    private WebElement buttonFavorite;
    @FindBy(xpath = "//*[@id=\"17588223:584\"]/div/div/form/div[1]/a/span/img")
    private WebElement cartFavorite;
    @FindBy(xpath = "//*[@id=\"17588182:584\"]/div/div/form/div[2]/div[1]/div/div/button")
    private WebElement buttonBuy;
    @FindBy(xpath = "//*[@id=\"popup-container\"]/div/div/div[2]/form/div[2]/button[3]")
    private WebElement buttonSizeM;
    @FindBy(xpath = "//*[@id=\"hCart\"]/a")
    private WebElement buttonBasket;
    @FindBy(xpath = "//*[@id=\"cartContent\"]/div[1]/div[3]/div[1]/div[1]/a")
    private WebElement cartProductBasket;
    @FindBy(xpath = "//*[@id=\"products\"]")
    private WebElement productVishivanka;
    @FindBy(xpath = "//*[@id=\"17588182:584\"]/div/div/form/div[2]/div[1]/div/div/div/div[1]/span")
    private WebElement firstProduct;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement email;
    @FindBy(xpath = "//*[@id=\"popup-container\"]/div/div/div[2]/a")
    private WebElement closeRegistrazione;
    @FindBy(xpath = "//*[@id=\"cart\"]/div/div/div[1]/ic")
    private WebElement closeBasket;
    private ProductCategoryPage acceptCookies(){
        workWithElement.click(buttonCookies);
        return this;
    }
    static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryPage.class);
   //Тест кейс 1 Перевірка коректної роботи сторінки каталогу сайту
    public ProductCategoryPage openProductCategoryPage(){
        driver.get(ConstantUrls.product_category_page);
        LOGGER.info("Відкрита сторінка каталогу");
        return this;
    }

    //Тест кейс 2 Перевірка роботи бокових кнопок скролу
    public ProductCategoryPage clickButtonUpAndDown(){
        buttonDown.click();
        buttonUp.click();
            if (buttonUp.isDisplayed() && buttonDown.isDisplayed()){
                System.out.println("Кнопки бокового скролу присутні на сторінці та коректно процюють");
            } else {
                System.out.println("Кнопки бокового скролу не присутні на сторінці та/або не коректно процюють");
            }
        return this;
    }
    //Тест кейс 3 Перевірка роботи фільтру для товарів на сторінці каталогу
    @SneakyThrows
    public ProductCategoryPage checkingTheFilterOnTheSite(){
        buttonWomen.click();
        Thread.sleep(2000);
        buttonVishivanka.click();
        Thread.sleep(2000);
        buttonSize.click();
        Thread.sleep(2000);
            if (productVishivanka.isDisplayed()){
                System.out.println("Фільтрація товарів за заданими параметрами відбулася успішно");
            } else {
                System.out.println("Не вдалося фільтрувати товари за заданими параметрами");
            }
        return this;
    }
    //Тест кейс 4 Перевірка роботи кнопки "Додати в обране" на сторінці каталогу товару
    @SneakyThrows
    public ProductCategoryPage checkingTheAddToFavoritesButton(){
        firstProduct.click();
        Thread.sleep(2000);
        addedButtonFavorite.click();
        Thread.sleep(2000);
            if (email.isDisplayed()){
                System.out.println("Кнопка 'Додати в обране' не працює. Потрібно авторизуватись");
            } else {
                System.out.println("Кнопка 'Додати в обране' працює");
            }
        closeRegistrazione.click();
        return this;
    }
    //Тест кейс 5 Перевірка роботи кнопки "Купити" на сторінці каталогу товару
    @SneakyThrows
    public ProductCategoryPage checkingBuyBotton(){
        buttonBuy.click();
        Thread.sleep(2000);
        buttonSizeM.click();
        Thread.sleep(2000);
            if (cartProductBasket.isDisplayed()){
                System.out.println("Товар успішно додано в кошик");
            } else {
                System.out.println("Товар не вдалось додати в кошик");
            }
        return this;
    }
}
