// 只能跑一次，第二次要删掉user最后一条数据
package test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class RegisterTest {
	WebDriver driver,driver2;
	
	@Before
	public void openWikipediaEnglishPage() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","chromedriver");
	driver = new ChromeDriver();
	driver.get("http://localhost:8080/OOAD-Project/login.jsp");
	Assert.assertEquals("Login", driver.getTitle());
	WebElement register = driver.findElement(By.id("reg"));
	Thread.sleep(3000);
	register.click();
	Thread.sleep(3000);
	Assert.assertEquals("Registration", driver.getTitle());
	}
	
	
	@Test
	public void emptyUsername() throws InterruptedException{
		WebElement register = driver.findElement(By.id("register"));
		register.click();
		Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals("username cannot be null", alertText);
	}
	@Test
	public void emptyPassword() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng");
		WebElement register = driver.findElement(By.id("register"));  //click submit register form
		register.click();
		Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals("password cannot be null", alertText);
	}
	
	@Test
	public void unMatchPassword() throws InterruptedException{
		String a = "111111";
		String b = "222222";
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(a);
		WebElement passwordRep = driver.findElement(By.id("passwordRep"));
		passwordRep.sendKeys(b);
		WebElement register = driver.findElement(By.id("register"));  //click submit register form
		register.click();
		Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals("Please enter the same password twice", alertText);
	}
	
	@Test
	public void simplePassword() throws InterruptedException{
		String a = "1111";
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(a);
		WebElement register = driver.findElement(By.id("register"));  //click submit register form
		register.click();
		Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals("password length should be at least 6", alertText);
	}
	
	@Test
	public void invalidEmail() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		WebElement passwordRep = driver.findElement(By.id("passwordRep"));
		passwordRep.sendKeys("111111");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("eq");
		WebElement register = driver.findElement(By.id("register"));  //click submit register form
		register.click();
		Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals("email should be UTD email", alertText);
	}
	
	@Test
	public void duplicateUsername() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		WebElement passwordRep = driver.findElement(By.id("passwordRep"));
		passwordRep.sendKeys("111111");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("eq@utdallas.edu");
		WebElement register = driver.findElement(By.id("register"));  //click submit register form
		register.click();
		Thread.sleep(2000);
		String s = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Username already be used", s);
	}
	
	@Test
	public void duplicateEmail() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("dsfsvs");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		WebElement passwordRep = driver.findElement(By.id("passwordRep"));
		passwordRep.sendKeys("111111");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("zzz@utdallas.edu");
		WebElement register = driver.findElement(By.id("register"));  //click submit register form
		register.click();
		Thread.sleep(2000);
		String s = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Email already be used", s);
	}
	
	@Test
	public void success() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng695");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		WebElement passwordRep = driver.findElement(By.id("passwordRep"));
		passwordRep.sendKeys("111111");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("new@utdallas.edu");
		WebElement register = driver.findElement(By.id("register"));  //click submit register form
		register.click();
		Thread.sleep(2000);
		Assert.assertEquals("Login", driver.getTitle());
	}
	
	@After
	public void closePage(){
	driver.quit();
	}
}
