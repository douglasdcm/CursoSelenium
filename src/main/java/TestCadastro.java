import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestCadastro {
	
	private WebDriver driver;
	private CampoTreinamentoPage page;
	private DSL dsl;
	
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
		driver.quit();
	}
	
	
	@Test
	public void deveInteragirComCadastro() {
		
		page.setNome("Douglas");
		page.setSobrenome("Cardoso");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setEscolaridade("Superior");
		page.setEsporte("Futebol");
		page.setEsporte("Corrida");
		page.cadastrar();
		Assert.assertTrue(page.obterResultadoCadastro().contains("Cadastrado"));
		Assert.assertTrue(page.obterResultadoNome().contains("Douglas"));
		Assert.assertTrue(page.obterResultadoSobrenome().contains("Cardoso"));
		Assert.assertTrue(page.obterResultadoSexo().contains("Masculino"));
		Assert.assertTrue(page.obterResultadoComidaFavorita().contains("Pizza"));
		Assert.assertTrue(page.obterResultadoEscolaridade().contains("superior"));
		Assert.assertTrue(page.obterResultadoEsportes().contains("Futebol Corrida"));
		
	}

}




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
//public class TestCadastro {
//	
//	private WebDriver driver;
//	private DSL dsl;
//	private CampoTreinamentoPage page;
//	
//	@Before
//	public void inicializa() {
//		driver = new FirefoxDriver();
//		driver.manage().window().setSize(new Dimension(1200, 765));
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		dsl = new DSL(driver);
//		page = new CampoTreinamentoPage(driver);
//	}
//	
//	@After
//	public void finaliza() {
//		driver.quit();
//	}
//	
//	
//	@Test
//	public void deveInteragirComCadastro() {
//		
////		WebDriver driver = new FirefoxDriver();
////		driver.manage().window().setSize(new Dimension (1200, 765));
////		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Douglas");
//		//dsl.escreve("elementosForm:nome", "Douglas");
////		Assert.assertEquals("Douglas", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
//		//Assert.assertEquals("Douglas", dsl.obterTexto("elementosForm:nome"));
//		
//		page.setNome("Douglas");
//		page.setSobrenome("Cardoso");
//		page.setSexoMasculino();
//		page
//		
//	
//		
////		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Cardoso");
//		dsl.escreve("elementosForm:sobrenome", "Cardoso");
////		Assert.assertEquals("Cardoso", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
//		Assert.assertEquals("Cardoso", dsl.obterTexto("elementosForm:sobrenome"));
//		
////		driver.findElement(By.id("elementosForm:sexo:0")).click();
//		dsl.clicarRadio("elementosForm:sexo:0");
////		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
//		dsl.estaRadioMarcado("elementosForm:sexo:0");
//		
////		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
//		dsl.clicarRadio("elementosForm:comidaFavorita:0");
////		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
//		dsl.estaRadioMarcado("elementosForm:comidaFavorita:0");
//				
//		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));		
//		Select combo = new Select(element);
//		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
////		combo.selectByVisibleText("Superior");
//		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
//		
//		element = driver.findElement(By.id("elementosForm:esportes"));
//		combo = new Select(element);
////		combo.selectByVisibleText("Futebol");
////		combo.selectByVisibleText("Corrida");
//		dsl.selecionarCombo("elementosForm:esportes", "Futebol");
//		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
//		
//		Assert.assertEquals(2, combo.getAllSelectedOptions().size());
//		
////		driver.findElement(By.id("elementosForm:cadastrar")).click();
//		dsl.clicarBotao("elementosForm:cadastrar");
////		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Cadastrado"));
////		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().contains("Douglas"));
////		Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().contains("Cardoso"));
////		Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().contains("Masculino"));
////		Assert.assertTrue(driver.findElement(By.id("descComida")).getText().contains("Carne"));
////		Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().contains("Superior"));
////		Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().contains("Futebol Corrida"));
//		Assert.assertTrue(dsl.obterTexto("resultado").contains("Cadastrado"));
//		Assert.assertTrue(dsl.obterTexto("descNome").contains("Douglas"));
//		Assert.assertTrue(dsl.obterTexto("descSobrenome").contains("Cardoso"));
//		Assert.assertTrue(dsl.obterTexto("descSexo").contains("Masculino"));
//		Assert.assertTrue(dsl.obterTexto("descComida").contains("Carne"));
//		Assert.assertTrue(dsl.obterTexto("descEscolaridade").contains("Superior"));
//		Assert.assertTrue(dsl.obterTexto("descEsportes").contains("Futebol Corrida"));
//		
//		
////		driver.quit();
//	}
//
//}
