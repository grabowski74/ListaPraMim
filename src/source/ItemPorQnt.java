package source;
/**
 * 
 * Representaçao da classe dos itens instanciados de acordo com a sua quantidade.
 * 
 * @author Matheus Silva Araujo
 * @author Gabriel Guimaraes de Almeida
 *  
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim
 * 
 */
public class ItemPorQnt implements Categoria {
	
	private String categoria;
	private int qnt;
	private String unidadeDeMedida;
	
	/**
	 * Representacao do construtor de itens de acordo com a sua quantidade;
	 * @param categoria2 e a categoria do referido item;
	 * @param qnt e a quantidade declarada do referido item;
	 * @param unidadeDeMedida e a unidade de medida do referido item.
	 */
	public ItemPorQnt(String categoria2, int qnt, String unidadeDeMedida) {
		this.categoria = categoria2;
		this.qnt = qnt;
		this.unidadeDeMedida = unidadeDeMedida;
	}

	@Override
	public String getCategoria() {
		return this.categoria;
	}
	
	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if("quantidade".equals(atributo)) {
			this.qnt = Integer.parseInt(novoValor);
		} else if("unidade de medida".equals(atributo)) {
			this.unidadeDeMedida = novoValor;
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
		return this.qnt;
	}

	@Override
	public String getUnidadeDeMedida() {
		// TODO Auto-generated method stub
		return this.unidadeDeMedida;
	}

	@Override
	public double getKg() {
		// TODO Auto-generated method stub
		return 0;
	}

}
