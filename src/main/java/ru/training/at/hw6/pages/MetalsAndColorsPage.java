package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import ru.training.at.hw6.forms.MetalsAndColorsForm;

@Url("metals-colors.html")
@Title("Metals and Colors")
public class MetalsAndColorsPage extends WebPage {

    @UI(".panel-body-list.results")
    public static WebList panelBodyListResults;

}
