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
 *         quantidade.
 */
public class ItemPorQnt extends Item {
	// Atributo que representa a quantidade do item.
	private int qnt;
	// Atributo que representa a unidade de medida da quantidade.
	private String unidadeDeMedida;

	/**
	 * Construtor da Item Por Quantidade.
	 * 
	 * @param nome
	 *            Uma String que representa o nome do item.
	 * @param categoria
	 *            Uma String que representa a categoria do item.
	 * @param localDeCompra
	 *            Uma String que representa o local onde o item foi registrado.
	 * @param preco
	 *            Um double que representa o preco do item.
	 * @param id
	 *            Um inteiro que representa o ID do Item Por Quantidade.
	 * @param qnt
	 *            Um inteiro que representa a quantidade do item.
	 * @param unidadeDeMedida
	 *            Uma String que representa a unidade de medida da quantidade do
	 *            item.
	 */
	public ItemPorQnt(String nome, String categoria, String localDeCompra, double preco, int id, int qnt,
			String unidadeDeMedida) {
		super(nome, categoria, localDeCompra, preco, id);
		validandoEntradaQnt(qnt);
		validandoEntradaUnidadeDeMedida(unidadeDeMedida);
		this.qnt = qnt;
		this.unidadeDeMedida = unidadeDeMedida;
	}

	/**
	 * Método que pega a quantidade do item.
	 * 
	 * @return Retorna um inteiro que representa a quantidade do item.
	 */
	public int getQuantidade() {
		return this.qnt;
	}

	/**
	 * Método que pega a unidade de medida da quantidade do item.
	 * 
	 * @return Retorna uma String que representa a unidade de medida da quantidade
	 *         do item.
	 */
	public String getUnidadeDeMedida() {
		return this.unidadeDeMedida;
	}

	/**
	 * Método que cria uma representacao textual do Item Por Quantidade.
	 */
	public String toString() {
		return super.id + ". " + super.nome + ", " + super.categoria + ", " + this.qnt + " " + this.unidadeDeMedida
				+ ", Preco: " + super.getListaPrecos();
	}

	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if (atributo.equals("nome") || atributo.equals("categoria")) {
			super.atualizaItem(atributo, novoValor);
		} else if (atributo.equals("quantidade")) {
			if (Integer.parseInt(novoValor) > 0) {
				this.qnt = Integer.parseInt(novoValor);
			}
		} else if (atributo.equals("unidade de medida")) {
			if (!novoValor.equals(null) || !atributo.trim().equals("")) {
				this.unidadeDeMedida = novoValor;
			}
		}
	}

	/**
	 * Método que valida as entradas passadas para registro de nome na construcao de
	 * item por quantidade.
	 * 
	 * @param qnt
	 *            Um inteiro que representa a quantidade a ser validada.
	 */
	private void validandoEntradaQnt(int qnt) {
		if (qnt < 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de item: valor de quantidade nao pode ser menor que zero.");
		}
	}

	/**
	 * Método que valida as entradas passadas como registro de unidade de medida na
	 * construcao de item por quantidade.
	 * 
	 * @param un
	 *            Uma String que representa para registro de unidade de medida na
	 *            construcao de item por quantidade.
	 */
	private void validandoEntradaUnidadeDeMedida(String un) {
		if (un.equals(null) || un.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de item: unidade de medida nao pode ser vazia ou nula.");
		}

	}

}
