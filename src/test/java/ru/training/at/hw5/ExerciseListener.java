package ru.training.at.hw5;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ExerciseListener  implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        //
        System.out.println("Success of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skip of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Failure of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //System.out.println("Failure of test cases and its details are : " + result.getName());
        //GetAttachment.makeStringAttachment(methodName);
        //System.out.println(methodName);
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        System.out.println("It's all");

        if (driver != null) {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            System.out.println("driver is not null");
            try {
                // Need resolve issues with:
                // screenshot's catalog and name
                FileUtils.copyFile(file, new File(System.getProperty("user.dir")
                        + "\\b" + ".png"));
                System.out.println("driver is not null");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
