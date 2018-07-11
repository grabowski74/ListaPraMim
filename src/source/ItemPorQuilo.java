package source;

public class ItemPorQuilo implements Categoria {
	
	private String categoria;
	private double kg;
	
	public ItemPorQuilo(String categoria2, double kg) {
		this.categoria = categoria2;
		this.kg = kg;
	}

	@Override
	public String getCategoria() {
		return this.categoria;
	}

	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if("kg".equals(atributo)) {
			this.kg = Double.parseDouble(novoValor);
		}
		
	}

}
