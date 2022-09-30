package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegFormPage {

    //Elements

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    private SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    emailInput = $("#userEmail"),
    genderInput = $("#genterWrapper");

    private final static String TITLE_TEXT = "Student Registration Form";


    //Actions

    public StudentRegFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public StudentRegFormPage setFirstName(String value) {
        firstNameInput .setValue(value);
        return this;
    }

    public StudentRegFormPage clearFirstName() {
        firstNameInput.clear();
        return this;
    }

    public StudentRegFormPage setLasttName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public StudentRegFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public StudentRegFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public StudentRegFormPage setNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public StudentRegFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public StudentRegFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public StudentRegFormPage setHobbies(String value){
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public StudentRegFormPage uploadPicture(String path) {
        $("#uploadPicture").uploadFile(new File(path));
        return this;
    }

    public StudentRegFormPage setAdress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public StudentRegFormPage selectState(String value) {
        $(byText("Select State")).click();
        $(byText(value)).click();
        return this;
    }

    public StudentRegFormPage selectCity(String value) {
        $(byText("Select City")).click();
        $(byText(value)).click();
        return this;
    }

    public StudentRegFormPage submit(){
        $("#submit").click();
        return this;
    }


    public StudentRegFormPage checkResultsVisible() {
        resultsTableComponent.checkVisible();
        return this;
    }

    public StudentRegFormPage checkResults(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}
