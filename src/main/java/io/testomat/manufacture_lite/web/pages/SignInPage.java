package io.testomat.manufacture_lite.web.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    public void open() {
        Selenide.open("/users/sign_in");
    }

    public void login(String email, String password) {
        $("#content-desktop #user_email").setValue(email);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [value='Sign In']").click();
        $("#content-desktop #user_email").shouldBe(hidden);
        $("#content-desktop #user_password").shouldBe(hidden);
    }
}
