package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import source.Controller;

public class ControllerTest {

	@Test
	public void testController() {
		Controller controller = new Controller();
	}

	@Test
	public void testAdiconaItemPorQtd() {
		Controller controller = new Controller();
		assertEquals(controller.adiconaItemPorQtd("Feijao", "alimento industrializado", 3, "sacos", "Feirao", 2.69), 1);
	}

	@Test
	public void testAdicionaItemPorQuilo() {
		Controller controller = new Controller();
		assertEquals(controller.adicionaItemPorQuilo("Maça", "alimento nao industrializado", 5.00, "Castelinho", 3.68), 1);
	}

	@Test
	public void testAdicionaItemPorUnidade() {
		Controller controller = new Controller();
		assertEquals(controller.adicionaItemPorUnidade("Detergente", "limpeza", 1, "Ofertao", 2.69), 1);
	}

	@Test
	public void testAtualizaItem() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("Feijao", "alimento industrializado", 3, "sacos", "Feirao", 2.69);
		controller.atualizaItem(1, "nome", "Arroz");
	}

	@Test
	public void testAdicionaPrecoItem() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("Feijao", "alimento industrializado", 3, "sacos", "Feirao", 2.69);
		controller.adicionaPrecoItem(1, "Ofertao", 4.69);
	}

	@Test
	public void testDeletaItem() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("Feijao", "alimento industrializado", 3, "sacos", "Feirao", 2.69);
		controller.deletaItem(1);		
	}

	@Test
	public void testExibeItem() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("Feijao", "alimento industrializado", 3, "sacos", "Feirao", 2.69);
		assertEquals(controller.exibeItem(1), "1. Feijao, alimento industrializado, 3 sacos, Preco: <Feirao, R$ 2,69;>");
	}

	@Test
	public void testGetItem() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("Feijao", "alimento industrializado", 3, "sacos", "Feirao", 2.69);
		assertEquals(controller.getItem(0), "1. Feijao, alimento industrializado, 3 sacos, Preco: <Feirao, R$ 2,69;>");
	}

	@Test
	public void testGetItemPorCategoria() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("Feijao", "alimento industrializado", 3, "sacos", "Feirao", 2.69);
		assertEquals(controller.getItemPorCategoria("alimento industrializado", 0), "1. Feijao, alimento industrializado, 3 sacos, Preco: <Feirao, R$ 2,69;>");
	}

	@Test
	public void testGetItemPorMenorPreco() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("Feijao", "alimento industrializado", 3, "sacos", "Feirao", 2.69);
		controller.adiconaItemPorQtd("Arroz", "alimento industrializado", 3, "sacos", "Feirao", 2.89);
		assertEquals(controller.getItemPorMenorPreco(0),"1. Feijao, alimento industrializado, 3 sacos, Preco: <Feirao, R$ 2,69;>");
	}

	@Test
	public void testGetItemPorPesquisa() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("Feijao", "alimento industrializado", 3, "sacos", "Feirao", 2.69);
		controller.adiconaItemPorQtd("Arroz", "alimento industrializado", 3, "sacos", "Feirao", 2.89);
		assertEquals(controller.getItemPorPesquisa("Feijao", 1), "");
	}

	@Test
	public void testAdicionaListaDeCompras() {
		fail("Not yet implemented");
	}

	@Test
	public void testPesquisaListaDeCompras() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionaCompraALista() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalizarListaDeCompras() {
		fail("Not yet implemented");
	}

	@Test
	public void testPesquisaCompraEmLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testAtualizaCompraDeLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItemLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletaCompraDaLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimirListaDeCompras() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItemListaPorData() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItemListaPorItem() {
		fail("Not yet implemented");
	}

}
