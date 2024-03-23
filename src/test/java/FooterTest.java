import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTest extends BaseClass{
    FooterClass footerClass;

    @BeforeMethod
    public void setup(){
        invokeBrowser("https://www.ebay.com/b/Home-Garden/11700/bn_1853126");
        footerClass = PageFactory.initElements(BaseClass.driver,FooterClass.class);
    }

    @AfterMethod
    public void quit(){
        quitBrowser();
    }

//    verifying the number of footer links
    @Test
    public void footerT(){
        int expected = 9;
        int actual = footerClass.footerA();
        Assert.assertEquals(actual,expected);
    }

//    verifying footer links (broken or not)
    @Test
    public void verifyFooterLinksT(){
        footerClass.verifyFooterLinks();
    }




}
