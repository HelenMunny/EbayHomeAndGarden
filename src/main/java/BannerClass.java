import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BannerClass extends BaseClass{
    @FindBy(xpath = "//div[@class=\"pagecontainer__top\"]")
    WebElement banner;
    public boolean bannerA(){
        explicitlyWait(banner);
        return banner.isDisplayed();
    }

    @FindBy(xpath = "//div[@class=\"pagecontainer__top\"] //a")
    List <WebElement> bannerLinks;
    public Integer countBannerLinks(){
        return bannerLinks.size();
    }

    @FindBy(xpath = "//a[@class=\"seo-breadcrumb-text\"]")
    List<WebElement> breadcrumpLinks;
    public void verifyBreadcrumpLinks(){
        for(WebElement link:breadcrumpLinks){
            String url = link.getAttribute("href");
            verifyLinks(url);
        }
    }

    @FindBy(xpath = "//div[@class=\"pagecontainer__top\"] //span[@class=\"b-pageheader__text\"]")
    WebElement bannerTitle;

    public String bannerTitleC(){
        explicitlyWait(bannerTitle);
        return bannerTitle.getText();
    }



}
