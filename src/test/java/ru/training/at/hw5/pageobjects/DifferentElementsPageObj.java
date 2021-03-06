package ru.training.at.hw5.pageobjects;


import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DifferentElementsPageObj extends BasePage {

    // Title
    @FindBy(css = "head > title")
    WebElement headTitle;

    //Select checkboxes Water
    @FindBy(xpath = "//label[contains(string(), 'Water')]/input[@type='checkbox']")
    WebElement checkboxWater;

    //label.label-checkbox
    //Select checkboxes Wind
    @FindBy(xpath = "//label[contains(string(), 'Wind')]/input[@type='checkbox']")
    WebElement checkboxWind;

    // Select radio Selen
    @FindBy(xpath = "//label[contains(string(), 'Selen')]/input[@type='radio']")
    WebElement radioSelen;

    //Select dropdown colors
    //@FindBy(xpath = "//div[@class='colors']//select[@class='uui-form-element']"));
    @FindBy(xpath = "//div[@class='main-content-hg']/div[@class='colors']")
    WebElement dropdownColors;

    //Select dropdown Yellow color
    @FindBy(xpath = "//option[text()='Yellow']")
    WebElement dropdownYellow;

    //Select panel body list logs
    //There are our logs
    @FindBy(xpath = "//*[@class='panel-body-list logs']/li")
    List<WebElement> logList;

    public DifferentElementsPageObj(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getLogList() {
        return logList;
    }

    public List<String> getLogListAsString() {
        List<String> list = new ArrayList<>();
        for (WebElement element : logList) {
            list.add(element.getText());
        }
        return list;
    }
}