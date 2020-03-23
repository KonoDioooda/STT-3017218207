package priv.yjk.selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleTest {

private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() {
		String uid = "3017218053";
		String addr = "https://gitee.com/chenkuochih/software_test.git";
		driver.get("http://103.120.226.190/selenium-demo/git-repo");
		driver.findElement(By.name("user_number")).sendKeys(uid);
		driver.findElement(By.name("password")).sendKeys(addr);
		driver.findElement(By.cssSelector(".btn")).click();
		WebElement resp = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code"));		
		assertEquals(resp.getText(), addr);
	}

}
