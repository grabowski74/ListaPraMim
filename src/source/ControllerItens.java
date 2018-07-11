package source;

import java.util.HashMap;
import java.util.Map;

public class ControllerItens {
	private Itens item;
	private Map<Integer, Itens> itens;
	private int id;
	
	public ControllerItens() {
		itens = new HashMap<Integer, Itens>();
		this.id = 1;
	}
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida,
			String localDeCompra, double preco) {
		item = new Itens(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco, id);
		this.itens.put(this.id, item);
		return this.id++;
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		item = new Itens(nome, categoria, kg, localDeCompra, localDeCompra, preco, id);
		this.itens.put(this.id, item);
		return this.id++;
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		item = new Itens(nome, categoria, unidade, localDeCompra, preco, id);
		this.itens.put(this.id, item);
		return this.id++;
	}

	public void atualizaItem(int id, String atributo, String novoValor) {
		if(atributo.equals("nome")) {
			itens.get(id).setNome(novoValor);
		} 
		
	}

	public void adicionaPrecoItem(int id, String supermercado, double preco) {
		this.itens.get(id).adicionaPrecoItem(supermercado, preco);
	}

	public void deletaItem(int id) {
		itens.remove(id);
	}

	public String getItem() {
		String res = "";
	    for (int id : itens.keySet()) {
	    	res += itens.get(id).toString();
	    }
		return res;
	}

	public String getItemPorCategoria(String categoria) {
		String res = "";
		for (int id : itens.keySet()) {
			if(itens.get(id).getCategoria().equals(categoria)) {
				res += itens.get(id).toString();
			}
	    }
		return res;
	}

	public String getItemPorMenorPreco() {

		return null;
	}

	public String getItemPorPesquisa(String strPesquisada) {

		return null;
	}
	public String exibeItem(int id2) {
		return itens.get(id2).toString();
	}

}
