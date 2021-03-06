package controllers;

import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparators.HoraComparatorListas;
import comparators.StringComparator;
import comparators.StringComparatorCompras;
import comparators.StringComparatorListas;
import comparators.ListaMercadosComparator;
import comparators.ListasComparator;
import entidades.Compra;
import entidades.ListaDeCompras;
import entidadesItem.Item;

/**
 * Representacao de um sitema de cadastro de lista de compras, nesse sistema e
 * possivel cadastrar, alterar, editar, adicionar e deletar listas e produtos.
 * ListaPraMim
 * 
 * 
 * @author Matheus Silva Araujo - 117210375
 * @author Gabriel Guimaraes Almeida
 * 
 * 
 *         Projeto de Laboratorio - Laboratorio de Programacao 2 - 2018.1
 *
 * 
 */
public class ControllerListas {

	private ListaDeCompras listaDeCompras;
	private Map<String, ListaDeCompras> mapaDasListas;

	private ControllerItens listaDeItens;
	private Comparator<String> comparador1;
	private Comparator<ListaDeCompras> comparador2;
	private Comparator<Object> comparador3;
	private Comparator<List<String>> comparador4;
	private int id;
	private String data;
	private File diretorio;

	/**
	 * Realiza a construcao do ControllerListas do sistema, todo ControllerListas
	 * instacia um mapa de listas de compras.
	 * 
	 */
	public ControllerListas() {
		this.mapaDasListas = new HashMap<>();
		data = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		this.id = 0;
	}

	/**
	 * Realiza a operacao de adicionar uma lista de itens ao sistema
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * 
	 * @return retorna a descricao da lista cadastrada
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		listaDeCompras = new ListaDeCompras(descritorLista, id);
		mapaDasListas.put(descritorLista, listaDeCompras);
		id++;
		return descritorLista;
	}

	/**
	 * Realiza a operacao de pesquisar listas cadastradas no sistema a partir do seu
	 * nome
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * 
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
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * @param qnt
	 *            e a quantidade do item a ser adicionado
	 * @param id
	 *            e o numero de identificacao unica do item desejado
	 * 
	 */
	public void adicionaCompraALista(String descritorLista, int qnt, Item item) {
		if (mapaDasListas.containsKey(descritorLista)) {
			mapaDasListas.get(descritorLista).adicionaCompra(qnt, item);
		}
	}

	/**
	 * Realiza a operacao de finalizar uma lista de compras
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * @param localDaCompra
	 *            e o local onde a compra foi realizada
	 * @param valor
	 *            e o valor final da compra
	 * 
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
	 * 
	 * @param descritorLista
	 *            e o nome da lista referida
	 * @param id
	 *            e o numero de identificacao unica do item
	 * 
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
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * @param id
	 *            e o numero de identificacao unica do item
	 * @param operacao
	 *            e a operacao a ser realizada, pode ser de adicionar ou diminuir a
	 *            quantidade de itens
	 * @param qnt
	 *            e quantidade a ser modificada do item
	 */

	public void atualizaCompraDeLista(String descritorLista, int id, String operacao, int qnt) {
		mapaDasListas.get(descritorLista).atualizaCompra(id, operacao, qnt);
	}

	/**
	 * Realiza a operacao de exibir um item cadastrado em uma lista de compras
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * @param posicaoItem
	 *            e a o posicao do referido item na lista
	 * @return retorna o status da compra na lista
	 */

	public String getItemLista(String descritorLista, int posicaoItem) {
		return mapaDasListas.get(descritorLista).getItem(posicaoItem);
	}

	/**
	 * Realiza a operacao de deletar uma compra de uma lista de compras
	 * 
	 * @param descritorLista
	 *            e o nome da referida lista
	 * @param id
	 *            e o numero de identificacao unica do item
	 */

	public void deletaCompraDaLista(String descritorLista, int id) {
		if (descritorLista.equals(null) || descritorLista.trim().equals("")) {
			throw new NullPointerException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
		}

		boolean a = false;
		for (ListaDeCompras b : mapaDasListas.values()) {
			if (b.contemItem(id)) {
				a = true;
			}
		}
		if (a) {
			mapaDasListas.get(descritorLista).deleta(id);
		} else {
			throw new Error("compra nao encontrada na lista.");
		}
	}

	/**
	 * Realiza a operacao de exibir um item em uma compra a partir da sua data
	 * 
	 * @param data
	 *            e data quando foi cadastrado a compra na lista
	 * @param posicao
	 *            e a posicao do item na lista
	 * @return retorna o status da compra
	 */
	public String getItemListaPorData(String data, int posicao) {
		this.comparador1 = new StringComparatorListas();
		List<String> listas = new ArrayList<>();
		for (ListaDeCompras lista : mapaDasListas.values()) {
			if (data.equals(lista.getData()) && !listas.contains(lista.getDescritor())) {
				listas.add(lista.getDescritor());
			}
		}

		Collections.sort(listas, comparador1);

		return listas.get(posicao);
	}

	/**
	 * Realiza a operacao de exibir o item na lista de compras a partir da sua
	 * posicao
	 * 
	 * @param id
	 *            e o numero de identificacao unica do item
	 * @param posicaoLista
	 *            e a posicao na lista do referido item
	 * @return retorna o status da compra na lista
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		this.comparador1 = new StringComparatorListas();

		List<String> listas = new ArrayList<>();
		for (ListaDeCompras lista : mapaDasListas.values()) {
			if (lista.contemItem(id)) {
				listas.add(lista.getDescritor());
			}
		}

		Collections.sort(listas, comparador1);

		return mapaDasListas.get(listas.get(posicaoLista)).getData() + " - " + listas.get(posicaoLista);
	}

	/**
	 * Realiza a operacao de pesquisar uma lista de compras a partir de sua data
	 * 
	 * @param data
	 *            e a data desejada a ser pesquisada
	 * 
	 * @return retorna o status da lista
	 */
	public String pesquisaListaDeComprasPorData(String data) {
		if (data.equals(null) || data.trim().equals("")) {
			throw new NullPointerException("Erro na pesquisa de compra: data nao pode ser vazia ou nula.");
		}
		if (!data.matches(this.data)) {

			throw new IllegalArgumentException(
					"Erro na pesquisa de compra: data em formato invalido, tente dd/MM/yyyy");
		}
		this.comparador1 = new StringComparatorListas();

		List<String> listas = new ArrayList<>();
		for (ListaDeCompras lista : mapaDasListas.values()) {
			if (data.equals(lista.getData()) && !listas.contains(lista.getDescritor())) {
				listas.add(lista.getDescritor());
			}
		}

		Collections.sort(listas, comparador1);
		return listas.toString();
	}

	/**
	 * Realiza a operacao de pesquisar uma lista de compras a partir de seus itens
	 * cadastrados
	 * 
	 * @param id
	 *            e o numero de identificacao unica do item
	 * @return retorna o status da lista de compras
	 */
	public String pesquisaListaDeComprasPorItem(int id) {
		this.comparador1 = new StringComparatorListas();

		List<String> listas = new ArrayList<>();
		for (ListaDeCompras lista : mapaDasListas.values()) {
			if (lista.contemItem(id)) {
				listas.add(lista.getDescritor());
			}
		}
		if (listas.size() == 0) {
			throw new NullPointerException("Erro na pesquisa de compra: compra nao encontrada na lista.");
		}

		Collections.sort(listas, comparador1);

		return listas.toString();
	}
	
	/**
	 * 
	 * @param dataAtual
	 * @return
	 */
	public String geraAutomaticaUltimaLista(String dataAtual) {
		for (ListaDeCompras a : mapaDasListas.values()) {
			if (a.getID() == this.id - 1) {
				adicionaListaDeCompras("Lista automatica 1 " + dataAtual);
				for (Compra b : a.getCompras()) {
					adicionaCompraALista("Lista automatica 1 " + dataAtual, b.getQnt(), b.getItem());
				}
				break;
			}
		}
		return "Lista automatica 1 " + dataAtual;
	}
	
	/**
	 * 
	 * @param descritorItem
	 * @param dataAtual
	 * @return
	 */
	public String geraAutomaticaItem(String descritorItem, String dataAtual) {
		int cont = 0;
		boolean c = false;
		for (ListaDeCompras lista : mapaDasListas.values()) {
			if (lista.contemItem(descritorItem) && lista.getID() >= cont) {
				c = true;
				cont = lista.getID();
			}
		}
		if (c == false) {
			throw new Error(
					"Erro na geracao de lista automatica por item: nao ha compras cadastradas com o item desejado.");
		}
		for (ListaDeCompras lista : mapaDasListas.values()) {
			if (lista.getID() == cont) {
				adicionaListaDeCompras("Lista automatica 2 " + dataAtual);
				for (Compra compra : lista.getCompras()) {
					adicionaCompraALista("Lista automatica 2 " + dataAtual, compra.getQnt(), compra.getItem());
				}
				break;
			}
		}
		return "Lista automatica 2 " + dataAtual;
	}
	
	/**
	 * 
	 * @param itens
	 * @param dataAtual
	 * @return
	 */
	public String geraAutomaticaItensMaisPresentes(Collection<Item> itens, String dataAtual) {
		adicionaListaDeCompras("Lista automatica 3 " + dataAtual);
		int aparicoesListas;
		int qntAparicoes;
		for (Item item : itens) {
			aparicoesListas = 0;
			qntAparicoes = 0;
			for (ListaDeCompras lista : mapaDasListas.values()) {
				if (lista.contemItem(item.getId())) {
					aparicoesListas += 1;
					qntAparicoes += lista.getCompra(item).getQnt();
				}
			}
			if (aparicoesListas >= ((mapaDasListas.values().size() - 1) / 2.0)) {
				adicionaCompraALista("Lista automatica 3 " + dataAtual, qntAparicoes / aparicoesListas, item);
			}

		}
		return "Lista automatica 3 " + dataAtual;

	}
	
	/**
	 * 
	 * @throws IOException
	 */
	public void fechaSistema() throws IOException {
		FileOutputStream salvar = null;
		if (diretorio == null) {
			diretorio = new File("arquivosListas");
			diretorio.mkdir();
		}

		try {
			salvar = new FileOutputStream(this.diretorio + File.separator + "saida.txt");
			@SuppressWarnings("resource")
			ObjectOutputStream objeto = new ObjectOutputStream(salvar);
			objeto.writeObject(mapaDasListas);
		} catch (IOException e) {
		} finally {
			if (salvar != null) {
				salvar.close();
			}
		}

	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void iniciaSistema() {
		FileInputStream ler = null;
		try {
			ler = new FileInputStream(this.diretorio + File.separator + "saida.txt");
			@SuppressWarnings("resource")
			ObjectInputStream objeto = new ObjectInputStream(ler);
			this.mapaDasListas = (HashMap<String, ListaDeCompras>) objeto.readObject();
		} catch (IOException | ClassNotFoundException e) {

		} finally {
			try {
				ler.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String sugere(String descritor, int posicaoEstabelecimento, int posicaoLista) {
		this.comparador4 = new ListasComparator();
		List<List<Object>> lista = new ArrayList<>();
		List<List<String>> listaDefinitiva = new ArrayList<>();
		List<String> listaMercados = new ArrayList<>();

		for (Compra compra : mapaDasListas.get(descritor).getCompras()) {
			for (String mercado : compra.getItem().getPrecoMercado()) {
				if (!listaMercados.contains(mercado)) {
					listaMercados.add(mercado);
				}
			}
		}
		for (String mercado : listaMercados) {
			List<Object> outraListaPqSim= new ArrayList<>();
			outraListaPqSim.add(mercado);
			if (!lista.contains(outraListaPqSim)) {
				lista.add(outraListaPqSim);
			}
		}
		for (String mercado: listaMercados) {
			for (Compra compra : mapaDasListas.get(descritor).getCompras()) {
				if (compra.getItem().getPrecoMercado().contains(mercado)) {
					adicionaNaLista(compra, mercado, lista);
				}
			}
		}
		
		
		for (List<Object> oiaMaisUma: lista) {
			List<String> listaPrecos = new ArrayList<>();
			for (Object coisa: oiaMaisUma) {
				if(coisa == oiaMaisUma.get(0)) {
					listaPrecos.add(coisa + ": R$ " + pegaOsPrecos(descritor, (String) coisa));
				} else {
					listaPrecos.add("- "+((Compra) coisa).toString());
				}
				
			}
			listaDefinitiva.add(listaPrecos);
		}
		if(listaDefinitiva.size() == 0) {
			throw new NullPointerException("Faltam dados para informar sobre preços em locais de compras.");
		}
		Collections.sort(listaDefinitiva, comparador4);
		
		if(posicaoLista >= listaDefinitiva.get(posicaoEstabelecimento).size()) {
			return "";
		}
		
		

		return listaDefinitiva.get(posicaoEstabelecimento).get(posicaoLista);
	}

	private void adicionaNaLista(Compra compra, String mercado, List<List<Object>> lista) {
		this.comparador3= new ListaMercadosComparator();
		for (List<Object> listinha: lista) {
			if (listinha.get(0).equals(mercado)) {
				listinha.add(compra);
			}
			Collections.sort(listinha, comparador3);
		}
		
	}

	private String pegaOsPrecos(String descritor, String mercado) {
		double preco = 0.0;
		DecimalFormat precoCerto = new DecimalFormat("#0.00");
		for (Compra compra : mapaDasListas.get(descritor).getCompras()) {
			
			if (compra.getItem().getPrecoMercado().contains(mercado)) {
				
				preco += compra.getItem().pegaPreco(mercado) * compra.getQnt();
			}
			
		}
		return transformaDouble(precoCerto.format(preco));

	}
	
	private String transformaDouble(String numero) {
		String aux = "";
		for(String parte: numero.split(",")) {
			if(parte.equals(numero.split(",")[0])) {
				aux += parte + ",";
			} else if(parte.equals(numero.split(",")[1])){
				aux += parte;
			}
			
			
		}
		return aux;
	}

}
