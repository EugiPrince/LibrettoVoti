package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Memorizza e gestisce un insieme di voti superati.
 * 
 * @author Fulvio
 *
 */
public class Libretto {

	private List<Voto> voti = new ArrayList<>();

	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v
	 * @return {@code true} se ha inserito il voto, oppure {@code false} se era in conflitto o duplicato
	 */
	public boolean add(Voto v) {
		if(this.isConflitto(v) || this.isDuplicato(v)) { //In realta' si puo' chiamare solo il cercaNomeCorso..
			return false;
		}
		else {
			this.voti.add(v);
			return true;
		}
	}
	
	/**
	 * Dato un libretto, restituisce una stringa nella quale ci sono solo voti uguali al valore
	 * passato per parametro
	 * 
	 * @param voto valore specificato
	 * @return stringa formattata per visualizzare il sotto-libretto
	 */
	public String stampaVotiUguali(int voto) {
		String s = "";
		for(Voto v : this.voti)
			if(v.getVoto()==voto)
				s += v.toString()+"\n";
		return s;
	}
	
	/**
	 * Genera un nuovo libretto, a partire da quello esistente, che conterra' esclusivamente
	 * i voti con votazione pari a quella specificata
	 * @param voto votazione specificata
	 * @return nuovo Libretto
	 */
	public Libretto estraiVotiUguali(int voto) {
		Libretto nuovo = new Libretto();
		for(Voto v : this.voti)
			if(v.getVoto()==voto)
				nuovo.add(v);
		return nuovo;
	}
	
	public String toString() {
		String s = "";
		for(Voto v : this.voti)
			s += v.toString()+"\n";
		return s;
	}

	/**
	 * Dato il nome di un corso ricerca se l'esame esiste nel libretto ed in tal caso restituisce
	 * l'oggetto {@Link Voto} corrispondente
	 * Se l'esame non esiste, restituisce null
	 * 
	 * @param nomeCorso nome esame da cercare
	 * @return voto corrispondente oppure {@code null} (se non esiste)
	 */
	public Voto cercaNomeCorso(String nomeCorso) {
		/*for(Voto v : this.voti)
			if(nomeCorso.compareTo(v.getCorso())==0)
				return v;
		
		return null;*/
		
		//Oppure uso indexOf (ma ho aggiungo equals in voto senno' non potrei)
		int i = this.voti.indexOf(new Voto(nomeCorso, 0, null));//Voto e data a caso, mi creo un oggetto che non entra nel libretto
		if(i!=-1)
			return this.voti.get(i);
		else
			return null;
	}
	
	/**
	 * Ritorna true se il corso specificato da v e' gia' esistente
	 * nel libretto, con la stessa valutazione. Se non esiste o la valutazione e' diversa
	 * ritora false
	 * 
	 * @param v voto da ricercare
	 * @return esistenza del duplicato
	 */
	public boolean isDuplicato(Voto v) {
		Voto result = this.cercaNomeCorso(v.getCorso());
		if(result==null)
			return false;
		
		/*if(result.getVoto()==v.getVoto())
			return true;
		
		return false;
		*/
		return (result.getVoto()==v.getVoto());
	}
	
	/**
	 * Determina se esiste un corso con lo stesso nome ma un voto diverso
	 * 
	 * @param v
	 * @return
	 */
	public boolean isConflitto(Voto v) {
		Voto result = this.cercaNomeCorso(v.getCorso());
		if(result==null)
			return false;
		
		return (result.getVoto()!=v.getVoto());
	}
}
