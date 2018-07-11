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
		}else if ("categoria".equals(atributo)) {
			this.categoria = novoValor;
		}
		
	}

	@Override
	public int getUnidade() {
		// TODO Auto-generated method stub
		return 0;
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
		return this.kg;
	}

}
