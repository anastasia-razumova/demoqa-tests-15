package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.StudentRegFormPage;
import com.demoqa.utils.RandomMonth;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentRegFormFaker {
    StudentRegFormPage studentRegFormPage = new StudentRegFormPage();

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String number = String.valueOf(faker.phoneNumber().subscriberNumber(10));
    String gender = faker.demographic().sex();
    String hobby = "Sports";
    String subject = "English";
    String address = String.valueOf(faker.address().fullAddress());
    String state = "NCR";
    String city = "Delhi";
    String day = String.valueOf(faker.number().numberBetween(1, 31));
    String month = String.valueOf(RandomMonth.getRandomMonth());
    String year = String.valueOf(faker.number().numberBetween(1950, 2010));
    String date = day + " " + month + "," + year;

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

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

