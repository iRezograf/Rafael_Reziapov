package ru.training.at.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features = {"/src/test/resources/HW5"})
@CucumberOptions(features = {"classpath:HW5"})
public class RunAllCucumberAcceptanceTests extends AbstractTestNGCucumberTests {
}
