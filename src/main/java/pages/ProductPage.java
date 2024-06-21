package pages;

import constants.ConstantUrls;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"c-p-bn\"]")
    private WebElement buttonCookies;
    @FindBy(xpath = "//*[@id=\"sizeList\"]/label[3]")
    private WebElement buttonMSize;
    @FindBy(xpath = "//*[@id=\"reactContent\"]/div/div[5]/div[4]/div[2]/div[2]/form/div[7]/div")
    private WebElement buttonFavoriteOnTheCart;
    @FindBy(xpath = "//*[@id=\"hWish\"]")
    private WebElement favoriteOnTheCartButton;
    @FindBy(xpath = "//*[@id=\"17588182:584\"]/div/div/form/div[2]/div[1]/div/a/header")
    private WebElement addFavoriteProduct;
    @FindBy(xpath = "//*[@id=\"reactContent\"]/div/div[5]/div[4]/div[2]/div[2]/form/div[7]/div")
    private WebElement buttonRemoveFavorite;
    @FindBy(xpath = "//*[@id=\"wishTabProds\"]/div/div/div[2]")
    private WebElement emptyFavoriteList;
    @FindBy(xpath = "//*[@id=\"cartContent\"]/div[1]/div[3]/div[1]/div[3]")
    private WebElement buttonRemoveOnTheBasket;
    @FindBy(xpath = "//*[@id=\"productBuy\"]")
    private WebElement buttonBuy;
    @FindBy(xpath = "//*[@id=\"hCart\"]/a")
    private WebElement buttonBasket;
    @FindBy(xpath = "//*[@id=\"cartContent\"]/div[2]/div[1]")
    private WebElement inscriptionRemoveBuy;
    @FindBy(xpath = "//*[@id=\"cartContent\"]/div[1]/div[3]/div[1]/div[1]")
    private WebElement cartPtoductBuy;
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
    @FindBy(xpath = "//*[@id=\"17588223:584\"]/div/div/form/div[2]/div[1]/div/a[1]/header")
    private WebElement cartProduct;
    @FindBy(xpath = "//*[@id=\"sizeList\"]/label[2]")
    private WebElement clickClick;
    @FindBy(xpath = "//*[@id=\"wlEmpty\"]")
    private WebElement nextPurchase;
    @FindBy(xpath = "//*[@id=\"cartContent\"]/div[2]")
    private WebElement cleanBasket;
    @FindBy(xpath = "//*[@id=\"popup-container\"]/div/div/div[2]/a")
    private WebElement buttonCloseFavoriteList;
    @FindBy(xpath = "//*[@id=\"WLPr\"]/div/div[2]/a/div/div/div[1]/div[1]/div[1]")
    private WebElement listFavorite;
    @FindBy(xpath = "//*[@id=\"popup-container\"]/div/div/div[2]/label")
    private WebElement removeTheCheckMark;
    static final Logger LOGGER = LoggerFactory.getLogger(ProductPage.class);
    private ProductPage acceptCookies(){
        workWithElement.click(buttonCookies);
        return this;
    }
    //Tecт кейс 1 Перевірка коректної роботи сторінки продукту на сайті
    public ProductPage openProductPage(){
        driver.get(ConstantUrls.product_page);
        LOGGER.info("Відкрита сторінка продукту");
        return this;
    }
    @SneakyThrows
    public ProductPage validEmailAddress() {
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
        Thread.sleep(5000);
        return this;
    }
    //Tecт кейс 2 Перевірка роботи кнопки "Додати в обране" на сторінці товару
    @SneakyThrows
    public ProductPage clickButtonFavorite(){
        clickClick.click();
        Thread.sleep(5000);
        buttonFavoriteOnTheCart.click();
        Thread.sleep(2000);
        buttonCloseFavoriteList.click();
        Thread.sleep(2000);
        favoriteOnTheCartButton.click();
        Thread.sleep(2000);
        listFavorite.click();
            if (addFavoriteProduct.isDisplayed()){
                System.out.println("Товір успішно додано до списку 'Обране'");
            } else {
                System.out.println("Товір не вдалось додати до списку 'Обране'");
            }
        return this;
    }
    //Tecт кейс 3 Перевірка роботи кнопки "Прибрати з обраного" на сторінці товару
    @SneakyThrows
    public ProductPage clickButtonRemoveFavorite(){
        addFavoriteProduct.click();
        Thread.sleep(2000);
        buttonRemoveFavorite.click();
        Thread.sleep(3000);
        removeTheCheckMark.click();
        Thread.sleep(3000);
        buttonCloseFavoriteList.click();
        Thread.sleep(3000);
        favoriteOnTheCartButton.click();
        Thread.sleep(2000);
        listFavorite.click();
        Thread.sleep(2000);
            if (nextPurchase.isDisplayed()){
                System.out.println("Товір успішно видалено зі списку 'Обране'");
            } else {
                System.out.println("Товір не вдалось видалити зі списку 'Обране'");
            }
        return this;
    }
    //Tecт кейс 4 Перевірка роботи кнопки "Купити" на сторінці товару
    @SneakyThrows
    public ProductPage clickButtonBuy(){
        driver.get(ConstantUrls.product_page);
        Thread.sleep(2000);
        buttonMSize.click();
        Thread.sleep(2000);
        buttonBuy.click();
        Thread.sleep(2000);
            if (cartPtoductBuy.isDisplayed()){
                System.out.println("Товір успішно додано до списку 'Корзина'");
            } else {
                System.out.println("Товір не вдалось додати до списку 'Корзина'");
            }
        return this;

    }
    //Tecт кейс 5 Перевірка роботи кнопки "Видалити товар" на сторінці товару після нажимання кнопки "Купити"
    @SneakyThrows
    public ProductPage clickButtonRemoveBuy(){
        buttonRemoveOnTheBasket.click();
        Thread.sleep(2000);
            if (cleanBasket.isDisplayed()){
                System.out.println("Товір успішно видалено зі списку 'Корзина'");
            } else {
                System.out.println("Товір не вдалось видалити зі списку 'Корзина'");
            }
        return this;
    }

}
