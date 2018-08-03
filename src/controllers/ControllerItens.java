package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparators.PrecoComparator;
import comparators.StringComparator;
import entidades.ListaDeCompras;
import entidadesItem.Item;
import entidadesItem.ItemPorQnt;
import entidadesItem.ItemPorQuilo;
import entidadesItem.ItemPorUnidade;


/**
 * Representacao de um sitema de cadastro de lista de compras, nesse sistema e
 * possivel cadastrar, alterar, editar, adicionar e deletar listas e produtos.
 * ListaPraMim

 * 
 * @author Matheus Silva Araujo - 117210375
 * @author Gabriel Guimaraes Almeida
 * 

 *         Projeto de Laboratorio - Laboratorio de Programacao 2 - 2018.1
 *
 */


public class ControllerItens {
	private Item item;
	private Map<Integer, Item> itens;
	private int id;
	private Comparator<Item> comparador;
	private File diretorio;


	/**
	 * Realiza a construcao do ControllerItens do sistema, toda ControllerItens
	 * instancia um mapa de itens
	 */


	public ControllerItens() {
		itens = new HashMap<Integer, Item>();
		this.id = 1;
	}


	/**
	 * Realiza a operacao de adicionar um item ao sistema por sua quantidade.
	 * 
	 * @param nome
	 *            e o nome do referido item
	 * @param categoria
	 *            e a categoria do referido item
	 * @param qnt
	 *            e a quantidade do referido item
	 * @param unidadeDeMedida
	 *            e a unidade de medida do referido item
	 * @param localDeCompra
	 *            e o local de compra do referido item
	 * @param preco
	 *            e o preco do referido item
	 * @return retorna o numero de identificacao unica do item
	 */

	public int adicionaItemPorQtd(String nome, String categoria, String localDeCompra, double preco, int qnt,
			String unidadeDeMedida) {

		item = new ItemPorQnt(nome, categoria, localDeCompra, preco, id, qnt, unidadeDeMedida);
		validandoEntradaItem(nome);
		this.itens.put(this.id, item);
		return this.id++;
	}


	/**
	 * Realiza a operacao de adicionar um item ao sistema por seu peso.
	 * 
	 * @param nome
	 *            e o nome do referido item
	 * @param categoria
	 *            e a categoria do referido item
	 * @param kg
	 *            e o peso do referido item
	 * @param localDeCompra
	 *            e o local de compra do referido item
	 * @param preco
	 *            e o preco do referido item
	 * @return retorna o numero de identificacao unica do item
	 */


	public int adicionaItemPorQuilo(String nome, String categoria, String localDeCompra, double preco, double kg) {
		item = new ItemPorQuilo(nome, categoria, localDeCompra, preco, id, kg);
		validandoEntradaItem(nome);
		this.itens.put(this.id, item);
		return this.id++;
	}


	/**
	 * Realiza a operacao de adicionar um item ao sistema por sua unidade.
	 * 
	 * @param nome
	 *            e o nome do referido item
	 * @param categoria
	 *            e a categoria do referido item
	 * @param unidade
	 *            e a unidade do referido item
	 * @param localDeCompra
	 *            e o local de compra do referido item
	 * @param preco
	 *            e o preco do referido item
	 * @return retorna o numero de identificacao unica do item
	 */


	public int adicionaItemPorUnidade(String nome, String categoria, String localDeCompra, double preco, int unidade) {
		item = new ItemPorUnidade(nome, categoria, localDeCompra, preco, id, unidade);
		validandoEntradaItem(nome);
		this.itens.put(this.id, item);
		return this.id++;
	}


	/**
	 * Realiza a operacao de atualizar um item a partir do atributo e novo valor
	 * fornecido
	 * 
	 * @param id
	 *            e o numero de identificacao unica do item
	 * @param atributo
	 *            e o atributo a ser modificado
	 * @param novoValor
	 *            e o valor a ser atualizado
	 */


	public void atualizaItem(int id, String atributo, String novoValor) {
		validandoAtributo(atributo);
		validandoNovoValor(atributo, novoValor);

		if (!itens.containsKey(id)) {
			throw new NullPointerException("Erro na atualizacao de item: item nao existe.");
		}

		itens.get(id).atualizaItem(atributo, novoValor);

	}


	/**
	 * Realiza a operacao de adicionar um preco a um determinado item
	 * 
	 * @param id
	 *            e o numero de identificacao unica do item
	 * @param supermercado
	 *            e o supermercado a ser adicionado o item
	 * @param preco
	 *            e o novo preco a ser cadastrado no referido supermercado
	 */


	public void adicionaPrecoItem(int id, String supermercado, double preco) {

		validandoCadastroDePreco(id, supermercado, preco);
		this.itens.get(id).adicionaPrecoItem(supermercado, preco);
	}


	/**
	 * Realiza a operacao de deletar um item a partir do seu id
	 * 
	 * @param id
	 *            e o numero de identificacao unica do referido item

	 */
	public void deletaItem(int id) {
		itens.remove(id);
	}


	/**
	 * Realiza a operacao de exibir o item a partir da sua posicao na lista de itens
	 * 
	 * @param posicao
	 *            e a posicao do referido item

	 * @return retorna o status do item desejado
	 */
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


	/**
	 * Realiza a operacao de exibir o item a partir da sua categoria na lista de
	 * itens
	 * 
	 * @param categoria
	 *            e a categoria do referido item
	 * @param posicao
	 *            e a posicao do referido item

	 * @return retorna o status do item desejado
	 */
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


	/**
	 * Realiza a operacao de exibir o item a partir do seu preco na lista de itens
	 * 
	 * @param posicao
	 *            e a posicao do referido item

	 * @return retorna o status do item desejado
	 */
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


	/**
	 * Realiza a operacao de exibir o item a partir do seu nome
	 * 
	 * @param strPesquisada
	 *            e o nome do item desejado
	 * @param posicao
	 *            e a posicao do referido item

	 * @return retorna o status do item desejado
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		this.comparador = new StringComparator();
		List<Item> listaItens = new ArrayList<>();

		for (int id2 : itens.keySet()) {
			for (String str : itens.get(id2).getNome().split(" ")) {
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


	/**
	 * Realiza a operacao de exibir o item atraves do numero de identificacao unica
	 * fornecido
	 * 
	 * @param id
	 *            e o numero de identificacao unica do referido item
	 * @return retorna o status do item cadastrado
	 */
	


	public String exibeItem(int id2) {
		if (id2 <= 0) {
			throw new IllegalArgumentException("Erro na listagem de item: id invalido.");
		} else if (!itens.containsKey(id2)) {
			throw new NullPointerException("Erro na listagem de item: item nao existe.");
		}
		return itens.get(id2).toString();

	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	public Item getItemPorID(int id) {
		if (!itens.containsKey(id)) {
			throw new NullPointerException(" item nao existe no sistema.");
		}
		return itens.get(id);
	}

	public Collection<Item> getItens() {
		return itens.values();
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
		for (Item item : itens.values()) {
			if (item.getNome().equals(nome)) {
				throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado no sistema.");
			}
		}
	}

	public Map<Integer, Item> getMap() {
		return this.itens;
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void fechaSistema() throws IOException {
		FileOutputStream salvar = null;
		if(diretorio == null) {
			diretorio = new File("arquivos");
			diretorio.mkdir();
		}
		
		try {
			salvar = new FileOutputStream(this.diretorio + File.separator + "saida.txt");
			@SuppressWarnings("resource")
			ObjectOutputStream objeto = new ObjectOutputStream(salvar);
			objeto.writeObject(itens);
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		} finally {
			if (salvar != null) {
				salvar.close();
			}
		}		
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void iniciaSistema() {
		FileInputStream ler = null;
		try {
			ler = new FileInputStream(this.diretorio + File.separator + "saida.txt");
			@SuppressWarnings("resource")
			ObjectInputStream objeto = new ObjectInputStream(ler);
			this.itens = (HashMap<Integer, Item>) objeto.readObject();
		} catch (IOException | ClassNotFoundException e) {
			try {
				throw new IOException("Erro na leitura");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				ler.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
