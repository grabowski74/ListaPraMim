package source;

import java.util.ArrayList;
import java.util.List;

public class Lista {

	private String localDeCompra;
	private int valor;
	private Compra compra;
	private List<Compra> compras;

	public Lista(String descritor) {
		compras = new ArrayList<>();
	}

	public void adicionaCompra(int qnt, Item item) {
		compra = new Compra(qnt, item);
		compras.add(compra);
	}

	public void finalizaLista(String localDaCompra, int valor) {
		this.localDeCompra = localDaCompra;
		this.valor = valor;

	}

	public void atualizaCompra(int id, int qnt) {
		for (Compra compra: compras) {
			if (compra.getId() == id) {
				compra.atualiza(qnt);
			}
		}
	}

	public String pesquisa(int id) {
		return compras.get(id).toString();
	}
}
