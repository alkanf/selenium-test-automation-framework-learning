package day7;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
    	java.util.Locale.setDefault(java.util.Locale.ENGLISH);
        System.setProperty("user.language", "en");
        System.setProperty("user.country", "US");
        // 1. Specify the report storage location
        String reportPath = System.getProperty("user.dir") + "\\reports\\TestReport.html";
        sparkReporter = new ExtentSparkReporter(reportPath);
        
        sparkReporter.config().setDocumentTitle("Automation Execution Report");
        sparkReporter.config().setReportName("Functional Testing Results");
        sparkReporter.config().setTheme(Theme.DARK);
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
        // Populate common system info
        extent.setSystemInfo("Host Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Alkan");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Browser", "Chrome");
        
        System.out.println("DEBUG: Extent Report Initialization Started...");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test Case PASSED: " + result.getName());
        System.out.println("PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test Case FAILED: " + result.getName());
        test.log(Status.FAIL, "Failure Reason: " + result.getThrowable().getMessage());
        System.out.println("FAILED: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test Case SKIPPED: " + result.getName());
        System.out.println("SKIPPED: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // 2. CRITICAL: Write all data to the report file
        if (extent != null) {
            extent.flush();
            System.out.println("DEBUG: Extent Report has been flushed and generated successfully.");
        } else {
            System.out.println("DEBUG: Extent object is null. Check onStart configuration.");
        }
    }
}