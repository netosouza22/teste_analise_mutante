package negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class TransacaoTest {

	Transacao transacao;
	Locacao locacao1;
	Locacao locacao2;
	Locacao locacao3;
	Locacao locacao4;
	Locacao locacao5;
	Filme filme1;
	Filme filme2;
	Filme filme3;
	Filme filme4;
	Filme filme5;
	Cliente cliente1;
	Cliente cliente2;
	Cliente cliente3;

	@Before
	public void setUp() throws Exception {	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addLocacaoFilmeTest() {
		cliente2 = new Cliente(2, "Neto", 200, true);
		filme1 = new Filme(1, "Java", Genero.COMEDIA, 20);
		transacao = new Transacao();
		locacao1 = new Locacao();
		locacao1.alugar(cliente2, filme1, "20/02/2022", "20:00");
		transacao.addLocacao(locacao1);

		transacao.addLocacao(locacao1);
		
		assertEquals(transacao.alugueis.get(0).movie.id, filme1.id);
	}
	@Test
	public void addLocacaoClienteTest() {
		cliente2 = new Cliente(2, "Neto", 200, true);
		filme1 = new Filme(1, "Java", Genero.COMEDIA, 20);
		transacao = new Transacao();
		locacao1 = new Locacao();
		locacao1.alugar(cliente2, filme1, "20/02/2022", "20:00");
		transacao.addLocacao(locacao1);
		
		transacao.addLocacao(locacao1);
		
		assertEquals(transacao.alugueis.get(0).client.id, cliente2.id);
	}
	
	@Test
	public void maisAlugadoTest() {
		cliente1 = new Cliente(1, "Neto", 200, true);
		cliente2 = new Cliente(2, "Neto", 200, true);
		filme1 = new Filme(1, "Java", Genero.DRAMA, 20);
		filme2 = new Filme(1, "Java", Genero.DRAMA, 20);
		filme3 = new Filme(1, "Java", Genero.DRAMA, 20);
		filme4 = new Filme(1, "Java", Genero.COMEDIA, 20);
		filme5 = new Filme(1, "Java", Genero.COMEDIA, 20);
		
		transacao = new Transacao();
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		locacao3 = new Locacao();
		locacao4 = new Locacao();
		locacao5 = new Locacao();
		locacao1.alugar(cliente1, filme1, "20/02/2022", "20:00");
		locacao2.alugar(cliente2, filme2, "20/02/2022", "20:00");
		locacao3.alugar(cliente1, filme3, "20/02/2022", "20:00");
		locacao4.alugar(cliente2, filme4, "20/02/2022", "20:00");
		locacao5.alugar(cliente1, filme5, "20/02/2022", "20:00");
		
		transacao.addLocacao(locacao1);
		
		assertEquals(transacao.MaisAlugado(), Genero.DRAMA);
	}
	
	@Test
	public void naoExisteMaisAlugadoTest() {
		transacao = new Transacao();
		
		assertEquals(transacao.MaisAlugado(), null);
	}
	
	@Test
	public void valorLocacaoTotalTest() {
		cliente2 = new Cliente(2, "Neto", 200, true);
		filme1 = new Filme(1, "Java", Genero.COMEDIA, 20);
		filme2 = new Filme(1, "Java1", Genero.DRAMA, 20);
		filme3 = new Filme(1, "Java2", Genero.MUSICAL, 20);
		transacao = new Transacao();
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		locacao3 = new Locacao();
		
		locacao1.alugar(cliente2, filme1, "20/02/2022", "20:00");
		locacao2.alugar(cliente2, filme1, "20/02/2022", "20:00");
		locacao3.alugar(cliente2, filme1, "20/02/2022", "20:00");
		
		transacao.addLocacao(locacao1);
		transacao.addLocacao(locacao2);
		transacao.addLocacao(locacao3);
		
		assertEquals(transacao.valorLocacaoTotal(), 60);
	}
	

}
