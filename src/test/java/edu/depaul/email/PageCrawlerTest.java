package edu.depaul.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

  @Test
  @DisplayName("Tests getBadLinks")
  void testGetBadLinks() {
    StorageService store = mock(StorageService.class);
    PageCrawler crawl = new PageCrawler(store);
    String url = "http://somewhere.com";
    crawl.crawl(url);
    crawl.report();
    Collection<String> expected = new HashSet<String>();
    expected.add(url);
    Collection<String> actual = crawl.getBadLinks();
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Tests getGoodLinks")
  void testGetGoodLinks() {
    StorageService store = mock(StorageService.class);
    PageCrawler crawl = new PageCrawler(store);
    String url = System.getProperty("user.dir") + "\\src\\test\\resources\\test1.html";
    crawl.crawl(url);
    crawl.report();
    Collection<String> expected = new HashSet<String>();
    expected.add(url);
    Collection<String> actual = crawl.getGoodLinks();
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Tests email detection via getBadLinks().")
  void testGetEmails() {
    StorageService storage = mock(StorageService.class);
    PageCrawler crawl = new PageCrawler(storage);
    String url = System.getProperty("user.dir") + "\\src\\test\\resources\\test_c.html";
    crawl.crawl(url);
    crawl.report();
    String email0 = "this@gmail.com";
    String email1 = "that@gmail.com";
    String email2 = "theOtherThing@gmail.com";
    Collection<String> expected = new HashSet<String>();
    expected.add(email2);
    expected.add(email1);
    expected.add(email0);
    Collection<String> actual = crawl.getEmails();
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Tests email detection handling when exceeding maximum email count.")
  void testMaximumEmails() {
    int maxEmails = 1;
    StorageService storage = mock(StorageService.class);
    PageCrawler crawl = new PageCrawler(storage, maxEmails);
    String url = System.getProperty("user.dir") + "\\src\\test\\resources\\test_d.html";
    crawl.crawl(url);
    crawl.report();
    Collection<String> content = crawl.getEmails();
    assertEquals(maxEmails, content.size());
  }

  @Test
  @Timeout(10)
  @DisplayName("Tests for if an infinite loop will happen")
  void testInfiniteLoop() {
    StorageService storage = mock(StorageService.class);
    PageCrawler crawler = new PageCrawler(storage);
    String url = System.getProperty("user.dir") + "\\src\\test\\resources\\test_a.html";
    crawler.crawl(url);
  }
}
