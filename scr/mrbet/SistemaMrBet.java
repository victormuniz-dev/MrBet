package mrbet;
/**
 * Classe manipular os dados providos das classes Aposta, Time e Campeonato e direcioná-los para MainMrBet.
 * @author Joao Victor Muniz Cabral - 123210456
 */
import java.util.ArrayList;
import java.util.HashMap;

public class SistemaMrBet {
	private HashMap<String, Time> times;
	private HashMap<String, Campeonato> campeonatos;
	private ArrayList<Aposta> apostas;
	
	/**
	 * Constroi um objeto SistemaMrBet
	 */
	public SistemaMrBet() {
		this.times = new HashMap<String, Time>();
		this.campeonatos = new HashMap<String, Campeonato>();
		this.apostas = new ArrayList<Aposta>(); 
		
	}
	
	/**
	 * Inclui um Objeto Time ao Sistema e armazena-o em um HashMap tendo como chave a id do time.
	 * @param id Identificador do time.
	 * @param String nome Nome do time.
	 * @param String mascote Mascote do time.
	 * @return String Texto que indica a validação a inclusão do Time do ao Sistema.
	 *  
	 */
	public String incluirTime(String id, String nome, String mascote) throws Exception {
		Time timeCadastrante = new Time(id, nome, mascote);
		if (times.containsKey(id)) throw new Exception("TIME JÁ EXISTENTE");
		times.put(id, timeCadastrante);
		return "INCLUSÃO REALIZADA!";
	}
	
	/**
	 * Busca um time cadastrado ao Sistema.
	 * @param id Indentificador do time
	 * @return String Representação textual do Time
	 */
	public String recuperarTime(String id) throws Exception {
		if (times.containsKey(id)) return times.get(id).toString();
		throw new Exception("TIME NÃO EXISTE!");
	}
	
	/**
	 * Inclui Campeonato ao Sistema e armazena-o em HashMap tendo como chave o nome do campeonato.
	 * @param String nome Nome do campeonato.
	 * @param int qtdParticipantes Quantidade de Participantes do campeonato.
	 * @return String Texto que indica a validação a inclusão do Time do ao Sistema. 
	 */
	public String incluirCampeonato(String nome, int qtdParticipantes) throws Exception {
		Campeonato campeonatoCadastrante = new Campeonato(nome, qtdParticipantes);
		if (campeonatos.containsKey(nome)) throw new Exception("CAMPEONATO JÁ EXISTE!");
		campeonatos.put(nome, campeonatoCadastrante);
		return "CAMPEONATO ADICIONADO!";
	}
	
	/**
	 * Inclui um time já cadastrado ao Sistema a um campeonato já cadastrado ao Sistems.
	 * @param String idTime idetificador do time.
	 * @param String nomeCampeonato Nome do Campeonato.
	 * @return String Testo que representa a validação da inclusão do time ao campeonato.
	 */
	public String incluirTimeEmCampeonato(String idTime, String nomeCampeonato) throws Exception {
		if (!times.containsKey(idTime)) throw new Exception("O TIME NÃO EXISTE!");
		else if (!campeonatos.containsKey(nomeCampeonato)) throw new Exception("O CAMPEONATO NÃO EXISTE!");
		else if (campeonatos.get(nomeCampeonato).getQtdParticipantes() == campeonatos.get(nomeCampeonato).getQtdTimes()) throw new Exception("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS");
		times.get(idTime).adicionaCampeonato(campeonatos.get(nomeCampeonato));
		campeonatos.get(nomeCampeonato).adicionarTime(times.get(idTime));
		return "TIME INCLUÍDO NO CAMPEONATO!";
	}
	
	/**
	 * Verifica se time já cadastrado está em um campeonato já cadastrado.
	 * @param String idTime Ideficador do time
	 * @param String nomeCampeonato Nome do Campeonato
	 * @return String Texto que indica se o time está ou não no campeonato.
	 */
	public String verificarTimeEmCampeonato(String idTime, String nomeCampeonato) throws Exception {
		Campeonato campeonato = null;
		if (!campeonatos.containsKey(nomeCampeonato)) throw new Exception("O CAMPEONATO NÃO EXISTE!");
		if (!times.containsKey(idTime)) throw new Exception("O TIME NÃO EXISTE!");
		campeonato = campeonatos.get(nomeCampeonato);
		if (!campeonato.verificaTime(idTime)) {
			return "O TIME NÃO ESTÁ NO CAMPEONATO!";
		} 
		return "O TIME ESTÁ NO CAMPEONATO!";
	}
	
	/**
	 * Exibe uma lista de todos os campeonatos nos quais um tima faz parte.
	 * @param String idTime Indentificador de time.
	 * @return ArrayList<String> lista de campeonados nos quais um time faz parte.
	 */
	public ArrayList<String> exibirCampeonatos(String idTime) throws Exception {
		ArrayList<String> saida = new ArrayList<>();
		if (!times.containsKey(idTime)) {
			throw new Exception("TIME NÃO CADASTRADO NO SISTEMA!");
		}
		ArrayList<Campeonato> campeonatosDeTime = new ArrayList<>();
		saida.add("Campeonatos do " + times.get(idTime).getNome() + ":");
		campeonatosDeTime = times.get(idTime).getCampeonatos();
		for (Campeonato i : campeonatosDeTime) {
			saida.add(i.toString());
		}
		return saida;
	}
	
	/**
	 * Efetua uma aposta no sistema.
	 * @param int palpite Papite da posição em que o time está no campeonato
	 * @param String valor Valor da aposta
	 * @param String idTime Indentificador de time.
	 * @return String Texto que representa a efetuação da aposta ou não.
	 */
	public String apostar(int palpite, String valor, String idTime, String nomeCampeonato) throws Exception {
		if (!times.containsKey(idTime)) throw new Exception("O TIME NÃO EXISTE!");
		if (!campeonatos.containsKey(nomeCampeonato)) throw new Exception("O CAMPEONATO NÃO EXISTE!");
		if (campeonatos.get(nomeCampeonato).getQtdParticipantes() < palpite) return "APOSTA NÃO REGISTRADA!";
		Aposta aposta = new Aposta(palpite, valor, times.get(idTime), campeonatos.get(nomeCampeonato));
		apostas.add(aposta);
		return "APOSTA REGISTRADA!";
	}
	
	/**
	 * Lista todos as apostas relizadas no Sistema.
	 * @return ArrayList<String> Lista com todas apostas em representação textual.
	 */
	public ArrayList<String> statusAposta() {
		int posicaoAposta = 1;
		ArrayList<String> listaApostas = new ArrayList<>();
		for (Aposta i : apostas) {
			listaApostas.add(String.valueOf(posicaoAposta) + ". " + i.toString());
			posicaoAposta++;
		}
		return listaApostas;
	}
}
