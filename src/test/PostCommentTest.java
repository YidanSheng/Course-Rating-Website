package test;
import java.util.ArrayList;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import dao.CommentDAO;
public class PostCommentTest {
WebDriver driver;

//will upload firework.jpg, dress.jpeg
@Before
public void testCourseClip() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","chromedriver");
	driver = new ChromeDriver();
	driver.get("http://localhost:8080/OOAD-Project/login.jsp");
	Assert.assertEquals("Login", driver.getTitle());
}


@Test
public void testPostEmptyComment() throws InterruptedException{
	WebElement username = driver.findElement(By.id("username"));
	username.sendKeys("xiaohuang");
	Thread.sleep(1000);
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("111111");
	Thread.sleep(1000);
	WebElement login = driver.findElement(By.id("login11"));
	login.click();
	Thread.sleep(1000);
	Assert.assertEquals("Homepage", driver.getTitle());
	WebElement OOADcourse = driver.findElement(By.id("course1"));
	Thread.sleep(1000);
	OOADcourse.click();
	Thread.sleep(1000);
	Assert.assertEquals("Course Detail", driver.getTitle());
	WebElement comment = driver.findElement(By.id("contentText"));
	WebElement submitbutton = driver.findElement(By.id("postcomment"));
	Thread.sleep(1000);
	String commenttest = "";
	comment.sendKeys(commenttest);
	submitbutton.click();
	Thread.sleep(1000);
	Alert alert = driver.switchTo().alert();
	String alertText = alert.getText();
	Thread.sleep(2000);
	Assert.assertEquals("Please enter comment content or attach file!", alertText);
}


@Test
public void testPostComment() throws InterruptedException{
	WebElement username = driver.findElement(By.id("username"));
	username.sendKeys("xiaohuang");
	Thread.sleep(1000);
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("111111");
	Thread.sleep(1000);
	WebElement login = driver.findElement(By.id("login11"));
	login.submit();
	Thread.sleep(1000);
	Assert.assertEquals("Homepage", driver.getTitle());
	WebElement OOADcourse = driver.findElement(By.id("course1"));
	Thread.sleep(1000);
	OOADcourse.click();
	Thread.sleep(1000);
	Assert.assertEquals("Course Detail", driver.getTitle());
	WebElement comment = driver.findElement(By.id("contentText"));
	WebElement submitbutton = driver.findElement(By.id("postcomment"));
	Thread.sleep(1000);
	String commenttest = "This comment only contains text";
	comment.sendKeys(commenttest);
	submitbutton.click();
	Thread.sleep(1000);
	String testResult = CommentDAO.TestPostComment();
	Thread.sleep(1000);
	Assert.assertEquals(commenttest, testResult);
	Thread.sleep(1000);
	Assert.assertEquals("Course Detail", driver.getTitle());
}

@Test
public void testPostFile() throws InterruptedException{
	WebElement username = driver.findElement(By.id("username"));
	username.sendKeys("xiaohuang");
	Thread.sleep(1000);
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("111111");
	Thread.sleep(1000);
	WebElement login = driver.findElement(By.id("login11"));
	login.click();
	Thread.sleep(1000);
	Assert.assertEquals("Homepage", driver.getTitle());
	WebElement OOADcourse = driver.findElement(By.id("course1"));
	Thread.sleep(1000);
	OOADcourse.click();
	Thread.sleep(1000);
	Assert.assertEquals("Course Detail", driver.getTitle());
	WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
	//test file name
	String filetest = "firework.jpg";
	file.sendKeys("/Users/shengyidan/Downloads/" + filetest);
	WebElement submitbutton = driver.findElement(By.id("postcomment"));
	Thread.sleep(1000);
	submitbutton.click();
	Thread.sleep(1000);
	Assert.assertEquals("Course Detail", driver.getTitle());
	ArrayList<String> testResult = CommentDAO.TestPostCommentFile();
	String fileresult = testResult.get(1);
	Thread.sleep(1000);
	Assert.assertEquals(filetest, fileresult);
	Thread.sleep(1000);
	Assert.assertEquals("Course Detail", driver.getTitle());
}

@Test
public void testPostCommentFile() throws InterruptedException{
	WebElement username = driver.findElement(By.id("username"));
	username.sendKeys("xiaohuang");
	Thread.sleep(1000);
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("111111");
	Thread.sleep(1000);
	WebElement login = driver.findElement(By.id("login11"));
	login.click();
	Thread.sleep(1000);
	Assert.assertEquals("Homepage", driver.getTitle());
	WebElement OOADcourse = driver.findElement(By.id("course1"));
	Thread.sleep(1000);
	OOADcourse.click();
	Thread.sleep(1000);
	Assert.assertEquals("Course Detail", driver.getTitle());
	WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
	//test file name
	String filetest = "dress.jpeg";
	file.sendKeys("/Users/shengyidan/Downloads/" + filetest);
	WebElement comment = driver.findElement(By.id("contentText"));
	Thread.sleep(1000);
	//test comment content
	String commenttest = "test comment";
	comment.sendKeys(commenttest);
	WebElement submitbutton = driver.findElement(By.id("postcomment"));
	Thread.sleep(1000);
	submitbutton.click();
	Thread.sleep(1000);
	Assert.assertEquals("Course Detail", driver.getTitle());
	ArrayList<String> testResult = CommentDAO.TestPostCommentFile();
	String commentresult = testResult.get(0);
	String fileresult = testResult.get(1);
	Thread.sleep(1000);
	Assert.assertEquals(commenttest, commentresult);
	Thread.sleep(1000);
	Assert.assertEquals(filetest, fileresult);
	Thread.sleep(1000);
	Assert.assertEquals("Course Detail", driver.getTitle());
	
}

@After
public void closePage(){
	driver.quit();
}
}