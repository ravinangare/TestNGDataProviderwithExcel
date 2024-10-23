package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Reader.ExcelReader;

public class LoginTest {
	 @DataProvider(name = "LoginDataProvider")
	    public Object[][] loginDataProvider() {
	        return ExcelReader.getLoginData("D:\\TestNGWS\\DataDrivenTesting\\TestData\\login_data.xlsx");
	    }

	    @Test(dataProvider = "LoginDataProvider")
	    public void testLogin(String username, String password) {
	   
	    	WebDriver driver = new ChromeDriver();

	        try {
	           driver.get("https://parabank.parasoft.com/parabank/overview.htm");
	            
	            driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	            driver.findElement(By.xpath("//input[@value='Log In']")).click();

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
