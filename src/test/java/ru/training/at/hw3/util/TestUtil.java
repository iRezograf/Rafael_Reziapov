package ru.training.at.hw3.util;

import org.testng.annotations.Test;
import ru.training.at.hw3.dp.DataStore;

@Test
public class TestUtil {

    TestUtil() {
        System.out.println(DataStore.getProperty("textUnderIconsList4"));
    }

}
