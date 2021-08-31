package tech.makers.twitter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TweetTest {
    @Test
    void testConstructs() {
        Tweet subject = new Tweet("Hello, world!");
        assertEquals("Hello, world!", subject.getBody());
        assertEquals(null, subject.getId());
    }

    @Test
    void testToString() {
        Tweet subject = new Tweet("Hello, world!");
        assertEquals("Tweet[id=null, body='Hello, world!']", subject.toString());
    }
}
