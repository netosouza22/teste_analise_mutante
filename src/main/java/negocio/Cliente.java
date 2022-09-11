package negocio;

import java.util.ArrayList;

public class Cliente {
	protected String name;
	protected int id;
	protected boolean isActive;
	protected int money;
	protected ArrayList<Filme> favMovies = new ArrayList<Filme>();
	
	public Cliente(int id, String name, int money, boolean isActive ) {
		this.name = name;
		this.id = id;
		this.money  = money;
		this.isActive = isActive;
	}
	
	public void favoritarFilme (Filme movie) {
		favMovies.add(movie);
	}
	
}
