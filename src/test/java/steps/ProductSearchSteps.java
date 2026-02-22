package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class ProductSearchSteps {
	
WebDriver driver = new ChromeDriver();
	
	private final String AMAZON_Login_URL= "https://www.amazon.com/gp/sign-in.html";
	String username = "qabatch.tftech@gmail.com";
	String password = "OurAutomation2025";
	String productName = "Laptop";
	
	@Given("the user is logged in in amazon account")
	public void the_user_is_logged_in() throws InterruptedException {
		driver.get(AMAZON_Login_URL);
		driver.findElement(By.id("ap_email_login")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.id("signInSubmit")).click(); 
		try {
            Thread.sleep(3000); // Wait for the results page to load
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
		
		WebElement userInPage = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		boolean isDisUser = userInPage.isDisplayed();
		
		if (isDisUser = true) {
			System.out.println("Step: The user is logged in successfully!");
		}
		else
			System.out.println("Faled Step: The user is NOT logged in!");
	}
	
	@When("the user searches for the product name in the search bar")
	public void the_user_searches_product() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName);
		try {
            Thread.sleep(3000); // Wait for the typing to execute
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
	}

	@And("the user clicks the search button")
	public void the_user_clicks_search_button() {
		driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("User clicked on search button successfully.");
	}

	@Then("the product should be visible in the search result")
	public void the_product_visible_in_search_result() {
		
		List<WebElement> titles = driver.findElements(By.xpath("//h2//span"));

		boolean found = false;

		for (WebElement title : titles) {
		    String text = title.getText().trim();
		    if (text.toLowerCase().contains(productName.toLowerCase())) {
		        found = true;
		        break;
		    }
		}

		if (found) {
		    System.out.println("Product is successfully visible in the search result.");
		} else {
		    System.out.println("Product is NOT visible in the search result.");
		}

	}

}  


    