import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BannerTest extends BaseClass{
    BannerClass bannerClass;

    @BeforeMethod
    public void setup(){
        invokeBrowser("https://www.ebay.com/b/Home-Garden/11700/bn_1853126");
        bannerClass = PageFactory.initElements(BaseClass.driver,BannerClass.class);
    }
    @AfterMethod
    public void quit(){
        quitBrowser();
    }

   @Test
   public void bannerAvailable(){
        boolean expected = true;
        boolean actual = bannerClass.bannerA();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void verifyBreadcrumpT(){
        bannerClass.verifyBreadcrumpLinks();
    }

    @Test
    public void bannerTitleT(){
        String actual = bannerClass.bannerTitleC();
        String expected = "Home & Garden";
        Assert.assertEquals(actual,expected);
    }

}