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
		String res = this.qnt + " " + this.item.getNome() + ", " + this.item.getCategoria();
		
		if(this.item.getQnt()!= 0){
			res += ", " + this.item.getQnt() + " " + this.item.getUnidade();
		}
		return res;
	}

	public void atualiza(int qnt, String operacao) {
		if("adiciona".equals(operacao)){
			this.qnt += qnt;
		} else if("diminui".equals(operacao)){
			this.qnt -= qnt;
		} 
	}

	public int getQnt() {
		return this.qnt;
	}

	
}
