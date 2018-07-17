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
	
	public String toString() {
		return this.qnt + " " + this.item.getNome() + ", " + this.item.getCategoria();
	}

	public void atualiza(int qnt) {
		this.qnt = qnt;
	}

	
}
