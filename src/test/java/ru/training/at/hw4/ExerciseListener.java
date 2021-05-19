package ru.training.at.hw4;


import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExerciseListener extends ExerciseOne implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        //failed();
        failed(result.getMethod().getMethodName());
    }

}
