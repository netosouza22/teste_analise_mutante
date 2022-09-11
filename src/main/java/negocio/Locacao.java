package negocio;

public class Locacao {
	
	protected Cliente client;
	protected Filme movie;
	protected double valorAluguel;
	protected String date;
	protected String hour;
	
	public String alugar(Cliente client, Filme movie, String date, String hour) {
		if(client.isActive == true) {
			this.client = client;
			this.movie = movie;
			this.date = date;
			this.hour = hour;
			
			return "Cliente criado!";
		}
		return "Cliente não está ativo!";
	}
	
	public String alugarComDesconto(Cliente client, Filme movie, String date, String hour) {
		
        switch (movie.genero) {
            case DRAMA: 
            	this.valorAluguel = movie.value * 0.9;
                break;

            case MUSICAL: 
            	this.valorAluguel = movie.value * 0.96;
                break;

            case ROMANCE:
            	this.valorAluguel = movie.value * 0.85;
                break;
                
            case TERROR: 
            	this.valorAluguel = movie.value * 0.8;
                break;

            default:
                this.valorAluguel = movie.value;
                break;
        }
		
		if(client.isActive == true) {
			this.client = client;
			this.movie = movie;
			this.date = date;
			this.hour = hour;
			
			return "Cliente criado!";
		}
		return "Cliente não está ativo!";
	}
	
	public void alugarFavoritos(Cliente client, String date, String hour) {
		this.client = client;
		this.date = date;
		this.hour = hour;
		for(Filme filme: client.favMovies) {	
			this.movie = filme;
		}
	}

}
