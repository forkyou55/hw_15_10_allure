package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    @DisplayName("Search Issue by number")
    public void testIssueSearch(){
        SelenideLogger.addListener("allure",new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("forkyou55/hw_15_10_allure");
        $(".header-search-input").submit();

        $(linkText("forkyou55/hw_15_10_allure")).click();
        $("#issues-tab").click();
        $(withText("")).should(Condition.exist);

    }
}
