package com.demoqa.tests.allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Open github")
    public WebSteps openMainPage() {
        open("https://github.com/");
        return this;
    }

    @Step("Search repository by name {repository}")
    public WebSteps searchRepository(String repository) {
        $("[name = q]").setValue(repository).pressEnter();
        return this;
    }

    @Step("Open repository {repository}")
    public WebSteps openRepository(String repository) {
        $(linkText(repository)).click();
        return this;
    }

    @Step("Check existance of tab {tab}")
    public WebSteps checkTab (String tab) {
        $(partialLinkText(tab)).shouldHave(text("Issues"));
        return this;
    }
}
