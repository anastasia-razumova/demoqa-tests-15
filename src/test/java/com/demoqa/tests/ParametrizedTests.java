package com.demoqa.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.demoqa.pages.data.Books;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;


public class ParametrizedTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @CsvSource(value = {
            "Гоголь, Мертвые души",
            "Пушкин, Евгений Онегин"
    })

    @ParameterizedTest
    void searchBooks(String searchQuery, String expectedText) {
        open("https://oz.by/");
        $("#top-s").setValue(searchQuery);
        $(".top-panel__search__btn__item").click();
        $$(".mn-layout__col-2__inner").shouldHave(CollectionCondition.texts(expectedText));
    }

    @EnumSource(Books.class)
    @ParameterizedTest
    void checkBooks(Books books) {
        open("https://www.podpisnie.ru/");
        $(".search-input").setValue(books.name());
        $$(".search__btn").shouldHave(CollectionCondition.texts("все результаты"));


    }

    @ValueSource(strings = {"shakespeare","ana"})
    @ParameterizedTest
    void checkAuthors(String testData){
        open("https://www.bookdepository.com/");
        $(".text-input").setValue(testData).pressTab();
        $$(".secondary-header").shouldHave(CollectionCondition.texts("Bestsellers"));

    }
}
