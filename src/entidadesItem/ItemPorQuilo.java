package entidadesItem;

import entidades.Item;

/**
 * 
 * Representa�ao da classe dos itens instanciados de acordo com a seu peso.
 * 
 * @author Matheus Silva Araujo
 * @author Gabriel Guimaraes de Almeida
 * 
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim
 * 
 */
public class ItemPorQuilo extends Item{
	
	private double kg;
	
	/**
	 * Representacao do construtor de itens de acordo com a sua quantidade;
	 * @param categoria2 e a categoria do referido item;
	 * @param kg e o peso do referido item.
	 */
	public ItemPorQuilo(String nome, String categoria, String localDeCompra, double preco, int id, double kg) {
		super(nome, categoria, localDeCompra, preco, id);
		if (kg < 0) {
			throw new IllegalArgumentException("Erro no cadastro de item: valor de quilos nao pode ser menor que zero.");
		}
		this.kg = kg;
	}
	
	public double getKg() {
		// TODO Auto-generated method stub
		return this.kg;
	}
	
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
