package edu.depaul.email;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailFinderTest {
  private static final String URL = "C:/Users/brian/GitHub_Repos/email-finder/src/test/resources/test.html";
  private static final String BADLINKS = "badlinks.txt";
  private static final String GOODLINKS = "good-links.txt";
  private static final String EMAIL = "email.txt";

  @Test
  @DisplayName("Tests passing one argument")
  void testRunOneArgument() {
    String[] args = {URL};
    EmailFinder.main(args);
    File file0 = new File(BADLINKS);
    File file1 = new File(GOODLINKS);
    File file2 = new File(EMAIL);

    assertAll(
        () -> assertTrue(file0.exists(), BADLINKS),
        () -> assertTrue(file1.exists(), GOODLINKS),
        () -> assertTrue(file2.exists(), EMAIL)
    );
  }

  @Test
  @DisplayName("Tests passing more than one argument")
  void testRunMultipleArgument() {
    String[] args = {URL, "3"};
    EmailFinder.main(args);
    File file0 = new File(BADLINKS);
    File file1 = new File(GOODLINKS);
    File file2 = new File(EMAIL);

    assertAll(
        () -> assertTrue(file0.exists(), BADLINKS),
        () -> assertTrue(file1.exists(), GOODLINKS),
        () -> assertTrue(file2.exists(), EMAIL)
    );
  }

  @Test
  @DisplayName("Tests passing one argument")
  void testRunNoArguments() {
    String[] args = {};
    EmailFinder.main(args);
    File file0 = new File(BADLINKS);
    File file1 = new File(GOODLINKS);
    File file2 = new File(EMAIL);

    assertAll(
        () -> assertTrue(file0.exists(), BADLINKS),
        () -> assertTrue(file1.exists(), GOODLINKS),
        () -> assertTrue(file2.exists(), EMAIL)
    );
  }
}
