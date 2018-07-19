package source;

import easyaccept.EasyAccept;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Facade {

	private Controller controller;

	public static void main(String[] args) {
		args = new String[] { "source.Facade", "easyAccept/use_case1.txt", "easyAccept/use_case1_exception.txt",
				"easyAccept/use_case2.txt", "easyAccept/use_case2_exception.txt", "easyAccept/use_case3.txt",
				"easyAccept/use_case3_exception.txt", "easyAccept/use_case4.txt",
				"easyAccept/use_case4_exception.txt" };
		EasyAccept.main(args);
	}

	public Facade() {
		controller = new Controller();
	}

	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		return controller.adiconaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return controller.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		return controller.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}

	public String exibeItem(int id) {
		return controller.exibeItem(id);
	}

	public void atualizaItem(int id, String atributo, String novoValor) {
		controller.atualizaItem(id, atributo, novoValor);
	}

	public void adicionaPrecoItem(int id, String supermercado, double preco) {
		controller.adicionaPrecoItem(id, supermercado, preco);
	}

	public void deletaItem(int id) {
		controller.deletaItem(id);
	}

	public String getItem(int posicao) {
		return controller.getItem(posicao);
	}

	public String getItemPorCategoria(String categoria, int posicao) {
		return controller.getItemPorCategoria(categoria, posicao);
	}

	public String getItemPorMenorPreco(int posicao) {
		return controller.getItemPorMenorPreco(posicao);
	}

	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return controller.getItemPorPesquisa(strPesquisada, posicao);
	}

	public String adicionaListaDeCompras(String descritorLista) {
		return controller.adicionaListaDeCompras(descritorLista);
	}

	public String pesquisaListaDeCompras(String descritorLista) {
		return controller.pesquisaListaDeCompras(descritorLista);
	}

	public void adicionaCompraALista(String descritorLista, int qnt, int id) {
		controller.adicionaCompraALista(descritorLista, qnt, id);
	}

	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valor) {
		controller.finalizarListaDeCompras(descritorLista, localDaCompra, valor);
	}

	public String pesquisaCompraEmLista(String descritorLista, int id) {
		return controller.pesquisaCompraEmLista(descritorLista, id);
	}

	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int qnt) {
		controller.atualizaCompraDeLista(descritorLista, id, operacao, qnt);
	}

	public String getItemLista(String descritorLista, int posicaoItem) {
		return controller.getItemLista(descritorLista, posicaoItem);
	}

	public void deletaCompraDeLista(String descritorLista, int id) {
		controller.deletaCompraDaLista(descritorLista, id);
	}

	public String getItemListaPorData(String data, int posicao) {
		return controller.getItemListaPorData(data, posicao);
	}

	public String getItemListaPorItem(int id, int posicaoLista) {
		return controller.getItemListaPorItem(id, posicaoLista);
	}
	
	public String dataAtual() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

}
