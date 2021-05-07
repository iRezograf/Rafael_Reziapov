package ru.training.at.hw2.ex1.dataproviders;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FourItemsOnTheHeaderSection {
    @DataProvider(name = "FourItemsOnTheHeaderSection")
    public Iterator<Object[]> createData() {
        List<String> lst = new ArrayList<> ();
        lst.add("HOME");
        lst.add("CONTACT FORM");
        lst.add("SERVICE");
        lst.add("METALS & COLORS");
        Iterator iterator = lst.iterator();
        return iterator;
    }
}
