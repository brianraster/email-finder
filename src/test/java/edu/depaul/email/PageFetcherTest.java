package edu.depaul.email;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PageFetcherTest {
  @Test
  @DisplayName("Test PageFetcher Constructor")
  void testConstructor() {
    PageFetcher pf = new PageFetcher();
    assertTrue(pf instanceof PageFetcher);
  }

  @Test
  @DisplayName("Test GetString Method")
  void testGetString() {
    String url = "http://cdm.depaul.edu/";
    PageFetcher pf = new PageFetcher();
    assertNotNull(pf.getString(url));
  }

  @Test
  @DisplayName("Test GetString method on a bad URL")
  void testGetBadString() {
    String bad = "htt:/cdm.depul.ed/";
    PageFetcher pf = new PageFetcher();
    assertThrows(EmailFinderException.class, () -> {pf.getString(bad);});
  }
}
