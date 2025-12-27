package io.testomat.manufacture_lite;

import com.codeborne.selenide.SelenideElement;
import io.testomat.manufacture_lite.web.pages.ProjectPage;
import io.testomat.manufacture_lite.web.pages.ProjectsPage;
import io.testomat.manufacture_lite.web.pages.SignInPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectPageTests extends BaseTest {

    static String email = env.get("USER_EMAIL");
    static String password = env.get("USER_PASSWORD");
    static SignInPage signInPage = new SignInPage();
    static ProjectsPage projectsPage = new ProjectsPage();
    ProjectPage projectPage = new ProjectPage();
    String projectName = "Manufacture light";

    @BeforeAll
    static void openTestomatAndLogin() {
        signInPage.open();
        signInPage.login(email, password);
        projectsPage.signInSuccess();
    }

    @BeforeEach
    void openProjectsPage() {
        projectsPage.open();
        projectsPage.isLoaded();
    }

    @Test
    public void projectCanBeFoundViaSearch() {
        projectsPage.searchForProject(projectName);
        projectsPage.selectProject(projectName);
        projectPage.isLoaded(projectName);
    }

    @Test
    public void projectCardHasTestsCount() {
        projectsPage.searchForProject(projectName);
        SelenideElement project = projectsPage.countOfProjectsShouldBeEqualTo(2).first();
        projectsPage.projectTestsCountShouldBeEqualTo(project, 0);
    }
}
