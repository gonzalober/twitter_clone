package tech.makers.twitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TweetTest {
    private Clock mockClock;
    @BeforeEach
    void setup(){
        String fixedDate="2021-09-01T00:00:00Z";
        ZoneId zoneId = ZoneId.systemDefault();
        mockClock= Clock.fixed(Instant.parse(fixedDate),zoneId);
    }

    @Test

    void testConstructs() {
        Tweet subject = new Tweet("Hello, world!", mockClock);
        assertEquals("Hello, world!", subject.getBody());
        assertEquals(null, subject.getId());
        assertEquals(LocalDateTime.now(mockClock),subject.getCreatedAt());

    }

    @Test
    void testToString() {
        Tweet subject = new Tweet("Hello, world!",mockClock);
        assertEquals("Tweet[id=null, body='Hello, world!', createdAt="+LocalDateTime.now(mockClock)+"]", subject.toString());
    }
}
