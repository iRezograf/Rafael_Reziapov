package jdisite.entities;

import com.epam.jdi.tools.DataClass;

public class ContactInfo extends DataClass<ContactInfo> {
    public String name, lastName, position, gender, religion, description;
    public int passportNumber, passportSeria;
    public boolean acceptConditions, passport;
}
