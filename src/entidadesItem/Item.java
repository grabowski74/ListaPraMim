package entidadesItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Gabriel Guimaraes de Almeida, Matheus Silva Araujo
 * 
 *         Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim
 *         
 *         Classe que representa um item de supermercado.
 */
public abstract class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributo que representa o nome do Item.
	protected String nome;
	// Atributo que representa uma lista com todos os precos dos varios
	// supermercados que possuem esse tipo de produto.
	private Map<String, Double> precos = new HashMap<String, Double>();
	// Atributo que representa o cógigo do produto.
	protected int id;
	// Atributo que representa a categoria a que o Item esta relacionado.
	protected String categoria;
	// O local onde foi registrado o Item.
	protected String localDeCompra;
	// O preco do Item.
	protected double preco;

	
	private int media;
	
	private int aparicoes;
	
	private int qntAparicoes;


	/**
	 * Construtor da classe.
	 * 
	 * @param nome
	 *            Uma String que representa o nome do Item.
	 * @param categoria
	 *            Uma String que representa a categoria do Item. Pode ser "higiene
	 *            pessoal", "limpeza", "alimento industrializado" e "alimento nao
	 *            industrializado".
	 * @param localDeCompra
	 *            Uma String que representa o local onde o item foi registrado.
	 * @param preco
	 *            Um double que representa o preco do item.
	 * @param id
	 *            Um inteiro que representa o ID do item.
	 */
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

		this.media = 0;

	}

	/**
	 * Método que pega o ID do Item.
	 * 
	 * @return Retorna um inteiro que representa o ID do item.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Método que altera o nome do item.
	 * 
	 * @param novoValor
	 *            Uma String que representa o novo nome do item.
	 */
	public void setNome(String novoValor) {
		this.nome = novoValor;
	}

	/**
	 * Método que adiciona precos ao item, recebendo como parametros o nome do
	 * supermercado e o preco a ser adicionado.
	 * 
	 * @param supermercado
	 *            Uma String que representa o local onde o novo preco do item foi
	 *            registrado.
	 * @param preco
	 *            Um double que representa o novo preco do item.
	 */
	public void adicionaPrecoItem(String supermercado, double preco) {
		this.precos.put(supermercado, preco);
	}

	/**
	 * Método que cria uma representacao textual do item.
	 */
	public String toString() {
		return null;
	}

	/**
	 * Método que mostra a lista de precos associoados ao item com seus respectivos
	 * locais de registro.
	 * 
	 * @return Retorna uma String que representa todos os locais de registro e os
	 *         precos ssocioados ao item.
	 */
	protected String getListaPrecos() {
		StringBuilder listaDePrecos = new StringBuilder("<");
		for (String localDeCompra : precos.keySet()) {
			listaDePrecos.append(String.format("%s, R$ %.2f;", localDeCompra, precos.get(localDeCompra)));
		}
		return listaDePrecos.toString() + ">";
	}

	/**
	 * Método que pega a categoria associada ao item.
	 * 
	 * @return Retorna uma String que representa a categoria do item.
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Método que atualiza um atributo do item. Recebe como parametros o atributo a
	 * ser alterado e o novo valor a ele atribuido.
	 * 
	 * @param atributo
	 *            Uma String que representa o atributo a ser atualizado.
	 * @param novoValor
	 *            Uma String que representa o novo valor do atributo.
	 */
	public void atualizaItem(String atributo, String novoValor) {
		if ("nome".equals(atributo)) {
			this.nome = novoValor;
		}
		if ("categoria".equals(atributo)) {
			this.categoria = novoValor;
		}
	}

	/**
	 * Método que pega o nome do item.
	 * 
	 * @return Retorna uma String que representa o nome do item.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Método que mostra a lista de precos associados ao item.
	 * 
	 * @return Retorna o menor preco de tal lista.
	 */
	public double getPreco() {
		List<Double> listPrecos = new ArrayList<>(precos.values());

		return Collections.min(listPrecos);

	}
	
	/**
	 * 
	 * @param mercado
	 * @return
	 */
	public double pegaPreco(String mercado){
		return precos.get(mercado);
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<String> getPrecoMercado() {
		return precos.keySet();
	}

	/**
	 * 
	 * @param media
	 */
	public void setMedia(int media) {
		this.media = media;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getMedia() {
		return this.media;
	}


	/////////////////////////////////////////////////////// METODOSPRIVADOS///////////////////////////////////////////////////////

	/**
	 * Método que valida as entradas passadas para registro de preco na contrucao de
	 * item.
	 * 
	 * @param preco
	 *            Um double que representa o preco a ser verificado.
	 */
	private void validandoEntradasPreco(double preco) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de item: preco de item invalido.");
		}

	}

	/**
	 * Método que valida as entradas passadas para rgistro de local de compra na
	 * construcao de item.
	 * 
	 * @param localDeCompra
	 *            Uma String que representa o local a ser verificado.
	 */
	private void validandoEntradasLocal(String localDeCompra) {
		if (localDeCompra.equals(null) || localDeCompra.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de item: local de compra nao pode ser vazio ou nulo.");
		}

	}

	/**
	 * Método que valida as entradas passadas para registro de categoria na
	 * construcao de item.
	 * 
	 * @param categoria
	 *            Uma String que representa a categoria a ser verificada.
	 */
	private void validandoEntradasCategoria(String categoria) {
		if (categoria.equals(null) || categoria.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de item: categoria nao pode ser vazia ou nula.");
		} else if (!categoria.equals("limpeza") && !categoria.equals("alimento industrializado")
				&& !categoria.equals("alimento nao industrializado") && !categoria.equals("higiene pessoal")) {
			throw new IllegalArgumentException("Erro no cadastro de item: categoria nao existe.");
		}

	}

	/**
	 * Método que valida as entradas passadas para registro de nome na construcao de
	 * item.
	 * 
	 * @param nome
	 *            String que representa o nome a ser validado.
	 */
	private void validandoEntradasNome(String nome) {
		if (nome.equals(null) || nome.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de item: nome nao pode ser vazio ou nulo.");
		}
	}

	/**
	 * 
	 * @param qnt
	 */
	public void taNaLista(int qnt) {
		this.aparicoes += 1;
		this.qntAparicoes += qnt;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getAparicoes() {
		return this.aparicoes;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getQntAparicoes() {
		return this.qntAparicoes;
	}
	/**
	 * 
	 * @param qnt
	 */
	public void saiuDaLista(int qnt) {
		this.aparicoes -= 1;
		this.qntAparicoes -= qnt;
	}
	


}
