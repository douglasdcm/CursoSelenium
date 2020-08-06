import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestFrame {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void deveInterarigirComFraneEscondido() {
		WebElement frame = driver.findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Frame OK!", alert.getText());
	}
	
	@Test
	public void deveInteragirComFrame() {
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension (1200, 765));
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Frame OK!", alert.getText());
		String texto = alert.getText();
		alert.accept();
		
		driver.switchTo().defaultContent(); //comes back to browser
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		Assert.assertEquals("Frame OK!", driver.findElement(By.id("elementosForm:nome"))
				.getAttribute("value"));
//		driver.quit();
	}

	@Test
	public void deveInteragirComPopup() {
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension (1200, 765));
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("teste");
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste2");
		
//		driver.quit();
		
	}
	
	@Test
	public void deveInteragirComPopupDoMal() {
		
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension(1200, 765));
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("buttonPopUpHard")).click();
		
		String mainWin = driver.getWindowHandle();
		//System.out.println(driver.getWindowHandle());
		//System.out.println(driver.getWindowHandles());
		
		/*
		driver.switchTo().window("8589934600");
		driver.findElement(By.tagName("textarea")).sendKeys("teste");
		driver.close();
		
		driver.switchTo().window("8589934593");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste2");
		*/
		
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		driver.findElement(By.tagName("textarea")).sendKeys("teste");
		driver.close();
		
		driver.switchTo().window(mainWin);
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste2");
		
//		driver.quit();
		
		
	}
	
}
