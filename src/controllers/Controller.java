package controllers;


import java.io.IOException;


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
public class Controller {

	private ControllerItens controllerItens;
	private ControllerListas controllerListas;
	private boolean flag = false;

	/**
	 * Realiza a construcao do Controller Master do sistema, toda Controller Master
	 * instacia um ControllerItens e um ControllerListas.
	 */
	public Controller() {
		controllerItens = new ControllerItens();
		controllerListas = new ControllerListas();
	}

	/////////////////////////////////////////////////////// CONTROLLERITENS///////////////////////////////////////////////////////

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
	public int adiconaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		return controllerItens.adicionaItemPorQtd(nome, categoria, localDeCompra, preco, qnt, unidadeDeMedida);
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
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {

		return controllerItens.adicionaItemPorQuilo(nome, categoria, localDeCompra, preco, kg);
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
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {

		return controllerItens.adicionaItemPorUnidade(nome, categoria, localDeCompra, preco, unidade);
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
		controllerItens.atualizaItem(id, atributo, novoValor);
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
		controllerItens.adicionaPrecoItem(id, supermercado, preco);
	}

	/**
	 * Realiza a operacao de deletar um item a partir do seu id
	 * 
	 * @param id
	 *            e o numero de identificacao unica do referido item
	 */
	public void deletaItem(int id) {
		controllerItens.deletaItem(id);
	}

	/**
	 * Realiza a operacao de exibir o item atraves do numero de identificacao unica
	 * fornecido
	 * 
	 * @param id
	 *            e o numero de identificacao unica do referido item
	 * @return retorna o status do item cadastrado
	 */
	public String exibeItem(int id) {
		return controllerItens.exibeItem(id);
	}

	/**
	 * Realiza a operacao de exibir o item a partir da sua posicao na lista de itens
	 * 
	 * @param posicao
	 *            e a posicao do referido item
	 * @return retorna o status do item desejado
	 */
	public String getItem(int posicao) {
		return controllerItens.getItem(posicao);
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
		return controllerItens.getItemPorCategoria(categoria, posicao);
	}

	/**
	 * Realiza a operacao de exibir o item a partir do seu preco na lista de itens
	 * 
	 * @param posicao
	 *            e a posicao do referido item
	 * @return retorna o status do item desejado
	 */
	public String getItemPorMenorPreco(int posicao) {
		return controllerItens.getItemPorMenorPreco(posicao);
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
		return controllerItens.getItemPorPesquisa(strPesquisada, posicao);
	}

	/**
	 * Realiza a operacao de adicionar uma lista de itens ao sistema
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * @return retorna a descricao da lista cadastrada
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		return controllerListas.adicionaListaDeCompras(descritorLista);
	}

	/**
	 * Realiza a operacao de pesquisar listas cadastradas no sistema a partir do seu
	 * nome
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * @return retorna o status da lista desejada
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		return controllerListas.pesquisaListaDeCompras(descritorLista);
	}

	/**
	 * Realiza a operacao de adicionar uma compra a uma lista ja cadastrada
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * @param qnt
	 *            e a quantidade do item a ser adicionado
	 * @param id
	 *            e o numero de identificacao unica do item desejado
	 */
	public void adicionaCompraALista(String descritorLista, int qnt, int id) {
		try {
			controllerItens.getItemPorID(id);
		} catch (Exception r) {
			throw new NullPointerException("Erro na compra de item:" + r.getMessage());
		}
		controllerListas.adicionaCompraALista(descritorLista, qnt, controllerItens.getItemPorID(id));
	}

	/**
	 * Realiza a operacao de finalizar uma lista de compras
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * @param localDaCompra
	 *            e o local onde a compra foi realizada
	 * @param valor
	 *            e o valor final da compra
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valor) {
		controllerListas.finalizarListaDeCompras(descritorLista, localDaCompra, valor);

	}

	/**
	 * Realiza a operacao de pesquisar uma certa compra em uma lista
	 * 
	 * @param descritorLista
	 *            e o nome da lista referida
	 * @param id
	 *            e o numero de identificacao unica do item
	 * @return retorna o status da compra
	 */
	public String pesquisaCompraEmLista(String descritorLista, int id) {
		return controllerListas.pesquisaCompraEmLista(descritorLista, id);
	}

	/**
	 * Realiza a operacao de atualizar uma certa compra em uma lista
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * @param id
	 *            e o numero de identificacao unica do item
	 * @param operacao
	 *            e a operacao a ser realizada, pode ser de adicionar ou diminuir a
	 *            quantidade de itens
	 * @param qnt
	 *            e quantidade a ser modificada do item
	 */
	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int qnt) {
		controllerListas.atualizaCompraDeLista(descritorLista, id, operacao, qnt);
	}

	/**
	 * Realiza a operacao de exibir um item cadastrado em uma lista de compras
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * @param posicaoItem
	 *            e a o posicao do referido item na lista
	 * @return retorna o status da compra na lista
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		return controllerListas.getItemLista(descritorLista, posicaoItem);
	}

	/**
	 * Realiza a operacao de deletar uma compra de uma lista de compras
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * @param id
	 *            e o numero de identificacao unica do item
	 */
	public void deletaCompraDaLista(String descritorLista, int id) {
		try {
			controllerItens.getItemPorID(id);
		} catch (Exception r) {

			throw new NullPointerException("Erro na exclusao de compra:" + r.getMessage());

		}
		controllerListas.deletaCompraDaLista(descritorLista, id);
	}

	/**
	 * Realiza a operacao de exibir um item em uma compra a partir da sua data
	 * 
	 * @param data
	 *            e data quando foi cadastrado a compra na lista
	 * @param posicao
	 *            e a posicao do item na lista
	 * @return retorna o status da compra
	 */
	public String getItemListaPorData(String data, int posicao) {
		return controllerListas.getItemListaPorData(data, posicao);
	}

	/**
	 * Realiza a operacao de exibir o item na lista de compras a partir da sua
	 * posicao
	 * 
	 * @param id
	 *            e o numero de identificacao unica do item
	 * @param posicaoLista
	 *            e a posicao na lista do referido item
	 * @return retorna o status da compra na lista
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		return controllerListas.getItemListaPorItem(id, posicaoLista);
	}

	/**
	 * Realiza a operacao de pesquisar uma lista de compras a partir de sua data
	 * 
	 * @param data
	 *            e a data desejada a ser pesquisada
	 * @return retorna o status da lista
	 */
	public String pesquisaListaDeComprasPorData(String data) {
		return controllerListas.pesquisaListaDeComprasPorData(data);
	}

	/**
	 * Realiza a operacao de pesquisar uma lista de compras a partir de seus itens
	 * cadastrados
	 * 
	 * @param id
	 *            e o numero de identificacao unica do item
	 * @return retorna o status da lista de compras
	 */
	public String pesquisaListaDeComprasPorItem(int id) {
		return controllerListas.pesquisaListaDeComprasPorItem(id);
	}

	/**
	 * 
	 * @param dataAtual
	 * @return
	 */
	public String geraAutomaticaUltimaLista(String dataAtual) {
		return controllerListas.geraAutomaticaUltimaLista(dataAtual);
	}
	
	/**
	 * 
	 * @param descritorItem
	 * @param dataAtual
	 * @return
	 */
	public String geraAutomaticaItem(String descritorItem, String dataAtual) {
		return controllerListas.geraAutomaticaItem(descritorItem, dataAtual);
	}
	
	/**
	 * 
	 * @param dataAtual
	 * @return
	 */
	public String geraAutomaticaItensMaisPresentes(String dataAtual) {
		return controllerListas.geraAutomaticaItensMaisPresentes(controllerItens.getItens(), dataAtual);
	}
	
	/**
	 * 
	 */
	public void fechaSistema() {
		try {
			controllerListas.fechaSistema();
			flag = true;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			controllerItens.fechaSistema();
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 */
	public void iniciaSistema() {
		if (flag == false) {
			throw new Error("Sistema iniciado pela primeira vez. Arquivo criado.");
		}
		controllerListas.iniciaSistema();
		controllerItens.iniciaSistema();

	}
	
	/**
	 * 
	 * @param descritor
	 * @param posicaoEstabelecimento
	 * @param posicaoLista
	 * @return
	 */
	public String sugereMelhorEstabelecimento(String descritor, int posicaoEstabelecimento, int posicaoLista) {
		return controllerListas.sugere(descritor, posicaoEstabelecimento, posicaoLista);
	}

}