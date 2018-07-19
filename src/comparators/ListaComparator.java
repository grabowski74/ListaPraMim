package comparators;
import java.util.Comparator;

import entidades.Compra;

public class ListaComparator implements Comparator<Compra>{

	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getCategoria().equals(o2.getCategoria())) {
			return o1.getNome().compareTo(o2.getNome());
		}
		return categoria(o1.getCategoria()) - categoria(o2.getCategoria());
	}
	
	private int categoria(String categoria) {
		if (categoria.equals("higiene pessoal")) {
			return 1;
		} else if (categoria.equals("limpeza")) {
			return 2;
		} else if (categoria.equals("alimento industrializado")) {
			return 3;
		} else if (categoria.equals("alimento nao industrializado")) {
			return 4;
		}
		return 0;
	}
	
}
