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
		// TODO Auto-generated method stub
		return null;
	}

	public void adicionaListaDeCompras(String descritorLista) {
		// TODO Auto-generated method stub

	}

	public String pesquisaListaDeCompras(String descritorLista) {
		// TODO Auto-generated method stub
		return null;
	}

	public void adicionaCompraALista(String descritorLista, int qnt, String id) {
		// TODO Auto-generated method stub

	}

	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valor) {
		// TODO Auto-generated method stub

	}

	public String pesquisaCompraEmLista(String descritorLista, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizaCompraDeLista(String descritorLista, String id, int qnt) {
		// TODO Auto-generated method stub

	}

	public String getItemLista(String descritorLista, int posicaoItem) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletaCompraDaLista(String descritorLista, String id) {
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

	public String getItemListaPorItem(String id, int posicaoLista) {
		// TODO Auto-generated method stub
		return null;
	}

	/////////////////////////////////////////////////////// METODOSPRIVADOS///////////////////////////////////////////////////////

	private void validandoEntradasUnidadeMedida(String unidadeDeMedida) {
		if (unidadeDeMedida.equals(null) || unidadeDeMedida.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de item: unidade de medida nao pode ser vazia ou nula.");
		}

	}

	private void validandoEntradasPreco(double preco) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de item: preco de item invalido.");
		}

	}

	private void validandoEntradasLocal(String localDeCompra) {
		if (localDeCompra.equals(null) || localDeCompra.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de item: local de compra nao pode ser vazio ou nulo.");
		}

	}

	private void validandoEntradasCategoria(String categoria) {
		if (categoria.equals(null) || categoria.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de item: categoria nao pode ser vazia ou nula.");
		}

		if (!categoria.equals("limpeza") && !categoria.equals("alimento industrializado")
				&& !categoria.equals("alimento nao industrializado") && !categoria.equals("higiene pessoal")) {
			throw new IllegalArgumentException("Erro no cadastro de item: categoria nao existe.");
		}

	}

	private void validandoEntradasNome(String nome) {
		if (nome.equals(null) || nome.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de item: nome nao pode ser vazio ou nulo.");
		}
	}

	private void validandoEntradasValorUnidade(int unidade) {
		if (unidade < 0) {
			throw new IllegalArgumentException("Erro no cadastro de item: valor de unidade nao pode ser menor que zero.");
		}

	}
}