package io.testomat.manufacture_lite.web.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    public void isLoaded(String projectName) {
        $(".breadcrumbs-page [title]").shouldHave(text(projectName));
    }
}
