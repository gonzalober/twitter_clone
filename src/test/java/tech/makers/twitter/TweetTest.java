package tech.makers.twitter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TweetTest {

    @Test

    void testConstructs() {
        Tweet subject = new Tweet("Hello, world!");
        assertEquals("Hello, world!", subject.getBody());
        assertEquals(null, subject.getId());
        assertEquals(null, subject.getCreated_at());
    }

    @Test
    void testToString() {
        Tweet subject = new Tweet("Hello, world!");
        assertEquals("Tweet[id=null, body='Hello, world!', created_at= Wed Sep 01 17:18:40 BST 2021]", subject.toString());
    }
}
