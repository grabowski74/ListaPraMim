package source;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ControllerListas {
	
	private Lista listaDeCompras;
	private Map<String, Lista> mapaDasListas;
	private Comparator<Lista> comparador;
	private String ls = System.lineSeparator();

	public ControllerListas() {
		this.mapaDasListas = new HashMap<>();
	}
	
	public String adicionaListaDeCompras(String descritorLista) {
		listaDeCompras = new Lista(descritorLista);
		mapaDasListas.put(descritorLista, listaDeCompras);
		return descritorLista;
	}

	public String pesquisaListaDeCompras(String descritorLista) {
		String aux = "";
		for (String descritor: mapaDasListas.keySet()) {
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
		mapaDasListas.get(descritorLista).finalizaLista(localDaCompra, valor);
	}

	public String pesquisaCompraEmLista(String descritorLista, int id) {
		return mapaDasListas.get(descritorLista).pesquisa(id);
	}

	public void atualizaCompraDeLista(String descritorLista, int id, int qnt, String operacao) {
		mapaDasListas.get(descritorLista).atualizaCompra(id, qnt, operacao);
	}

	public String getItemLista(String descritorLista, int posicaoItem) {
		return mapaDasListas.get(descritorLista).getItemLista(posicaoItem);
	}

	public void deletaCompraDaLista(String descritorLista, int id) {
		mapaDasListas.get(descritorLista).deletaCompraDaLista(id);
		
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
