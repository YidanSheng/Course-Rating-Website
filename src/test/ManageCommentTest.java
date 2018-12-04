package test;
import java.util.ArrayList;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import dao.CommentDAO;
public class ManageCommentTest {
WebDriver driver;
//add comment which comment_id = 1 for delete
//add comment which comment_id = 2,3,4 for edit
//edit3 needs file, edit4 needs file
//will update dog.jpg
@Before
public void testCourseClip() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","chromedriver");
	driver = new ChromeDriver();
	driver.get("http://localhost:8080/OOAD-Project/login.jsp");
	Assert.assertEquals("Login", driver.getTitle());
}


@Test
public void testDeleteComment() throws InterruptedException{
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
	WebElement userId = driver.findElement(By.id("user2"));
	Thread.sleep(3000);
	userId.click();
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
	WebElement deleteId = driver.findElement(By.id("delete1"));
	deleteId.click();
	Thread.sleep(3000);
	String resultcontext = CommentDAO.TestEditComment(1);
	Assert.assertEquals("", resultcontext);
	Thread.sleep(3000);
	String resultfile = CommentDAO.TestEditFile(1);
	Thread.sleep(3000);
	Assert.assertEquals("", resultfile);
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
}

@Test
public void testEditContentAddFile() throws InterruptedException{	
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
	WebElement userId = driver.findElement(By.id("user2"));
	Thread.sleep(3000);
	userId.click();
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
	WebElement editId = driver.findElement(By.id("edit2"));
	editId.click();
	Thread.sleep(3000);
	Assert.assertEquals("Edit Comment", driver.getTitle());
	WebElement editcontent = driver.findElement(By.id("commentcontent"));
	editcontent.clear();
	Thread.sleep(3000);
	String commentcontent = "This is edited comment new";
	editcontent.sendKeys(commentcontent);
	Thread.sleep(3000);
	WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
	String commentfile = "dog.jpg";
	String filepath = "/Users/shengyidan/Downloads/" + commentfile;
	file.sendKeys(filepath);
	Thread.sleep(3000);
	WebElement submitbutton = driver.findElement(By.id("updateForm"));	
	Thread.sleep(3000);
	submitbutton.click();
	Thread.sleep(3000);
	String resultcontext = CommentDAO.TestEditComment(2);
	Assert.assertEquals(commentcontent, resultcontext);
	Thread.sleep(3000);
	String resultfile = CommentDAO.TestEditFile(2);
	Thread.sleep(3000);
	Assert.assertEquals(commentfile, resultfile);
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
}

@Test
public void testEditContentDeleteFile() throws InterruptedException{
	
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
	WebElement userId = driver.findElement(By.id("user2"));
	Thread.sleep(3000);
	userId.click();
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
	WebElement editId = driver.findElement(By.id("edit3"));
	editId.click();
	Thread.sleep(3000);
	Assert.assertEquals("Edit Comment", driver.getTitle());
	WebElement editcontent = driver.findElement(By.id("commentcontent"));
	editcontent.clear();
	Thread.sleep(3000);
	String commentcontent = "This is edited comment!";
	editcontent.sendKeys(commentcontent);	
	Thread.sleep(3000);
	WebElement clear = driver.findElement(By.id("clearComment"));	
	clear.click();
	Thread.sleep(3000);
	WebElement submitbutton = driver.findElement(By.id("updateForm"));
	Thread.sleep(3000);
	submitbutton.click();
	Thread.sleep(3000);
	String resultcontext = CommentDAO.TestEditComment(3);
	Assert.assertEquals(commentcontent, resultcontext);
	Thread.sleep(3000);
	String resultfile = CommentDAO.TestEditFile(3);
	Thread.sleep(3000);
	Assert.assertEquals("", resultfile);
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
}

@Test
public void testDeleteContentDeleteFile() throws InterruptedException{	
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
	WebElement userId = driver.findElement(By.id("user2"));
	Thread.sleep(3000);
	userId.click();
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
	WebElement editId = driver.findElement(By.id("edit4"));
	editId.click();
	Thread.sleep(3000);
	Assert.assertEquals("Edit Comment", driver.getTitle());
	WebElement editcontent = driver.findElement(By.id("commentcontent"));
	editcontent.clear();
	Thread.sleep(3000);
	editcontent.sendKeys("");	
	Thread.sleep(3000);
	WebElement clear = driver.findElement(By.id("clearComment"));	
	clear.click();
	Thread.sleep(3000);
	WebElement submitbutton = driver.findElement(By.id("updateForm"));
	Thread.sleep(3000);
	submitbutton.click();
	Thread.sleep(3000);
	String resultcontext = CommentDAO.TestEditComment(4);
	Assert.assertEquals("", resultcontext);
	Thread.sleep(3000);
	String resultfile = CommentDAO.TestEditFile(4);
	Thread.sleep(3000);
	Assert.assertEquals("", resultfile);
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
}

@After
public void closePage(){
	driver.quit();
}
}