package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;


public class LoginPage {
	


	    WebDriver driver;
	    String baseURL = "https://www.saucedemo.com/";

	    @Given("I navigate to the login page")
	    public void navigate_to_login_page() {
	       
	        driver = new ChromeDriver();
	        driver.get(baseURL);
	    }

	    @When("I enter username {string} and password {string}")
	    public void enter_username_password(String username, String password) {
	        WebElement usernameField = driver.findElement(By.id("user-name"));
	        usernameField.sendKeys(username);
	        
	        WebElement passwordField = driver.findElement(By.id("password"));
	        passwordField.sendKeys(password);
	    }

	    @And("I click the login button")
	    public void click_login_button() {
	        WebElement loginButton = driver.findElement(By.id("login-button"));
	        loginButton.click();
	    }

	    @Then("I should see homepage with title {string}")
	    public void i_should_see_homepage_with_title(String expectedTitle) {
	        try {
	            WebElement homepageTitleElement = driver.findElement(By.className("title"));
	            String actualTitle = homepageTitleElement.getText();
	            Assert.assertEquals("Homepage title does not match", expectedTitle, actualTitle);
	        } catch (Exception e) {
	            captureErrorMessage();
	        }
	    }

	    public void captureErrorMessage() {
	        try {
	            WebElement errorMessageElement = driver.findElement(By.xpath("//h3[@data-test='error']"));
	            String errorMessage = errorMessageElement.getText();
	            System.out.println("Error Message: " + errorMessage);
	            Assert.fail("Login failed with error message: " + errorMessage);
	        } catch (Exception e) {
	            System.out.println("Error message not found.");
	            e.printStackTrace();
	            }
	    }

	        
	    	
	        
	    		


		

	    @After
	    public void close_browser() {
	        
	    }
	}


