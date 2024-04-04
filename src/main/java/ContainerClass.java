import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContainerClass extends BaseClass{

    @FindBy(xpath = "//div[@class=\"pagecontainer__center PR_right_wrap \"]")
    WebElement container;
    @FindBy(xpath = "//div[@class=\"pagecontainer__center PR_right_wrap \"] //a")
    List <WebElement> containerLinks;
    @FindBy(xpath = "//section[@class=\"b-module b-visualnav\"]")
    List <WebElement> productSections;
    @FindBy(xpath = "//h2[@class=\"section-title__title\"]")
    List <WebElement> sectionTitles;
    @FindBy(xpath = "//h2[@id=\"s0-28_1-9-0-1[1]-0-2-0-title\"]")
    WebElement sectionTitle1;
    @FindBy(xpath = "//h2[@id=\"s0-28_1-9-0-1[2]-0-2-0-title\"]")
    WebElement sectionTitle2;
    @FindBy(css = "[id=\"s0-28_1-9-0-1[3]-0-0-3-0-title\"]")
    WebElement sectionTitle3;
    @FindBy(css = "[id=\"s0-28_1-9-0-1[4]-1-0-bModCarousel-3-0-title\"]")
    WebElement sectionTitle4;
    @FindBy(css = "[id=\"s0-28_1-9-0-1[5]-0-2-0-title\"]")
    WebElement sectionTitle5;
    @FindBy(xpath = "//section[@class=\"b-module b-blurb\"]/div/p[1]")
    WebElement contentParagraph1;
    @FindBy(xpath = "//section[@class=\"b-module b-blurb\"]/div/p[2]")
    WebElement contentParagraph2;

    public boolean checkContainer(){
        return container.isDisplayed();
    }

    public void verifyContainerLinks(){
        for(WebElement link:containerLinks){
            String url = link.getAttribute("href");
            verifyLinks(url);
        }
    }
    public Integer countContainerLinks(){
        return containerLinks.size();
    }

    public void getURLContainerLinks(){
        for(WebElement link:containerLinks){
            String openTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            link.sendKeys(openTab);
            System.out.println(link.getAttribute("href"));
        }
    }

    public void clickEachContainerLinks(){
        for(WebElement link:containerLinks){
            String openTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            link.sendKeys(openTab);
        }
    }

    public Integer countProductSections(){
        return productSections.size();
    }


    public Integer countSectionTitles(){
        return sectionTitles.size();
    }
    public void checkSectionTitles(){
        for(WebElement title:sectionTitles){
            System.out.println(title.getText());
        }
    }

    public String title1(){
        return sectionTitle1.getText();
    }


    public String title2(){
        explicitlyWait(sectionTitle2);
        return sectionTitle2.getText();
    }

    public String title3(){
        explicitlyWait(sectionTitle3);
        return sectionTitle3.getText();
    }


    public String title4(){
        explicitlyWait(sectionTitle4);
        return sectionTitle4.getText();
    }


    public String title5(){
        explicitlyWait(sectionTitle5);
        return sectionTitle5.getText();
    }


    public String paragraph1(){
        explicitlyWait(contentParagraph1);
        return contentParagraph1.getText();
    }


    public String paragraph2(){
        explicitlyWait(contentParagraph2);
        return contentParagraph2.getText();
    }


}
