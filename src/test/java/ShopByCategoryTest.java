import org.openqa.selenium.support.PageFactory;
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
}
