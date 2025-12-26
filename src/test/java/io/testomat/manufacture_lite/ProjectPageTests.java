package io.testomat.manufacture_lite;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.testomat.manufacture_lite.utils.StringParsers.parseIntegerFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectPageTests extends BaseTest {

    static String baseUrl = env.get("BASE_URL");
    static String userEmail = env.get("USER_EMAIL");
    static String userPassword = env.get("USER_PASSWORD");
    String projectName = "Manufacture light";

    @BeforeAll
    static void openTestomatAndLogin() {
        open(baseUrl);
        loginUser(userEmail, userPassword);
    }

    @BeforeEach
    void openHomePage() {
        open(baseUrl);
    }

    @Test
    public void projectCanBeFoundViaSearch() {
        searchForProject(projectName);
        selectProject(projectName);
        waitForProjectPageIsLoaded(projectName);
    }

    @Test
    public void projectCardHasTestsCount() {
        searchForProject(projectName);
        SelenideElement project = countOfProjectsShouldBeEqualTo(2).first();
        projectTestsCountShouldBeEqualTo(project, 0);
    }

    private static void projectTestsCountShouldBeEqualTo(SelenideElement targetProject, Integer expectedCount) {
        String testsCountLine = targetProject.$("p").getText();
        int actualCount = parseIntegerFromString(testsCountLine);
        assertEquals(expectedCount, actualCount);
    }

    private static @NonNull ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return $$(".grid li").filter(visible).shouldHave(size(expectedSize));
    }

    private static void loginUser(String email, String password) {
        $("#content-desktop #user_email").setValue(email);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [value='Sign In']").click();
    }

    private static void searchForProject(String projectName) {
        $("#content-desktop #search").setValue(projectName);
    }

    private static void selectProject(String projectName) {
        $(byText(projectName)).click();
    }

    private static void waitForProjectPageIsLoaded(String projectName) {
        $(".breadcrumbs-page [title]").shouldHave(text(projectName));
    }
}
