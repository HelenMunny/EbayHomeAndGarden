import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.concurrent.TimeUnit;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FooterClass extends BaseClass{

    @FindBy(xpath = "//footer[@id=\"glbfooter\"]")
    WebElement footer;
    @FindBy(xpath = "//button[@id=\"ifhItem0\"]")
    WebElement scrollUpBtn;
    @FindBy(css = "[class=\"gf-legal\"]")
    WebElement copyrightMsg;
    @FindBy(xpath = "//footer[@id=\"glbfooter\"] //a[@class=\"thrd gf-bar-a\"]")
    public List<WebElement> footerLinks;
    public boolean checkFooter(){
        if(footer.isEnabled() && footer.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }


    public boolean checkScrollBtn(){
        if(scrollUpBtn.isEnabled() && scrollUpBtn.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }

    public String checkCopyright(){
       return copyrightMsg.getText();
    }


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

//    public void getFooterURLText(){
//        TreeSet<String> set = new TreeSet<>();
//        for(WebElement link:footerLinks){
//            Actions actions = new Actions(driver);
//            actions.contextClick(link).perform();
//            switchTab();
//            String url = driver.getCurrentUrl();
//            set.add(url);
//            System.out.println(set);
//            driver.navigate().back();
//        }
//    }

public void verifyFooterLinks(){
    for(WebElement link:footerLinks){
       String url = link.getAttribute("href");
       verifyLinks(url);
    }
}






}
