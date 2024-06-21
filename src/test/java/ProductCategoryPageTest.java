import org.testng.annotations.Test;

public class ProductCategoryPageTest extends BasePageTest {
    @Test
    public void cheskProductCategoryPage(){
        productCategoryPage
                .openProductCategoryPage()
                .clickButtonUpAndDown()
                .checkingTheFilterOnTheSite()
                .checkingTheAddToFavoritesButton()
                .checkingBuyBotton();
    }
}
