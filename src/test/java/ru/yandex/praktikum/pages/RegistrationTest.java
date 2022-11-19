package ru.yandex.praktikum.pages;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.*;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import java.util.Random;

public class RegistrationTest extends BaseTest {
    @Test
    @DisplayName(value = "Успешная регистрация нового пользователя")
    public void registrationNewUserSuccess() {
        try {
            Random random = new Random();
            String username = "user" + random.nextInt(1000000);
            String email = "email" + random.nextInt(1000000) + "@test.ru";
            String password = "pAss" + random.nextInt(1000000);

            MainPage mainPage = open(baseURL, MainPage.class);
            AuthForm authForm = mainPage.clickToEnterAccountButton();
            RegisterForm registerForm = authForm.clickToRegisterButton();
            registerForm.setUsernameTextLine(username);
            registerForm.setEmailTextLine(email);
            registerForm.setPasswordTextLine(password);
            registerForm.clickToRegisterButton();
            $(By.xpath(".//h2[text()='Вход']")).shouldBe(Condition.visible);
        } catch (Exception e) {
            cleanDriver();
        }
    }

    @Test
    @DisplayName(value = "Неудачная регистрация пользователя при вводе слишком короткого пароля")
    public void registrationWithTooShortPasswordFailure() {
        try {
            Random random = new Random();
            String username = "user" + random.nextInt(1000000);
            String email = "email" + random.nextInt(1000000) + "@test.ru";

            int length = 4;
            boolean useLetters = true;
            boolean useNumbers = true;
            String password = RandomStringUtils.random(length, useLetters, useNumbers);

            MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
            AuthForm authForm = mainPage.clickToEnterAccountButton();
            RegisterForm registerForm = authForm.clickToRegisterButton();
            registerForm.setUsernameTextLine(username);
            registerForm.setEmailTextLine(email);
            registerForm.setPasswordTextLine(password);
            registerForm.clickToRegisterButton();

            $(By.xpath(".//p[text() = 'Некорректный пароль']")).shouldBe(Condition.visible);
        } catch (Exception e) {
            cleanDriver();
        }
    }
}
