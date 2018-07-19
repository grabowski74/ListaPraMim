package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe que representa um item de supermercado.
 * 
 * @author Gabriel Guimaraes de Almeida
 *
 */

public abstract class Item {

	protected String nome;
	// Atributo que representa uma lista com todos os precos dos varios
	// supermercados que possuem esse tipo de produto.
	private Map<String, Double> precos = new HashMap<String, Double>();
	// Atributo que representa o cógigo do produto.
	protected int id;
	protected String categoria;
	protected String localDeCompra;
	protected double preco;

	public Item(String nome, String categoria, String localDeCompra, double preco, int id) {
		validandoEntradasNome(nome);
		validandoEntradasCategoria(categoria);
		validandoEntradasLocal(localDeCompra);
		validandoEntradasPreco(preco);
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.localDeCompra = localDeCompra;
		this.preco = preco;
		adicionaPrecoItem(localDeCompra, preco);
	}

	public int getId() {
		return this.id;
	}

	public void setNome(String novoValor) {
		this.nome = novoValor;
	}

	public void adicionaPrecoItem(String supermercado, double preco) {
		this.precos.put(supermercado, preco);
	}

	public String toString() {
		return null;
	}

	protected String getListaPrecos() {
		StringBuilder listaDePrecos = new StringBuilder("<");
		for (String localDeCompra : precos.keySet()) {
			listaDePrecos.append(String.format("%s, R$ %.2f;", localDeCompra, precos.get(localDeCompra)));
		}
		return listaDePrecos.toString() + ">";
	}

	public String getCategoria() {
		return categoria;
	}

	public void atualizaItem(String atributo, String novoValor) {
		if ("nome".equals(atributo)) {
			this.nome = novoValor;
		}
		if ("categoria".equals(atributo)) {
			this.categoria = novoValor;
		}
	}

	public String getNome() {
		return this.nome;
	}

	public double getPreco() {
		List<Double> listPrecos = new ArrayList<>(precos.values());

		return Collections.min(listPrecos);

	}



	/////////////////////////////////////////////////////// METODOSPRIVADOS///////////////////////////////////////////////////////

	private void validandoEntradasPreco(double preco) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de item: preco de item invalido.");
		}

	}

	private void validandoEntradasLocal(String localDeCompra) {
		if (localDeCompra.equals(null) || localDeCompra.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de item: local de compra nao pode ser vazio ou nulo.");
		}

	}

	private void validandoEntradasCategoria(String categoria) {
		if (categoria.equals(null) || categoria.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de item: categoria nao pode ser vazia ou nula.");
		} else if (!categoria.equals("limpeza") && !categoria.equals("alimento industrializado")
				&& !categoria.equals("alimento nao industrializado") && !categoria.equals("higiene pessoal")) {
			throw new IllegalArgumentException("Erro no cadastro de item: categoria nao existe.");
		}

	}

	private void validandoEntradasNome(String nome) {
		if (nome.equals(null) || nome.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de item: nome nao pode ser vazio ou nulo.");
		}
	}


}
