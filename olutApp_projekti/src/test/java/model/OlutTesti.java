package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OlutTesti {
@Test
	public void setOlutNimi() {
		Olut olut = new Olut();
		olut.setNimi("Stella");
		assertEquals("Stella", olut.getNimi());
	}

@Test
public void setOlutArvosanaYli() {
	Olut olut = new Olut();
	double odotettuArvosana = 5;
	olut.setArvosana(6);
	assertEquals(olut.getArvosana(), odotettuArvosana);
}
@Test
public void setOlutArvosanaAlle() {
	Olut olut = new Olut();
	double odotettuArvosana = 0;
	olut.setArvosana(-1);
	assertEquals(olut.getArvosana(), odotettuArvosana);
}
@Test
public void setArvosanaTypo() {
	Olut olut = new Olut();
	olut.setArvosana(4.754);
	double kelvollinenArvosana = 4.75;
	double arvosana = olut.getArvosana();
	System.out.println(arvosana);
	assertEquals(arvosana, kelvollinenArvosana);
}

}