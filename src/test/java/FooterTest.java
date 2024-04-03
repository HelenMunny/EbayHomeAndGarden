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

    //    Testing if footer is available
    @Test
    public void testFooter(){
        boolean actual = footerClass.checkFooter();
        boolean expected = true;
        Assert.assertEquals(actual,expected);
    }

//    checking if copyright msg is according to expectation
    @Test
    public void testCopyright(){
        String actual = footerClass.checkCopyright();
        Assert.assertTrue(actual.contains("Copyright © 1995-2024 eBay Inc. All Rights Reserved."));
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

    //    Testing if help button is available
    @Test
    public void testScrollBtn(){
        boolean actual = footerClass.checkScrollBtn();
        boolean expected = true;
        Assert.assertEquals(actual,expected);
    }

//    clicking footer links one by one
    @Test
    public void clickFooterLinks(){
        footerClass.clickEachFooterLinks();
    }


//    getting footer urls
    @Test
    public void getUrls(){
        footerClass.getURLFooterLinks();
    }

}
