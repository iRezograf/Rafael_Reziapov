package ru.training.at.hw3.dp;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Test
public class LoginPageDataProvider {
    //@DataProvider(name = "LoginPageDataProvider")
    public LoginPageDataOfTest [] createData() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/conf.properties");
        Properties props = new Properties();
        props.load(fileInputStream);
        fileInputStream.close();
        //loading props
        System.out.println(DataStore);
        LoginPageDataOfTest loginPageDataOfTest = new LoginPageDataOfTest();
        loginPageDataOfTest.setUserName(DataStore.getProperty("userName"));
        loginPageDataOfTest.setUserName(DataStore.getProperty("password"));
        loginPageDataOfTest.setUserNameAfterLogged(DataStore.getProperty("userNameAfterLogged"));

        //loginPageDataOfTest.setUserName(props.getProperty("userName"));
        ///loginPageDataOfTest.setUserName(props.getProperty("password"));
        //loginPageDataOfTest.setUserNameAfterLogged(props.getProperty("userNameAfterLogged"));
        System.out.println(DataStore.getProperty("userNameAfterLogged"));
        //String s1 = props.getProperty("s1");
        //String s2 = props.getProperty("s2");
        //String s3 = props.getProperty("s3");
        //List<String> list = Arrays.asList(s1, s2, s3);
        //loginPageDataOfTest.setList(list);
        return new LoginPageDataOfTest[]{loginPageDataOfTest};
    }

}
