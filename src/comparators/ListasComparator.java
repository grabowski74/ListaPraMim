package comparators;

import java.util.Comparator;
import java.util.List;

public class ListasComparator implements Comparator<List<String>>{

	@Override
	public int compare(List<String> o1, List<String> o2) {
		return o1.get(0).split(":")[1].compareTo(o2.get(0).split(":")[1]);
	}

}
