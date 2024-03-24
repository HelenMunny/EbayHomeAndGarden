import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContainerClass extends BaseClass{

    @FindBy(xpath = "//div[@class=\"pagecontainer__center PR_right_wrap \"]")
    WebElement container;
    public boolean checkContainer(){
        return container.isDisplayed();
    }

    @FindBy(xpath = "//div[@class=\"pagecontainer__center PR_right_wrap \"] //a")
    List <WebElement> containerLinks;
    public void verifyContainerLinks(){
        for(WebElement link:containerLinks){
            String url = link.getAttribute("href");
            verifyLinks(url);
        }
    }
    public Integer countContainerLinks(){
        return containerLinks.size();
    }

    @FindBy(xpath = "//section[@class=\"b-module b-visualnav\"]")
    List <WebElement> productSections;
    public Integer countProductSections(){
        return productSections.size();
    }

    @FindBy(xpath = "//h2[@class=\"section-title__title\"]")
    List <WebElement> sectionTitles;
    public Integer countSectionTitles(){
        return sectionTitles.size();
    }
    public void checkSectionTitles(){
        for(WebElement title:sectionTitles){
            System.out.println(title.getText());
        }
    }


}
