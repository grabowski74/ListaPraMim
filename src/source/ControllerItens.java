package source;

import java.util.HashMap;
import java.util.Map;

public class ControllerItens {
	private Itens item;
	private Map<String, Itens> itens;
	
	public ControllerItens() {
		itens = new HashMap<String, Itens>();
	}
	public String adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida,
			String localDeCompra, double preco) {
		int id = itens.size() + 1;
		item = new Itens(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco, id);
		this.itens.put(item.getId(), item);
		return item.getId();
	}

	public String adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		int id = itens.size() + 1;
		item = new Itens(nome, categoria, kg, localDeCompra, localDeCompra, preco, id);
		this.itens.put(item.getId(), item);
		return item.getId();
	}

	public String adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		int id = itens.size() + 1;
		item = new Itens(nome, categoria, unidade, localDeCompra, preco, id);
		this.itens.put(item.getId(), item);
		return item.getId();
	}

	public void atualizaItem(String id, String atributo, String novoValor) {
		
	}

	public void adicionaPrecoItem(String id, String supermercado, double preco) {
		// TODO Auto-generated method stub
		
	}

	public void deletaItem(String id) {
		// TODO Auto-generated method stub
		
	}

	public String getItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemPorCategoria(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemPorMenorPreco() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemPorPesquisa(String strPesquisada) {
		// TODO Auto-generated method stub
		return null;
	}

}
