package automation_tasks;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dataprovider {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
 
		testLogin(driver, "standard_user", "secret_sauce");
		testLogin(driver, "invalid_user", "wrong_password");
		testLogin(driver, "", "");
		testLogin(driver, "locked_out_user","secret_sauce");
		
		//---> @DataProviders in TestNg () ,, ---> 

	}



	public static void testLogin(WebDriver driver, String username, String password)  throws InterruptedException {


		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));




		WebElement usernameField = driver.findElement(By.id("user-name"));
		Thread.sleep(2000);
		WebElement passwordField = driver.findElement(By.id("password"));
		Thread.sleep(2000);
		WebElement loginButton = driver.findElement(By.id("login-button"));
		Thread.sleep(2000);


		usernameField.clear();      
		passwordField.clear();
		usernameField.sendKeys(username);
		Thread.sleep(2000);
		passwordField.sendKeys(password);
		Thread.sleep(2000);
		loginButton.click();


	}

}


