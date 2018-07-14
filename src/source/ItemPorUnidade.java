package source;
/**
 * 
 * Representaçao da classe dos itens instanciados de acordo com a sua unidade.
 * 
 * @author Matheus Silva Araujo
 * @author Gabriel Guimaraes de Almeida
 * 
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim
 * 
 */
public class ItemPorUnidade implements Categoria {
	
	private String categoria;
	private int unidade;
	
	/**
	 * Representacao do construtor de itens de acordo com a sua unidade;
	 * @param categoria2 e a categoria do referido item;
	 * @param unidade e a unidade do referido item.
	 */
	public ItemPorUnidade(String categoria2, int unidade) {
		this.categoria = categoria2;
		this.unidade = unidade;
	}
	
	public int getUnidade() {
		return this.unidade;
	}

	@Override
	public String getCategoria() {
		return this.categoria;
	}

	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if("unidade".equals(atributo)) {
			this.unidade = Integer.parseInt(novoValor);
		} else if ("categoria".equals(atributo)) {
			this.categoria = novoValor;
		}
		
	}

	@Override
	public int getQuantidade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUnidadeDeMedida() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getKg() {
		// TODO Auto-generated method stub
		return 0;
	}

}
