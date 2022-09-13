package Configuration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentReport {
    private ExtentReport(){}
    private static ExtentReports extent;
    public static ExtentTest test;
    private WebDriver driver;

    public static ExtentReports initReports() throws IOException {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target//Extent-Reports//index.html").viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY}).apply();
        final File CONF = new File("ExtentConfig.xml");
        reporter.loadXMLConfig(CONF);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }

    public static void flushReports() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File("target//Extent-Reports//index.html").toURI());
    }

    public static void createTest(String testCaseName){
        test = extent.createTest(testCaseName);
    }
}
