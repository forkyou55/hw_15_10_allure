package guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open main page")
    public void openMainPage(){
        open("https://github.com");

    }
    @Step("Search repository {repo}")
    public void searchForRepository(String repo){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();

    }
    @Step ("Click repositories link {repo}")
    public void clickOnRepository(String repo){
        $(linkText(repo)).click();}


    @Step ("Open tab Issue ")
    public void openIssuesTab(){
        $("#issues-tab").click();

    }

    @Step ("Checking button Issue")
    public void shouldSeeIssueWithNumber(){
        $(withText("")).should(Condition.exist);
    }

}
