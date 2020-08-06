import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class TesteCampoTreinamento {

	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void finaliza() {
//		driver.quit();
	}
	
	@Test
	public void testetTextField() throws InterruptedException {
		page.setNome("Teste de escrita");
		Assert.assertEquals("Teste de escrita",page.obterValorNome());
	}
	
	@Test
	public void testeTextArea() throws InterruptedException {
		page.setSugestao("teste\nteste");
		Assert.assertEquals("teste\nteste",page.obterValorSugestao());
	}
	
	@Test
	public void deveInteragirComRadioButton() throws InterruptedException {
		page.setSexoMasculino();
		Assert.assertTrue(page.verificarSexoMasculinoMarcado());
	}
	
	@Test
	public void deveInteragirComCheckbox() throws InterruptedException {
		page.setComidaPizza();
		Assert.assertTrue(page.verificarComidaPizzaMarcada());
	}
	
	@Test
	public void deveInteragirComCombo() throws InterruptedException {
		dsl.selecionarCombo("elementosForm:escolaridade", "superior");
		Assert.assertEquals("Superior", dsl.obterValorCombo("elementosForm:escolaridade"));
	}
	
	
	@Test
	public void deveVerificarValoresCombo() throws InterruptedException {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		
		Select combo= new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		boolean encontrou = false;
		for(WebElement option: options ) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		
		Assert.assertTrue(encontrou);
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() throws InterruptedException {
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension(1200, 765));
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		WebElement element = driver.findElement(By.id("elementosForm:esportes"));		
//		Select combo= new Select(element);
//		combo.selectByVisibleText("Natacao");
//		combo.selectByVisibleText("Corrida");
//		combo.selectByVisibleText("O que eh esporte?");
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo= new Select(element);
		List<WebElement> allSellectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSellectedOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		allSellectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSellectedOptions.size());
		//driver.quit();
	}
	
	
	@Test
	public void deveInteragirComBotoes() {
		
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension(1200, 765));
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement botao = driver.findElement(By.id("buttonSimple"));
//		botao.click();
		dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		//driver.quit();
		
	}
	
	@Test
	public void deveInteragirComLinks() {
		
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension (1200, 765));
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
//		WebElement element = driver.findElement(By.linkText("Voltar"));
//		element.click();
		dsl.clicarLink("Voltar");
//		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
		//driver.quit();
		
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension (1200, 765));
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
//		Assert.assertTrue(driver.findElement(By.tagName("body"))
//				.getText().contains("Campo de Treinamento"));
//		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
//		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
		
		//driver.quit();
	}
	
	@Test
	public void testJavascript() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
////		js.executeScript("alert('Testando js via selenium')");
//		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
//		js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
//		
//		WebElement element = driver.findElement(By.id("elementosForm:nome"));
//		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
		
		dsl.executarJS("Testando js via selenium", "");
//		dsl.executarJS(cmd, param)
		
	}
	
}



//import java.util.List;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//
//
//
//public class TesteCampoTreinamento {
//
//	private WebDriver driver;
//	private DSL dsl;
//	
//	@Before
//	public void inicializa() {
//		driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension(1200, 765));
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		dsl = new DSL(driver);
//	}
//	
//	@After
//	public void finaliza() {
//		driver.quit();
//	}
//	
//	@Test
//	public void testetTextField() throws InterruptedException {
////		WebDriver driver = new FirefoxDriver();
////		driver.manage().window().setSize(new Dimension(1200, 765));
////		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		//inicializa();
//		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
//		//dsl.escreve("elementosForm:nome", "Teste de escrita");
//		
//		
//		
//		//Assert.assertEquals("Teste de escrita",driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
//		Assert.assertEquals("Teste de escrita",dsl.obterValorCampo("elementosForm:nome"));
//		//driver.quit();
//	}
//	
//	@Test
//	public void testeTextArea() throws InterruptedException {
////		WebDriver driver = new FirefoxDriver();
////		driver.manage().window().setSize(new Dimension(1200, 765));
////		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		//driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\nteste");
//		dsl.escreve("elementosForm:sugestoes", "teste\nteste");
//		
//		//Assert.assertEquals("teste\nteste",driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
//		Assert.assertEquals("teste\nteste",dsl.obterValorCampo("elementosForm:sugestoes"));
//		//driver.quit();
//	}
//	
//	@Test
//	public void deveInteragirComRadioButton() throws InterruptedException {
////		WebDriver driver = new FirefoxDriver();
////		driver.manage().window().setSize(new Dimension(1200, 765));
////		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
////		driver.findElement(By.id("elementosForm:sexo:0")).click();
//		dsl.clicarRadio("elementosForm:sexo:0");
//		
//		//Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
//		Assert.assertTrue(dsl.estaRadioMarcado("elementosForm:sexo:0"));
//		
//		//driver.quit();
//	}
//	
//	@Test
//	public void deveInteragirComCheckbox() throws InterruptedException {
////		WebDriver driver = new FirefoxDriver();
////		driver.manage().window().setSize(new Dimension(1200, 765));
////		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
//		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
//		//driver.quit();
//	}
//	
//	@Test
//	public void deveInteragirComCombo() throws InterruptedException {
////		WebDriver driver = new FirefoxDriver();
////		driver.manage().window().setSize(new Dimension(1200, 765));
////		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
////		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
////		
////		Select combo = new Select(element);
////		//Thread.sleep(3000);
////		//combo.selectByIndex(2);
////		//combo.selectByValue("superior");
////		combo.selectByVisibleText("Superior");
//		dsl.selecionarCombo("elementosForm:escolaridade", "superior");
//		
////		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
//		Assert.assertEquals("Superior", dsl.obterValorCombo("elementosForm:escolaridade"));
//		//driver.quit();
//	}
//	
//	
//	@Test
//	public void deveVerificarValoresCombo() throws InterruptedException {
////		WebDriver driver = new FirefoxDriver();
////		driver.manage().window().setSize(new Dimension(1200, 765));
////		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
//		
//		Select combo= new Select(element);
//		List<WebElement> options = combo.getOptions();
//		Assert.assertEquals(8, options.size());
//		boolean encontrou = false;
//		for(WebElement option: options ) {
//			if(option.getText().equals("Mestrado")) {
//				encontrou = true;
//				break;
//			}
//		}
//		
//		Assert.assertTrue(encontrou);
//		
//		//driver.quit();
//	}
//	
//	@Test
//	public void deveVerificarValoresComboMultiplo() throws InterruptedException {
////		WebDriver driver = new FirefoxDriver();
////		driver.manage().window().setSize(new Dimension(1200, 765));
////		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
////		WebElement element = driver.findElement(By.id("elementosForm:esportes"));		
////		Select combo= new Select(element);
////		combo.selectByVisibleText("Natacao");
////		combo.selectByVisibleText("Corrida");
////		combo.selectByVisibleText("O que eh esporte?");
//		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
//		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
//		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
//		
//		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
//		Select combo= new Select(element);
//		List<WebElement> allSellectedOptions = combo.getAllSelectedOptions();
//		Assert.assertEquals(3, allSellectedOptions.size());
//		
//		combo.deselectByVisibleText("Corrida");
//		allSellectedOptions = combo.getAllSelectedOptions();
//		Assert.assertEquals(2, allSellectedOptions.size());
//		//driver.quit();
//	}
//	
//	
//	@Test
//	public void deveInteragirComBotoes() {
//		
////		WebDriver driver = new FirefoxDriver();
////		driver.manage().window().setSize(new Dimension(1200, 765));
////		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		
//		WebElement botao = driver.findElement(By.id("buttonSimple"));
////		botao.click();
//		dsl.clicarBotao("buttonSimple");
//		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
//		//driver.quit();
//		
//	}
//	
//	@Test
//	public void deveInteragirComLinks() {
//		
////		WebDriver driver = new FirefoxDriver();
////		driver.manage().window().setSize(new Dimension (1200, 765));
////		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		
////		WebElement element = driver.findElement(By.linkText("Voltar"));
////		element.click();
//		dsl.clicarLink("Voltar");
////		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
//		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
//		//driver.quit();
//		
//	}
//	
//	@Test
//	public void deveBuscarTextosNaPagina() {
//		
////		WebDriver driver = new FirefoxDriver();
////		driver.manage().window().setSize(new Dimension (1200, 765));
////		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		
////		Assert.assertTrue(driver.findElement(By.tagName("body"))
////				.getText().contains("Campo de Treinamento"));
////		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
//		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
////		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
//		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
//		
//		//driver.quit();
//	}
//	
//	
//}
