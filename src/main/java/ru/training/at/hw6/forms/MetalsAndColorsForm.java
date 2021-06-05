package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class MetalsAndColorsForm  {

    @UI(".panel-body-list.results")
    public static WebList panelBodyListResults;

    @UI("[name=custom_radio_odd]")
    public static RadioButtons customRadioOdd;

    @UI("[name=custom_radio_even]")
    public static RadioButtons customRadioEven;

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown colors; //@FindBy(css = "div[ui=dropdown]")

    @JDropdown(root = "div[ui=combobox]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown metals;

    @JDropdown(root = "div[ui=droplist]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown vegetables;

    //@FindBy(css = "#elements-checklist")
    @JDropdown(root = "#elements-checklist]",
            value = ".filter-option",
            list = "p",
            expand = ".caret")
    public static Checklist elements;

    @FindBy(css = "#submit-button")
    public static Button submitButton;

}
