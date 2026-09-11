package mrbet.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mrbet.Aposta;
import mrbet.Campeonato;
import mrbet.SistemaMrBet;
import mrbet.Time;

class ApostaTeste {
	
	SistemaMrBet mb = new SistemaMrBet();
	Time time = new Time("250_PB", "Nacional de Patos", "Canário");
	Time time2 = new Time("252_PB", "Sport Lagoa Seca", "Carneiro");
	Campeonato campeonato = new Campeonato("Brasileirão série A 2023", 20);

	@Test
	void testToString() {
		Aposta aposta = new Aposta(1, "R$ 10,00", time, campeonato);
		assertEquals("[250_PB] Nacional de Patos / Canário\n"
				+ "Brasileirão série A 2023\n"
				+ "1/20\n"
				+ "R$ 10,00", aposta.toString());
	}

	@Test
	void testToString2() {
		Aposta aposta = new Aposta(2, "R$ 20,00", time2, campeonato);
		assertEquals("[252_PB] Sport Lagoa Seca / Carneiro\n"
				+ "Brasileirão série A 2023\n"
				+ "2/20\n"
				+ "R$ 20,00", aposta.toString());
	}
}
