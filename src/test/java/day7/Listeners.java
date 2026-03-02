package day7;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	
	 public void onTestStart(ITestResult result) {
		   System.out.println("On listeners start");
		  }
	 
	 public void onTestSuccess(ITestResult result) {
		    // not implemented
		  }
	 
	 public void onTestFailure(ITestResult result) {
		    // not implemented
		  }
	 
	 public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }
	 
	 public void onStart(ITestContext context) {
		    // not implemented
		  }
	 
	 public void onFinish(ITestContext context) {
		    // not implemented
		  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
