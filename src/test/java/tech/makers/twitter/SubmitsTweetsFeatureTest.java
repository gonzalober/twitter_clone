package tech.makers.twitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.htmlunit.webdriver.MockMvcHtmlUnitDriverBuilder;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
// vvv-- This clears the database before every test. Important to avoid false positives!
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class SubmitsTweetsFeatureTest {
    WebDriver driver;

    @BeforeEach
    void setup(WebApplicationContext context) {
        // This sets up webdriver so we can use it to test our application
        driver = MockMvcHtmlUnitDriverBuilder
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void tweetIndexShouldSubmitAndDisplayTweets() throws Exception {
        // localhost:9990 is the default address of the server in test mode
        driver.get("http://localhost:9990/");
        driver.findElement(By.id("tweet-form-body")).sendKeys("This is a tweet!");
        driver.findElement(By.id("tweet-form-submit")).click();
        assertThat(driver.findElement(By.tagName("body")).getText()).contains("This is a tweet!");
    }
}
