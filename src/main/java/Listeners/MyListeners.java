package Listeners;

import Logs.Logutiles;
import org.testng.*;

public class MyListeners implements IInvokedMethodListener , ITestListener, IExecutionListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        Logutiles.info(method.getTestMethod().getMethodName() + " Started ");
    }
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        Logutiles.info(method.getTestMethod().getMethodName() + " Finished ");
    }
    public void onTestStart(ITestResult result) {
        Logutiles.info(result.getMethod().getMethodName() + " Started ");
    }
    public void onTestSuccess(ITestResult result) {
        Logutiles.debug(result.getMethod().getMethodName() +"Success");
    }
    public void onTestFailure(ITestResult result) {
        Logutiles.error(result.getMethod().getMethodName() +"Failed");;
    }
    public void onTestSkipped(ITestResult result) {
        Logutiles.warn(result.getMethod().getMethodName() +"Skipped");
    }
    @Override
    public void onExecutionStart() {
        Logutiles.info(" Execution Started");
    }

    @Override
    public void onExecutionFinish() {
        Logutiles.info(" Execution Finished");
    }

}
