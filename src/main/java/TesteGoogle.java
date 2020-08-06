
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class TesteGoogle {
	
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://www.google.com");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {
//		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Douglas\\Google Drive\\Pessoais\\Estudos\\Selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		//WebDriver driver = new ChromeDriver();
//		//WebDriver driver = new InternetExplorerDriver();
//		//String parentWindowHandle = driver.getWindowHandle();
//		//driver.manage().window().setPosition(new Point(100, 100));
//		driver.manage().window().setSize(new Dimension(1200, 765));
//		//driver.manage().window().maximize();
//		driver.get("http://www.google.com");
		//driver.switchTo().window(parentWindowHandle);
		Thread.sleep(3000);
		Assert.assertEquals("Google", driver.getTitle());
//		driver.quit();
	}

}
