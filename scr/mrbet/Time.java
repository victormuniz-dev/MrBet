package mrbet;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Representação de um time no Sistema
 */
public class Time {
	private String id;
	private String nome;
	private String mascote;
	private ArrayList<Campeonato> campeonatos;
	
	/**
	 * Constroi um Time
	 * @param id Identificador do time
	 * @param nome Nome do time
	 * @param mascote Mascote do time
	 */
	public Time(String id, String nome, String mascote) {
		this.id = id;
		this.nome = nome;
		this.mascote = mascote;
		campeonatos = new ArrayList<Campeonato>();
	}
	
	/**
	 * Acessa o nome do time.
	 * @return String nome Nome do time.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Acessa o Identidifador do time.
	 * @return String id Identificador do time.
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Acessa o Mascote do time.
	 * @return String mascote Mascote do time.
	 */
	public String getMascote() {
		return mascote;
	}
	
	/**
	 * Acessa a lista de com todos os Campeonatos dos quais o time faz parte
	 * @return ArrayList<Campeonato> Lista com os objetos que representam os Campeonatos.
	 */
	public ArrayList<Campeonato> getCampeonatos() {
		ArrayList<Campeonato> listaCampeonatos = new ArrayList<>();
		for (Campeonato i : campeonatos) {
			listaCampeonatos.add(i);
		}
		return listaCampeonatos;
	}
	
	/**
	 * Adiciona um Campeonato à lista de campeonatos dos quais tme participa.
	 * @param Campeonato Campeonato Objeto que representa o Campeonato.
	 */
	public void adicionaCampeonato(Campeonato campeonato) {
		campeonatos.add(campeonato);
	}
	
	/**
	 * Torna um objeto em numero inteiro que o representa.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	/**
	 * Verifica se dois objetos que representa um time são iguais com base no seu indentificador.
	 * @param Object obj objeto a ser compatado.
	 * @return valor booleano que representa se os dois objetos são ou não iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(id, other.id);
	}
	
	/**
	 * Monta a representação textual do time.
	 * @return String com a representação textual do time.
	 * "[identificador do time] nome do time / mascote do time"
	 */
	public String toString() {
		return "[" + this.id + "] " + this.nome + " / " + this.mascote;
	}
}
