package source;

public class Compra {

	private int qnt;
	private Item item;

	public Compra(int qnt, Item item) {
		this.item = item;
		this.qnt = qnt;
	}

	public int getId() {
		return this.item.getId();
	}

	public void atualiza(String operacao, int qnt) {
		if (operacao.equals("adiciona")) {
			this.qnt += qnt;
		} else {
			this.qnt -= qnt;
		}
	}

	public String toString() {

		String res = this.qnt + " " + item.getNome() + ", " + item.getCategoria();
		if (item instanceof ItemPorQnt) {
			res += ", " + ((ItemPorQnt) item).getQuantidade() + " " + ((ItemPorQnt) item).getUnidadeDeMedida();
		}
		return res;
	}

	public void atualiza(int qnt, String operacao) {
		if ("adiciona".equals(operacao)) {
			this.qnt += qnt;
		} else if ("diminui".equals(operacao)) {
			this.qnt -= qnt;
		}
	}

	public int getQnt() {
		return this.qnt;
	}

	public String getCategoria() {
		return this.item.getCategoria();
	}

	public String getNome() {
		return this.item.getNome();
	}

}
