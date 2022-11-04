package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    private static final String REPOSITORY = "forkyou55/hw_15_10_allure";

    @Test
    @DisplayName("Search Issue by number")
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> open("https://github.com"));
        step("Search repositories" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Click repositories link" + REPOSITORY, () -> $(linkText(REPOSITORY)).click());
        step("Open tab Issue", () -> $("#issues-tab").click());
        step("Checking button Issue", () -> {
            $(withText("")).should(Condition.exist);
        });


    }
}
