package source;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Lista {

	private String localDeCompra;
	private int valor;
	private Compra compra;
	private List<Compra> compras;
	private Comparator<Compra> comparador;

	public Lista(String descritor) {
		validandoEntradaDescritor(descritor);
		compras = new ArrayList<>();
	}

	public void adicionaCompra(int qnt, Item item) {
		compra = new Compra(qnt, item);
		compras.add(compra);
		this.comparador = new OrdenadorLista();
		Collections.sort(compras, comparador);
	}

	public void finalizaLista(String localDaCompra, int valor) {
		this.localDeCompra = localDaCompra;
		this.valor = valor;

	}

	public void atualizaCompra(int id, String operacao, int qnt) {
		if(!operacao.equals("adiciona") && !operacao.equals("diminui")) {
			throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}
		boolean aux = false;
		Compra comp = null;
		for (Compra compra: compras) {
			if (compra.getId() == id) {
				aux = true;
				compra.atualiza(operacao, qnt);
				if (compra.getQnt() == 0) {
					comp = compra;
				}
				compras.remove(comp);
				break;
			}
		}
		if (aux == false) {
			throw new NullPointerException("Erro na atualizacao de compra: compra nao encontrada na lista.");
		}
	}

	public String pesquisa(int id) {
		for (Compra compra: compras) {
			if(compra.getId() == id) {
				return compra.toString();
			}
		}
		throw new NullPointerException("Erro na pesquisa de compra: compra nao encontrada na lista.");
	}
	
	private void validandoEntradaDescritor(String descritor) {
		if (descritor.equals(null) || descritor.trim().equals("")) {
			throw new NullPointerException("Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}
		
	}

	public String getItem(int posicaoItem) {
		if(posicaoItem >= compras.size()){
			return "";
		}
		return compras.get(posicaoItem).toString();
	}

	public void deleta(int id) {
		boolean aux = false;
		for (Compra compra: compras) {
			if(compra.getId() == id) {
				compras.remove(compra);
				aux = true;
				break;
			}
		}
		if(aux == false) {
			throw new NullPointerException("Erro na exclusao de compra: compra nao encontrada na lista.");
		}
		
	}
}
