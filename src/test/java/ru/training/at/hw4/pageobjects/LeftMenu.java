package ru.training.at.hw4.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LeftMenu {
    WebDriver driver;

    @FindBy(css = "#mCSB_1_container > ul > li")
    List<WebElement> leftMenu;

    public LeftMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<String> getLeftMenuAsString() {
        List<String> list = new ArrayList<>();
        for (WebElement element : leftMenu) {
            list.add(element.getText());
        }
        return list;
    }
}
