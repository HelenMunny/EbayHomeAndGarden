import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContainerTest extends BaseClass{
    ContainerClass containerClass;

    @BeforeMethod
    public void setup(){
        invokeBrowser("https://www.ebay.com/b/Home-Garden/11700/bn_1853126");
        containerClass = PageFactory.initElements(BaseClass.driver, ContainerClass.class);
    }

    @AfterMethod
    public void quit(){
        quitBrowser();
    }

//    checking if container is displayed properly
    @Test
    public void testContainer(){
        boolean actual = containerClass.checkContainer();
        boolean expected = true;
        Assert.assertEquals(actual,expected);
    }
//    verifying if container has any broken link
    @Test(enabled = false)
    public void testContainerLinks(){
        containerClass.verifyContainerLinks();
    }

//    checking number of links are in container
    @Test
    public void countContainerLinksT(){
        Integer actual = containerClass.countContainerLinks();
        Assert.assertTrue(actual>=35);
    }

//    checking how many product sections are present in the page
    @Test
    public void countProductSections(){
        Integer actual = containerClass.countProductSections();
        Assert.assertTrue(actual>=3);
    }

//    counting the total section titles
    @Test
    public void countSectionTitleT(){
        Integer actual = containerClass.countSectionTitles();
        Assert.assertTrue(actual>=5);
    }

//    getting text from section titles
    @Test
    public void testSectionTitles(){
        containerClass.checkSectionTitles();
    }






}
