import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

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

public void verifyFooterLinks(){
    for(WebElement link:footerLinks){
       String url = link.getAttribute("href");
       verifyLinks(url);
    }
}






}
