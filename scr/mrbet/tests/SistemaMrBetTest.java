package mrbet.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mrbet.SistemaMrBet;


class SistemaMrBetTest {
	
	SistemaMrBet mb = new SistemaMrBet();
	
	@BeforeEach
	void inclusaoDeTimes() throws Exception {
		mb.incluirTime("250_PB", "Nacional de Patos", "Canário");
		mb.incluirTime("252_PB", "Sport Lagoa Seca", "Carneiro");
		mb.incluirTime("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
		mb.incluirTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
	}
	
	@Test
	void testIncluirCampeonato() throws Exception {
		assertEquals("CAMPEONATO ADICIONADO!", mb.incluirCampeonato("Brasileirão série A 2023", 20));
	}

	@Test
	void testIncluirCampeonatoJáExistente() throws Exception {
		mb.incluirCampeonato("Brasileirão série A 2023", 20);
		try {
			assertEquals("CAMPEONATO ADICIONADO!", mb.incluirCampeonato("Brasileirão série A 2023", 20));
			fail();
		} catch (Exception e) {
			assertEquals("CAMPEONATO JÁ EXISTE!", e.getMessage());
		}
	}
		
	@Test
	void testIncluirTimeEmCampeonato() throws Exception {
		mb.incluirCampeonato("Brasileirão série A 2023", 20);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mb.incluirTimeEmCampeonato("250_PB", "Brasileirão série A 2023"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mb.incluirTimeEmCampeonato("252_PB", "Brasileirão série A 2023"));
	}
	
	@Test
	void testIncluirTimeEmCampeonatoQueJáFoiIncluido() throws Exception {
		mb.incluirCampeonato("Brasileirão série A 2023", 20);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mb.incluirTimeEmCampeonato("250_PB", "Brasileirão série A 2023"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mb.incluirTimeEmCampeonato("252_PB", "Brasileirão série A 2023"));
		try {
			assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mb.incluirTimeEmCampeonato("252_PB", "Brasileirão série A 2023"));
		} catch (Exception e) {
			assertEquals("TIME INCLUÍDO NO CAMPEONATO!", e.getMessage());
		}
		
	}
	
	@Test
	void testIncluirTimeQueNaoExisteEmCampeonato() throws Exception {
		mb.incluirCampeonato("Brasileirão série A 2023", 20);
		try {
			assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mb.incluirTimeEmCampeonato("005_PB", "Brasileirão série A 2023"));
		} catch (Exception e) {
			assertEquals("O TIME NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testIncluirTimeEmCampeonatoQueNaoExiste() throws Exception {
		try {
			assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mb.incluirTimeEmCampeonato("252_PB", "Brasileirão série D 2023"));
		} catch (Exception e) {
			assertEquals("O CAMPEONATO NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testIncluirTimeEmCampeonatoExcedendoNumeroDeParticipantes() throws Exception {
		mb.incluirCampeonato("Brasileirão série A 2023", 1);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mb.incluirTimeEmCampeonato("252_PB", "Brasileirão série A 2023"));
		try {
			assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mb.incluirTimeEmCampeonato("250_PB", "Brasileirão série A 2023"));
		} catch (Exception e) {
			assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!", e.getMessage());
		}
	}
	
	@Test
	void testVerificarTimeEmCampeonato() throws Exception {
		mb.incluirCampeonato("Copa do Nordeste 2023", 20);
		mb.incluirTimeEmCampeonato("250_PB", "Copa do Nordeste 2023");
		assertEquals("O TIME ESTÁ NO CAMPEONATO!", mb.verificarTimeEmCampeonato("250_PB", "Copa do Nordeste 2023"));
		assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!", mb.verificarTimeEmCampeonato("252_PB", "Copa do Nordeste 2023"));
	}
	
	@Test
	void testVerificarTimeEmCampeonatoQueNaoExiste() throws Exception {
		try {
			assertEquals("O TIME ESTÁ NO CAMPEONATO!", mb.verificarTimeEmCampeonato("252_PB", "Brasileirão série D 2023"));
		} catch (Exception e) {
			assertEquals("O CAMPEONATO NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testVerificarTimeQueNaoExisteEmCampeonato() throws Exception {
		mb.incluirCampeonato("Copa do Nordeste 2023", 20);
		try {
			assertEquals("O TIME ESTÁ NO CAMPEONATO!", mb.verificarTimeEmCampeonato("005_PB", "Copa do Nordeste 2023"));
		} catch (Exception e) {
			assertEquals("O TIME NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testExibirCampeonatos() throws Exception {
		mb.incluirCampeonato("Copa do Nordeste 2023", 20);
		mb.incluirCampeonato("Brasileirão série A 2023", 20);
		mb.incluirTimeEmCampeonato("250_PB", "Copa do Nordeste 2023");
		mb.incluirTimeEmCampeonato("250_PB", "Brasileirão série A 2023");
		ArrayList<String> listaCampeonatos = new ArrayList<>();
		listaCampeonatos.add("Campeonatos do Nacional de Patos:");
		listaCampeonatos.add("* Copa do Nordeste 2023 - 1/20");
		listaCampeonatos.add("* Brasileirão série A 2023 - 1/20");
		assertEquals( listaCampeonatos, mb.exibirCampeonatos("250_PB"));
	}
	
	@Test
	void testExibirCampeonatosDeTimeQueNaoExiste() throws Exception {
		ArrayList<String> listaCampeonatos = new ArrayList<>();
		listaCampeonatos.add("Campeonatos do Nacional de Patos:");
		listaCampeonatos.add("* Copa do Nordeste 2023 - 1/20");
		listaCampeonatos.add("* Brasileirão série A 2023 - 1/20");
		try {
			assertTrue(listaCampeonatos == mb.exibirCampeonatos("005_PB"));
		} catch (Exception e) {
			assertEquals("TIME NÃO CADASTRADO NO SISTEMA!", e.getMessage());
		}
	}
	
	@Test
	void testApostar() throws Exception {
		mb.incluirCampeonato("Brasileirão série A 2023", 20);
		assertEquals("APOSTA REGISTRADA!", mb.apostar(1, "R$10,00", "250_PB", "Brasileirão série A 2023"));
	}
	
	@Test
	void testApostarTimeNaoExite() throws Exception {
		mb.incluirCampeonato("Brasileirão série A 2023", 20);
		try {
			assertEquals("APOSTA REGISTRADA!", mb.apostar(1, "R$10,00", "050_PB", "Brasileirão série A 2023"));
		} catch (Exception e) {
			assertEquals("O TIME NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testApostarCampeonatoNaoExite() throws Exception {
		try {
			assertEquals("APOSTA REGISTRADA!", mb.apostar(1, "R$10,00", "250_PB", "Brasileirão série A 2023"));
		} catch (Exception e) {
			assertEquals("O CAMPEONATO NÃO EXISTE!", e.getMessage());
		}
		
	}
	
	@Test
	void testApostaNaoRegistrada() throws Exception {
		mb.incluirCampeonato("Brasileirão série A 2023", 20);
		assertEquals("APOSTA NÃO REGISTRADA!", mb.apostar(21, "R$10,00", "250_PB", "Brasileirão série A 2023"));
	}	
	
	@Test
	void statusAposta() throws Exception {
		mb.incluirCampeonato("Brasileirão série A 2023", 20);
		mb.apostar(1, "R$ 10,00", "252_PB", "Brasileirão série A 2023");
		ArrayList<String> listaApostas = new ArrayList<>();
		listaApostas.add("1. [252_PB] Sport Lagoa Seca / Carneiro\n"
				+ "Brasileirão série A 2023\n"
				+ "1/20\n"
				+ "R$ 10,00");
		assertEquals(listaApostas, mb.statusAposta());
	}
	
	@Test
	void statusAposta2() throws Exception {
		mb.incluirCampeonato("Brasileirão série A 2023", 20);
		mb.apostar(1, "R$ 10,00", "252_PB", "Brasileirão série A 2023");
		mb.apostar(2, "R$ 10,00", "250_PB", "Brasileirão série A 2023");
		ArrayList<String> listaApostas = new ArrayList<>();
		listaApostas.add("1. [252_PB] Sport Lagoa Seca / Carneiro\n"
				+ "Brasileirão série A 2023\n"
				+ "1/20\n"
				+ "R$ 10,00");
		listaApostas.add("2. [250_PB] Nacional de Patos / Canário\n"
				+ "Brasileirão série A 2023\n"
				+ "2/20\n"
				+ "R$ 10,00");
		assertEquals(listaApostas, mb.statusAposta());
	}
}
