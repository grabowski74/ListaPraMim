package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.Controller;
import controllers.Controller;

public class ControllerTest {

	@Test
	public void testController() {
		Controller controller = new Controller();
	}

	@Test
	public void testAdicionaItemPorQtd() {
		Controller controller = new Controller();
		assertEquals(1, controller.adiconaItemPorQtd("feijao", "alimento industrializado", 3, "sacos", "feirao", 2.56));
	}
	
	@Test (expected = NullPointerException.class)
	public void testAdicionaItemPorQtdSemNome() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("", "alimento industrializado", 3, "sacos", "feirao", 2.56);
	}
	
	@Test (expected = NullPointerException.class)
	public void testAdicionaItemPorQtdSemCategoria() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("feijao", "", 3, "sacos", "feirao", 2.56);
	}
	
	@Test (expected = NullPointerException.class)
	public void testAdicionaItemPorQtdSemUnidade() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("feijao", "alimento industrializado", 3, "", "feirao", 2.56);
	}
	
	@Test (expected = NullPointerException.class)
	public void testAdicionaItemPorQtdSemLocalDeCompra() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("feijao", "alimento industrializado", 3, "sacos", "", 2.56);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdComQntNegativa() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("feijao", "alimento industrializado", -3, "sacos", "feirao", 2.56);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdComPrecoNegativa() {
		Controller controller = new Controller();
		controller.adiconaItemPorQtd("feijao", "alimento industrializado", 3, "sacos", "feirao", -2.56);
	}

	@Test
	public void testAdicionaItemPorQuilo() {
		Controller controller = new Controller();
		assertEquals(1, controller.adicionaItemPorQuilo("soja", "alimento nao industrializado", 2.50, "feirao", 4.65));
	}

	@Test
	public void testAdicionaItemPorUnidade() {
		Controller controller = new Controller();
		assertEquals(1, controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 0.98));
	}

	@Test
	public void testExibeItem() {
		Controller controller = new Controller();
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		assertEquals("1. sabonete, higiene pessoal, Preco: <feirao, R$ 2,43;>", controller.exibeItem(1));
	}

	@Test
	public void testAtualizaItem() {
		Controller controller = new Controller();
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.atualizaItem(1, "nome", "sabao");
	}
	
	@Test (expected = NullPointerException.class)
	public void testAtualizaItemSemNome() {
		Controller controller = new Controller();
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.atualizaItem(1, "", "sabao");
	}
	
	@Test (expected = NullPointerException.class)
	public void testAtualizaItemSemAtributo() {
		Controller controller = new Controller();
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.atualizaItem(1, "nome", "");
	}

	@Test
	public void testAdicionaPrecoItem() {
		Controller controller = new Controller();
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.adicionaPrecoItem(1, "ofertao", 4.56);
	}
	
	@Test (expected = NullPointerException.class)
	public void testAdicionaPrecoItemSemLocal() {
		Controller controller = new Controller();
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.adicionaPrecoItem(1, "", 4.56);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAdicionaPrecoItemComPrecoNegativo() {
		Controller controller = new Controller();
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.adicionaPrecoItem(1, "ofertao", -4.56);
	}

	@Test
	public void testDeletaItem() {
		Controller controller = new Controller();
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.deletaItem(1);
	}

	@Test
	public void testGetItem() {
		Controller controller = new Controller();
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		assertEquals("1. sabonete, higiene pessoal, Preco: <feirao, R$ 2,43;>", controller.getItem(0));
	}

	@Test
	public void testGetItemPorCategoria() {
		Controller controller = new Controller();
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		assertEquals("1. sabonete, higiene pessoal, Preco: <feirao, R$ 2,43;>", controller.getItemPorCategoria("higiene pessoal", 0));
	}

	@Test
	public void testGetItemPorMenorPreco() {
		Controller controller = new Controller();
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		controller.adicionaItemPorUnidade("esponja", "limpeza", 2, "feirao", 0.76);
		assertEquals("2. esponja, limpeza, Preco: <feirao, R$ 0,76;>", controller.getItemPorMenorPreco(0));
	}

	@Test
	public void testGetItemPorPesquisa() {
		Controller controller = new Controller();
		controller.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		assertEquals("1. sabonete, higiene pessoal, Preco: <feirao, R$ 2,43;>", controller.getItemPorPesquisa("sabo", 0));
	}

	@Test
	public void testAdicionaListaDeCompras() {
		Controller controller = new Controller();
		assertEquals("compras do sabado",controller.adicionaListaDeCompras("compras do sabado"));
	}
	
	@Test (expected = NullPointerException.class)
	public void testAdicionaListaDeComprasSemNome() {
		Controller controller = new Controller();
		controller.adicionaListaDeCompras("");
	}

	@Test
	public void testPesquisaListaDeCompras() {
		Controller controller = new Controller();
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
