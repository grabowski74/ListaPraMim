package source;

import java.util.Comparator;

public class StringComparator implements Comparator<Itens> {

	@Override
	public int compare(Itens o1, Itens o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
