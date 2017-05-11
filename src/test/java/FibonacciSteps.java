import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by kiddynamo on 5/10/17.
 */
public class FibonacciSteps {
    private int index;
    private int result;

    @Given("^I want fibonacci number (\\d+)$")
    public void i_want_the_x_fibonacci_number(int number) throws Throwable {
        index = number;
    }

    @When("^I use the calculator$")
    public void i_use_the_calculator() throws Throwable {
        result = Fibonacci.get(index);
    }

    @Then("^I should get the number (\\d+)$")
    public void i_should_get_the_number(int arg1) throws Throwable {
        assertEquals(arg1, result);
    }

}
