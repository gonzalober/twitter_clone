package tech.makers.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TweetsController {
    // @Autowired is an annotation.
    // It tells Spring 'you need to give us an object like this'.
    // So when we call any of our controller methods,
    // it will magically be there for us to use!
    @Autowired
    private TweetRepository tweetRepository;

    // This is another annotation.
    // It tells Spring what route it should watch out for
    // and call this method when someone loads that route.
    @GetMapping("/")
    public String index(Model model) {
        // Model is the 'view model'. We add attributes on it, which then
        // get passed into the views in `src/main/resources/templates/index.html`.
        model.addAttribute("newTweet", new Tweet());
        model.addAttribute("tweets", tweetRepository.findAll());
        return "index";
        //     ^^^^^^^ This is how Spring knows what template to use.
    }

    // This is like @GetMapping, but for POST requests.
    @PostMapping("/tweets")
    public String create(@ModelAttribute Tweet tweet) {
        //               ^^^^^^^^^^^^^^^^^^^^^^^^^^^
        // This `ModelAttribute` is actually an instance of our entity Tweet.
        // Auto-constructed for us based on the parameters in the POST request.
        // So we just need to save it!
        tweetRepository.save(tweet);
        return "redirect:/";
        // This is a special string that means 'redirect me to:' and then we give
        // it '/' so it redirects to the root.
    }
}
