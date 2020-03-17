package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib; //Potrebbe essere utilizzata anche da altri metodi a parte run
	
	private void run() {
		this.lib = new Libretto(); //Crea un libretto vuoto
		
		Voto v1 = new Voto("Tecniche di Programmazione", 30, LocalDate.of(2020, 06, 15));
		Voto v2 = new Voto("Analisi II", 28, LocalDate.of(2020, 06, 28));
		
		lib.add(v1);
		lib.add(v2);
		lib.add(new Voto("Economia", 24, LocalDate.of(2020, 02, 14)));
		
		System.out.println(this.lib);
		
		System.out.println(this.lib.stampaVotiUguali(28));
		
		System.out.println(this.lib.estraiVotiUguali(28));
	}
	
	public static void main(String[] args) {
		TestLibretto test = new TestLibretto(); //Creo un'istanza di me stesso, cosi' creo un oggetto test
		test.run(); // qua gli dice cosa fare, ma sara' tutto dentro al metodo run, non al main
	}

}
