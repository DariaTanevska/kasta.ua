import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.AllureListener;

@Listeners({AllureListener.class})
public class HomePageTest extends BasePageTest{
    @Test
    public void checkHomePage(){
        homePage.openHomePage()
                .checkIfThereIsAnIconForAuthorization()
                .invalidEmailAddress()
                .validEmailAddress()
                .searchProductOnTheSite();
    }
}
