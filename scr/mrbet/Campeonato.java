package mrbet;
/**
 * Representação de um campeonato no Sistema.
 */
import java.util.ArrayList;
import java.util.Objects;

public class Campeonato {
	private String nome;
	private int qtdParticipantes;
	private ArrayList<Time> times;
	
	/**
	 * Constroi um Campeonato
	 * @param String nome Nome do Campeonato
	 * @param String qtdParticipantes Quantidade de participantes disponíveis no campeonato.
	 */
	public Campeonato(String nome, int qtdParticipantes) {
		this.nome = nome;
		this.qtdParticipantes = qtdParticipantes;
		this.times = new ArrayList<Time>();
	}
	
	/**
	 * Acessa o nome do Campeonato.
	 * return nome Nome doCampeonato
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Acessa a quantidade de Participantes do campeonato.
	 * @return  int qtdParticipantes Quantidade de participantes
	 */
	public int getQtdParticipantes() {
		return qtdParticipantes;
	}
	
	/**
	 * Acessa a quantidades de time que já estão participando do campeonato.
	 * @return int quantidades de time que já estão participando do campeonato.
	 */
	public int getQtdTimes() {
		return times.size() - 1;
	}
	
	/**
	 * Adiciona o time ao campeonato.
	 * @param Time time um objto que representa o time.
	 * @return boolean que representa se o time foi adifionado ou não.
	 */
	public boolean adicionarTime(Time time) {
		if (times.contains(time)) return false; 
		times.add(time);
		return true;
	}
	
	/**
	 * Verifica se um time já foi adicionado ou não ao campeonato.
	 * @param String id Identificador do time
	 * @return boolean que representa se o time já faz ou não parte do campeonato.
	 */
	public boolean verificaTime(String id) {
		for (int i = 0; i < times.size(); i++) {
			if(id == times.get(i).getId()) return true;
		}
		return false;
	}
	
	/**
	 * Torna um objeto em numero inteiro que o representa.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nome);
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
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nome, other.nome);
	}
	
	/**
	 * Monta uma representação textual do Campeonato
	 * @return "* (nome do Campeonato) (quantidades de times que estão participando) / (quantidade maxima de participantes)" 
	 */
	public String toString( ) {
		return "* " + nome + " - " + String.valueOf(times.size()) + "/" + String.valueOf(qtdParticipantes);
	}
}
