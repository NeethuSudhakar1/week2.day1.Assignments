package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();//no need to download the driver
		String driverpath = System.getProperty("webdriver.chrome.driver");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ABCD Company");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Tom");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Jerry");

	  
		WebElement sel1 = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select select = new Select(sel1);
		select.selectByVisibleText("Conference");
		//Thread.sleep(3000);
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Tommy");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Computer");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Description for Tommy");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("tommy@gmail.com");
		
		WebElement sel2 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select select2 = new Select(sel2);
		select2.selectByVisibleText("New York");
					
		driver.findElement(By.name("submitButton")).click();
		String title1 = driver.getTitle();
		System.out.print("The title of the resulting page is "+title1);
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("XYZ Company");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).clear();
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Tomz");
		
		driver.findElement(By.name("submitButton")).click();
		String title2 = driver.getTitle();
		System.out.println("");
		System.out.print("The title of the resulting page after changes "+title2);

	}

}
