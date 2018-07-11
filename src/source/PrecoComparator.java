package source;

import java.util.Comparator;

public class PrecoComparator implements Comparator<Itens> {

	@Override
	public int compare(Itens o1, Itens o2) {
		if(o1.getPreco() < o2.getPreco()) {
			return -1;
		}
		if(o1.getPreco() > o2.getPreco()) {
			return 1;
		}
		return 0;
	}

}
