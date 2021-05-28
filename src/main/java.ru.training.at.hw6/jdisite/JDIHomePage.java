package jdisite;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class JDIHomePage extends WebPage {

    @FindBy(css = ".benefit")
    private WebList benefits;

    public int getBenefitsCount() {
        return benefits.size();
    }
}
