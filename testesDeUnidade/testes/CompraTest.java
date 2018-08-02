package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import entidades.Compra;
import entidadesItem.Item;

public class CompraTest {

	@Test
	public void testCompra() {
		Item item = null;
		Compra compra = new Compra(1, item);
	}

	@Test
	public void testAtualiza() {
		Item item = null;
		Compra compra = new Compra(1, item);
		compra.atualiza("adiciona", 3);
	}

	@Test
	public void testGetQnt() {
		Item item = null;
		Compra compra = new Compra(1, item);
		assertEquals(1, compra.getQnt());
	}

}
