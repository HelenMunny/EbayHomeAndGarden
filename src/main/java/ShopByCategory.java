import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopByCategory extends BaseClass{
    @FindBy(xpath = "//section[@class=\"b-module b-visualnav\"][1]  //div[@class=\"b-visualnav__title\"]")
    List<WebElement> categories;
    @FindBy(xpath = "//section[@id=\"s0-17-12-0-1[0]-0-0\"]")
    WebElement shopByCategory;
    @FindBy(xpath = "//section[@id=\"s0-17-12-0-1[0]-0-0\"] //a")
    List <WebElement> links;
    @FindBy(xpath = "//h2[@id=\"s0-17-12-0-1[0]-0-0-8-0-title\"]")
    WebElement sectionTitle;
    @FindBy(xpath = "//button[@class=\"b-accordion-handler b-textlink b-textlink--parent\"]")
    List <WebElement> accordionBtns;


    public void printCategories(){
        for(WebElement category:categories){
            explicitlyWait(category);
            System.out.println(category.getText());
        }
    }

    public boolean checkShopByCategory(){
        if(shopByCategory.isDisplayed() && shopByCategory.isEnabled()){
            return true;
        }else{
            return false;
        }
    }

    public Integer numOfLinks(){
        return links.size();
    }

    public String checkSectionTitle(){
        return sectionTitle.getText();
    }

    public void checkAccordionBtns(){
        for(WebElement btn:accordionBtns){
           String ariaExpanded = btn.getAttribute("aria-expanded");
            System.out.println(ariaExpanded);
        }
    }


}
