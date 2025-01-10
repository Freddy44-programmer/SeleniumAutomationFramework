package TestNGTutorials;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener interface which implements TestNG listeners
public class Listeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //screenshot code
        System.out.println("Test Failed" + result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onFinish(ITestContext context) {

    }

}
