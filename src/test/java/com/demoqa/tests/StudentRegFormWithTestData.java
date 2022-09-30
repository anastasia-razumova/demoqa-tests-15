package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.demoqa.tests.TestData.*;

public class StudentRegFormWithTestData {

  /*  String firstName;
    String lastName;
    String email;
    String day;
    String month;
    String year;
    String phone;

    @BeforeEach
    void prepareTestData(){
       firstName = "Ivan";
        lastName = "Ivanov";
        email = "ivani@gmail.com";
        day = "15";
        month = "June";
        year = "1980";
        phone = "1234567890";
    }*/


    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void simpleTest() {


        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressTab();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/3.png"));
        $("#currentAddress").setValue("Address123");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName));
        $(".table-responsive").shouldHave(text(lastName));
        $(".table-responsive").shouldHave(text(email));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text(number));
        $(".table-responsive").shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Address123"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));





    }
}

