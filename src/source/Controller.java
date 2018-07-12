package source;

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

		if (qnt <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de item: valor de quantidade nao pode ser menor que zero.");
		}
		return controllerItens.adicionaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		
		if (kg <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de item: valor de quilos nao pode ser menor que zero.");
		}
		return controllerItens.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		
		return controllerItens.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
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

	public void adicionaListaDeCompras(String descritorLista) {
		// TODO Auto-generated method stub

	}

	public String pesquisaListaDeCompras(String descritorLista) {
		// TODO Auto-generated method stub
		return null;
	}

	public void adicionaCompraALista(String descritorLista, int qnt, int id) {
		// TODO Auto-generated method stub

	}

	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valor) {
		// TODO Auto-generated method stub

	}

	public String pesquisaCompraEmLista(String descritorLista, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizaCompraDeLista(String descritorLista, int id, int qnt) {
		// TODO Auto-generated method stub

	}

	public String getItemLista(String descritorLista, int posicaoItem) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletaCompraDaLista(String descritorLista, int id) {
		// TODO Auto-generated method stub

	}

	public String imprimirListaDeCompras(String descritorLista) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemListaPorData(String data, int posicao) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemListaPorItem(int id, int posicaoLista) {
		// TODO Auto-generated method stub
		return null;
	}
}