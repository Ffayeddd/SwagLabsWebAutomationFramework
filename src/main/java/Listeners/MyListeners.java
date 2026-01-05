package Listeners;

import Logs.LogUtils;
import org.testng.*;

public class MyListeners implements IInvokedMethodListener , ITestListener, IExecutionListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        LogUtils.info(method.getTestMethod().getMethodName() + " Started ");
    }
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        LogUtils.info(method.getTestMethod().getMethodName() + " Finished ");
    }
    public void onTestStart(ITestResult result) {
        LogUtils.info(result.getMethod().getMethodName() + " Started ");
    }
    public void onTestSuccess(ITestResult result) {
        LogUtils.debug(result.getMethod().getMethodName() +"Success");
    }
    public void onTestFailure(ITestResult result) {
        LogUtils.error(result.getMethod().getMethodName() +"Failed");;
    }
    public void onTestSkipped(ITestResult result) {
        LogUtils.warn(result.getMethod().getMethodName() +"Skipped");
    }
    @Override
    public void onExecutionStart() {
        LogUtils.info(" Execution Started");
    }

    @Override
    public void onExecutionFinish() {
        LogUtils.info(" Execution Finished");
    }

}
