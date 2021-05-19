package ru.training.at.hw4.util;

import io.qameta.allure.Attachment;
import ru.training.at.hw4.dp.DataStore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetAttachment {

    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get(
                DataStore.getProperty("PathToPicture"),
                resourceName));
    }

}
