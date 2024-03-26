import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderClass extends BaseClass{

    @FindBy(css = "[id=\"gh\"]")
    WebElement header;
    public boolean setHeader(){
        explicitlyWait(header);
        if(header.isDisplayed() && header.isEnabled()){
            return true;
        }else{
            return false;
        }
    }

    @FindBy(xpath = "//header[@id=\"gh\"] //a")
    List<WebElement> headerLinks;
    public Integer setHeaderLinks(){
        return headerLinks.size();
    }

    public void verifyHeaderLinks(){
        for(WebElement link:headerLinks){
            String url = link.getAttribute("href");
            verifyLinks(url);
        }
    }




    @FindBy(id = "gh-la")
    WebElement logoLink;
    public String logoCheck(){
        if(logoLink.isEnabled() && logoLink.isDisplayed()){
            logoLink.click();
        }
        return driver.getCurrentUrl();
    }

    public boolean checkLogo(){
        return logoLink.isDisplayed();
    }

    @FindBy(xpath = "//a[@data-sp=\"m570.l2633\"]")
    WebElement cart;
    public boolean checkCart(){
        if(cart.isEnabled() && cart.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }

    @FindBy(css = "[id=\"gh-topl\"]")
    WebElement shipToFlag;
    public boolean checkShipToFlag(){
        if(shipToFlag.isEnabled() && shipToFlag.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }

    @FindBy(css = "[id=\"gh-shop-a\"]")
    WebElement shopByCategory;
    @FindBy(xpath = "//a[@_sp=\"m570.l3412\"][text()=\"Home & garden\"]")
    WebElement homeAndGarden;
    public String setShopByCategory(){
        shopByCategory.click();
        explicitlyWait(homeAndGarden);
        homeAndGarden.click();
        return driver.getCurrentUrl();
    }

    @FindBy(css = "[id=\"gh-ac\"]")
    WebElement searchBar;
    @FindBy(css = "[id=\"gh-btn\"]")
    WebElement searchBtn;
    public String setSearchOption(){
        searchBar.sendKeys("Home & Garden");
        searchBtn.click();
        implicitlyWait();
        return driver.getCurrentUrl();
    }

    @FindBy(css = "[id=\"gh-cat\"]")
    WebElement selectACategory;
    public String setSelectACategory(){
        dropdown(selectACategory,"Home & Garden");
        searchBtn.click();
        return driver.getCurrentUrl();
    }

    @FindBy(css = "[_sp=\"m570.l2919\"]")
    WebElement myeBay;
    @FindBy(css = "[data-sp=\"m570.l1533\"]")
    WebElement summary;
    public String checkMyeBay(){
        actions(myeBay);
        explicitlyWait(summary);
        summary.click();
        return driver.getCurrentUrl();
    }

    @FindBy(css = "[data-sp=\"m570.l1528\"]")
    WebElement sell;

    public String setSellBtn(){
        sell.click();
        return driver.getCurrentUrl();
    }

    @FindBy(css = "[data-sp=\"m570.l1545\"]")
    WebElement helpContactBtn;
    public String setHelpAndContact(){
        helpContactBtn.click();
        return driver.getCurrentUrl();
    }

    @FindBy(css = "[data-sp=\"m570.l2633\"]")
    WebElement cartBtn;
    public String setCartBtn(){
        cartBtn.click();
        return driver.getCurrentUrl();
    }








}
