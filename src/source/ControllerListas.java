package source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerListas {

	private ListaDeCompras listaDeCompras;
	private Map<String, ListaDeCompras> mapaDasListas;

	public ControllerListas() {
		this.mapaDasListas = new HashMap<>();
	}

	public String adicionaListaDeCompras(String descritorLista) {
		listaDeCompras = new ListaDeCompras(descritorLista);
		mapaDasListas.put(descritorLista, listaDeCompras);
		return descritorLista;
	}

	public String pesquisaListaDeCompras(String descritorLista) {
		String aux = "";
		for (String descritor : mapaDasListas.keySet()) {
			if (descritor.startsWith(descritorLista)) {
				aux += descritor;
			}
		}
		return aux;
	}

	public void adicionaCompraALista(String descritorLista, int qnt, Item item) {
		if (mapaDasListas.containsKey(descritorLista)) {
			mapaDasListas.get(descritorLista).adicionaCompra(qnt, item);
		}
	}

	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valor) {
		if (descritorLista.equals(null) || descritorLista.trim().equals("")) {
			throw new NullPointerException(
					"Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}
		if (localDaCompra.equals(null) || localDaCompra.trim().equals("")) {
			throw new NullPointerException(
					"Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException(
					"Erro na finalizacao de lista de compras: valor final da lista invalido.");
		}
		mapaDasListas.get(descritorLista).finalizaLista(localDaCompra, valor);
	}

	public String pesquisaCompraEmLista(String descritorLista, int id) {
		if (id < 0) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: item id invalido.");
		}
		if (descritorLista.equals(null) || descritorLista.trim().equals("")) {
			throw new NullPointerException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		}
		return mapaDasListas.get(descritorLista).pesquisa(id);
	}

	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int qnt) {
		mapaDasListas.get(descritorLista).atualizaCompra(id, operacao, qnt);
	}

	public String getItemLista(String descritorLista, int posicaoItem) {
		return mapaDasListas.get(descritorLista).getItem(posicaoItem);
	}

	public void deletaCompraDaLista(String descritorLista, int id) {
		if (descritorLista.equals(null) || descritorLista.trim().equals("")) {
			throw new NullPointerException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
		}
		mapaDasListas.get(descritorLista).deleta(id);
	}

	public String getItemListaPorData(String data, int posicao) {
		List<String> listas = new ArrayList<>();
		for (ListaDeCompras lista : mapaDasListas.values()) {
			if (data.equals(lista.getData()) && !listas.contains(lista.getDescritor())) {
				listas.add(lista.getDescritor());
			}
		}
		
		Collections.sort(listas);
		
		return listas.get(posicao);
	}

	public String getItemListaPorItem(int id, int posicaoLista) {
		// TODO Auto-generated method stub
		return null;
	}

}
