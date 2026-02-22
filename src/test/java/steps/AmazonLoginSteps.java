package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.*;

public class AmazonLoginSteps {
	
	WebDriver driver;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.out.println("Navigating to login page...");
        driver = new ChromeDriver();
		driver.get("https://www.amazon.com/gp/sign-in.html");
        
        driver.manage().window().maximize();
    }

    @When("I enter a valid username and password")
    public void i_enter_a_valid_username_and_password() throws InterruptedException {
        System.out.println("Entering valid credentials...");
        Thread.sleep(3000);        
        driver.findElement(By.id("ap_email_login")).sendKeys("qabatch.tftech@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.id("continue")).click(); 
        Thread.sleep(3000);
	    driver.findElement(By.id("ap_password")).sendKeys("OurAutomation2025");
	 
    }

    @And("I click the login button")
    public void i_click_the_login_button() throws InterruptedException {
        System.out.println("Clicking login button...");
        Thread.sleep(3000); 
        driver.findElement(By.id("signInSubmit")).click(); 
    }

    @Then("I should see a welcome message")
    public void i_should_see_a_welcome_message() {
        System.out.println("Checking welcome message...");
        
        String text = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
        Assertions.assertTrue(
            text.contains("Hello") && !text.contains("sign in"),
            "User is not logged in!"
        );

        System.out.println("Login successful. Greeting text: " + text);
        

        
       
    }
}