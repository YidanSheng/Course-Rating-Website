
package test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import dao.CourseDAO;
import dao.UserDAO;
import po.Course;
import po.User;
public class ManagementTest {
	WebDriver driver;
	@Before
	public void openWikipediaEnglishPage() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","chromedriver");
	driver = new ChromeDriver();
	driver.get("http://localhost:8080/OOAD-Project/login.jsp");
	Assert.assertEquals("Login", driver.getTitle());
	}
	@Test
	public void loginManagement() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.id("login11"));
		login.click();
		Thread.sleep(2000);
		User user = UserDAO.checkLogin("gaozheng", "111111");
		Assert.assertTrue(null!=user);
	}
	
	@Test
	public void editCourse() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.id("login11"));
		login.click();
		Thread.sleep(2000);
		User user = UserDAO.checkLogin("gaozheng", "111111");
		Assert.assertTrue(null!=user);
		WebElement edit = driver.findElement(By.id("edit2"));
		edit.click();
		Thread.sleep(2000);
		WebElement description = driver.findElement(By.id("courseDescription"));
		description.clear();
		description.sendKeys("check");
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.id("submitEdit"));
		submit.click();
		Course course = CourseDAO.getCourseDetail(Long.parseLong("2"));
		Assert.assertEquals("check", course.getDescription());
	}
	
	
	@Test
	public void addCourse() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.id("login11"));
		login.click();
		Thread.sleep(2000);
		User user = UserDAO.checkLogin("gaozheng", "111111");
		Assert.assertTrue(null!=user);
		Thread.sleep(2000);
		Course course = new Course();
		Assert.assertEquals("Course Management", driver.getTitle());
		WebElement addCourse = driver.findElement(By.id("addCourse"));
		addCourse.click();
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("test");
		course.setName("test");
		WebElement number = driver.findElement(By.id("number"));
		number.sendKeys("1111");
		course.setNumber(1111);
		WebElement description = driver.findElement(By.id("description"));
		description.sendKeys("content.");
		course.setDescription("content.");
		WebElement addSubmit = driver.findElement(By.id("addSubmit"));
		addSubmit.click();
		
		Assert.assertEquals(false, CourseDAO.checkUniqueByName(course.getId(),course.getName()));
	}
	
	@Test
	public void deleteCourse() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.id("login11"));
		login.click();
		Thread.sleep(2000);
		User user = UserDAO.checkLogin("gaozheng", "111111");
		Assert.assertTrue(null!=user);
		Thread.sleep(2000);
		Assert.assertEquals("Course Management", driver.getTitle());
		WebElement delete = driver.findElement(By.id("delete30"));
		delete.click();
		Thread.sleep(2000);
		Assert.assertEquals(null, CourseDAO.getCourseDetail((long) 30));
	}
	
	@After
	public void closePage(){
	driver.quit();
	}
}
