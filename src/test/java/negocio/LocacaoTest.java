package negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocacaoTest {
	
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

	@Test
	public void alugarTest() {
		locacao1 = new Locacao();
		cliente2 = new Cliente(2, "Neto", 200, true);
		cliente3 = new Cliente(3, "Neto", 200, false);
		
		
		assertEquals(
				locacao1.alugar(cliente2, filme1, "20/02/2022", "20:00"), 
				"Cliente criado!");
		assertEquals(
				locacao1.alugar(cliente3, filme2, "20/02/2022", "20:00"), 
				"Cliente não está ativo!");
	}
	@Test 
	public void alugarComDescontGeneroTest() {
		transacao = new Transacao();
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		locacao3 = new Locacao();
		locacao4 = new Locacao();
		locacao5 = new Locacao();
		
		cliente1 = new Cliente(1, "Neto", 200, true);
		cliente3 = new Cliente(2, "Neto", 200, false);
		
		filme1 = new Filme(1, "Java", Genero.DRAMA, 40);
		filme2 = new Filme(1, "Java", Genero.MUSICAL, 40);
		filme3 = new Filme(1, "Java", Genero.ROMANCE, 40);
		filme4 = new Filme(1, "Java", Genero.TERROR, 40);
		filme5 = new Filme(1, "Java", Genero.COMEDIA, 40);
		
		locacao1.alugarComDesconto(cliente1, filme1, "20/02/2022", "20:00");
		locacao2.alugarComDesconto(cliente1, filme2, "20/02/2022", "20:00");
		locacao3.alugarComDesconto(cliente1, filme3, "20/02/2022", "20:00");
		locacao4.alugarComDesconto(cliente1, filme4, "20/02/2022", "20:00");
		locacao5.alugarComDesconto(cliente1, filme5, "20/02/2022", "20:00");
		
		assertTrue(locacao1.valorAluguel == 40 * 0.9);
		assertTrue(locacao2.valorAluguel == 40 * 0.96);
		assertTrue(locacao3.valorAluguel == 40 * 0.85);
		assertTrue(locacao4.valorAluguel == 40 * 0.8);
		assertTrue(locacao5.valorAluguel == 40);
	}
	
	@Test 
	public void ConseguirAlugarComDescontoTest() {
		locacao1 = new Locacao();
		
		cliente1 = new Cliente(1, "Neto", 200, true);
		cliente2 = new Cliente(2, "Neto", 200, false);
		
		filme1 = new Filme(1, "Java", Genero.DRAMA, 40);
		filme2 = new Filme(1, "Java", Genero.MUSICAL, 40);
		
		assertEquals(
				locacao1.alugarComDesconto(cliente1, filme1, "20/02/2022", "20:00"), 
				"Cliente criado!");
		
		assertEquals(
				locacao1.alugarComDesconto(cliente2, filme1, "20/02/2022", "20:00"), 
				"Cliente não está ativo!");
	}
	
	@Test 
	public void AlugarFavoritosTest() {
		locacao1 = new Locacao();
		filme1 = new Filme(1, "Java", Genero.COMEDIA, 200);
		cliente1 = new Cliente(1, "Neto", 200, true);
		
		cliente1.favoritarFilme(filme1);
		
		
		locacao1.alugarFavoritos(cliente1, "20/05/2022", "20:00");
		
		assertTrue(locacao1.movie.id == cliente1.favMovies.get(0).id);
		
	}

}
