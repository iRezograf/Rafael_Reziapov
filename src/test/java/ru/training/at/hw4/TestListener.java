package ru.training.at.hw4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


//@Listeners(ExerciseListener.class)
public class TestListener extends ExerciseOne {

    @BeforeClass
    public void StartUp() throws IOException {
        allExerciseOneTest();
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void takeScreenShot() {
        Assert.assertEquals(true, false);
    }

}
