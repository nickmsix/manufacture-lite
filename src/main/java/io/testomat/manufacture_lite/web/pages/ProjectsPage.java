package io.testomat.manufacture_lite.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    private SelenideElement searchInput = $("#content-desktop #search");

    public void open() {
        Selenide.open("");
    }

    public void isLoaded() {
        searchInput.shouldBe(visible);
    }

    public void signInSuccess() {
        $("#container .common-flash-success").shouldBe(visible);
    }

    public void searchForProject(String projectName) {
        searchInput.setValue(projectName);
    }

    public void selectProject(String projectName) {
        $(byText(projectName)).click();
    }

    public ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return $$(".grid li").filter(visible).shouldHave(size(expectedSize));
    }

    public void projectTestsCountShouldBeEqualTo(SelenideElement project, Integer expectedCount) {
        project.shouldHave(text(expectedCount + " tests"));
    }
}
