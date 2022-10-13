package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FileTest {

    ClassLoader cl = FileTest.class.getClassLoader();

    @Test
    void zipTest() throws Exception {
        InputStream is = cl.getResourceAsStream("pdf1.zip");
        ZipInputStream zis = new ZipInputStream(is);
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            String name = entry.getName();
            assertThat(entry.getName()).contains("test");

        }
    }

    @Test
    void csvTest() throws Exception {
        InputStream is = cl.getResourceAsStream("csv.zip");
        ZipInputStream zis = new ZipInputStream(is);
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            String name = entry.getName();
            assertThat(entry.getName()).contains("addresses");

        }
    }

    @Test
    void xlsTest() throws Exception {
        InputStream is = cl.getResourceAsStream("xls.zip");
        ZipInputStream zis = new ZipInputStream(is);
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            String name = entry.getName();
            assertThat(entry.getName()).contains("tests-example");

        }
    }

}