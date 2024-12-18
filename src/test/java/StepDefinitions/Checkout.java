package StepDefinitions;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkout {
		    WebDriver driver;

	    @Given("I am on the Sauce Demo login page")
	    public void i_am_on_the_sauce_demo_login_page() {
	        
	        driver = new ChromeDriver();
	        driver.get("https://www.saucedemo.com/");
	    }

	    @When("I login with valid credentials")
	    public void i_login_with_valid_credentials() {
	        driver.findElement(By.id("user-name")).sendKeys("standard_user");
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");
	        driver.findElement(By.id("login-button")).click();
	    }

	    @Then("I add products to the cart")
	    public void i_add_products_to_the_cart() {
	        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
	    }

	    @Then("I proceed to checkout")
	    public void i_proceed_to_checkout() {
	        driver.findElement(By.id("shopping_cart_container")).click();
	        driver.findElement(By.id("checkout")).click();
	    }

	    @Then("I enter checkout information")
	    public void i_enter_checkout_information() {
	        driver.findElement(By.id("first-name")).sendKeys("Aruna");
	        driver.findElement(By.id("last-name")).sendKeys("Anu");
	        driver.findElement(By.id("postal-code")).sendKeys("12345");
	        driver.findElement(By.id("continue")).click();
	    }

	    @Then("I finish the checkout process")
	    public void i_finish_the_checkout_process() {
	        driver.findElement(By.id("finish")).click();
	    }

	    @Then("I should see the order confirmation")
	    public void i_should_see_the_order_confirmation() {
	        boolean isDisplayed = driver.findElement(By.className("complete-header")).isDisplayed();
	        if (isDisplayed) {
	            System.out.println("Order placed successfully");
	        } else {
	            System.out.println("Order placement failed");
	        }
	        driver.quit();
	    }
	}


