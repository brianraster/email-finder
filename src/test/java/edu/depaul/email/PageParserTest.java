package edu.depaul.email;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageParserTest {
  @Test
  @DisplayName("Test PageParser constructor")
  void testPageParserConstructor() {
    PageParser p = new PageParser();
    assertTrue(p instanceof PageParser);
  }

  @Test
  @DisplayName("Test findLinks for no links")
  void testFindLinksNoLinks() {
    String html = "<html><body></body></html>";
    Document doc = Jsoup.parse(html);
    PageParser p = new PageParser();
    Collection<String> links = p.findLinks(doc);
    assertEquals(0,links.size());
  }

  @Test
  @DisplayName("Test findLinks for 1 link")
  void testFindLinks() {
    String html = "<html><a href='/some/other/file.html'>my link</a></body></html>";
    Document doc = Jsoup.parse(html);
    PageParser p = new PageParser();
    p.findLinks(doc);
    assertEquals(null,doc.getElementById("my link"));
  }

  @Test
  @DisplayName("Tests finding one email in a document.")
  void testFindOneEmail() {
    String email = "my@email.com";
    String html = "<html><body>" + email + "</body></html>";
    Document doc = Jsoup.parse(html);
    PageParser p = new PageParser();
    Collection<String> emails = p.findEmails(doc);
    assertEquals(1, emails.size());
  }
}
