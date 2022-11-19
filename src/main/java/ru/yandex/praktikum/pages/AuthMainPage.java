package ru.yandex.praktikum.pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.page;

public class AuthMainPage extends MainPage {
    public UserProfile clickToUserProfile() {
        userProfileButton.scrollTo();
        userProfileButton.shouldBe(Condition.visible);
        userProfileButton.click();
        UserProfile userProfile = page(UserProfile.class);
        return userProfile;
    }
}
