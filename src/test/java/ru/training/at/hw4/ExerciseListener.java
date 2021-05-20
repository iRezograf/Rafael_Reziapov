package ru.training.at.hw4;


import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExerciseListener extends ExerciseOne implements ITestListener {
    ExerciseOne exerciseOne;

    public ExerciseListener() {
        this.exerciseOne = new ExerciseOne();
    }

    @Override
    public void onTestStart(ITestResult result) {
        //
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //
        System.out.println("Success of test cases and its details are : "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skip of test cases and its details are : "+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Failure of test cases and its details are : "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failure of test cases and its details are : "+result.getName());
        failed(result.getMethod().getMethodName());

    }

}
