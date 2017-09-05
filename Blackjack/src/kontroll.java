import java.util.ArrayList;
import java.util.Random;

public class kontroll {

	public static kontroll kontrolll = null;
	public static kontroll getkontroll() {
		if (kontrolll == null)
			kontrolll = new kontroll();
		return kontrolll;
	
	
	
		
	}
	
	// Henter Number array legger det inn i kortet, burde kalt dette for kortstokk.
	private ArrayList<Number> kortet;
	
	
	public kontroll () {
		this.kortet = new ArrayList<Number>();
		
	}
	
	
	
	
	
	// Stokke bunken med random putter det inn i tmpstokk
	public void stokke() {
		ArrayList<Number> tmpStokk = new ArrayList<Number>();
		Random random = new Random();
		int randomkortindeks = 0;
		int orginalstorrelse = this.kortet.size();
		for (int i= 0; i < orginalstorrelse; i++) {
			// Lag random indeksen
			randomkortindeks = random.nextInt((this.kortet.size()-1 -0) + 1) + 0;
			tmpStokk.add(this.kortet.get(randomkortindeks));
			
			this.kortet.remove(randomkortindeks);
			
		}
		this.kortet = tmpStokk;
		
	}
	
	// Lager et helt nytt dekk
	public void lagfulltdekk() {
		for (Farge kortfarge : Farge.values()) {
			for (Kort kortverdi : Kort.values()) {
				this.kortet.add(new Number(kortverdi,kortfarge));
			}
			
		}
	}
	
	public String skrivut() {
		String kortut = "";
		
		for (Number akort : this.kortet) {
			kortut += "\n " + akort.toString();
		
		}
	return kortut;
	
	}
	
	public void fjernkort(int i) {
		this.kortet.remove(i);
	}
	
	public Number skaffkort(int i) {
		return this.kortet.get(i);
	}
	public void leggtilkort(Number skaffkort1) {
		this.kortet.add(skaffkort1);
	}
	
	public void trekk(kontroll kommerfra) {
		this.kortet.add(kommerfra.skaffkort(0));
		kommerfra.fjernkort(0);
	}
	
	public int getdealerkortverdi () {
		
		
		int verdideal = 0;
		int esset = 0;
		
		
		for (Number akort : this.kortet) {
			switch(akort.skaffverdi()) {
			
			case To: verdideal =2; break;
			case Tre: verdideal =3; break;
			case Fire: verdideal =4; break;
			case Fem: verdideal =5; break;
			case Seks: verdideal =6; break;
			case Sju: verdideal =7; break;
			case Atte: verdideal =8; break;
			case Ni: verdideal =9; break;
			case Ti: verdideal =10; break;
			case Elleve: verdideal =10; break;
			case Tolv: verdideal =10; break;
			case Tretten: verdideal =10; break;
			case En: verdideal = 11; break;
			}
		}
		
		
		return verdideal;
		
	}
	
	// Returnere verdi av totalt kort i decket
	public int kortverdi() {
		int fullverdi = 0;
		int esset = 0;
		
		for (Number akort : this.kortet) {
			switch(akort.skaffverdi()) {
			
			case To: fullverdi +=2; break;
			case Tre: fullverdi +=3; break;
			case Fire: fullverdi +=4; break;
			case Fem: fullverdi +=5; break;
			case Seks: fullverdi +=6; break;
			case Sju: fullverdi +=7; break;
			case Atte: fullverdi +=8; break;
			case Ni: fullverdi +=9; break;
			case Ti: fullverdi +=10; break;
			case Elleve: fullverdi +=10; break;
			case Tolv: fullverdi +=10; break;
			case Tretten: fullverdi +=10; break;
			case En: esset +=1; break;
			}
		}
		for (int i=0; i < esset; i++) {
			if (fullverdi > 10) {
				fullverdi += 1;
			}
			else {
				fullverdi +=11;
			}
		}
		return fullverdi;
	}
	
	
	public int dekkstorrelse() {
		return this.kortet.size();
		
	}
	
	public void flyttalttildekk (kontroll flytttil) {
		int Dettedekketstorrelse = this.kortet.size();
		
	

	
	for (int i =0; i <Dettedekketstorrelse; i++) {
		flytttil.leggtilkort(this.skaffkort(i));
		}
	
	for(int i = 0; i < Dettedekketstorrelse; i++) {
		this.fjernkort(0);
	}
	}
	
	 
	public static kontroll start () {
		try {
			App window = new App ();
			window.frame.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	
	
	
	
	}
	//	 Random randomGenerator = new Random();
	// int randomInt = randomGenerator.nextInt(11);     			
	//	int randomINt = randomInt;		  		   
