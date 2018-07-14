package source;
/**
 * 
 * Representaçao da classe dos itens instanciados de acordo com a seu peso.
 * 
 * @author Matheus Silva Araujo
 * @author Gabriel Guimaraes de Almeida
 * 
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim
 * 
 */
public class ItemPorQuilo implements Categoria {
	
	private String categoria;
	private double kg;
	
	/**
	 * Representacao do construtor de itens de acordo com a sua quantidade;
	 * @param categoria2 e a categoria do referido item;
	 * @param kg e o peso do referido item.
	 */
	public ItemPorQuilo(String categoria2, double kg) {
		this.categoria = categoria2;
		this.kg = kg;
	}

	@Override
	public String getCategoria() {
		return this.categoria;
	}

	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if("kg".equals(atributo)) {
			this.kg = Double.parseDouble(novoValor);
		}else if ("categoria".equals(atributo)) {
			this.categoria = novoValor;
		}
		
	}

	@Override
	public int getUnidade() {
		// TODO Auto-generated method stub
		return 0;
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
		return this.kg;
	}

}
