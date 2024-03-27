import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopByCategory extends BaseClass{
    @FindBy(xpath = "//section[@class=\"b-module b-visualnav\"][1]  //div[@class=\"b-visualnav__title\"]")
    List<WebElement> categories;

    public void printCategories(){
        for(WebElement category:categories){
            explicitlyWait(category);
            System.out.println(category.getText());
        }
    }



}
