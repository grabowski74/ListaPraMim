package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.Controller;
import controllers.ControllerItens;

public class ControllerItensTest {

	@Test
	public void testControllerItens() {
		ControllerItens controller = new ControllerItens();
	}

	@Test
	public void testAdicionaItemPorQtd() {
		ControllerItens controller = new ControllerItens();
		assertEquals(1, controller.adicionaItemPorQtd("feijao", "alimento industrializado", "feirao", 2.56, 3, "sacos"));
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

}
