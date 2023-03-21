package it.polito.tdp.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dictionary {
	
	private Set<String> insieme = new HashSet();
	
	public void loadDictionary(String language) {
		try {
			FileReader fr = new FileReader("/Users/macbook/git/Lab03/src/main/resources/"+language+".txt");
			BufferedReader br = new BufferedReader(fr); 
			String word;
			while((word = br.readLine()) != null) {
				insieme.add(word);
			 }
			br.close();
			} 
		catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
	}
	
	public List<String> pulisciStringhe(String s){
		List<String> daRestituire = new ArrayList<String>();
		//pulisco la stringa
		s.toLowerCase().replaceAll("“[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		//separo sugli spazi
		for(String temp: s.split(" ")) {
			daRestituire.add(temp);
		}
		return daRestituire;
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> listaRich = new ArrayList<RichWord>();
		for(String s: inputTextList) {
			RichWord r = new RichWord(s);
			if(insieme.contains(s))
				r.setCorretta(true);
			else
				r.setCorretta(false);
			listaRich.add(r);
		}
		return listaRich;
	}
	
	public Object[] stampaContaSbagliate(String partenza) {
		Object daRestituire[] = new Object[2];
		String daStampare = "";
		int cntSbagliate = 0;
		List<RichWord> parole = this.spellCheckText(this.pulisciStringhe(partenza));
		for(RichWord r: parole) {
			if(!r.isCorretta()) {
				daStampare += r.getParola() + "\n";
				cntSbagliate++;
			}
				
		}
		daRestituire[0] = daStampare;
		daRestituire[1] = cntSbagliate;
		return daRestituire;
	}
	

}
