package source;

public class ItemPorUnidade implements Categoria {
	
	private String categoria;
	private int unidade;

	public ItemPorUnidade(String categoria2, int unidade) {
		this.categoria = categoria2;
		this.unidade = unidade;
	}
	
	public int getUnidade() {
		return this.unidade;
	}

	@Override
	public String getCategoria() {
		return this.categoria;
	}

	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if("unidade".equals(atributo)) {
			this.unidade = Integer.parseInt(novoValor);
		} else if ("categoria".equals(atributo)) {
			this.categoria = novoValor;
		}
		
	}

	@Override
	public int getQuantidade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUnidadeDeMedida() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getKg() {
		// TODO Auto-generated method stub
		return 0;
	}

}
