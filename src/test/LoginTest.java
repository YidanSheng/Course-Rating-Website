package test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class LoginTest {
WebDriver driver;
@Before
public void openWikipediaEnglishPage() throws InterruptedException{
System.setProperty("webdriver.chrome.driver","chromedriver");
driver = new ChromeDriver();
driver.get("http://localhost:8080/OOAD-Project/login.jsp");
Assert.assertEquals("Login", driver.getTitle());
}
@Test
public void normalUserLogin() throws InterruptedException{
	WebElement username = driver.findElement(By.id("username"));
	username.sendKeys("xiaohuang");
	Thread.sleep(2000);
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("111111");
	Thread.sleep(2000);
	WebElement login = driver.findElement(By.id("login11"));
	login.click();
	Thread.sleep(2000);
	Assert.assertEquals("Homepage", driver.getTitle());
	Thread.sleep(2000);
	WebElement logout = driver.findElement(By.id("logout11"));
	Thread.sleep(2000);
	logout.click();
	Thread.sleep(2000);
	Assert.assertEquals("Logout", driver.getTitle());
	Thread.sleep(2000);
	WebElement loginAgain = driver.findElement(By.id("loginAgain11"));
	Thread.sleep(2000);
	loginAgain.click();
	Thread.sleep(2000);
	Assert.assertEquals("Login", driver.getTitle());

}
@Test
public void adminUserLogin() throws InterruptedException{
	WebElement username = driver.findElement(By.id("username"));
	username.sendKeys("gaozheng");
	Thread.sleep(2000);
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("111111");
	Thread.sleep(2000);
	WebElement login = driver.findElement(By.id("login11"));
	login.click();
	Thread.sleep(2000);
	Assert.assertEquals("Course Management", driver.getTitle());
	Thread.sleep(2000);
	WebElement logout = driver.findElement(By.id("logout11"));
	Thread.sleep(2000);
	logout.click();
	Thread.sleep(2000);
	Assert.assertEquals("Logout", driver.getTitle());
	Thread.sleep(2000);
	WebElement loginAgain = driver.findElement(By.id("loginAgain11"));
	Thread.sleep(2000);
	loginAgain.click();
	Thread.sleep(2000);
	Assert.assertEquals("Login", driver.getTitle());
}
@Test
public void errorLogin() throws InterruptedException{
	WebElement username = driver.findElement(By.id("username"));
	username.sendKeys("xiaoyinghua");
	Thread.sleep(2000);
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("nihaoya");
	Thread.sleep(2000);
	WebElement login = driver.findElement(By.id("login11"));
	login.click();
	Thread.sleep(2000);
	WebElement loginAlert = driver.findElement(By.id("loginAlert"));
	String message = driver.findElement(By.id("loginAlert")).getText();
	Thread.sleep(2000);
	Assert.assertEquals("Username or password doesn't match our record, please enter again.", message);
}
@After
public void closePage(){
driver.quit();
}
}
