package entidadesItem;

/**
 * 
 * Representa�ao da classe dos itens instanciados de acordo com a sua unidade.
 * 
 * @author Matheus Silva Araujo
 * @author Gabriel Guimaraes de Almeida
 * 
 * 
 *         Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim
 * 
 */
public class ItemPorUnidade extends Item {

	private int unidade;

	/**
	 * Representacao do construtor de itens de acordo com a sua unidade;
	 * 
	 * @param unidade2
	 * @param preco
	 * @param localDeCompra
	 * @param categoria
	 * @param nome
	 * @param categoria2
	 *            e a categoria do referido item;
	 * @param unidade
	 *            e a unidade do referido item.
	 */
	public ItemPorUnidade(String nome, String categoria, String localDeCompra, double preco, int id, int unidade) {
		super(nome, categoria, localDeCompra, preco, id);
		validandoEntradaUnidade(unidade);
		this.unidade = unidade;
	}

	public int getUnidade() {
		return this.unidade;
	}

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

	private void validandoEntradaUnidade(int unidade) {
		if (unidade < 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de item: valor de unidade nao pode ser menor que zero.");
		}
	}

}
