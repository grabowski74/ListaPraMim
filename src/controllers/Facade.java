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
				"easyAccept/use_case4_exception.txt" };
		EasyAccept.main(args);
	}
	
	/**
	 * 
	 */
	public Facade() {
		controller = new Controller();
	}
	/**
	 * 
	 * @param nome
	 * @param categoria
	 * @param qnt
	 * @param unidadeDeMedida
	 * @param localDeCompra
	 * @param preco
	 * @return
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		return controller.adiconaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
	}
	/**
	 * 
	 * @param nome
	 * @param categoria
	 * @param kg
	 * @param localDeCompra
	 * @param preco
	 * @return
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return controller.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}
	/**
	 * 
	 * @param nome
	 * @param categoria
	 * @param unidade
	 * @param localDeCompra
	 * @param preco
	 * @return
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		return controller.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public String exibeItem(int id) {
		return controller.exibeItem(id);
	}
	/**
	 * 
	 * @param id
	 * @param atributo
	 * @param novoValor
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		controller.atualizaItem(id, atributo, novoValor);
	}
	/**
	 * 
	 * @param id
	 * @param supermercado
	 * @param preco
	 */
	public void adicionaPrecoItem(int id, String supermercado, double preco) {
		controller.adicionaPrecoItem(id, supermercado, preco);
	}
	/**
	 * 
	 * @param id
	 */
	public void deletaItem(int id) {
		controller.deletaItem(id);
	}
	/**
	 * 
	 * @param posicao
	 * @return
	 */
	public String getItem(int posicao) {
		return controller.getItem(posicao);
	}
	/**
	 * 
	 * @param categoria
	 * @param posicao
	 * @return
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return controller.getItemPorCategoria(categoria, posicao);
	}
	/**
	 * 
	 * @param posicao
	 * @return
	 */
	public String getItemPorMenorPreco(int posicao) {
		return controller.getItemPorMenorPreco(posicao);
	}
	/**
	 * 
	 * @param strPesquisada
	 * @param posicao
	 * @return
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return controller.getItemPorPesquisa(strPesquisada, posicao);
	}
	/**
	 * 
	 * @param descritorLista
	 * @return
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		return controller.adicionaListaDeCompras(descritorLista);
	}
	/**
	 * 
	 * @param descritorLista
	 * @return
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		return controller.pesquisaListaDeCompras(descritorLista);
	}
	/**
	 * 
	 * @param descritorLista
	 * @param qnt
	 * @param id
	 */
	public void adicionaCompraALista(String descritorLista, int qnt, int id) {
		controller.adicionaCompraALista(descritorLista, qnt, id);
	}
	/**
	 * 
	 * @param descritorLista
	 * @param localDaCompra
	 * @param valor
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valor) {
		controller.finalizarListaDeCompras(descritorLista, localDaCompra, valor);
	}
	/**
	 * 
	 * @param descritorLista
	 * @param id
	 * @return
	 */
	public String pesquisaCompraEmLista(String descritorLista, int id) {
		return controller.pesquisaCompraEmLista(descritorLista, id);
	}
	/**
	 * 
	 * @param descritorLista
	 * @param id
	 * @param operacao
	 * @param qnt
	 */
	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int qnt) {
		controller.atualizaCompraDeLista(descritorLista, id, operacao, qnt);
	}
	/**
	 * 
	 * @param descritorLista
	 * @param posicaoItem
	 * @return
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		return controller.getItemLista(descritorLista, posicaoItem);
	}
	/**
	 * 
	 * @param descritorLista
	 * @param id
	 */
	public void deletaCompraDeLista(String descritorLista, int id) {
		controller.deletaCompraDaLista(descritorLista, id);
	}
	/**
	 * 
	 * @param data
	 * @param posicao
	 * @return
	 */
	public String getItemListaPorData(String data, int posicao) {
		return controller.getItemListaPorData(data, posicao);
	}
	/**
	 * 
	 * @param id
	 * @param posicaoLista
	 * @return
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		return controller.getItemListaPorItem(id, posicaoLista);
	}
	/**
	 * 
	 * @return
	 */
	public String dataAtual() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		return controller.pesquisaListaDeComprasPorData(data);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		return controller.pesquisaListaDeComprasPorItem(id);
	}

}
