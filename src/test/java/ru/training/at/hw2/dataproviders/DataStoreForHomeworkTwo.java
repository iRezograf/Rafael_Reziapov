package ru.training.at.hw2.dataproviders;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class DataStoreForHomeworkTwo {
    String siteUrl;
    String browserTitle;
    String userName;
    String password;
    String userNameAfterLogged;
    ArrayList<String> textOfHeaderMenuButtonsList;
    ArrayList<String> textUnderIconsList;
    ArrayList<String> textInLeftSectionMenuButtonList;
    ArrayList<String> textSelectedCheckBoxList;
    ArrayList<String> textSelectedRadioList;
    ArrayList<String> textSelectedDropDownList;

    public DataStoreForHomeworkTwo() {
        this.siteUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        this.browserTitle = "Home Page";
        this.userName = "Roman";
        this.password = "Jdi1234";
        this.userNameAfterLogged = "ROMAN IOVLEV";

        textOfHeaderMenuButtonsList = new ArrayList<>();
        textOfHeaderMenuButtonsList.add("HOME");
        textOfHeaderMenuButtonsList.add("CONTACT FORM");
        textOfHeaderMenuButtonsList.add("SERVICE");
        textOfHeaderMenuButtonsList.add("METALS & COLORS");
        this.textOfHeaderMenuButtonsList = textOfHeaderMenuButtonsList;

        textUnderIconsList = new ArrayList<>();
        textUnderIconsList.add("To include good practices\n"
                    + "and ideas from successful\n"
                    + "EPAM project");
        textUnderIconsList.add("To be flexible and\n"
                    + "customizable");
        textUnderIconsList.add("To be multiplatform");
        textUnderIconsList.add(
            "Already have good base\n"
                    + "(about 20 internal and\n"
                    + "some external projects),\n"
                    + "wish to get more…");
        this.textUnderIconsList = textUnderIconsList;
        this.textInLeftSectionMenuButtonList = null;
        this.textSelectedCheckBoxList = null;
        this.textSelectedRadioList = null;
        this.textSelectedDropDownList = null;
    }
}
