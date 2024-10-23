package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Reader.ExcelReader;

public class UserRegisterTest {
	 @DataProvider(name = "RegisterDataProvider")
	    public Object[][] RegisterDataProvider() {
	        return ExcelReader.getRegisterData("D:\\TestNGWS\\DataDrivenTesting\\TestData\\login_data.xlsx");
	    }

	    @Test(dataProvider = "RegisterDataProvider")
	    public void RegisterUser(String firstname, String lastname, String address, String city) {
	   
	    	WebDriver driver = new ChromeDriver();

	        try {
	           driver.get("https://parabank.parasoft.com/parabank/register.htm");
	            
	            driver.findElement(By.id("customer.firstName")).sendKeys(firstname);
	            driver.findElement(By.id("customer.lastName")).sendKeys(lastname);
	            driver.findElement(By.id("customer.address.street")).sendKeys(address);
	            driver.findElement(By.id("customer.address.city")).sendKeys(city);
//	            driver.findElement(By.xpath("//input[@value='Log In']")).click();

	            // Validate login outcome
//	            if (username.startsWith("validUser")) {
//	                // Check for successful login
//	                String welcomeText = driver.findElement(By.xpath("//h1[contains(text(), 'Welcome')]")).getText();
//	                Assert.assertTrue(welcomeText.contains("Welcome"), "Login failed for valid user: " + username);
//	            } else {
//	                // Check for unsuccessful login
//	                String errorMessage = driver.findElement(By.className("error")).getText();
//	                Assert.assertTrue(errorMessage.contains("The username and password could not be verified."), 
//	                    "Login should have failed for user: " + username);
//	            }

	        } finally {
	            driver.quit();
	        }
	    }
}
