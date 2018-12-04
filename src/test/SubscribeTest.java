package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import dao.SubscribeDAO;

public class SubscribeTest{
	WebDriver driver;
	@Before
	public void openWikipediaEnglishPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/OOAD-Project/login.jsp");
		Assert.assertEquals("Login", driver.getTitle());
	}
	@Test
	public void subscribe() throws InterruptedException{
		boolean state = true;
		String temp_state = "";
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("xiaohuang");
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.id("login11"));
		login.click();
		Thread.sleep(3000);
		Assert.assertEquals("Homepage", driver.getTitle());
		WebElement OOADcourse = driver.findElement(By.id("course1"));
		Thread.sleep(500);
		OOADcourse.click();
		Thread.sleep(500);
		Assert.assertEquals("Course Detail", driver.getTitle());
		Thread.sleep(500);
		String state_first = driver.findElement(By.id("stateButton")).getAttribute("value");
		Thread.sleep(500);
		Long userid = Long.parseLong(driver.findElement(By.id("formUserId")).getAttribute("value"));
		Thread.sleep(500);
		Long courseid = Long.parseLong(driver.findElement(By.id("formCourseId")).getAttribute("value"));
		Thread.sleep(500);
		state = SubscribeDAO.recordExists(courseid, userid);
		Thread.sleep(500);
		if(state) {
			temp_state = "Unsubscribe";
		}else {
			temp_state = "Subscribe";
		}
		Thread.sleep(500);
		Assert.assertEquals(temp_state, state_first);
		Thread.sleep(500);
		WebElement sub = driver.findElement(By.id("stateButton"));
		Thread.sleep(500);
		sub.click();
		Thread.sleep(500);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		state = SubscribeDAO.recordExists(courseid, userid);
		Thread.sleep(500);
		if(state) {
			temp_state = "Subscribe Successful!";
		}else {
			temp_state = "Unsubscribe Successful!";
		}
		Thread.sleep(500);
		Assert.assertEquals(temp_state, alertText);
		Thread.sleep(500);
	}
	
	@After
	public void closePage(){
		driver.quit();
	}
}
