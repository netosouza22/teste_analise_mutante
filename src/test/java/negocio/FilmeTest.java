package negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class FilmeTest {

	Filme movie;
	@Before

	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void testCreateMovie() {
		movie = new Filme(0, "Java", Genero.DRAMA, 25);
		assertEquals(0, movie.id);
		assertEquals("Java", movie.name);
		assertEquals(Genero.DRAMA, movie.genero);
		assertTrue(25 == movie.value);
	}

}
