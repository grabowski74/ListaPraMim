package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparators.PrecoComparator;
import comparators.StringComparator;
import entidades.Item;
import entidadesItem.ItemPorQnt;
import entidadesItem.ItemPorQuilo;
import entidadesItem.ItemPorUnidade;

public class ControllerItens {
	private Item item;
	private Map<Integer, Item> itens;
	private int id;
	private Comparator<Item> comparador;

	public ControllerItens() {
		itens = new HashMap<Integer, Item>();
		this.id = 1;
	}

	public int adicionaItemPorQtd(String nome, String categoria, String localDeCompra,
			double preco, int qnt, String unidadeDeMedida) {
		item = new ItemPorQnt(nome, categoria, localDeCompra, preco, id, qnt, unidadeDeMedida);
		validandoEntradaItem(nome);
		this.itens.put(this.id, item);
		return this.id++;
	}

	public int adicionaItemPorQuilo(String nome, String categoria, String localDeCompra, double preco, double kg) {
		item = new ItemPorQuilo(nome, categoria, localDeCompra, preco, id, kg);
		validandoEntradaItem(nome);
		this.itens.put(this.id, item);
		return this.id++;
	}

	public int adicionaItemPorUnidade(String nome, String categoria, String localDeCompra, double preco, int unidade) {
		item = new ItemPorUnidade(nome, categoria, localDeCompra, preco, id, unidade);
		validandoEntradaItem(nome);
		this.itens.put(this.id, item);
		return this.id++;
	}

	public void atualizaItem(int id, String atributo, String novoValor) {
		validandoAtributo(atributo);
		validandoNovoValor(atributo, novoValor);

		if (!itens.containsKey(id)) {
			throw new NullPointerException("Erro na atualizacao de item: item nao existe.");
		}

		itens.get(id).atualizaItem(atributo, novoValor);

	}

	public void adicionaPrecoItem(int id, String supermercado, double preco) {

		validandoCadastroDePreco(id, supermercado, preco);
		this.itens.get(id).adicionaPrecoItem(supermercado, preco);
	}

	public void deletaItem(int id) {
		itens.remove(id);
	}

	public String getItem(int posicao) {
		this.comparador = new StringComparator();
		List<Item> listaItens = new ArrayList<>();

		for (int id : itens.keySet()) {
			listaItens.add(itens.get(id));
		}
		
		String res = "";
		Collections.sort(listaItens, this.comparador);
		for (int i = 0; i < listaItens.size(); i++) {
			if (i == posicao) {
				res += listaItens.get(i).toString();
			}
		}

		return res;
	}

	public String getItemPorCategoria(String categoria, int posicao) {
		if (categoria.equals(null) || "".equals(categoria.trim())) {
			throw new NullPointerException("");
		} else if (!categoria.equals("limpeza") && !categoria.equals("alimento industrializado")
				&& !categoria.equals("alimento nao industrializado") && !categoria.equals("higiene pessoal")) {
			throw new IllegalArgumentException("Erro na listagem de item: categoria nao existe.");
		}
		this.comparador = new StringComparator();
		List<Item> listaItens = new ArrayList<>();

		for (int id2 : itens.keySet()) {
			if (itens.get(id2).getCategoria().equals(categoria)) {
				listaItens.add(itens.get(id2));
			}
		}

		String res = "";
		Collections.sort(listaItens, this.comparador);
		for (int i = 0; i < listaItens.size(); i++) {
			if (i == posicao) {
				res += listaItens.get(posicao).toString();
			}
		}
		return res;
	}

	public String getItemPorMenorPreco(int posicao) {
		this.comparador = new PrecoComparator();
		List<Item> OutraListaItens = new ArrayList<>(itens.values());
		Collections.sort(OutraListaItens, this.comparador);
		String res = "";
		for (int i = 0; i < OutraListaItens.size(); i++) {
			if (i == posicao) {
				res += OutraListaItens.get(i).toString();
			}
		}
		return res;
	}

	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		this.comparador = new StringComparator();
		List<Item> listaItens = new ArrayList<>();

		for (int id2 : itens.keySet()) {
			for (String str: itens.get(id2).getNome().split(" ")) {
				if (str.toLowerCase().startsWith(strPesquisada)) {
				listaItens.add(itens.get(id2));
			}
			}
			
		}

		String res = "";
		Collections.sort(listaItens, this.comparador);
		for (int i = 0; i < listaItens.size(); i++) {
			if (i == posicao) {
				res += listaItens.get(i).toString();
			}
		}
		return res;
	}

	public String exibeItem(int id2) {
		if (id2 <= 0) {
			throw new IllegalArgumentException("Erro na listagem de item: id invalido.");
		} else if (!itens.containsKey(id2)) {
			throw new NullPointerException("Erro na listagem de item: item nao existe.");
		}
		return itens.get(id2).toString();
	}
	
	public Item getItemPorID(int id) {
		if(!itens.containsKey(id)) {
			throw new NullPointerException(" item nao existe no sistema.");
		}
		return itens.get(id);
	}

	/////////////////////////////////////////////////////// METODOSPRIVADOS///////////////////////////////////////////////////////

	private void validandoEntradasNome(String nome) {
		if (nome.equals(null) || nome.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de item: nome nao pode ser vazio ou nulo.");
		}
	}

	private void validandoAtributo(String atributo) {
		if (atributo.equals(null) || atributo.trim().equals("")) {
			throw new NullPointerException("Erro na atualizacao de item: atributo nao pode ser vazio ou nulo.");
		}
		if (!atributo.equals("nome") && !atributo.equals("categoria") && !atributo.equals("kg")
				&& !atributo.equals("unidade de medida") && !atributo.equals("quantidade")
				&& !atributo.equals("unidade")) {
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao existe.");
		}
	}

	private void validandoNovoValor(String atributo, String novoValor) {

		if (novoValor.equals(null) || novoValor.trim().equals("")) {
			throw new NullPointerException(
					"Erro na atualizacao de item: novo valor de atributo nao pode ser vazio ou nulo.");
		}

		if (!atributo.equals("nome") && !atributo.equals("categoria") && !atributo.equals("unidade de medida")) {

			if (atributo.equals("quantidade")) {
				if (Integer.parseInt(novoValor) < 0) {
					throw new IllegalArgumentException(
							"Erro na atualizacao de item: valor de quantidade nao pode ser menor que zero.");
				}
			} else if (atributo.equals("unidade")) {
				if (Integer.parseInt(novoValor) < 0) {
					throw new IllegalArgumentException(
							"Erro na atualizacao de item: valor de unidade nao pode ser menor que zero.");
				}
			} else if (atributo.equals("kg")) {
				if (Double.parseDouble(novoValor) < 0) {
					throw new IllegalArgumentException(
							"Erro na atualizacao de item: valor de quilos nao pode ser menor que zero.");
				}
			}
		}

		if (atributo.equals("nome")) {
			validandoEntradasNome(novoValor);

		} else if (atributo.equals("categoria")) {
			if (novoValor.equals(null) || novoValor.trim().equals("")) {

				throw new NullPointerException("Erro na atualizaçao de item: categoria nao pode ser vazia ou nula.");

			} else if (!novoValor.equals("limpeza") && !novoValor.equals("alimento industrializado")
					&& !novoValor.equals("alimento nao industrializado") && !novoValor.equals("higiene pessoal")) {

				throw new IllegalArgumentException("Erro na atualizacao de item: categoria nao existe.");
			}
		} else if (atributo.equals("unidade de medida")) {
			if (novoValor.equals(null) || novoValor.trim().equals("")) {

				throw new NullPointerException(
						"Erro na atualizaçao de item: unidade de medida nao pode ser vazia ou nula.");
			}
		}
	}

	private void validandoCadastroDePreco(int id, String supermercado, double preco) {
		if (supermercado.equals(null) || "".equals(supermercado.trim())) {
			throw new NullPointerException("Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo.");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de preco: preco de item invalido.");
		}
		if (id < 0) {
			throw new IllegalArgumentException("Erro no cadastro de preco: id de item invalido.");
		}

		if (!itens.containsKey(id)) {
			throw new NullPointerException("Erro no cadastro de preco: item nao existe.");
		}

	}
	
	private void validandoEntradaItem(String nome) {
		for (Item item: itens.values()) {
			if (item.getNome().equals(nome)) {
				throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado no sistema.");
			}
		}
	}
}
