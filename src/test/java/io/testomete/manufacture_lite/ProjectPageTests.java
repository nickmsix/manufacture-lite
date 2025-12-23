package io.testomete.manufacture_lite;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests {

    @Test
    public void projectCanBeFoundViaSearch() {
        //  Login
        open("https://app.testomat.io");
        $("#content-desktop #user_email").setValue("test.nick.acc.1@gmail.com");
        $("#content-desktop #user_password").setValue("TY6WT!xWwennHBs");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [value='Sign In']").click();

        // Search for Project
        String projectName = "Manufacture light";
        $("#content-desktop #search").setValue(projectName);

        // Open Project
        $(byText(projectName)).click();

        // Validate the Project page
        $(".breadcrumbs-page [title]").shouldHave(text(projectName));
    }
}
