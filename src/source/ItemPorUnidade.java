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

	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if("unidade".equals(atributo)) {
			this.unidade = Integer.parseInt(novoValor);
		}
		
	}

}
