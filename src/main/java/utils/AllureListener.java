package utils;

import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test" + result.getMethod().getMethodName() + " started!!!");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test" + result.getMethod().getMethodName() + " PASSED!!!");

    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test" + result.getMethod().getMethodName() + " FAILED!!!");

    }
    @Attachment(value = "Page Screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}

