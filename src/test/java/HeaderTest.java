import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends BaseClass{
    HeaderClass headerClass;

    @BeforeMethod
    public void setup(){
        invokeBrowser("https://www.ebay.com/b/Home-Garden/11700/bn_1853126");
        headerClass = PageFactory.initElements(BaseClass.driver,HeaderClass.class);
    }
    @AfterMethod
    public void quit(){
        quitBrowser();
    }

//    checking if header is displayed and enabled
    @Test
    public void testHeader(){
        boolean actual = headerClass.setHeader();
        boolean expected = true;
        Assert.assertEquals(actual,expected);
    }

//    checking how many links are in Header
    @Test
    public void testHeaderLinks(){
        Integer actual = headerClass.setHeaderLinks();
        Assert.assertTrue(actual>=69);

    }

//    Testing if logo image+link is working
    @Test
    public void logoCheckT(){
        String actual = headerClass.logoCheck();
        String expected = "https://www.ebay.com/";
        Assert.assertEquals(actual,expected);
    }

//    verifying if shop by category button works perfectly
    @Test
    public void testShopByCategory(){
        String actual = headerClass.setShopByCategory();
        String expected = "https://www.ebay.com/b/Home-Garden/11700/bn_1853126";
        Assert.assertEquals(actual,expected);
    }

//    verifying if search bar and search button are working properly
    @Test
    public void testSearchOption(){
        String actual = headerClass.setSearchOption();
        String expected = "https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2499334.m570.l1313&_nkw=Home+%26+Garden&_sacat=11700";
        Assert.assertEquals(expected, actual);
    }

//    verifying the select a category dropdown of the search bar
    @Test
    public void testSelectACategory(){
        String actual = headerClass.setSelectACategory();
        String expected = "https://www.ebay.com/b/Home-Garden/11700/bn_1853126";
        Assert.assertEquals(actual, expected);
    }

//    testing if MyeBay button works
    @Test
    public void testMyeBay(){
        String actual = headerClass.checkMyeBay();
        String expected = "https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com%2Fmye%2Fmyebay%2Fsummary&sgfl=sm";
        Assert.assertEquals(actual, expected);
    }

//testing if sell button works
    @Test
    public void testSellBtn(){
        String actual = headerClass.setSellBtn();
        String expected = "https://www.ebay.com/sl/sell";
        Assert.assertEquals(actual,expected);
    }

//    testing if Help & Contact button works
    @Test
    public void testHelpAndContact() {
        String actual = headerClass.setHelpAndContact();
        String expected = "https://www.ebay.com/splashui/captcha?";
        Assert.assertTrue(actual.contains(expected));
    }

//    Testing if cart button works
    @Test
    public void testCartBtn() {
        String actual = headerClass.setCartBtn();
        String expected = "https://www.ebay.com/splashui/captcha?";
        Assert.assertTrue(actual.contains(expected));
    }











}
