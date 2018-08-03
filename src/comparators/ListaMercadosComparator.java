package comparators;

import java.util.Comparator;

import entidades.Compra;

public class ListaMercadosComparator implements Comparator<Object>{
	
	private Comparator<Compra> comparador = new StringComparatorCompras();

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Compra && o2 instanceof Compra) {
			return comparador.compare((Compra) o1, (Compra) o2);
		}
		return 0;
	}

	
	

}
