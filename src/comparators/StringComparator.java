package comparators;
/**
 * 
 * Representa�ao da classe auxiliar StringComparator que implementa a interface nativa

 * Comparator, cujo a sua funcao e ordenar os itens de acordo com o seu nome.
 * 
 * @author Matheus Silva Araujo
 * @author Gabriel Guimaraes de Almeida
 * 
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim 
 * 
 */
import java.util.Comparator;

import entidades.Item;

public class StringComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}

