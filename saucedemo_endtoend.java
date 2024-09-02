package automation_tasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class saucedemo_endtoend {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		driver.findElement(By.name("checkout")).click();
		
		driver.findElement(By.name("firstName")).sendKeys("manu");
		driver.findElement(By.name("lastName")).sendKeys("yadav");
		driver.findElement(By.name("postalCode")).sendKeys("505501");
		
		driver.findElement(By.name("continue")).click();
		
		
		String historyview = driver.findElement(By.className("checkout_summary_container")).getText();
		System.out.println(historyview);
		
		Thread.sleep(3000);
		driver.close();
		}

}
