package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import entidades.ListaDeCompras;
import entidadesItem.Item;

public class ListaDeComprasTest {

	@Test
	public void testListaDeCompras() {
		ListaDeCompras lista = new ListaDeCompras("feira", 1);
	}

	@Test
	public void testAdicionaCompra() {
		ListaDeCompras lista = new ListaDeCompras("feira", 1);
		Item item = null;
		lista.adicionaCompra(2, item);
	}

	@Test
	public void testFinalizaLista() {
		ListaDeCompras lista = new ListaDeCompras("feira", 1);
		Item item = null;
		lista.adicionaCompra(2, item);
		lista.finalizaLista("feirao", 100);
	}
}
