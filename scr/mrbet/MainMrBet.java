package mrbet;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMrBet {
	public static void main(String[] args) throws Exception {
		SistemaMrBet mb = new SistemaMrBet();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String opcao = menu(mb, sc);
			comandoMenu(sc, mb, opcao);
		}
	}	
	
	private static String menu(SistemaMrBet mb, Scanner sc) {
		System.out.println(
				"(M)Minha inclusão de times\n" +
				"(R)Recuperar time\n" +
				"(.)Adicionar campeonato\n" +
				"(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" + 
				"(E)Exibir campeonatos que o time participa" +
				"(T)Tentar a sorte e status\n" +
				"(!)Já pode fechar o programa!\n" +
				"\n" +
				"Opção>");
		
		return sc.nextLine().toUpperCase();
	}
	
	private static void comandoMenu(Scanner sc, SistemaMrBet mb, String opcao) throws Exception {
		switch (opcao) {
			case "M":
				System.out.println("Código: ");
				String id = sc.nextLine();
				System.out.println("Nome: ");
				String nome = sc.nextLine();
				System.out.println("Mascote: ");
				String mascote = sc.nextLine();
				adicionarTime(mb, id, nome, mascote);
				break;
			case "R":
				System.out.println("Código: ");
				String id2 = sc.nextLine();
				recuperarTime(mb, id2);
				break;
			case ".":
				System.out.println("Campeonato: ");
				String nome2 = sc.nextLine();
				System.out.println("Participantes: ");
				String qtdParticipantes = sc.nextLine();
				adicionarCampeonato(mb, nome2, Integer.parseInt(qtdParticipantes));
				break;
			case "B":
				System.out.println("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato?)");
				String escolha = sc.nextLine();
				if (escolha.toUpperCase() == "I") {
					System.out.println("Código: ");
					String id3 = sc.nextLine();
					System.out.println("Campeonato: ");
					String nome3 = sc.nextLine();
					adicionarTimeEmCampeonato(mb, id3, nome3);
				} else if (escolha.toUpperCase() == "V") {
					System.out.println("Código: ");
					String id4 = sc.nextLine();
					System.out.println("Campeonato: ");
					String nome4 = sc.nextLine();
					verificaTimeEmCampeonato(mb, id4, nome4);
				}
				break;
			case "E":
				System.out.println("Time: ");
				String idTime = sc.nextLine();
				exibeCampeonatosDeTime(mb, idTime);
				break;
			case "T":
				System.out.println("(A) Apostar ou (S) Status das Apostas?");
				String escolha2 = sc.nextLine();
				if (escolha2.toUpperCase() == "A") {
					System.out.println("Código: ");
					String timeAposta = sc.nextLine();
					System.out.println("Campeonato: ");
					String campeonatoAposta = sc.nextLine();
					System.out.println("Colocação: ");
					String colocacao = sc.nextLine();
					System.out.println("Valor da Aposta: ");
					String valorDaAposta = sc.nextLine();
					apostar(mb, Integer.parseInt(colocacao), valorDaAposta, timeAposta, campeonatoAposta);
				} else if (escolha2.toUpperCase() == "S") {
					statusAposta(mb);
				}
				break;
			case "!":
				System.out.println("Por hoje é só, pessoal!");
				break;
		}
	}
	
	private static void adicionarTime(SistemaMrBet mb, String id, String nome, String mascote) throws Exception {
		System.out.println(mb.incluirTime(id, nome, mascote));
	}
		
	private static void recuperarTime(SistemaMrBet mb, String id) throws Exception {
		System.out.println(mb.recuperarTime(id));
	}
		
	private static void adicionarCampeonato(SistemaMrBet mb, String nome, int qtdParticipantes) throws Exception {
		System.out.println(mb.incluirCampeonato(nome, qtdParticipantes));
	}
	
	private static void adicionarTimeEmCampeonato(SistemaMrBet mb, String idTime, String nomeCampeonato) throws Exception {
		System.out.println(mb.incluirTimeEmCampeonato(idTime, nomeCampeonato));
	}
	
	private static void verificaTimeEmCampeonato(SistemaMrBet mb, String idTime, String nomeCampeonato) throws Exception {
		System.out.println(mb.verificarTimeEmCampeonato(idTime, nomeCampeonato));
	}
	
	private static void exibeCampeonatosDeTime(SistemaMrBet mb, String idTime) throws Exception {
		ArrayList<String> saida = new ArrayList<>();
		saida = mb.exibirCampeonatos(idTime);
		for (String i: saida) {
			System.out.println(i);
		}
	}
	
	private static void apostar(SistemaMrBet mb, int palpite, String valor, String idTime, String nomeCampeonato) throws Exception {
		System.out.println(mb.apostar(palpite, valor, idTime, nomeCampeonato));	
	}
	
	private static void statusAposta(SistemaMrBet mb) {
		ArrayList<String> saida = new ArrayList<>();
		saida = mb.statusAposta();
		System.out.println("Apostas:");
		for (String i : saida) {
			System.out.println(i);
		}
	}
}
