package ru.training.at.hw4;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.training.at.hw4.util.GetAttachment;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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
        System.out.println("Failure of test cases and its details are : " + result.getName());
        Object driver = result.getTestContext().getAttribute("driver");

        if (driver != null) {
            GetAttachment.makeStringAttachment(Arrays.asList(
                    "test context contains driver:",
                    driver.toString()
            ));
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            System.out.println("driver is not null");
            try {
                FileUtils.copyFile(file, new File(System.getProperty("user.dir")
                        + "\\b" + ".png"));
                System.out.println("driver is not null");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("EEE: onTestFailure.exit")
        //failed(result.getMethod().getMethodName(), driver)
    }

}
