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

	public void atualizaCompra(int id, int qnt, String operacao) {
		
		for (Compra compra: compras) {
			if (compra.getId() == id) {
				compra.atualiza(qnt, operacao);
				if(compra.getQnt() < 1){
					compras.remove(compra);
					break;
				}
			}
		}
	}

	public String pesquisa(int id) {
		boolean a = false;
		String res = "";
		for(Compra o : compras){
			if(o.getId()== id){
				res = o.toString();
				a = true;
			}
		}
		if(a == false){
			throw new Error("Erro na pesquisa de compra: compra nao encontrada na lista.");
		}
		return res;
	}

	public String getItemLista(int posicaoItem) {
		return compras.get(posicaoItem).toString();
	}

	public void deletaCompraDaLista(int id) {
		for(Compra o : compras){
			if(o.getId() == id){
				compras.remove(o);
				break;
			}
		}
	}
}
