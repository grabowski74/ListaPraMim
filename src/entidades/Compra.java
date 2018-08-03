package entidades;

import entidadesItem.Item;
import entidadesItem.ItemPorQnt;

/**
 * 
 * @author Gabriel Guimaraes de Almeida, Metheus Silva Araujo
 * 
 *         Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim
 *
 *         Classe que representa uma compra adicionada a uma lista de compras
 *         anteriormente criadas.
 */
public class Compra {
	// Atributo que representa a quantidade do item relacionado a compra;
	private int qnt;
	// Atributo que representa o item relacionado a compra;
	private Item item;

	/**
	 * Construtor da classe. Recebe um Integer e um Item como parametros, a
	 * quantidade do item relacionado e o item em si, respectivamente;
	 * 
	 * @param qnt
	 *            A quantidade do item relacionado a compra;
	 * @param item
	 *            O item relacionado a compra.
	 */

	public Compra(int qnt, Item item) {
		this.item = item;
		this.qnt = qnt;
	}

	/**
	 * Método para pegar o ID do item relacionado a compra;
	 * 
	 * @return Retorna um inteiro que representa o ID.
	 */

	public int getId() {
		return this.item.getId();
	}

	/**
	 * Método que atualiza a quantidade do item relacionado a compra;
	 * 
	 * @param operacao
	 *            Uma String que pode ser "adiciona" (acrescenta uma quantidade
	 *            recebida a quantidade atual), ou "diminui" (subtrai uma quantidade
	 *            recebida da quantidade atual). Se, quando decrescida, a quantidade
	 *            atual chegar a zero, a compra eh excluida eda lista de compras em
	 *            que se encontrava;
	 * @param qnt
	 *            A quantidade a ser somada ou subtraida.
	 */


	public void atualiza(String operacao, int qnt) {
		if (operacao.equals("adiciona")) {
			this.qnt += qnt;
		} else {
			this.qnt -= qnt;
		}
	}

	/**
	 * Método que retorna a representacao textual da compra baseada no tipo de item
	 * relacionado a mesma.
	 */
	public String toString() {

		String res = this.qnt + " " + item.getNome() + ", " + item.getCategoria();
		if (item instanceof ItemPorQnt) {
			res += ", " + ((ItemPorQnt) item).getQuantidade() + " " + ((ItemPorQnt) item).getUnidadeDeMedida();

		}
		return res;
	}

	/**
	 * Método que pega a quantidade do item relacionado a ser comprada;
	 * 
	 * @return Um inteiro que representa essa quantidade.
	 */
	public int getQnt() {
		return this.qnt;
	}

	/**
	 * Método que pega a categoria relacionada ao item da compra;
	 * 
	 * @return Uma Strign que representa tal categoria.
	 */
	public String getCategoria() {
		return this.item.getCategoria();
	}

	/**
	 * Método que pega o nome do item da compra;
	 * 
	 * @return Uma String que representa esse nome.
	 */
	public String getNome() {
		return this.item.getNome();
	}

	/**
	 * 
	 * @return
	 */
	public Item getItem() {
		return this.item;
	}

}
