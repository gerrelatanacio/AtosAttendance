package atosAttendance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Attendance {
	
	@Test
	public void timeInAttendance() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//Login
		driver.get("https://apex.oracle.com/pls/apex/fdx/r/atos-attendance-tool");
		driver.findElement(By.cssSelector("#P9999_USERNAME")).sendKeys("A792970");
		driver.findElement(By.cssSelector("#P9999_PASSWORD")).sendKeys("ggaAUG21");
		driver.findElement(By.cssSelector("[onclick*='submit']")).click();
		
		//TimeIn
		driver.findElement(By.cssSelector(".t-HeroRegion .t-Button")).click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("[title*='Attendance']")));
		driver.findElement(By.cssSelector(".t-Dialog-footer [onclick*='submit'")).click();
		
		
		//To get out of iFrame
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void timeOutAttendance() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//Login
		driver.get("https://apex.oracle.com/pls/apex/fdx/r/atos-attendance-tool");
		driver.findElement(By.cssSelector("#P9999_USERNAME")).sendKeys("A792970");
		driver.findElement(By.cssSelector("#P9999_PASSWORD")).sendKeys("ggaAUG21");
		driver.findElement(By.cssSelector("[onclick*='submit']")).click();
		
		//TimeOut
		driver.findElement(By.cssSelector(".t-HeroRegion .t-Button")).click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("[title*='Attendance']")));
		Select timeInOutOptions = new Select(driver.findElement(By.cssSelector("#P10_TIME_TYPE")));
		timeInOutOptions.selectByValue("Out");
		
		driver.findElement(By.cssSelector(".t-Dialog-footer [onclick*='submit'")).click();
		
		
		//To get out of iFrame
		driver.switchTo().defaultContent();
	}
	

}
