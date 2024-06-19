package org.example;

import org.testng.ITestResult;
import org.testng.ITestListener;

public class ITestListener1 implements ITestListener {
    public void OnTestStart (ITestResult result)
    {
        System.out.println("On starting Test");
    }
    public void OnTestSuccess (ITestResult result)
    {
        System.out.println("Successfull");
    }
    public void OnTestFailure (ITestResult result)
    {
        System.out.println("Failed");
    }
    public void OnTestSkipped(ITestResult result)
    {
        System.out.println("Skipped");
    }
    public void OnTestSkippedWithinSuccessPercentage(ITestResult result)
    {
        System.out.println("Within Success Percentage");
    }
}
