package it.polito.tdp.model;

public class RichWord {
	
	private String parola;
	private boolean corretta;
	
	public RichWord(String parola) {
		this.parola = parola;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public boolean isCorretta() {
		return corretta;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}
	
	

}
