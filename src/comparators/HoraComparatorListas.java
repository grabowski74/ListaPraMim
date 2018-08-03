package comparators;

import java.util.Comparator;

import entidades.ListaDeCompras;

public class HoraComparatorListas implements Comparator<ListaDeCompras>{

	@Override
	public int compare(ListaDeCompras o1, ListaDeCompras o2) {
		return o1.getHora().compareTo(o2.getHora());
	}

	

}
