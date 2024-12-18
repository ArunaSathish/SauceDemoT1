package StepDefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class Addtocart {
    WebDriver driver;
    WebDriver wait;

    @Given("I am on the Sauce Demo website")
    public void i_am_on_the_sauce_demo_website() {
       
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I log in with valid credentials")
    public void i_log_in_with_valid_credentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("I add {string} to the cart")
    public void i_add_to_the_cart(String itemName) {
        String itemId = "";
        switch (itemName) {
            case "Sauce Labs Backpack":
                itemId = "add-to-cart-sauce-labs-backpack";
                break;
            case "Sauce Labs Bike Light":
                itemId = "add-to-cart-sauce-labs-bike-light";
                break;
            // Add more cases as needed
        }
        driver.findElement(By.id(itemId)).click();
    }

    @Then("the cart should contain {string} item\\(s)")
    public void the_cart_should_contain_items(String itemCount) {
        String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
        assertEquals(itemCount, cartCount);
       
    }
}
	    