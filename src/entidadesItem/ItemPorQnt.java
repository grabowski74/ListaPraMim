package entidadesItem;

/**
 * 
 * Representa�ao da classe dos itens instanciados de acordo com a sua quantidade.
 * 
 * @author Matheus Silva Araujo
 * @author Gabriel Guimaraes de Almeida
 *  
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim
 * 
 */
public class ItemPorQnt extends Item {
	
	private int qnt;
	private String unidadeDeMedida;
	
	/**
	 * Representacao do construtor de itens de acordo com a sua quantidade;
	 * @param categoria2 e a categoria do referido item;
	 * @param qnt e a quantidade declarada do referido item;
	 * @param unidadeDeMedida e a unidade de medida do referido item.
	 */
	public ItemPorQnt(String nome, String categoria, String localDeCompra, double preco, int id, int qnt, String unidadeDeMedida) {
		super(nome, categoria, localDeCompra, preco, id);
		validandoEntradaQnt(qnt);
		validandoEntradaUnidadeDeMedida(unidadeDeMedida);
		this.qnt = qnt;
		this.unidadeDeMedida = unidadeDeMedida;
	}
	
	public int getQuantidade() {
		return this.qnt;
	}

	
	public String getUnidadeDeMedida() {
		return this.unidadeDeMedida;
	}
	
	public String toString() {
		return super.id + ". " + super.nome + ", " + super.categoria + ", " + this.qnt + " " + this.unidadeDeMedida + ", Preco: " + super.getListaPrecos();
	}
	
	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if (atributo.equals("nome") || atributo.equals("categoria")) {
			super.atualizaItem(atributo, novoValor);
		} else if(atributo.equals("quantidade")) {
			if (Integer.parseInt(novoValor) > 0) {
				this.qnt = Integer.parseInt(novoValor);
			}
		} else if (atributo.equals("unidade de medida")) {
			if (!novoValor.equals(null) || !atributo.trim().equals("")) {
				this.unidadeDeMedida = novoValor;
			}
		}
	}
	
	private void validandoEntradaQnt(int qnt) {
		if (qnt < 0) {
			throw new IllegalArgumentException("Erro no cadastro de item: valor de quantidade nao pode ser menor que zero.");
		}
	}
	
	private void validandoEntradaUnidadeDeMedida(String un) {
		if(un.equals(null) || un.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de item: unidade de medida nao pode ser vazia ou nula.");
		}
		
	}

}
