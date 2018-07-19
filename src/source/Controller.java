package source;

import controllers.ControllerItens;
import controllers.ControllerListas;

public class Controller {

	private ControllerItens controllerItens;
	private ControllerListas controllerListas;

	public Controller() {
		controllerItens = new ControllerItens();
		controllerListas = new ControllerListas();
	}

	/////////////////////////////////////////////////////// CONTROLLERITENS///////////////////////////////////////////////////////

	public int adiconaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		return controllerItens.adicionaItemPorQtd(nome, categoria, localDeCompra, preco, qnt, unidadeDeMedida);
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {

		return controllerItens.adicionaItemPorQuilo(nome, categoria, localDeCompra, preco, kg);
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {

		return controllerItens.adicionaItemPorUnidade(nome, categoria, localDeCompra, preco, unidade);
	}

	public void atualizaItem(int id, String atributo, String novoValor) {
		controllerItens.atualizaItem(id, atributo, novoValor);
	}

	public void adicionaPrecoItem(int id, String supermercado, double preco) {
		controllerItens.adicionaPrecoItem(id, supermercado, preco);
	}

	public void deletaItem(int id) {
		controllerItens.deletaItem(id);
	}

	public String exibeItem(int id) {
		return controllerItens.exibeItem(id);
	}

	public String getItem(int posicao) {
		return controllerItens.getItem(posicao);
	}

	public String getItemPorCategoria(String categoria, int posicao) {
		return controllerItens.getItemPorCategoria(categoria, posicao);
	}

	public String getItemPorMenorPreco(int posicao) {
		return controllerItens.getItemPorMenorPreco(posicao);
	}

	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return controllerItens.getItemPorPesquisa(strPesquisada, posicao);
	}

	public String adicionaListaDeCompras(String descritorLista) {
		return controllerListas.adicionaListaDeCompras(descritorLista);
	}

	public String pesquisaListaDeCompras(String descritorLista) {
		return controllerListas.pesquisaListaDeCompras(descritorLista);
	}

	public void adicionaCompraALista(String descritorLista, int qnt, int id) {
		try {
			controllerItens.getItemPorID(id);
		} catch (Exception r) {
			throw new NullPointerException("Erro na compra de item:" + r.getMessage());
		}
		controllerListas.adicionaCompraALista(descritorLista, qnt, controllerItens.getItemPorID(id));
	}

	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valor) {
		controllerListas.finalizarListaDeCompras(descritorLista, localDaCompra, valor);

	}

	public String pesquisaCompraEmLista(String descritorLista, int id) {
		return controllerListas.pesquisaCompraEmLista(descritorLista, id);
	}

	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int qnt) {
		controllerListas.atualizaCompraDeLista(descritorLista, id, operacao, qnt);
	}

	public String getItemLista(String descritorLista, int posicaoItem) {
		return controllerListas.getItemLista(descritorLista, posicaoItem);
	}

	public void deletaCompraDaLista(String descritorLista, int id) {
		try {
			controllerItens.getItemPorID(id);
		} catch(Exception r) {
			throw new NullPointerException("Erro na exclusao de compra:" + r.getMessage());
		}
		controllerListas.deletaCompraDaLista(descritorLista, id);
	}

	public String getItemListaPorData(String data, int posicao) {
		return controllerListas.getItemListaPorData(data, posicao);
	}

	public String getItemListaPorItem(int id, int posicaoLista) {
		// TODO Auto-generated method stub
		return null;
	}
}