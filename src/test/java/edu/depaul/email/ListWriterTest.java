package edu.depaul.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListWriterTest {
  @Test
  @DisplayName("Tests for a list being written with results")
  void testWriteList() {
    String one = "Uno";
    String two = "Dos";
    String three = "Tres";
    String expected = one + "\n" + two + "\n" + three + "\n";

    Collection<String> coll = new ArrayList<String>();
    coll.add(one);
    coll.add(two);
    coll.add(three);

    OutputStream stream = new ByteArrayOutputStream();
    ListWriter write = new ListWriter(stream);
    try {
      write.writeList(coll);
      assertEquals(expected, stream.toString());
    } catch (Exception e) {
      throw new EmailFinderException("error", e);
    }
  }
}
