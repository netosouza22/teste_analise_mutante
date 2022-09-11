package negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class ClienteTest {
	Cliente cliente1;
	Filme filme1;
	
	@Before
	public void setUp() throws Exception {	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	void favoritarFilmeTest() {
		filme1 = new Filme(1, "Java", Genero.COMEDIA, 200);
		cliente1 = new Cliente(1, "Neto", 200, true);
		
		cliente1.favoritarFilme(filme1);
		
		assertTrue(cliente1.favMovies.get(0).id == 1);
	}

}
