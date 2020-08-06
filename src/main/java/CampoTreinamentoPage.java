import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

	private DSL dsl;
	
	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void setNome(String nome) {
		dsl.escreve("elementosForm:nome", nome);
	}
	
	public void setSobrenome(String sobrenome) {
		dsl.escreve("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}
	
	public void setComidaPizza() {
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}
	
	public void setComidaCarne() {
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}
	
	public void setEscolaridade(String valor) {
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}
	
	public void setEsporte(String valor) {
		dsl.selecionarCombo("elementosForm:esportes", valor);
	}
	
	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	public String obterResultadoCadastro() {
		return dsl.obterTexto("resultado");
	}
	
	public String obterResultadoNome() {
		return dsl.obterTexto("descNome");
	}
	
	public String obterResultadoSobrenome() {
		return dsl.obterTexto("descSobrenome");
	}
	
	public String obterResultadoSexo() {
		return dsl.obterTexto("descSexo");
	}
	
	public String obterResultadoComidaFavorita() {
		return dsl.obterTexto("descComida");
	}
	
	public String obterResultadoEscolaridade() {
		return dsl.obterTexto("descEscolaridade");
	}
	
	public String obterResultadoEsportes() {
		return dsl.obterTexto("descEsportes");
	}
	
	public String obterValorNome() {
		return dsl.obterValorCampo("elementosForm:nome");
	}
	
	public void setSugestao(String valor) {
		dsl.escreve("elementosForm:sugestoes", valor);
	}
	
	public String obterValorSugestao() {
		return dsl.obterValorCampo("elementosForm:sugestoes");
	}
	
	public boolean verificarSexoMasculinoMarcado() {
		return dsl.estaRadioMarcado("elementosForm:sexo:0");
	}
	
	public boolean verificarComidaPizzaMarcada() {
		return dsl.estaCheckBoxMarcado("elementosForm:comidaFavorita:2");
	}
	
	public boolean verificarComidaCarneMarcada() {
		return dsl.estaCheckBoxMarcado("elementosForm:comidaFavorita:1");
	}
	
	
}
