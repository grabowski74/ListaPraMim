package source;
/**
 * 
 * Representaçao da interface categoria que instancia os mais diversos tipos de
 * itens.
 * 
 * @author Matheus Silva Araujo
 * @author Gabriel Guimaraes de Almeida 
 * 
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim
 * 
 */
public interface Categoria {           
	
	String getCategoria();
	
	void atualizaItem(String atributo, String novoValor);
	
	int getUnidade();
	
	int getQuantidade();
	
	String getUnidadeDeMedida();
	
	double getKg();

}
