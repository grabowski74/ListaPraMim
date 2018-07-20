package controllers;
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
public class Controller {

	private ControllerItens controllerItens;
	private ControllerListas controllerListas;
	/**
	 * 
	 */
	public Controller() {
		controllerItens = new ControllerItens();
		controllerListas = new ControllerListas();
	}

	/////////////////////////////////////////////////////// CONTROLLERITENS///////////////////////////////////////////////////////
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
	public int adiconaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		return controllerItens.adicionaItemPorQtd(nome, categoria, localDeCompra, preco, qnt, unidadeDeMedida);
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

		return controllerItens.adicionaItemPorQuilo(nome, categoria, localDeCompra, preco, kg);
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

		return controllerItens.adicionaItemPorUnidade(nome, categoria, localDeCompra, preco, unidade);
	}
	/**
	 * 
	 * @param id
	 * @param atributo
	 * @param novoValor
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		controllerItens.atualizaItem(id, atributo, novoValor);
	}
	/**
	 * 
	 * @param id
	 * @param supermercado
	 * @param preco
	 */
	public void adicionaPrecoItem(int id, String supermercado, double preco) {
		controllerItens.adicionaPrecoItem(id, supermercado, preco);
	}
	/**
	 * 
	 * @param id
	 */
	public void deletaItem(int id) {
		controllerItens.deletaItem(id);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public String exibeItem(int id) {
		return controllerItens.exibeItem(id);
	}
	/**
	 * 
	 * @param posicao
	 * @return
	 */
	public String getItem(int posicao) {
		return controllerItens.getItem(posicao);
	}
	/**
	 * 
	 * @param categoria
	 * @param posicao
	 * @return
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return controllerItens.getItemPorCategoria(categoria, posicao);
	}
	/**
	 * 
	 * @param posicao
	 * @return
	 */
	public String getItemPorMenorPreco(int posicao) {
		return controllerItens.getItemPorMenorPreco(posicao);
	}
	/**
	 * 
	 * @param strPesquisada
	 * @param posicao
	 * @return
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return controllerItens.getItemPorPesquisa(strPesquisada, posicao);
	}
	/**
	 * 
	 * @param descritorLista
	 * @return
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		return controllerListas.adicionaListaDeCompras(descritorLista);
	}
	/**
	 * 
	 * @param descritorLista
	 * @return
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		return controllerListas.pesquisaListaDeCompras(descritorLista);
	}
	/**
	 * 
	 * @param descritorLista
	 * @param qnt
	 * @param id
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
	 * 
	 * @param descritorLista
	 * @param localDaCompra
	 * @param valor
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valor) {
		controllerListas.finalizarListaDeCompras(descritorLista, localDaCompra, valor);

	}
	/**
	 * 
	 * @param descritorLista
	 * @param id
	 * @return
	 */
	public String pesquisaCompraEmLista(String descritorLista, int id) {
		return controllerListas.pesquisaCompraEmLista(descritorLista, id);
	}	
	/**
	 * 
	 * @param descritorLista
	 * @param id
	 * @param operacao
	 * @param qnt
	 */
	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int qnt) {
		controllerListas.atualizaCompraDeLista(descritorLista, id, operacao, qnt);
	}
	/**
	 * 
	 * @param descritorLista
	 * @param posicaoItem
	 * @return
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		return controllerListas.getItemLista(descritorLista, posicaoItem);
	}
	/**
	 * 
	 * @param descritorLista
	 * @param id
	 */
	public void deletaCompraDaLista(String descritorLista, int id) {
		try {
			controllerItens.getItemPorID(id);
		} catch(Exception r) {
			throw new NullPointerException("Erro na exclusao de compra:" + r.getMessage());
		}
		controllerListas.deletaCompraDaLista(descritorLista, id);
	}
	/**
	 * 
	 * @param data
	 * @param posicao
	 * @return
	 */
	public String getItemListaPorData(String data, int posicao) {
		return controllerListas.getItemListaPorData(data, posicao);
	}
	/**
	 * 
	 * @param id
	 * @param posicaoLista
	 * @return
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		return controllerListas.getItemListaPorItem(id, posicaoLista);
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public String pesquisaListaDeComprasPorData(String data) {
		return controllerListas.pesquisaListaDeComprasPorData(data);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public String pesquisaListaDeComprasPorItem(int id) {
		return controllerListas.pesquisaListaDeComprasPorItem(id);
	}

}