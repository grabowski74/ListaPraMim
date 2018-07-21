package controllers;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparators.StringComparatorListas;
import entidades.ListaDeCompras;
import entidadesItem.Item;
/**
 * Representacao de um sitema de cadastro de lista de compras, nesse sistema e possivel cadastrar,
 * alterar, editar, adicionar e deletar listas e produtos. ListaPraMim
 * 
 * @author Matheus Silva Araujo - 117210375
 * @author Gabriel Guimaraes Almeida
 * 
 * Projeto de Laboratorio - Laboratorio de Programacao 2 - 2018.1
 *
 */
public class ControllerListas {

	private ListaDeCompras listaDeCompras;
	private Map<String, ListaDeCompras> mapaDasListas;
	private Comparator<String> comparador;
	private String data;
	
	/**
	 * Realiza a construcao do ControllerListas do sistema, todo ControllerListas instacia um mapa de 
	 * listas de compras.
	 */
	public ControllerListas() {
		this.mapaDasListas = new HashMap<>();
		data = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}
	
	/**
	 * Realiza a operacao de adicionar uma lista de itens ao sistema
	 * @param descritorLista e o nome da referida lista
	 * @return retorna a descricao da lista cadastrada
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		listaDeCompras = new ListaDeCompras(descritorLista);
		mapaDasListas.put(descritorLista, listaDeCompras);
		return descritorLista;
	}
	
	/**
	 * Realiza a operacao de pesquisar listas cadastradas no sistema a partir do seu nome
	 * @param descritorLista e o nome da referida lista
	 * @return retorna o status da lista desejada
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		if (descritorLista.equals(null) || descritorLista.trim().equals("")) {
			throw new NullPointerException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		}
		if (!mapaDasListas.containsKey(descritorLista)) {
			throw new NullPointerException("Erro na pesquisa de compra: lista de compras nao existe.");
		}
		
		String aux = "";
		for (String descritor : mapaDasListas.keySet()) {
			if (descritor.startsWith(descritorLista)) {
				aux = descritor;
			}
		}
		return aux;
	}
	
	/**
	 * Realiza a operacao de adicionar uma compra a uma lista ja cadastrada
	 * @param descritorLista e o nome da referida lista
	 * @param qnt e a quantidade do item a ser adicionado
	 * @param id e o numero de identificacao unica do item desejado
	 */
	public void adicionaCompraALista(String descritorLista, int qnt, Item item) {
		if (mapaDasListas.containsKey(descritorLista)) {
			mapaDasListas.get(descritorLista).adicionaCompra(qnt, item);
		}
	}
	
	/**
	 * Realiza a operacao de finalizar uma lista de compras
	 * @param descritorLista e o nome da referida lista
	 * @param localDaCompra e o local onde a compra foi realizada
	 * @param valor e o valor final da compra
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valor) {
		if (descritorLista.equals(null) || descritorLista.trim().equals("")) {
			throw new NullPointerException(
					"Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}
		if (localDaCompra.equals(null) || localDaCompra.trim().equals("")) {
			throw new NullPointerException(
					"Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException(
					"Erro na finalizacao de lista de compras: valor final da lista invalido.");
		}
		mapaDasListas.get(descritorLista).finalizaLista(localDaCompra, valor);
	}
	
	/**
	 * Realiza a operacao de pesquisar uma certa compra em uma lista
	 * @param descritorLista e o nome da lista referida
	 * @param id e o numero de identificacao unica do item
	 * @return retorna o status da compra
	 */
	public String pesquisaCompraEmLista(String descritorLista, int id) {
		if (id < 0) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: item id invalido.");
		}
		if (descritorLista.equals(null) || descritorLista.trim().equals("")) {
			throw new NullPointerException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		}
		return mapaDasListas.get(descritorLista).pesquisa(id);
	}
	
	/**
	 * Realiza a operacao de atualizar uma certa compra em uma lista
	 * @param descritorLista e o nome da referida lista
	 * @param id e o numero de identificacao unica do item
	 * @param operacao e a operacao a ser realizada, pode ser de adicionar ou diminuir a quantidade de itens
	 * @param qnt e quantidade a ser modificada do item
	 */
	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int qnt) {
		mapaDasListas.get(descritorLista).atualizaCompra(id, operacao, qnt);
	}
	
	/**
	 * Realiza a operacao de exibir um item cadastrado em uma lista de compras
	 * @param descritorLista e o nome da referida lista
	 * @param posicaoItem e a o posicao do referido item na lista
	 * @return retorna o status da compra na lista
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		return mapaDasListas.get(descritorLista).getItem(posicaoItem);
	}
	
	/**
	 * Realiza a operacao de deletar uma compra de uma lista de compras
	 * @param descritorLista e o nome da referida lista
	 * @param id e o numero de identificacao unica do item
	 */
	public void deletaCompraDaLista(String descritorLista, int id) {
		if (descritorLista.equals(null) || descritorLista.trim().equals("")) {
			throw new NullPointerException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
		}
		mapaDasListas.get(descritorLista).deleta(id);
	}
	
	/**
	 * Realiza a operacao de exibir um item em uma compra a partir da sua data
	 * @param data e data quando foi cadastrado a compra na lista
	 * @param posicao e a posicao do item na lista
	 * @return retorna o status da compra
	 */
	public String getItemListaPorData(String data, int posicao) {
		this.comparador = new StringComparatorListas();
		List<String> listas = new ArrayList<>();
		for (ListaDeCompras lista : mapaDasListas.values()) {
			if (data.equals(lista.getData()) && !listas.contains(lista.getDescritor())) {
				listas.add(lista.getDescritor());
			}
		}

		Collections.sort(listas, comparador);

		return listas.get(posicao);
	}
	
	/**
	 * Realiza a operacao de exibir o item na lista de compras a partir da sua posicao
	 * @param id e o numero de identificacao unica do item
	 * @param posicaoLista e a posicao na lista do referido item
	 * @return retorna o status da compra na lista
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		this.comparador = new StringComparatorListas();
		List<String> listas = new ArrayList<>();
		for (ListaDeCompras lista : mapaDasListas.values()) {
			if (lista.contemItem(id)) {
				listas.add(lista.getDescritor());
			}
		}
		
		Collections.sort(listas, comparador);
		
		return mapaDasListas.get(listas.get(posicaoLista)).getData() + " - " + listas.get(posicaoLista);
	}
	
	/**
	 * Realiza a operacao de pesquisar uma lista de compras a partir de sua data
	 * @param data e a data desejada a ser pesquisada
	 * @return retorna o status da lista
	 */
	public String pesquisaListaDeComprasPorData(String data) {
		if (data.equals(null) || data.trim().equals("")) {
			throw new NullPointerException("Erro na pesquisa de compra: data nao pode ser vazia ou nula.");
		}
		if (!data.matches(this.data)) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: data em formato invalido, tente dd/MM/yyyy");
		}
		this.comparador = new StringComparatorListas();
		List<String> listas = new ArrayList<>();
		for (ListaDeCompras lista : mapaDasListas.values()) {
			if (data.equals(lista.getData()) && !listas.contains(lista.getDescritor())) {
				listas.add(lista.getDescritor());
			}
		}

		Collections.sort(listas, comparador);
		return listas.toString();
	}
	
	/**
	 * Realiza a operacao de pesquisar uma lista de compras a partir de seus itens cadastrados
	 * @param id e o numero de identificacao unica do item
	 * @return retorna o status da lista de compras
	 */
	public String pesquisaListaDeComprasPorItem(int id) {
		this.comparador = new StringComparatorListas();
		List<String> listas = new ArrayList<>();
		for (ListaDeCompras lista : mapaDasListas.values()) {
			if (lista.contemItem(id)) {
				listas.add(lista.getDescritor());
			}
		}
		if (listas.size() == 0) {
			throw new NullPointerException("Erro na pesquisa de compra: compra nao encontrada na lista.");
		}
		
		Collections.sort(listas, comparador);
		
		return listas.toString();
	}

}
