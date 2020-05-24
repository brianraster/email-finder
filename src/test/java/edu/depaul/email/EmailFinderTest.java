package edu.depaul.email;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmailFinderTest {

  @Test
  @DisplayName("Tests output file creation")
  void testOutFile() {
    EmailFinder emailFinder = new EmailFinder();
    String[] args = {"C:/Users/brian/GitHub_Repos/email-finder/src/test/resources/test.html"};
    emailFinder.run(args);
  }
}
