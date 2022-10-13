package com.demoqa.tests;


import com.demoqa.model.Students;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;


public class JsonTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonTest() throws Exception {
        File file = new File("src/test/resources/sample.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Students students = objectMapper.readValue(file, Students.class);
        assertThat(students.firstName).isEqualTo("Anna");
        assertThat(students.lastName).isEqualTo("Ivanova");
        assertThat(students.age).isEqualTo(12);
    }

}


