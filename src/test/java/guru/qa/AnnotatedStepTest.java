package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {
    private static final String REPOSITORY = "forkyou55/hw_15_10_allure";


    @Test
    @Owner("IvanishchevStanislav")
    @DisplayName("Check annotated web steps ")
    public void testAnnotatedStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber();
    }


}
