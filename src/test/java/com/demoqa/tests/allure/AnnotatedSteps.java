package com.demoqa.tests.allure;

import org.junit.jupiter.api.Test;

public class AnnotatedSteps {

    private static final String REPOSITORY = "anastasia-razumova/demoqa-tests-15";
    private static final String TAB = "Issues";

    @Test
    public void testAnnotatedSteps() {
        WebSteps steps = new WebSteps();
        steps.openMainPage().searchRepository(REPOSITORY)
                .openRepository(REPOSITORY)
                .checkTab(TAB);
    }
}
