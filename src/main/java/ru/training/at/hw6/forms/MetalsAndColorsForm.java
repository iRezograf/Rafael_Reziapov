package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.complex.Combobox;
import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class MetalsAndColorsForm  {

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
}
