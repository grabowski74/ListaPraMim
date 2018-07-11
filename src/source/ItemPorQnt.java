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
		if("qnt".equals(atributo)) {
			this.qnt = Integer.parseInt(novoValor);
		} else if("unidadeDeMedida".equals(atributo)) {
			this.unidadeDeMedida = novoValor;
		}
		
	}

}
