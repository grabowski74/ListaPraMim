package comparators;

import java.util.Comparator;

public class ListaMercadosComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.startsWith("- ") && o2.startsWith("- ")) {
			return o1.compareTo(o2);
		}
		return 0;
	}

}
