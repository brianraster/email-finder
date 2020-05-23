package edu.depaul.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class StorageServiceTest {

  @Test
  @DisplayName("Test that a new StorageService is an instance of StorageService")
  void testSetupStorage() {
    StorageService t = new StorageService();
    assertTrue(t instanceof StorageService);
  }

  // Helper function to make sure a file exists
  public static boolean isFileExists(File file){
    return file.exists() && !file.isDirectory();
  }

  @Test
  @DisplayName("Test storeList for emails")
  void testStoreListEmail() {
    File file = new File("email.txt");
    StorageService t = new StorageService();
    t.addLocation(StorageService.StorageType.EMAIL,"email.txt");
    Collection<String> s = new ArrayList<String>();
    s.add("brianaster85@gmail.com");
    s.add("whatever@email.com");
    s.add("someones@email.com");
    t.storeList(StorageService.StorageType.EMAIL, s);
    isFileExists(file);
  }

  @Test
  @DisplayName("Test storeList for bad links")
  void testStoreListBadLinks() {
    File file = new File("badlinks.txt");
    StorageService t = new StorageService();
    t.addLocation(StorageService.StorageType.BADLINKS,"badlinks.txt");
    Collection<String> s = new ArrayList<String>();
    s.add("badlink.what");
    s.add("horriblelink.who");
    s.add("whatever.how");
    t.storeList(StorageService.StorageType.BADLINKS, s);
    isFileExists(file);
  }

  @Test
  @DisplayName("Test storeList for good links")
  void testStoreListGoodLinks() {
    File file = new File("good-links.txt");
    StorageService t = new StorageService();
    t.addLocation(StorageService.StorageType.GOODLINKS,"good-links.txt");
    Collection<String> s = new ArrayList<String>();
    s.add("www.google.com");
    s.add("www.gmail.com");
    s.add("www.yahoo.com");
    t.storeList(StorageService.StorageType.GOODLINKS, s);
    isFileExists(file);
  }

  @Test
  @DisplayName("Test for if no emails locations are added")
  void testNoEmails() {
    StorageService t = new StorageService();
    Collection<String> blank = new ArrayList<String>();

    assertThrows(EmailFinderException.class, () -> t.storeList(StorageService.StorageType.EMAIL, blank));
  }

  @Test
  @DisplayName("Tests for if no bad link locations are added")
  void testNoBadLinks() {
    StorageService t = new StorageService();
    Collection<String> blank = new ArrayList<String>();

    assertThrows(EmailFinderException.class, () -> t.storeList(StorageService.StorageType.BADLINKS, blank));
  }

  @Test
  @DisplayName("Tests for if no good links locations are added")
  void testNoGoodLinks() {
    StorageService t = new StorageService();
    Collection<String> blank = new ArrayList<String>();

    assertThrows(EmailFinderException.class, () -> t.storeList(StorageService.StorageType.GOODLINKS, blank));
  }

}
