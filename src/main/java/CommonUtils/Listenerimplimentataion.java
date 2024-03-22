package CommonUtils;

import java.io.IOException;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenerimplimentataion implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("testscript execution is started");
		String methodname=result.getMethod().getMethodName();
		Reporter.log(methodname+"testscript execution is started",true);
		test.log(Status.PASS, "testscript execution is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("testscript execution is success ");
		//capture the ,method name
		String methodname=result.getMethod().getMethodName();
		Reporter.log(methodname+"tesrscript execution is pass",true);
		test.log(Status.PASS, "testscript execution is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("testscript execution is failed");
		String methodname=result.getMethod().getMethodName();
		Reporter.log(methodname+"tesrscript execution is fail",true);
		test.log(Status.FAIL, "testscript execution is fail");
		//to take screenshot if testscript is failed
		WebDriverUtil wutil=new WebDriverUtil();
		try {
		String path=wutil.Screenshot(baseclass.sdriver);
		test.addScreenCaptureFromPath(path);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("testscript execution is skipped");
		String methodname=result.getMethod().getMethodName();
		Reporter.log(methodname+"tesrscript execution is skip",true);
		test.log(Status.SKIP, "testscript execution is skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//System.out.println("testscript execution is started in suit level");
		
		//to configure extent reports
		ExtentSparkReporter esr=new ExtentSparkReporter("./ExtentReport/"+jutil+"emptyreport.html"); 
		esr.config().setReportName("vtigerCRM");
		esr.config().setTheme(Theme.DARK);
		esr.config().setDocumentTitle("Janhvi");
		
		//to generate extent reports
	    report=new ExtentReports();
	    report.attachReporter(esr);
		report.setSystemInfo("Browser","Chrome");
		report.setSystemInfo("Chrome", "122");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Author", "janhvi");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//System.out.println("testscripte execution is finsh in suit level");
		report.flush();
	}

}
