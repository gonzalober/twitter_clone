package tech.makers.twitter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Date;

// This is a Spring Entity.
// It represents a Model in MVC.
// And each instance, when saved, will refer to a row in the 'tweet' table in the database.
@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String body;
    private LocalDateTime created_at;

    protected Tweet(String body) {}

    public Tweet(String body, Clock clock) {
        this.body = body;
        this.created_at = LocalDateTime.now(clock);
    }

    @Override
    public String toString() {
        return String.format("Tweet[id=%d, body='%s', created_at=%s]", id, body, created_at);
    }

    public Long getId() {
        return this.id;
    }

    public String getBody() {
        return this.body;
    }

    public LocalDateTime getCreated_at() { return created_at; }
}
