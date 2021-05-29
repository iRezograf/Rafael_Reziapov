package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.at.hw6.forms.MetalsAndColorsForm;

@Url("metals-colors.html")
@Title("Metals and Colors")
public class MetalsAndColorsPage extends WebPage {

    // . - class ; # - id
    @UI(".info-panel-section")
    public static Section infoPanelSection;

    @UI(".form")
    public static MetalsAndColorsForm metalsAndColorsForm;
}
