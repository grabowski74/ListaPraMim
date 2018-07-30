package controllers;

import easyaccept.EasyAccept;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Representacao de um sitema de cadastro de lista de compras, nesse sistema e possivel cadastrar,
 * alterar, editar, adicionar e deletar listas e produtos. ListaPraMim
 * 
 * @author Matheus Silva Araujo - 117210375
 * @author Gabriel Guimaraes Almeida
 * 
 * Projeto de Laboratorio - Laboratorio de Programacao 2 - 2018.1
 *
 */
public class Facade {

	private Controller controller;

	public static void main(String[] args) {
		args = new String[] { "controllers.Facade", "easyAccept/use_case1.txt", "easyAccept/use_case1_exception.txt",
				"easyAccept/use_case2.txt", "easyAccept/use_case2_exception.txt", "easyAccept/use_case3.txt",
				"easyAccept/use_case3_exception.txt", "easyAccept/use_case4.txt",

				"easyAccept/use_case4_exception.txt", "easyAccept/use_case5.txt" };

		EasyAccept.main(args);
	}
	
	/**
	 * Realiza a construcao da fachada do sistema, toda fachada instacia um controller master.
	 */
	public Facade() {
		controller = new Controller();
	}
	
	/**
	 * Realiza a operacao de adicionar um item ao sistema por sua quantidade.
	 * @param nome e o nome do referido item
	 * @param categoria e a categoria do referido item
	 * @param qnt e a quantidade do referido item
	 * @param unidadeDeMedida e a unidade de medida do referido item
	 * @param localDeCompra e o local de compra do referido item
	 * @param preco e o preco do referido item 
	 * @return retorna o numero de identificacao unica do item
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		return controller.adiconaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
	}
	
	/**
	 * Realiza a operacao de adicionar um item ao sistema por seu peso.
	 * @param nome e o nome do referido item
	 * @param categoria e a categoria do referido item
	 * @param kg e o peso do referido item
	 * @param localDeCompra e o local de compra do referido item
	 * @param preco e o preco do referido item
	 * @return retorna o numero de identificacao unica do item
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return controller.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}
	
	/**
	 * Realiza a operacao de adicionar um item ao sistema por sua unidade.
	 * @param nome e o nome do referido item
	 * @param categoria e a categoria do referido item
	 * @param unidade e a unidade do referido item
	 * @param localDeCompra e o local de compra do referido item
	 * @param preco e o preco do referido item
	 * @return retorna o numero de identificacao unica do item
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		return controller.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}
	
	/**
	 * Realiza a operacao de exibir o item atraves do numero de identificacao unica 
	 * fornecido
	 * @param id e o numero de identificacao unica do referido item
	 * @return retorna o status do item cadastrado
	 */
	public String exibeItem(int id) {
		return controller.exibeItem(id);
	}
	
	/**
	 * Realiza a operacao de atualizar um item a partir do atributo e novo valor fornecido
	 * @param id e o numero de identificacao unica do item
	 * @param atributo e o atributo a ser modificado
	 * @param novoValor e o valor a ser atualizado
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		controller.atualizaItem(id, atributo, novoValor);
	}
	
	/**
	 * Realiza a operacao de adicionar um preco a um determinado item
	 * @param id e o numero de identificacao unica do item
	 * @param supermercado e o supermercado a ser adicionado o item
	 * @param preco e o novo preco a ser cadastrado no referido supermercado
	 */
	public void adicionaPrecoItem(int id, String supermercado, double preco) {
		controller.adicionaPrecoItem(id, supermercado, preco);
	}
	
	/**
	 * Realiza a operacao de deletar um item a partir do seu id
	 * @param id e o numero de identificacao unica do referido item
	 */
	public void deletaItem(int id) {
		controller.deletaItem(id);
	}
	
	/**
	 * Realiza a operacao de exibir o item a partir da sua posicao na lista de itens
	 * @param posicao e a posicao do referido item
	 * @return retorna o status do item desejado
	 */
	public String getItem(int posicao) {
		return controller.getItem(posicao);
	}
	
	/**
	 * Realiza a operacao de exibir o item a partir da sua categoria na lista de itens
	 * @param categoria e a categoria do referido item
	 * @param posicao e a posicao do referido item
	 * @return retorna o status do item desejado
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return controller.getItemPorCategoria(categoria, posicao);
	}
	
	/**
	 * Realiza a operacao de exibir o item a partir do seu preco na lista de itens
	 * @param posicao e a posicao do referido item
	 * @return retorna o status do item desejado
	 */
	public String getItemPorMenorPreco(int posicao) {
		return controller.getItemPorMenorPreco(posicao);
	}
	
	/**
	 * Realiza a operacao de exibir o item a partir do seu nome
	 * @param strPesquisada e o nome do item desejado
	 * @param posicao e a posicao do referido item
	 * @return retorna o status do item desejado
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return controller.getItemPorPesquisa(strPesquisada, posicao);
	}
	
	/**
	 * Realiza a operacao de adicionar uma lista de itens ao sistema
	 * @param descritorLista e o nome da referida lista
	 * @return retorna a descricao da lista cadastrada
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		return controller.adicionaListaDeCompras(descritorLista);
	}
	
	/**
	 * Realiza a operacao de pesquisar listas cadastradas no sistema a partir do seu nome
	 * @param descritorLista e o nome da referida lista
	 * @return retorna o status da lista desejada
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		return controller.pesquisaListaDeCompras(descritorLista);
	}
	
	/**
	 * Realiza a operacao de adicionar uma compra a uma lista ja cadastrada
	 * @param descritorLista e o nome da referida lista
	 * @param qnt e a quantidade do item a ser adicionado
	 * @param id e o numero de identificacao unica do item desejado
	 */
	public void adicionaCompraALista(String descritorLista, int qnt, int id) {
		controller.adicionaCompraALista(descritorLista, qnt, id);
	}
	
	/**
	 * Realiza a operacao de finalizar uma lista de compras
	 * @param descritorLista e o nome da referida lista
	 * @param localDaCompra e o local onde a compra foi realizada
	 * @param valor e o valor final da compra
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valor) {
		controller.finalizarListaDeCompras(descritorLista, localDaCompra, valor);
	}
	
	/**
	 * Realiza a operacao de pesquisar uma certa compra em uma lista
	 * @param descritorLista e o nome da lista referida
	 * @param id e o numero de identificacao unica do item
	 * @return retorna o status da compra
	 */
	public String pesquisaCompraEmLista(String descritorLista, int id) {
		return controller.pesquisaCompraEmLista(descritorLista, id);
	}
	
	/**
	 * Realiza a operacao de atualizar uma certa compra em uma lista
	 * @param descritorLista e o nome da referida lista
	 * @param id e o numero de identificacao unica do item
	 * @param operacao e a operacao a ser realizada, pode ser de adicionar ou diminuir a quantidade de itens
	 * @param qnt e quantidade a ser modificada do item
	 */
	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int qnt) {
		controller.atualizaCompraDeLista(descritorLista, id, operacao, qnt);
	}
	
	/**
	 * Realiza a operacao de exibir um item cadastrado em uma lista de compras
	 * @param descritorLista e o nome da referida lista
	 * @param posicaoItem e a o posicao do referido item na lista
	 * @return retorna o status da compra na lista
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		return controller.getItemLista(descritorLista, posicaoItem);
	}
	
	/**
	 * Realiza a operacao de deletar uma compra de uma lista de compras
	 * @param descritorLista e o nome da referida lista
	 * @param id e o numero de identificacao unica do item
	 */
	public void deletaCompraDeLista(String descritorLista, int id) {
		controller.deletaCompraDaLista(descritorLista, id);
	}
	
	/**
	 * Realiza a operacao de exibir um item em uma compra a partir da sua data
	 * @param data e data quando foi cadastrado a compra na lista
	 * @param posicao e a posicao do item na lista
	 * @return retorna o status da compra
	 */
	public String getItemListaPorData(String data, int posicao) {
		return controller.getItemListaPorData(data, posicao);
	}
	
	/**
	 * Realiza a operacao de exibir o item na lista de compras a partir da sua posicao
	 * @param id e o numero de identificacao unica do item
	 * @param posicaoLista e a posicao na lista do referido item
	 * @return retorna o status da compra na lista
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		return controller.getItemListaPorItem(id, posicaoLista);
	}
	
	/**
	 * Realiza a operacao de fornecer a data atual
	 * @return retorna a data atual
	 */
	public String dataAtual() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}
	
	/**
	 * Realiza a operacao de pesquisar uma lista de compras a partir de sua data
	 * @param data e a data desejada a ser pesquisada
	 * @return retorna o status da lista
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		return controller.pesquisaListaDeComprasPorData(data);
	}
	
	/**
	 * Realiza a operacao de pesquisar uma lista de compras a partir de seus itens cadastrados
	 * @param id e o numero de identificacao unica do item
	 * @return retorna o status da lista de compras
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		return controller.pesquisaListaDeComprasPorItem(id);
	}

	
	public String geraAutomaticaUltimaLista() {
		return controller.geraAutomaticaUltimaLista(dataAtual());
	}
	
	public String geraAutomaticaItem(String descritorItem) {
		return controller.geraAutomaticaItem( descritorItem, dataAtual());
	}
	
	public String geraAutomaticaItensMaisPresentes() {
		return controller.geraAutomaticaItensMaisPresentes(dataAtual());
	}


}
