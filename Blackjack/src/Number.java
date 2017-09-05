import java.util.ArrayList;
import java.util.Random;


public class Number {
	

private Kort kort;
private Farge farge;


	
public Number(Kort kort, Farge farge) {
	this.kort = kort;
	this.farge = farge;
	
}
	// TOstring metode
public String toString() {
	return this.kort.toString() + "-" + this.farge.toString()
; }

	
public Kort skaffverdi() {
	return this.kort;
	
}

}
