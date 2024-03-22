import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

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
