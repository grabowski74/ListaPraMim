package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import comparators.ListaComparator;
import entidadesItem.Item;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Gabriel Gu7imaraes de Almeida, Matheus Silva Araujo;
 * 
 *         Classe que representa uma lista de compras. Possui uma lista de
 *         compras com suas quantidades a serem compradas.
 * 
 *         Laboratorio de Programacao 2 - Projeto de Laboratorio - ListaPraMim
 */
public class ListaDeCompras {

	// O local onde sera feita a compra de acordo com a lista;
	private String localDeCompra;
	// O nome da lista. Cada lista tem um descritor unico e eh o seu identificador;
	private String descritor;
	// O valor da final da lista, passado pelo criador da mesma;
	private int valor;
	// Objeto que representa uma compra a ser adicionada na lista;
	private Compra compra;
	// Uma lista de compras do tipo Compra. Compras do mesmo item nao podem ser
	// adicionadas quando ja ha uma compra de tal item na lista;
	private List<Compra> compras;
	// Um comparador que serve para ordenar a lista em dois layers:
	// 1-) de acordo com a categoria do item relacionado a compra.
	// 2-) de acordo com a ordem lexicografica do nome dos itens relacionado as
	// compras;
	private Comparator<Compra> comparador;
	// Objeto do tipo Date que ajuda a pegar a data e hora do sitema no momento da
	// criacao da lista;
	private Date horario = new Date();
	// A data em que a lista foi criada;
	private String data;
	// A hora que em a lis ta foi criada;
	private String hora;

	private int id;


	/**
	 * Construtor da classe. Recebe somente uma String que representa o nome da
	 * lista no sitema;
	 * 
	 * @param descritor
	 *            O nome da lista. Cada lista tem um descritor unico e eh o seu
	 *            identificador.
	 */

	public ListaDeCompras(String descritor, int id) {

		validandoEntradaDescritor(descritor);
		this.descritor = descritor;
		compras = new ArrayList<>();
		this.data = new SimpleDateFormat("dd/MM/yyyy").format(horario);
		this.hora = new SimpleDateFormat("hh:mm:ss").format(horario);

		this.id = id;

	}

	/**
	 * Método que adiciona uma nova compra a lista recebendo um Item e a quantidade
	 * a ser comprada do mesmo;
	 * 
	 * @param qnt
	 *            Um inteiro que representa a quantidade a ser comprada do item
	 *            relacionado a compra;
	 * @param item
	 *            O item da compra.
	 */
	public void adicionaCompra(int qnt, Item item) {
		comparador = new ListaComparator();

		compra = new Compra(qnt, item);
		compras.add(compra);
		this.comparador = new ListaComparator();
		Collections.sort(compras, comparador);

	}

	/**
	 * Método que fecha a lista. Recebe o local onde as compras serao feitas e o
	 * valor final da lista;
	 * 
	 * @param localDaCompra
	 *            Uma String que representa o local da compra;
	 * @param valor
	 *            Um inteiro que representa o valor final da lista. Tal valor eh
	 *            definido por quem fecha a lista.
	 */
	public void finalizaLista(String localDaCompra, int valor) {
		this.localDeCompra = localDaCompra;
		this.valor = valor;

	}

	/**
	 * Método que atualiza a quantidade de uma compra;
	 * 
	 * @param id
	 *            O identificador do item relacionado a compra que se quer alterar a
	 *            quantidade;
	 * @param operacao
	 *            Uma Strign que representa a ser feita na quantidade atual da
	 *            compra. Pode ser "adiciona" ou "diminui";
	 * @param qnt
	 *            Um inteiro que represnta a quantidade a ser acrescida ou subtraida
	 *            da quantidade atual.
	 */
	public void atualizaCompra(int id, String operacao, int qnt) {
		if (!operacao.equals("adiciona") && !operacao.equals("diminui")) {
			throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}
		boolean aux = false;
		Compra comp = null;
		for (Compra compra : compras) {
			if (compra.getId() == id) {
				aux = true;
				compra.atualiza(operacao, qnt);
				if (compra.getQnt() == 0) {
					comp = compra;
				}
				compras.remove(comp);
				break;
			}
		}
		if (aux == false) {
			throw new NullPointerException("Erro na atualizacao de compra: compra nao encontrada na lista.");
		}
	}

	/**
	 * Método que pesquisa um item na lista atraves do seu ID;
	 * 
	 * @param id
	 *            Um inteiro que represnta o identificador unico do item pesquisado;
	 * @return Retorna a representacao textual da compra que tem o item pesquisado
	 *         relacionado a mesma.
	 */
	public String pesquisa(int id) {

		for (Compra compra : compras) {
			if (compra.getId() == id) {
				return compra.toString();
			}
		}
		throw new NullPointerException("Erro na pesquisa de compra: compra nao encontrada na lista.");
	}

	/**
	 * Método que valida a o descritor passado na cronstrucao da classe;
	 * 
	 * @param descritor
	 *            Uma Strign que representa o descritor da classe.
	 */
	private void validandoEntradaDescritor(String descritor) {
		if (descritor.equals(null) || descritor.trim().equals("")) {
			throw new NullPointerException(
					"Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}

	}

	/**
	 * Método que pega uma compra na lista atraves da posicao de tal compra na lista
	 * de compras;
	 * 
	 * @param posicaoItem
	 *            Um inteiro que representa a posicao da compra na lista;
	 * @return Retorna a representacao textual da compra.
	 */
	public String getItem(int posicaoItem) {
		if (posicaoItem >= compras.size()) {
			return "";
		}
		return compras.get(posicaoItem).toString();
	}

	/**
	 * Método que retira uma compra da lista atraves do ID do item relacionado a uma
	 * compra na lista;
	 * 
	 * @param id
	 *            Um inteiro que representa o ID do item.
	 */
	public void deleta(int id) {
		boolean aux = false;
		for (Compra compra : compras) {
			if (compra.getId() == id) {
				compras.remove(compra);
				aux = true;
				break;
			}
		}
		if (aux == false) {
			throw new NullPointerException("Erro na exclusao de compra: compra nao encontrada na lista.");
		}

	}

	/**
	 * Método que pega a data em que a lista foi criada;
	 * 
	 * @return Retorna uma String que representa a data de criacao da lista.
	 */
	public Object getData() {
		return this.data;

	}

	/**
	 * Método que pega o descritor da lista;
	 * 
	 * @return Retorna uma String que representa o descritor da lista.
	 */
	public String getDescritor() {
		return this.descritor;
	}

	/**
	 * Método que verifica se um item esta relacionado a alguma compra na lista de
	 * compras recebendo o ID de tal item;
	 * 
	 * @param id
	 *            Um inteiro que representa o Id do item;
	 * @return Retorna true se o item se encontra na lista e false se nao.
	 */
	public boolean contemItem(int id) {
		for (Compra compra : compras) {
			if (compra.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public String getHora() {
		return this.hora;
	}

	public void setData(String novaData) {
		this.data = novaData;
	}

	public void setDescritor(String novoDescritor) {
		this.descritor = novoDescritor;
	}

	public boolean contemItem(String descritorItem) {
		for (Compra compra : compras) {
			if (compra.getNome().equals(descritorItem)) {

				return true;
			}
		}
		return false;
	}


	public int getID() {
		return this.id;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getQnt() {
		return compra.getQnt();
	}

	public Item getItemPorId(int id) {
		for (Compra compra : compras) {
			if (compra.getId() == id) {
				return compra.getItem();
			}
		}
		throw new NullPointerException("Erro na exclusao de compra: compra nao encontrada na lista.");
	}

	public Compra getCompra(Item item) {
		for(Compra compra: compras) {
			if(compra.getItem() == item) {
				return compra;
			}
		}
		return null;
	}
	
	public String toString() {
		String aux = "";
		for (Compra compra: compras) {
			aux += compra.toString() + "\n";
		}
		return aux;
	}


}
