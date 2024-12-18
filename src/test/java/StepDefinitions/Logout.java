package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
	
	    private WebDriver driver;

	    @Given("User is on the SauceDemo login page")
	    public void userIsOnLoginPage() {
	        driver = new ChromeDriver();
	        driver.get("https://www.saucedemo.com/");
	    }

	    @When("User logs in with username {string} and password {string}")
	    public void userLogsIn(String username, String password) {
	        
	        WebElement usernameField = driver.findElement(By.id("user-name"));
	        usernameField.sendKeys("standard_user");

	        
	        WebElement passwordField = driver.findElement(By.id("password"));
	        passwordField.sendKeys("secret_sauce");

	   
	        WebElement loginButton = driver.findElement(By.id("login-button"));
	        loginButton.click();
	    }

	    @When("User logs out from SauceDemo")
	    public void userLogsOut() {
	       
	        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
	        menuButton.click();
	        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
	        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
	        logoutLink.click();

	        
	    }

	    @Then("User should be logged out successfully")
	    public void verifyLogout() {
	       
	        String currentUrl = driver.getCurrentUrl();
	        Assert.assertEquals("https://www.saucedemo.com/", currentUrl);

	       
	    }
	}


