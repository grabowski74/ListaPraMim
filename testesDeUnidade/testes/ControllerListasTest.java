package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.Controller;
import controllers.ControllerListas;
import controllers.ControllerListas;

public class ControllerListasTest {

	@Test
	public void testControllerListas() {
		ControllerListas controller = new ControllerListas();
	}

	@Test
	public void testAdicionaListaDeCompras() {
		ControllerListas controller = new ControllerListas();
		assertEquals("compras do sabado",controller.adicionaListaDeCompras("compras do sabado"));
	}
	
	@Test (expected = NullPointerException.class)
	public void testAdicionaListaDeComprasSemNome() {
		ControllerListas controller = new ControllerListas();
		controller.adicionaListaDeCompras("");
	}

	@Test
	public void testPesquisaListaDeCompras() {
		ControllerListas controller = new ControllerListas();
		controller.adicionaListaDeCompras("sabadao");
		assertEquals("sabadao", controller.pesquisaListaDeCompras("sabadao"));
	}

	@Test
	public void testAdicionaCompraALista() {
		Controller controller = new Controller();
		controller.adicionaListaDeCompras("sabadao");
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.adicionaCompraALista("sabadao", 2, 1);
	}

	@Test
	public void testFinalizarListaDeCompras() {
		Controller controller = new Controller();
		controller.adicionaListaDeCompras("sabadao");
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.adicionaCompraALista("sabadao", 2, 1);
		controller.finalizarListaDeCompras("sabadao", "feirao", 100);
	}

	@Test
	public void testPesquisaCompraEmLista() {
		Controller controller = new Controller();
		controller.adicionaListaDeCompras("sabadao");
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.adicionaCompraALista("sabadao", 2, 1);
		assertEquals("2 sabonete, higiene pessoal", controller.pesquisaCompraEmLista("sabadao", 1));
	}

	@Test
	public void testAtualizaCompraDeLista() {
		Controller controller = new Controller();
		controller.adicionaListaDeCompras("sabadao");
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.adicionaCompraALista("sabadao", 2, 1);
		controller.atualizaCompraDeLista("sabadao", 1, "adiciona", 2);
	}

	@Test
	public void testGetItemLista() {
		Controller controller = new Controller();
		controller.adicionaListaDeCompras("sabadao");
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.adicionaCompraALista("sabadao", 2, 1);
		assertEquals("2 sabonete, higiene pessoal", controller.getItemLista("sabadao", 0));
	}

	@Test
	public void testDeletaCompraDeLista() {
		Controller controller = new Controller();
		controller.adicionaListaDeCompras("sabadao");
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.adicionaCompraALista("sabadao", 2, 1);
		controller.deletaCompraDaLista("sabadao", 1);
	}

	@Test
	public void testGetItemListaPorData() {
		Controller controller = new Controller();
		controller.adicionaListaDeCompras("sabadao");
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.adicionaCompraALista("sabadao", 2, 1);
		assertEquals("sabadao", controller.getItemListaPorData("20/07/2018", 0));
	}

	@Test
	public void testGetItemListaPorItem() {
		Controller controller = new Controller();
		controller.adicionaListaDeCompras("sabadao");
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.adicionaCompraALista("sabadao", 2, 1);
		assertEquals("20/07/2018 - sabadao", controller.getItemListaPorItem(1, 0));
	}

	@Test
	public void testPesquisaListasDeComprasPorItem() {
		Controller controller = new Controller();
		controller.adicionaListaDeCompras("sabadao");
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.adicionaCompraALista("sabadao", 2, 1);
		assertEquals("[sabadao]", controller.pesquisaListaDeComprasPorItem(1));
	}

}
