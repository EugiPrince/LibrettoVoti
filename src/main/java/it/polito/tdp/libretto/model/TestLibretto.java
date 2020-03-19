package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib; //Potrebbe essere utilizzata anche da altri metodi a parte run
	
	private void run() {
		this.lib = new Libretto(); //Crea un libretto vuoto
		
		
		//1) Inserire alcuni voti
		Voto v1 = new Voto("Tecniche di Programmazione", 30, LocalDate.of(2020, 06, 15));
		Voto v2 = new Voto("Analisi II", 28, LocalDate.of(2020, 06, 28));
		
		lib.add(v1);
		lib.add(v2);
		if(lib.add(new Voto("Economia", 24, LocalDate.of(2020, 02, 14)))==false)
				System.out.println("Errore nell'inserimento di Economia");
		
		System.out.println(this.lib);
		
		//2) Stampa tutti i voti pari a 28
		System.out.println(this.lib.stampaVotiUguali(28));
		
		System.out.println(this.lib.estraiVotiUguali(28));
		
		//3) Cerca un esame superato, conoscendo il nome del corso
		String nomeCorso = "Analisi II";
		
		Voto votoAnalisi = this.lib.cercaNomeCorso(nomeCorso);
		System.out.println("Il voto di "+nomeCorso+" e' "+votoAnalisi.getVoto());
		
		//Voto mancante
		Voto votoFisica = this.lib.cercaNomeCorso("Fisica I");
		System.out.println("Il voto di "+nomeCorso+" e' "+votoFisica);
		
		//4) e 5) Verifica voti duplicati e voti in conflitto
		Voto economia2 = new Voto("Economia", 24, LocalDate.now());
		Voto economia3 = new Voto("Economia", 21, LocalDate.now());

		System.out.println("Economia con 24 duplicato: "+lib.isDuplicato(economia2)+"/conflitto: "+lib.isConflitto(economia2));
		System.out.println("Economia con 21 duplicato: "+lib.isDuplicato(economia3)+"/conflitto: "+lib.isConflitto(economia3));

	}
	
	public static void main(String[] args) {
		TestLibretto test = new TestLibretto(); //Creo un'istanza di me stesso, cosi' creo un oggetto test
		test.run(); // qua gli dice cosa fare, ma sara' tutto dentro al metodo run, non al main
	}

}
