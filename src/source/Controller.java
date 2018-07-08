package source;

public class Controller {
	
	ControllerItens controllerItens;
	ControllerListas controllerListas;
	
	public Controller() {
		controllerItens = new ControllerItens();
		controllerListas = new ControllerListas();
	}
	
///////////////////////////////////////////////////////CONTROLLERITENS///////////////////////////////////////////////////////

	public String adiconaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		return controllerItens.adicionaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra);
	}

	public String adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return controllerItens.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	public String adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra,
			double preco) {
		return controllerItens.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra);
	}

	public void atualizaItem(String id, String atributo, String novoValor) {
		controllerItens.atualizaItem(id, atributo, novoValor);		
	}

	public void adicionaPrecoItem(String id, String supermercado, double preco) {
		controllerItens.adicionaPrecoItem(id, supermercado, preco);		
	}

	public void deletaItem(String id) {
		controllerItens.deletaItem(id);
	}

	public String getItem() {
		return controllerItens.getItem();
	}

	public String getItemPorCategoria(String categoria) {
		return controllerItens.getItemPorCategoria(categoria);
	}

	public String getItemPorMenorPreco() {
		return controllerItens.getItemPorMenorPreco();
	}

	public String getItemPorPesquisa(String strPesquisada) {
		return controllerItens.getItemPorPesquisa(strPesquisada);
	}

///////////////////////////////////////////////////////CONTROLLERLISTAS///////////////////////////////////////////////////////
	
	public void adicionaListaDeCompras(String descritorLista) {
		controllerListas.adicionaListaDeCompras(descritorLista);		
	}

	public String pesquisaListaDeCompras(String descritorLista) {
		return controllerListas.pesquisaListaDeCompras(descritorLista);
	}

	public void adicionaCompraALista(String descritorLista, int qnt, String id) {
		controllerListas.adicionaCompraALista(descritorLista, qnt, id);
	}

	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valor) {
		controllerListas.finalizarListaDeCompras(descritorLista, localDaCompra, valor);
	}

	public String pesquisaCompraEmLista(String descritorLista, String id) {
		return controllerListas.pesquisaCompraEmLista(descritorLista, id);
	}

	public void atualizaCompraDeLista(String descritorLista, String id, int qnt) {
		controllerListas.atualizaCompraDeLista(descritorLista, id, qnt);
	}

	public String getItemLista(String descritorLista, int posicaoItem) {
		return controllerListas.getItemLista(descritorLista, posicaoItem);
	}

	public void deletaCompraDaLista(String descritorLista, String id) {
		controllerListas.deletaCompraDaLista(descritorLista, id);
	}

	public String imprimirListaDeCompras(String descritorLista) {
		return controllerListas.imprimirListaDeCompras(descritorLista);
	}

	public String getItemListaPorData(String data, int posicao) {
		return controllerListas.getItemListaPorData(data, posicao);
	}

	public String getItemListaPorItem(String id, int posicaoLista) {
		return controllerListas.getItemListaPorItem(id, posicaoLista);
	}

}
