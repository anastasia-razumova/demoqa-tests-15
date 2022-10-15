package com.demoqa.tests.allure;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaSteps {

    private static final String REPOSITORY = "anastasia-razumova/demoqa-tests-15";
    private static final String TAB = "Issues";

    @Test
    public void testLambdaSteps() {

        step("Open github", () ->
                open("https://github.com/")
        );

        step("Search repository " + REPOSITORY, () ->
                $("[name = q]").setValue(REPOSITORY).pressEnter()
        );

        step("Open repository " + REPOSITORY, () ->
                $(linkText(REPOSITORY)).click()
        );

        step("Check existance of tab " + TAB, () ->
                $(partialLinkText(TAB)).shouldHave(text("Issues"))
        );
    }
}
