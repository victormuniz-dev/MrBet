package mrbet.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mrbet.Campeonato;
import mrbet.Time;

class CampeonatoTeste {
	
	Campeonato campeonato = new Campeonato("Copa do Nordeste 2023", 20);
	Time time = new Time("250_PB", "Nacional de Patos", "Canário");
	Time time2 = new Time("252_PB", "Sport Lagoa Seca", "Carneiro");
	
	@Test
	void testAdicionarTime() {
		assertTrue(campeonato.adicionarTime(time));
	}
	
	@Test
	void testAdicionarTimeJaExistente() {
		campeonato.adicionarTime(time);
		assertFalse(campeonato.adicionarTime(time));
	}
	
	@Test
	void testVerificaTime() {
		campeonato.adicionarTime(time);
		assertTrue(campeonato.verificaTime("250_PB"));
	}
	
	@Test
	void testVerificaTimeNãoExistente() {
		campeonato.adicionarTime(time2);
		assertFalse(campeonato.verificaTime("250_PB"));
	}

	@Test
	void testEqualsObject() {
		Campeonato campeonato2 = new Campeonato("Copa do Nordeste 2023", 20);
		assertEquals(campeonato, campeonato2);
	}
	
	@Test
	void testEqualsObjectDiferentes() {
		Campeonato campeonato2 = new Campeonato("Nordestão 2024", 20);
		assertFalse(campeonato.equals(campeonato2));
	}

	@Test
	void testToString() {
		assertEquals("* Copa do Nordeste 2023 - 0/20", campeonato.toString());
	}

}
