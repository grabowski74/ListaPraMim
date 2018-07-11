package source;

import java.util.HashMap;
import java.util.Map;

public class Itens {

	private String nome;
	private Categoria categoria;
	private Map<String, Double> precos = new HashMap<String, Double>();
	private String id;
	
	public Itens(String nome2, String categoria2, int qnt, String unidadeDeMedida, String localDeCompra2,
			double preco2, int id) {
		this.id = "id" + id;
		this.nome = nome2;
		this.precos.put(localDeCompra2, preco2);
		this.categoria = new ItemPorQnt(categoria2, qnt, unidadeDeMedida);
	}

	public Itens(String nome2, String categoria2, double kg, String localDeCompra2, String localDeCompra3, double preco2, int id) {
		this.id = "id" + id;
		this.nome = nome2;
		this.precos.put(localDeCompra2, preco2);
		this.categoria = new ItemPorQuilo(categoria2, kg);
	}

	public Itens(String nome2, String categoria2, int unidade, String localDeCompra2, double preco2, int id) {
		this.id = "id" + id;
		this.nome = nome2;
		this.precos.put(localDeCompra2, preco2);
		this.categoria = new ItemPorUnidade(categoria2, unidade);
	}

	public String getId() {
		return this.id;
	}

	public void setNome(String novoValor) {
		this.nome = novoValor;		
	}

	public void adicionaPrecoItem(String supermercado, double preco) {
		this.precos.put(supermercado, preco);
	}
	
	public String toString() {
		return this.id + ". " + this.nome + ", " + categoria.getCategoria() + ", " + getListaPrecos();
	}
	
	protected String getListaPrecos() {
        StringBuilder listaDePrecos = new StringBuilder("<");
        for (String localDeCompra : precos.keySet()) {
            listaDePrecos.append(String.format("%s, R$ %.2f;", localDeCompra, precos.get(localDeCompra)));
        }
        return listaDePrecos.toString() + ">";
    }
	
	public String getCategoria() {
		return categoria.getCategoria();
	}

	
	
	

}
