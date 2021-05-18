package ru.training.at.hw4.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Benefits {
    public WebDriver driver;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitTxt;


    public Benefits(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<String> getBenefitTxtAsString() {
        List<String> list = new ArrayList<>();
        for (WebElement element : benefitTxt) {
            list.add(element.getText());
        }
        return list;
    }
}
