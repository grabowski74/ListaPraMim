package comparators;
/**
 * 
 * Representa�ao da classe auxiliar PrecoComparator que implementa a interface nativa

 * Comparator, cujo a sua funcao e ordenar os itens de acordo com o seu preco.
 * 
 * @author Matheus Silva Araujo
 * @author Gabriel Guimaraes de Almeida
 * 
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim 
 * 
 */
import java.util.Comparator;


import entidadesItem.Item;

public class PrecoComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		if(o1.getPreco() < o2.getPreco()) {
			return -1;
		}
		if(o1.getPreco() > o2.getPreco()) {
			return 1;
		}
		return 0;
	}

}

