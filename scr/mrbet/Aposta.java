package mrbet;

/**
 * represetação de uma Aposta no Sistema
 */

public class Aposta {
	private int palpite;
	private String valorDepositado;
	private Time time;
	private Campeonato campeonato;
	
	/**
	 * Constroi uma aposta.
	 * @param int palpite Palpite da posicao que um time opuca em um campeonato.
	 * @param Strinf valorDepositado Valor da aposta
	 * @param Time time Objeto que representa um time.
	 * @param Campeonato campeonato Objeto que representa um campeonato.
	 */
	public Aposta(int palpite, String valorDepositado, Time time, Campeonato campeonato) {
		this.palpite = palpite;
		this.valorDepositado = valorDepositado;
		this.time = time;
		this.campeonato = campeonato;
	}
	
	/**
	 * Representação de uma aposta.
	 * return String "[(identficador do time)] (nome do time) / (mascote)
	 * 			(nome do campeonato)
				(palpite) / (quantidade maxima de participantes do campeonato)
				(valor da aposta)
	 */
	public String toString() {
		return ("[" + time.getId() +"] " + time.getNome() + " / " + time.getMascote() + "\n" +
				campeonato.getNome() + "\n" +
				palpite + "/" + campeonato.getQtdParticipantes() + "\n" +
				valorDepositado);
	}
}
