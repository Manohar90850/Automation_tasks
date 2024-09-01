package automation_tasks;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class readingexcelfile {

	static WebDriver driver;
	static WebElement loginbutton;

	public static void main(String[] args) throws IOException, InterruptedException {


		driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)");

		File xlpath = new File("C:\\Users\\HP\\OneDrive\\Desktop\\book1.xlsx");
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream(xlpath);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Login");

		int rowcount = sheet.getLastRowNum();
		// int columcount = sheet.getRow(0).getLastCellNum();

		for(int i=0; i< rowcount; i++) {

			Row row = sheet.getRow(i+1);

			String username = row.getCell(0).getStringCellValue();
			String password = row.getCell(1).getStringCellValue();

			System.out.println(username);
			System.out.println(password);


			WebElement loginname = driver.findElement(By.xpath("//input[@id='username']"));

			loginname.clear();
			loginname.sendKeys(username);
			Thread.sleep(2000);

			WebElement loginpassword = driver.findElement(By.xpath("//input[@id='password']"));

			loginpassword.clear();
			loginpassword.sendKeys(password);


			WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));


			Thread.sleep(4000);

			JavascriptExecutor se = (JavascriptExecutor) driver;
			se.executeScript("arguments[0].scrollIntoView(true);", loginbutton);
			// se.executeScript("window.scrollBy(0,400)");


			loginbutton.click();
			Thread.sleep(2000);

			String messg = driver.findElement(By.xpath("//div[@id='flash']/descendant::b")).getText();

			System.out.println(messg);

		}
	}
}


