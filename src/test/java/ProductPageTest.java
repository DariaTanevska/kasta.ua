import org.testng.annotations.Test;

public class ProductPageTest extends BasePageTest{
    @Test
    public void checkProductPage(){
        productPage
                .openProductPage()
                .validEmailAddress()
                .clickButtonFavorite()
                .clickButtonRemoveFavorite()
                .clickButtonBuy()
                .clickButtonRemoveBuy();
    }
}
