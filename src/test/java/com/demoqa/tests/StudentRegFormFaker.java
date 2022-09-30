package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.StudentRegFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.demoqa.tests.TestData.*;

import static com.demoqa.tests.TestData.lastName;

public class StudentRegFormFaker extends com.demoqa.tests.TestBase {
    StudentRegFormPage studentRegFormPage = new StudentRegFormPage();


    @Test
    void simpleTest() {
        studentRegFormPage.openPage()
                .setFirstName(firstName)
                .setLasttName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setBirthDate(day,month, year)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture("src/test/resources/3.png")
                .setAdress(address)
                .selectState(state)
                .selectCity(city)
                .submit();

        studentRegFormPage.checkResultsVisible()
                .checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", email)
                .checkResults("Gender", gender)
                .checkResults("Mobile", number)
                .checkResults("Date of Birth", date)
                .checkResults("Subjects", subject)
                .checkResults("Hobbies", hobby)
                .checkResults("Address", address)
                .checkResults("State and City", state + " " + city);

    }
}

