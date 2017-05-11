import com.mashape.unirest.http.Unirest;
import com.me.bookstore.Application;
import com.me.bookstore.BooksResource;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by kiddynamo on 5/10/17.
 */
public class CustomerSteps {
    private Integer result;
    private ConfigurableApplicationContext run;

    private static boolean latch;

    @Before
    public void before() {
        if (!latch) {
            run = SpringApplication.run(Application.class);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> run.close()));
            latch = true;
        }
    }

    @Given("^there are (\\d+) books for sale$")
    public void there_are_books_for_sale(int arg1) throws Throwable {

        BooksResource.setNumberOfBooks(arg1);
    }

    @When("^I request the book catalog$")
    public void i_request_the_book_catalog() throws Throwable {
        result = Integer.parseInt(Unirest.get("http://localhost:8080/books").asObject(String.class).getBody());
    }

    @When("^I add a new book to the catalog$")
    public void i_add_a_new_book_to_the_catalog() throws Throwable {
        BooksResource books = new BooksResource();
        books.addBook();
        result = books.books();
    }


    @Then("^I should see (\\d+) book(?:|s) for sale$")
    public void i_should_see_books(int arg1) throws Throwable {
        assertEquals((Integer) arg1, result);
    }

}
