package priv.yjk.selenium;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class GitAddrTest {
	public static String baseURL;
	private static WebDriver driver;
	private String uid;
	private String addr;
	
	public GitAddrTest(String uid, String addr) {
		this.uid = uid;
		this.addr = addr;
	}
	
	@Parameters
	public static Collection getData() {
		return Arrays.asList(new Object[][] {
			{"3017218053", "https://gitee.com/chenkuochih/software_test.git"},
			{"3017218054", "https://gitee.com/roshan0/software_test.git"},
			{"3017218055", "https://gitee.com/dai88X/software_test.git"},
			{"3017218056", "https://github.com/Bing-Max/SoftwareTest.git"},
			{"3017218057", "https://github.com/YumengGuo/SoftwareTesting"},
			{"3017218058", "https://github.com/howAreYouHkk/SoftwareTestingTechnology"},
			{"3017218059", "https://github.com/Eternal144/Software-Testing"},
			{"3017218060", "https://gitee.com/HangxueLiu/softwareTest.git"},
			{"3017218061", "https://github.com/qq734628996/software-test"},
			{"3017218062", "https://github.com/cxdzb/software-testing-technology"},
			{"3017218063", "https://github.com/PathfinderTJU/Softwate_test_homework"},
			{"3017218064", "https://github.com/Martin12345677/software_testing_technology"},
			{"3017218065", "https://gitee.com/panliming0418/softwareTestingTechnology.git"},
			{"3017218066", "https://gitee.com/taytaytaytaylor11/SoftwareTesting"},
			{"3017218067", "https://gitee.com/surumeng/test3017218067"},
			{"3017218068", "https://gitee.com/Sunhanyu/SoftwareTestingTechnology.git"},
			{"3017218069", "https://github.com/HaomingSun-1895/Software-Testing-hw.git"},
			{"3017218070", "https://github.com/Taoboan1999/Taoboan1999"},
			{"3017218071", "https://github.com/tianzhaotju/software_testing"},
			{"3017218072", "https://github.com/ZhaomengWang/software_testing"}
		});
	}
	
	@BeforeClass
	public static void init() {
		driver = new ChromeDriver();
		baseURL = "http://103.120.226.190/selenium-demo/git-repo";
		driver.get(baseURL);
	}
	
	@Test
	public void test() {
//		driver.get("http://103.120.226.190/selenium-demo/git-repo");
		driver.findElement(By.name("user_number")).sendKeys(this.uid);
		driver.findElement(By.name("password")).sendKeys(this.addr);
		driver.findElement(By.cssSelector(".btn")).click();
		WebElement resp = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code"));
		
		assertEquals(resp.getText(), this.addr);
	}
	
	@AfterClass
	public static void tearDown() {
	    driver.quit();
	}

}
