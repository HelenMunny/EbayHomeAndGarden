import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FooterClass extends BaseClass{

    @FindBy(xpath = "//footer[@id=\"glbfooter\"]")
    WebElement footer;
    public boolean checkFooter(){
        if(footer.isEnabled() && footer.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }

    @FindBy(xpath = "//button[@id=\"ifhItem0\"]")
    WebElement helpBtn;
    public boolean checkHelpBtn(){
        if(helpBtn.isEnabled() && helpBtn.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }
    @FindBy(css = "[class=\"gf-legal\"]")
    WebElement copyrightMsg;
    public String checkCopyright(){
       return copyrightMsg.getText();
    }

    @FindBy(xpath = "//footer[@id=\"glbfooter\"] //a[@class=\"thrd gf-bar-a\"]")
    public List<WebElement> footerLinks;

    public Integer footerA(){
        for(WebElement link:footerLinks){
            System.out.println(link.isEnabled());
        }
        return footerLinks.size();
    }

    public void clickEachFooterLinks(){
        for(WebElement link:footerLinks){
            String openTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            link.sendKeys(openTab);
        }
    }

    public void getURLFooterLinks(){
        for(WebElement link:footerLinks){
            String openTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            link.sendKeys(openTab);
            System.out.println(link.getAttribute("href"));
        }
    }


public void verifyFooterLinks(){
    for(WebElement link:footerLinks){
       String url = link.getAttribute("href");
       verifyLinks(url);
    }
}






}
