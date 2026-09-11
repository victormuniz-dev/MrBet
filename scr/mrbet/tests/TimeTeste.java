package mrbet.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mrbet.Campeonato;
import mrbet.Time;

class TimeTeste {
	
	Campeonato campeonato = new Campeonato("Copa do Nordeste 2023", 20);
	Time time = new Time("250_PB", "Nacional de Patos", "Canário");
	Time time2 = new Time("252_PB", "Sport Lagoa Seca", "Carneiro");
	
	@Test
	void testEqualsObject() {
		Time time3 = new Time("250_PB", "Nacional de Patos", "Canário");
		assertEquals(time, time3);
	}
	
	@Test
	void testEqualsObjectDiferentes() {
		assertFalse(time.equals(time2));
	}

	@Test
	void testToString() {
		assertEquals("[250_PB] Nacional de Patos / Canário", time.toString());
	}
	
	@Test
	void testToString2() {
		assertEquals("[252_PB] Sport Lagoa Seca / Carneiro", time2.toString());
	}

}
