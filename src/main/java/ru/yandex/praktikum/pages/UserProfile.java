package ru.yandex.praktikum.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class UserProfile extends CommonItems {
    @FindBy(how = How.XPATH, using=".//button[text()='Выход']")
    private SelenideElement logoutButton;

    @FindBy(how = How.XPATH, using=".//label[text()='Имя']/../input")
    private SelenideElement username;

    public String getUsername() {
        return username.getValue();
    }

    public AuthForm clickToLogoutButton() {
        logoutButton.scrollTo();
        logoutButton.shouldBe(Condition.visible);
        logoutButton.click();
        AuthForm authForm = page(AuthForm.class);
        return authForm;
    }
}
