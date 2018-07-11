package source;

import java.util.HashMap;
import java.util.Map;

public class ControllerItens {
	private Itens item;
	private Map<Integer, Itens> itens;
	private int id;

	public ControllerItens() {
		itens = new HashMap<Integer, Itens>();
		this.id = 1;
	}

	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		validandoEntradasNome(nome);
		validandoEntradasCategoria(categoria);
		validandoEntradasLocal(localDeCompra);
		validandoEntradasPreco(preco);
		validandoEntradasUnidadeMedida(unidadeDeMedida);
		item = new Itens(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco, id);
		this.itens.put(this.id, item);
		return this.id++;
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		validandoEntradasNome(nome);
		validandoEntradasCategoria(categoria);
		validandoEntradasLocal(localDeCompra);
		validandoEntradasPreco(preco);
		item = new Itens(nome, categoria, kg, localDeCompra, localDeCompra, preco, id);
		this.itens.put(this.id, item);
		return this.id++;
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		validandoEntradasNome(nome);
		validandoEntradasCategoria(categoria);
		validandoEntradasLocal(localDeCompra);
		validandoEntradasPreco(preco);
		validandoEntradasValorUnidade(unidade);
		item = new Itens(nome, categoria, unidade, localDeCompra, preco, id);
		this.itens.put(this.id, item);
		return this.id++;
	}

	public void atualizaItem(int id, String atributo, String novoValor) {
		validandoAtributo(atributo);
		validandoNovoValor(atributo, novoValor);

		
		if (!itens.containsKey(id)) {
			throw new NullPointerException("Erro na atualizacao de item: item nao existe.");
		}
		
		itens.get(id).atualizaItem(atributo, novoValor);

	}

	public void adicionaPrecoItem(int id, String supermercado, double preco) {
		this.itens.get(id).adicionaPrecoItem(supermercado, preco);
	}

	public void deletaItem(int id) {
		itens.remove(id);
	}

	public String getItem() {
		String res = "";
		for (int id : itens.keySet()) {
			res += itens.get(id).toString();
		}
		return res;
	}

	public String getItemPorCategoria(String categoria) {
		String res = "";
		for (int id : itens.keySet()) {
			if (itens.get(id).getCategoria().equals(categoria)) {
				res += itens.get(id).toString();
			}
		}
		return res;
	}

	public String getItemPorMenorPreco() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemPorPesquisa(String strPesquisada) {
		// TODO Auto-generated method stub
		return null;
	}

	public String exibeItem(int id2) {
		return itens.get(id2).toString();
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
			throw new IllegalArgumentException(
					"Erro no cadastro de item: valor de unidade nao pode ser menor que zero.");
		}

	}

	private void validandoAtributo(String atributo) {
		if (atributo.equals(null) || atributo.trim().equals("")) {
			throw new NullPointerException("Erro na atualizacao de item: atributo nao pode ser vazio ou nulo.");
		}
		if (!atributo.equals("nome") && !atributo.equals("categoria") && !atributo.equals("kg")
				&& !atributo.equals("unidade") && !atributo.equals("quantidade")) {
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao existe.");
		}
	}

	private void validandoNovoValor(String atributo, String novoValor) {
		if (novoValor.equals(null) || novoValor.trim().equals("")) {
			throw new NullPointerException("Erro na atualizacao de item: novo valor de atributo nao pode ser vazio ou nulo.");
		}
		
		if (atributo.equals("nome")) {
			validandoEntradasNome(novoValor);
		} else if (atributo.equals("categoria")) {
			if (novoValor.equals(null) || novoValor.trim().equals("")) {
				throw new NullPointerException("Erro na atualizaçao de item: categoria nao pode ser vazia ou nula.");
			}

			if (!novoValor.equals("limpeza") && !novoValor.equals("alimento industrializado")
					&& !novoValor.equals("alimento nao industrializado") && !novoValor.equals("higiene pessoal")) {
				throw new IllegalArgumentException("Erro na atualizacao de item: categoria nao existe.");
			}
		} else if (atributo.equals("quantidade")) {
			validandoEntradasValorUnidade(Integer.parseInt(novoValor));
		} else if (atributo.equals("unidade")) {
			validandoEntradasValorUnidade(Integer.parseInt(novoValor));
		} else if (atributo.equals("kg")) {
			validandoEntradasValorUnidade(Integer.parseInt(novoValor));
		}
		
	}

}
