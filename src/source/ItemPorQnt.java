package source;

public class ItemPorQnt implements Categoria {
	
	private String categoria;
	private int qnt;
	private String unidadeDeMedida;

	public ItemPorQnt(String categoria2, int qnt, String unidadeDeMedida) {
		this.categoria = categoria2;
		this.qnt = qnt;
		this.unidadeDeMedida = unidadeDeMedida;
	}

	@Override
	public String getCategoria() {
		return this.categoria;
	}

	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if("quantidade".equals(atributo)) {
			this.qnt = Integer.parseInt(novoValor);
		} else if("unidade de medida".equals(atributo)) {
			this.unidadeDeMedida = novoValor;
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
		return this.qnt;
	}

	@Override
	public String getUnidadeDeMedida() {
		// TODO Auto-generated method stub
		return this.unidadeDeMedida;
	}

	@Override
	public double getKg() {
		// TODO Auto-generated method stub
		return 0;
	}

}
