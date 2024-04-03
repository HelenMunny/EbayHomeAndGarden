import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShopByCategoryTest extends BaseClass{
    ShopByCategory shopByCategory;

    @BeforeMethod
    public void setup(){
        invokeBrowser("https://www.ebay.com/b/Home-Garden/11700/bn_1853126");
        shopByCategory = PageFactory.initElements(BaseClass.driver, ShopByCategory.class);
    }

    @AfterMethod
    public void quit(){
        quitBrowser();
    }

    @Test
    public void testCategories(){
        shopByCategory.printCategories();
    }

    @Test
    public void testShopByCategory(){
        boolean expected = true;
        boolean actual = shopByCategory.checkShopByCategory();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void numLinks(){
        int actual = shopByCategory.numOfLinks();
        Assert.assertTrue(actual>=290);
    }

    @Test
    public void testTitle(){
        String expected = "Shop by Category";
        String actual = shopByCategory.checkSectionTitle();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testAriaExpanded(){
        shopByCategory.checkAccordionBtns();
    }



}

