import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BannerClass extends BaseClass{
    @FindBy(xpath = "//div[@class=\"pagecontainer__top\"]")
    WebElement banner;
    @FindBy(xpath = "//div[@class=\"pagecontainer__top\"] //a")
    List <WebElement> bannerLinks;
    @FindBy(xpath = "//a[@class=\"seo-breadcrumb-text\"]")
    List<WebElement> breadcrumpLinks;
    @FindBy(xpath = "//div[@class=\"pagecontainer__top\"] //span[@class=\"b-pageheader__text\"]")
    WebElement bannerTitle;

    public boolean bannerA(){
        explicitlyWait(banner);
        return banner.isDisplayed();
    }

    public Integer countBannerLinks(){
        return bannerLinks.size();
    }

    public void verifyBreadcrumpLinks(){
        for(WebElement link:breadcrumpLinks){
            String url = link.getAttribute("href");
            verifyLinks(url);
        }
    }

    public String bannerTitleC(){
        explicitlyWait(bannerTitle);
        return bannerTitle.getText();
    }



}
