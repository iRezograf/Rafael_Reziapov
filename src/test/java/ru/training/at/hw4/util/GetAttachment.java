package ru.training.at.hw4.util;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;
import ru.training.at.hw4.dp.DataStore;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@UtilityClass
public class GetAttachment {

    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get(
                DataStore.getProperty("PathToPicture"),
                resourceName));
    }

    @Attachment
    public String makeStringAttachment(List<String> collection) {
        return collection.toString();
    }

    @Attachment(type = "image/png", value = "try to use param {attName}")
    public byte[] attachPngImage(byte[] source, String attName) {
        return source;
    }

    public void attachFromInputStream(String name, InputStream is) {
        Allure.addAttachment(name, is);
    }
}
