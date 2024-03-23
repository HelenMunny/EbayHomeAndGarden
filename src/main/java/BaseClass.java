import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass {
public static WebDriver driver;

public void invokeBrowser(String url){
    System.setProperty("webdriver.jdk.factory","jdk-http-client");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(url);
}

public void quitBrowser(){
    driver.quit();
}

public void explicitlyWait(WebElement element){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(element));
}

public void implicitlyWait(){
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

public void dropdown(WebElement element, String text){
    Select select = new Select(element);
    select.selectByVisibleText(text);
}

public void actions(WebElement element){
    Actions actions = new Actions(driver);
    actions.moveToElement(element).perform();
}

public void verifyLinks(String url){
        try{
            URL link = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();

            if(httpURLConnection.getResponseCode()==200){
                System.out.println(url+" - NOT a broken link.");
            }else {
                System.out.println(url+" - is a broken link.");
            }
        }catch(Exception e){
            System.out.println(url+" - is a broken link.");
        }
    }


}
