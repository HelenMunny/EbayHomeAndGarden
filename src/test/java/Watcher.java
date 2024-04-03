import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Watcher implements ITestListener {
    private static final ExtentReports extent = ExtentManager.createInstance("testReport.html");
    private static final ThreadLocal<ExtentTest> testMethod = new ThreadLocal<>();

    private ExtentTest getTest(ITestResult result){
        return testMethod.get();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentTest test = extent.createTest(methodName);
        testMethod.set(test);
        String[] groups = result.getMethod().getGroups();
        Arrays.asList(groups).forEach(x->testMethod.get().assignCategory(x));
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println("Failed!");

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH-mm-ss");
        Date date = new Date();
        String name = dateFormat.format(date);
        File file = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file, new File("src/screenshot/"+name+".png"));
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }

        getTest(result).fail(result.getThrowable());

    }

    public synchronized void onFinish(ITestContext context){
        extent.flush();
    }

}

