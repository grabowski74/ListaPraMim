package source;

public class Facade {
	
	private Controller controller;
	
	public Facade() {
		controller = new Controller();
	}
	
	public String adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra, double preco) {
		return controller.adiconaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);		
	}
	
	public String adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return controller.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);	
	}
	
	public String adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		return controller.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}
	
	public void atualizaItem(String id, String atributo, String novoValor ) {
		controller.atualizaItem(id, atributo, novoValor);
	}
	
	public void adicionaPrecoItem(String id, String supermercado, double preco) {
		controller.adicionaPrecoItem(id, supermercado, preco);
	}
	
	public void deletaItem(String id) {
		controller.deletaItem(id);
	}
	
	public String getItem() {
		return controller.getItem();
	}
	
	public String getItemPorCategoria(String categoria) {
		return controller.getItemPorCategoria(categoria);
	}
	
	public String getItemPorMenorPreco() {
		return controller.getItemPorMenorPreco();
	}
	
	public String getItemPorPesquisa(String strPesquisada) {
		return controller.getItemPorPesquisa(strPesquisada);
	}
	
	public void adicionaListaDeCompras(String descritorLista) {
		controller.adicionaListaDeCompras(descritorLista);
	}
	
	public String pesquisaListaDeCompras(String descritorLista) {
		return controller.pesquisaListaDeCompras(descritorLista);
	}
	
	public void adicionaCompraALista(String descritorLista, int qnt, String id) {
		controller.adicionaCompraALista(descritorLista, qnt, id);
	}
	
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valor) {
		controller.finalizarListaDeCompras(descritorLista, localDaCompra, valor);
	}
	
	public String pesquisaCompraEmLista(String descritorLista, String id) {
		return controller.pesquisaCompraEmLista(descritorLista, id);
	}
	
	public void atualizaCompraDeLista(String descritorLista, String id, int qnt) {
		controller.atualizaCompraDeLista(descritorLista, id, qnt);
	}
	
	public String getItemLista(String descritorLista, int posicaoItem) {
		return controller.getItemLista(descritorLista, posicaoItem);
	}
	
	public void deletaCompraDaLista(String descritorLista, String id) {
		controller.deletaCompraDaLista(descritorLista, id);
	}
	
	public String imprimirListaDeCompras(String descritorLista) {
		return controller.imprimirListaDeCompras(descritorLista);
	}
	
	public String getItemListaPorData(String data, int posicao) {
		return controller.getItemListaPorData(data, posicao);
	}
	
	public String getItemListaPorItem(String id, int posicaoLista) {
		return controller.getItemListaPorItem(id, posicaoLista);
	}
	
	
}
