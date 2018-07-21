package entidadesItem;

/**
 * 
 * @author Matheus Silva Araujo
 * @author Gabriel Guimaraes de Almeida
 * 
 * 
 *         Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim
 * 
 *         Representacao da classe dos itens instanciados de acordo com a sua
 *         unidade.
 */
public class ItemPorUnidade extends Item {
	// A unidade do item.
	private int unidade;

	/**
	 * Representacao do construtor de Item Por Unidade;
	 * 
	 * @param preco
	 *            Um double que representa o preco do item.
	 * @param localDeCompra
	 *            Uma String que representa o local onde o item foi registrado.
	 * @param nome
	 *            Uma String que representa o nome do item.
	 * @param categoria
	 *            Uma String que representa a categoria do referido item;
	 * @param unidade
	 *            Um inteiro que representa a unidade do referido item.
	 */
	public ItemPorUnidade(String nome, String categoria, String localDeCompra, double preco, int id, int unidade) {
		super(nome, categoria, localDeCompra, preco, id);
		validandoEntradaUnidade(unidade);
		this.unidade = unidade;
	}

	/**
	 * Método que pega a unidade do item.
	 * 
	 * @return Retorna um inteiro que representa a unidade do item.
	 */
	public int getUnidade() {
		return this.unidade;
	}

	/**
	 * Método que cria uma representacao textual de Item Por Unidade.
	 */
	public String toString() {
		return super.id + ". " + super.nome + ", " + super.categoria + ", Preco: " + super.getListaPrecos();
	}

	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if (atributo.equals("nome") || atributo.equals("categoria")) {
			super.atualizaItem(atributo, novoValor);
		} else if ("unidade".equals(atributo)) {
			this.unidade = Integer.parseInt(novoValor);
		}
	}

	/**
	 * Método que valida a entrada para registro de unidade na construcao de Item
	 * Por Unidade.
	 * 
	 * @param unidade
	 *            Um inteiro que representa a unidade de item.
	 */
	private void validandoEntradaUnidade(int unidade) {
		if (unidade < 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de item: valor de unidade nao pode ser menor que zero.");
		}
	}

}
