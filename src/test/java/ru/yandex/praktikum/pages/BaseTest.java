package ru.yandex.praktikum.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class BaseTest {
    final String baseURL = "https://stellarburgers.nomoreparties.site/";

    protected String email;
    protected String password;

    protected String username;

    protected AuthForm registration() {
        Random random = new Random();
        String username = "user" + random.nextInt(1000000);
        String email = "email" + random.nextInt(1000000) + "@test.ru";
        String password = "pAssma" + random.nextInt(1000000);

        this.email = email;
        this.password = password;
        this.username = username;

        MainPage mainPage = open(baseURL, MainPage.class);
        AuthForm authForm = mainPage.clickToEnterAccountButton();
        RegisterForm registerForm = authForm.clickToRegisterButton();
        registerForm.setUsernameTextLine(username);
        registerForm.setEmailTextLine(email);
        registerForm.setPasswordTextLine(password);
        AuthForm authForm1 = registerForm.clickToRegisterButton();
        return authForm1;
    }

    protected void cleanDriver() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @After
    public void teardown() {
        cleanDriver();
    }
}
