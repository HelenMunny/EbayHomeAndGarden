import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class FooterClass extends BaseClass{

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
