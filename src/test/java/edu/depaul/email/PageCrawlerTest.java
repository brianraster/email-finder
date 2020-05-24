package edu.depaul.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class PageCrawlerTest {
  @Test
  @DisplayName("Test construction of PageCrawler")
  void testConstructorMaxEmails0(){
    StorageService store = mock(StorageService.class);
    PageCrawler crawl = new PageCrawler(store);
    assertNotNull(crawl);
  }

  @Test
  @DisplayName("Test construction of PageCrawler with max emails")
  void testConstructorMaxEmails50() {
    StorageService store = mock(StorageService.class);
    PageCrawler crawl = new PageCrawler(store,50);
    assertNotNull(crawl);
  }
}
