package entidadesItem;

/**
 * 
 * @author Matheus Silva Araujo
 * @author Gabriel Guimaraes de Almeida
 * 
 *         Representacao da classe dos itens instanciados de acordo com a seu
 *         peso.
 * 
 *         Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim
 * 
 */
public class ItemPorQuilo extends Item {
	// Um double que representa o peso do item.
	private double kg;

	/**
	 * Representacao do construtor de Item Por Quilo.
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
	 *            Um inteiro que representa o ID do item.
	 * @param kg
	 *            Um double que representa o peso do item.
	 */
	public ItemPorQuilo(String nome, String categoria, String localDeCompra, double preco, int id, double kg) {
		super(nome, categoria, localDeCompra, preco, id);
		if (kg < 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de item: valor de quilos nao pode ser menor que zero.");
		}
		this.kg = kg;
	}

	/**
	 * Método que pega o peso d item.
	 * 
	 * @return Um double que representa o peso do item.
	 */
	public double getKg() {
		return this.kg;
	}

	/**
	 * Método que cria uma representacao textual de Item Por Quilo.
	 */
	public String toString() {
		return super.id + ". " + super.nome + ", " + super.categoria + ", Preco por quilo: " + super.getListaPrecos();
	}

	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if (atributo.equals("nome") || atributo.equals("categoria")) {
			super.atualizaItem(atributo, novoValor);
		} else if ("kg".equals(atributo)) {
			this.kg = Double.parseDouble(novoValor);
		}
	}

}
