package ru.training.at.hw6.providers;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

@NoArgsConstructor
@Getter
@Setter
public class LoginUserData {
    String pageUrl;     //"index.html"
    String pageTitle;   //"Home Page"
    String userName;    //"Roman"
    String password;    //"Jdi1234"
    String userNameAfterLogged;    //"ROMAN IOVLEV"
}
