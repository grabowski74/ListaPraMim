package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.Facade;

public class FacadeTest {

	@Test
	public void testFacade() {
		Facade facade = new Facade();
	}

	@Test
	public void testAdicionaItemPorQtd() {
		Facade facade = new Facade();
		assertEquals(1, facade.adicionaItemPorQtd("feijao", "alimento industrializado", 3, "sacos", "feirao", 2.56));
	}
	
	@Test (expected = NullPointerException.class)
	public void testAdicionaItemPorQtdSemNome() {
		Facade facade = new Facade();
		facade.adicionaItemPorQtd("", "alimento industrializado", 3, "sacos", "feirao", 2.56);
	}
	
	@Test (expected = NullPointerException.class)
	public void testAdicionaItemPorQtdSemCategoria() {
		Facade facade = new Facade();
		facade.adicionaItemPorQtd("feijao", "", 3, "sacos", "feirao", 2.56);
	}
	
	@Test (expected = NullPointerException.class)
	public void testAdicionaItemPorQtdSemUnidade() {
		Facade facade = new Facade();
		facade.adicionaItemPorQtd("feijao", "alimento industrializado", 3, "", "feirao", 2.56);
	}
	
	@Test (expected = NullPointerException.class)
	public void testAdicionaItemPorQtdSemLocalDeCompra() {
		Facade facade = new Facade();
		facade.adicionaItemPorQtd("feijao", "alimento industrializado", 3, "sacos", "", 2.56);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdComQntNegativa() {
		Facade facade = new Facade();
		facade.adicionaItemPorQtd("feijao", "alimento industrializado", -3, "sacos", "feirao", 2.56);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdComPrecoNegativa() {
		Facade facade = new Facade();
		facade.adicionaItemPorQtd("feijao", "alimento industrializado", 3, "sacos", "feirao", -2.56);
	}

	@Test
	public void testAdicionaItemPorQuilo() {
		Facade facade = new Facade();
		assertEquals(1, facade.adicionaItemPorQuilo("soja", "alimento nao industrializado", 2.50, "feirao", 4.65));
	}

	@Test
	public void testAdicionaItemPorUnidade() {
		Facade facade = new Facade();
		assertEquals(1, facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 0.98));
	}

	@Test
	public void testExibeItem() {
		Facade facade = new Facade();
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		assertEquals("1. sabonete, higiene pessoal, Preco: <feirao, R$ 2,43;>", facade.exibeItem(1));
	}

	@Test
	public void testAtualizaItem() {
		Facade facade = new Facade();
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.atualizaItem(1, "nome", "sabao");
	}
	
	@Test (expected = NullPointerException.class)
	public void testAtualizaItemSemNome() {
		Facade facade = new Facade();
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.atualizaItem(1, "", "sabao");
	}
	
	@Test (expected = NullPointerException.class)
	public void testAtualizaItemSemAtributo() {
		Facade facade = new Facade();
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.atualizaItem(1, "nome", "");
	}

	@Test
	public void testAdicionaPrecoItem() {
		Facade facade = new Facade();
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaPrecoItem(1, "ofertao", 4.56);
	}
	
	@Test (expected = NullPointerException.class)
	public void testAdicionaPrecoItemSemLocal() {
		Facade facade = new Facade();
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaPrecoItem(1, "", 4.56);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAdicionaPrecoItemComPrecoNegativo() {
		Facade facade = new Facade();
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaPrecoItem(1, "ofertao", -4.56);
	}

	@Test
	public void testDeletaItem() {
		Facade facade = new Facade();
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.deletaItem(1);
	}

	@Test
	public void testGetItem() {
		Facade facade = new Facade();
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		assertEquals("1. sabonete, higiene pessoal, Preco: <feirao, R$ 2,43;>", facade.getItem(0));
	}

	@Test
	public void testGetItemPorCategoria() {
		Facade facade = new Facade();
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		assertEquals("1. sabonete, higiene pessoal, Preco: <feirao, R$ 2,43;>", facade.getItemPorCategoria("higiene pessoal", 0));
	}

	@Test
	public void testGetItemPorMenorPreco() {
		Facade facade = new Facade();
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaItemPorUnidade("esponja", "limpeza", 2, "feirao", 0.76);
		assertEquals("2. esponja, limpeza, Preco: <feirao, R$ 0,76;>", facade.getItemPorMenorPreco(0));
	}

	@Test
	public void testGetItemPorPesquisa() {
		Facade facade = new Facade();
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		assertEquals("1. sabonete, higiene pessoal, Preco: <feirao, R$ 2,43;>", facade.getItemPorPesquisa("sabo", 0));
	}

	@Test
	public void testAdicionaListaDeCompras() {
		Facade facade = new Facade();
		assertEquals("compras do sabado",facade.adicionaListaDeCompras("compras do sabado"));
	}
	
	@Test (expected = NullPointerException.class)
	public void testAdicionaListaDeComprasSemNome() {
		Facade facade = new Facade();
		facade.adicionaListaDeCompras("");
	}

	@Test
	public void testPesquisaListaDeCompras() {
		Facade facade = new Facade();
		facade.adicionaListaDeCompras("sabadao");
		assertEquals("sabadao", facade.pesquisaListaDeCompras("sabadao"));
	}

	@Test
	public void testAdicionaCompraALista() {
		Facade facade = new Facade();
		facade.adicionaListaDeCompras("sabadao");
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaCompraALista("sabadao", 2, 1);
	}

	@Test
	public void testFinalizarListaDeCompras() {
		Facade facade = new Facade();
		facade.adicionaListaDeCompras("sabadao");
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaCompraALista("sabadao", 2, 1);
		facade.finalizarListaDeCompras("sabadao", "feirao", 100);
	}

	@Test
	public void testPesquisaCompraEmLista() {
		Facade facade = new Facade();
		facade.adicionaListaDeCompras("sabadao");
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaCompraALista("sabadao", 2, 1);
		assertEquals("2 sabonete, higiene pessoal", facade.pesquisaCompraEmLista("sabadao", 1));
	}

	@Test
	public void testAtualizaCompraDeLista() {
		Facade facade = new Facade();
		facade.adicionaListaDeCompras("sabadao");
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaCompraALista("sabadao", 2, 1);
		facade.atualizaCompraDeLista("sabadao", 1, "adiciona", 2);
	}

	@Test
	public void testGetItemLista() {
		Facade facade = new Facade();
		facade.adicionaListaDeCompras("sabadao");
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaCompraALista("sabadao", 2, 1);
		assertEquals("2 sabonete, higiene pessoal", facade.getItemLista("sabadao", 0));
	}

	@Test
	public void testDeletaCompraDeLista() {
		Facade facade = new Facade();
		facade.adicionaListaDeCompras("sabadao");
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaCompraALista("sabadao", 2, 1);
		facade.deletaCompraDeLista("sabadao", 1);
	}

	@Test
	public void testGetItemListaPorData() {
		Facade facade = new Facade();
		facade.adicionaListaDeCompras("sabadao");
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaCompraALista("sabadao", 2, 1);
		assertEquals("sabadao", facade.getItemListaPorData("20/07/2018", 0));
	}

	@Test
	public void testGetItemListaPorItem() {
		Facade facade = new Facade();
		facade.adicionaListaDeCompras("sabadao");
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaCompraALista("sabadao", 2, 1);
		assertEquals("20/07/2018 - sabadao", facade.getItemListaPorItem(1, 0));
	}

	@Test
	public void testPesquisaListasDeComprasPorData() {
		Facade facade = new Facade();
		facade.adicionaListaDeCompras("sabadao");
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaCompraALista("sabadao", 2, 1);
		assertEquals("[sabadao]", facade.pesquisaListasDeComprasPorData("20/07/2018"));
	}

	@Test
	public void testPesquisaListasDeComprasPorItem() {
		Facade facade = new Facade();
		facade.adicionaListaDeCompras("sabadao");
		facade.adicionaItemPorUnidade("sabonete", "higiene pessoal", 2, "feirao", 2.43);
		facade.adicionaCompraALista("sabadao", 2, 1);
		assertEquals("[sabadao]", facade.pesquisaListasDeComprasPorItem(1));
	}

}
