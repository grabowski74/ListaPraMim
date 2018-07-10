package source;

public class ItemPorUnidade implements Categoria {
	
	private String categoria;
	private int unidade;

	public ItemPorUnidade(String categoria2, int unidade) {
		this.categoria = categoria2;
		this.unidade = unidade;
	}

	@Override
	public String getCategoria() {
		return this.categoria;
	}

}
