package tech.makers.twitter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// This is a Spring Entity.
// It represents a Model in MVC.
// And each instance, when saved, will refer to a row in the 'tweet' table in the database.
@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String body;

    protected Tweet() {}

    public Tweet(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return String.format("Tweet[id=%d, body='%s']", id, body);
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }
}
