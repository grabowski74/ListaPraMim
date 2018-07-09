package source;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControllerItensTest {
	
	

	@Test
	public void testControllerItens() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionaItemPorQtd() {
		ControllerItens controller = new ControllerItens();
		assertEquals(controller.adicionaItemPorQtd("feijao", "alimentos", 3, "sacos", "Feirao", 3.44), "id1");
		
	}

	@Test
	public void testAdicionaItemPorQuilo() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionaItemPorUnidade() {
		fail("Not yet implemented");
	}

}
