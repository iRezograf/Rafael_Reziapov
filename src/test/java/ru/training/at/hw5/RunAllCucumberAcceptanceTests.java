package ru.training.at.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features = {"/src/test/resources/HW5"})
//@CucumberOptions(features = {"src/test/resources/hw5"})
@CucumberOptions(
        features = "src/test/resources/hw5",
        glue = {"src/test/java/ru/training/at/hw5/hook",
                "src/test/java/ru/training/at/hw5/steps"},
        tags = "@Ex2",
        dryRun = false
)
public class RunAllCucumberAcceptanceTests extends AbstractTestNGCucumberTests {
}