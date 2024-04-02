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

    //    getting container urls
    @Test
    public void getUrls(){
        containerClass.getURLContainerLinks();
    }

    //    clicking container links one by one
    @Test
    public void clickContainerLinks(){
       containerClass.clickEachContainerLinks();
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

//    checking section title 1
    @Test
    public void testTitle1(){
        String actual = containerClass.title1();
        String expected = "Shop by category";
        Assert.assertEquals(actual,expected);
    }
    //    checking section title 2
    @Test
    public void testTitle2(){
        String actual = containerClass.title2();
        String expected = "Explore more categories";
        Assert.assertEquals(actual,expected);
    }
    //    checking section title 3
    @Test
    public void testTitle3(){
        String actual = containerClass.title3();
        String expected = "Top Deals";
        Assert.assertEquals(actual,expected);
    }
    //    checking section title 4
    @Test
    public void testTitle4(){
        String actual = containerClass.title4();
        String expected = "More from brands you love";
        Assert.assertEquals(actual,expected);
    }

    //    checking section title 5
    @Test
    public void testTitle5(){
        String actual = containerClass.title5();
        String expected = "Shop by Stores";
        Assert.assertEquals(actual,expected);
    }
    //    checking content paragraph at the bottom of the container
    @Test
    public void testParagraph1(){
        String actual = containerClass.paragraph1();
        String expected = "Home and Garden\n" +
                "\n" +
                "Make Your House Your Home\n" +
                "When it comes to home improvement, look no further than the home and garden pages of eBay. A wide range of home goods from generators to rugs to furniture and bedding, are just a mouse click away. You’ll find everything you need in and around your home to make it uniquely your own.\n" +
                "\n" +
                "Roll Up Your Sleeves\n" +
                "Assembling those shelves for your family room is a difficult job without the right tools. A home makeover simply can’t be done without the manual and power tools to help create the rooms of your dreams. Prepare for your next project —large or small— with tools ranging from cordless drills to wrenches to the toolboxes to store them away.\n" +
                "\n" +
                "Let There Be Light\n" +
                "Half the fun of home decor is deciding how to light up your living space. Whether you need a simple LED bulb or a contemporary chandelier to a steam punk fixture with retro incandescent bulbs, eBay can shed some light on your search. And if you want to shut the sunshine out from time to time, we have plenty of ways to stay in the shade, too. Stop and stay awhile with our colorful collection of everything from wood blinds to bamboo shades.";
        Assert.assertEquals(actual,expected);
    }

    //    checking content paragraph at the bottom of the container
    @Test
    public void testParagraph2(){
        String actual = containerClass.paragraph2();
        String expected = "Enjoy everyday low prices and free shipping with eBay Deals. Don’t forget to check out eBay Coupons for upcoming promotions.";
        Assert.assertEquals(actual,expected);
    }



}
