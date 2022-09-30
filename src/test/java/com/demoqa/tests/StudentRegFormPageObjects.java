package com.demoqa.tests;


import com.codeborne.selenide.Configuration;
import com.demoqa.pages.StudentRegFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegFormPageObjects {
    StudentRegFormPage studentRegFormPage = new StudentRegFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void simpleTest() {
        studentRegFormPage.openPage()
                .setFirstName("Ivan")
                .setLasttName("Ivanov")
                .setEmail("ivani@gmail.com")
                .setGender("Male")
                .setNumber("1234567890")
                .setBirthDate("15", "June", "1980")
                .setSubject("English")
                .setHobbies("Sports")
                .uploadPicture("src/test/resources/3.png")
                .setAdress("Address123")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit();

        studentRegFormPage.checkResultsVisible()
                .checkResults("Student Name", "Ivan Ivanov")
                .checkResults("Student Email", "ivani@gmail.com")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "1234567890")
                .checkResults("Date of Birth", "15 June,1980")
                .checkResults("Subjects", "English")
                .checkResults("Hobbies", "Sports")
                .checkResults("Address", "Address123")
                .checkResults("State and City", "NCR Delhi");




    }
}

