package source;

public class Itens {
	
	private String nome;
	private Categoria categoria;
	private double preco;
	private String localDeCompra;
	private String id;
	
	public Itens(String nome2, String categoria2, int qnt, String unidadeDeMedida, String localDeCompra2,
			double preco2, int id) {
		this.id = "id" + id;
		this.nome = nome2;
		this.preco = preco2;
		this.localDeCompra = localDeCompra2;
		this.categoria = new ItemPorQnt(categoria2, qnt, unidadeDeMedida);
	}

	public Itens(String nome2, String categoria2, double kg, String localDeCompra2, String localDeCompra3, double preco2, int id) {
		this.id = "id" + id;
		this.nome = nome2;
		this.preco = preco2;
		this.localDeCompra = localDeCompra2;
		this.categoria = new ItemPorQuilo(categoria2, kg);
	}

	public Itens(String nome2, String categoria2, int unidade, String localDeCompra2, double preco2, int id) {
		this.id = "id" + id;
		this.nome = nome2;
		this.preco = preco2;
		this.localDeCompra = localDeCompra2;
		this.categoria = new ItemPorUnidade(categoria2, unidade);
	}

	public String getId() {
		return this.id;
	}

	public void setNome(String novoValor) {
		this.nome = novoValor;		
	}

	public void setPreco(String atributo) {
		double novoPreco = Double.parseDouble(atributo);
		this.preco = novoPreco;	
	}

	public void setLocalDeCompra(String novoValor) {
		this.localDeCompra = novoValor;
	}
	
	

}
