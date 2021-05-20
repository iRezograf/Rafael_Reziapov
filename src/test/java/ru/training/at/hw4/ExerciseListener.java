package ru.training.at.hw4;


import org.testng.ITestListener;
import org.testng.ITestResult;

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

    // Vladimir, I need help!
    // ExerciseOne exerciseOne = new ExerciseOne()
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failure of test cases and its details are : " + result.getName());

        //Object driver = result.getTestContext().getAttribute("driver");

        /* Vladimir, I need help!
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

         */
        //System.out.println("EEE: onTestFailure.exit")
        //exerciseOne.failed(result.getMethod().getMethodName(), driver);
    }

}
