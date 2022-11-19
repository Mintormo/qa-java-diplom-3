package ru.yandex.praktikum.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ConstructorTest extends BaseTest {
    @Test
    @DisplayName(value = "Переход к странице соусов в конструкторе")
    public void goToSaucePage() {
        try {
            AuthForm authForm = registration();
            authForm.setEmailTextLine(email);
            authForm.setPasswordTextLine(password);
            AuthMainPage authMainPage = authForm.clickToLoginButton();
            authMainPage.clickToConstructorButton();
            authMainPage.clickToSaucePageButton();
            $(By.xpath(".//h2[text()='Соусы']")).shouldBe(Condition.visible);
        } catch (Exception e) {
            cleanDriver();
        }
    }

    @Test
    @DisplayName(value = "Переход к странице булок в конструкторе")
    public void goToBunsPage() {
        try {
            AuthForm authForm = registration();
            authForm.setEmailTextLine(email);
            authForm.setPasswordTextLine(password);
            AuthMainPage authMainPage = authForm.clickToLoginButton();
            authMainPage.clickToConstructorButton();
            authMainPage.clickToBunsPageButton();
            $(By.xpath(".//h2[text()='Булки']")).shouldBe(Condition.visible);
        } catch (Exception e) {
            cleanDriver();
        }
    }

    @Test
    @DisplayName(value = "Переход к странице начинок в конструкторе")
    public void goToIngredientsPage() {
        try {
            AuthForm authForm = registration();
            authForm.setEmailTextLine(email);
            authForm.setPasswordTextLine(password);
            AuthMainPage authMainPage = authForm.clickToLoginButton();
            authMainPage.clickToConstructorButton();
            authMainPage.clickToIngredientsPageButton();
            $(By.xpath(".//h2[text()='Начинки']")).shouldBe(Condition.visible);
        } catch (Exception e) {
            cleanDriver();
        }
    }
}
