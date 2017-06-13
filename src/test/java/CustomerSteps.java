import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.me.bookstore.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by kiddynamo on 5/10/17.
 */
public class CustomerSteps {
    private Integer result;
    private ConfigurableApplicationContext run;

    private static boolean latch;
    private BooksResource books;
    private Exception exception;

    static {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private String error;

    @Before
    public void before() {
        books = new BooksResource();
        books.clear();

        if (!latch) {
            run = SpringApplication.run(Application.class);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> run.close()));
            latch = true;
        }
    }

    @Given("^there are (\\d+) books for sale$")
    public void there_are_books_for_sale(int arg1) throws Throwable {
        books.setNumberOfBooks(arg1);
    }

    @Given("^there is a unique book in the catalog$")
    public void there_is_a_unique_book_in_the_catalog() throws Throwable {
        books.addBook(new Book("The Catcher in the Rye"));
    }

    @When("^I add a book with the same title$")
    public void i_add_a_book_with_the_same_title() throws Throwable {
        this.error = Unirest.post("http://localhost:8080/books")
                .header("Content-Type", "application/json")
                .body(new Book("The Catcher in the Rye"))
                .asJson().getBody().getObject().getString("exception");
    }

    @When("^I request the book catalog$")
    public void i_request_the_book_catalog() throws Throwable {
        Books body = Unirest.get("http://localhost:8080/books").asObject(Books.class).getBody();
        result = body.size();
    }

    @When("^I add a new book to the catalog$")
    public void i_add_a_new_book_to_the_catalog() throws Throwable {
        books.addBook(new Book("The Catcher in the Rye"));
        result = books.books().size();
    }

    @When("^I remove a book from the catalog$")
    public void i_remove_a_book_from_the_catalog() throws Throwable {
        books.removeBook(books.books().get(0));
        result = books.books().size();
    }

    @Then("^I should see (\\d+) book(?:|s) for sale$")
    public void i_should_see_books(int arg1) throws Throwable {
        assertEquals((Integer) arg1, result);
    }

    @Then("^I should receive an error message$")
    public void i_should_receive_an_error_message() throws Throwable {
        assertEquals(BookNameConflictException.class.getName(), error);
    }

    @Then("^the book should not be created$")
    public void the_book_should_not_be_created() throws Throwable {
        assertEquals(1, books.books().size());
    }

}
