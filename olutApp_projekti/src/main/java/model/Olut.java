package model;

import java.text.DecimalFormat;

public class Olut {
	private int olut_id;
	private String nimi;
	private String maa;
	private String tyyppi;
	private double prosentit;
	private double arvosana;
	
	public Olut() {
		super();
		this.olut_id = 0;
		this.nimi = null;
		this.maa = null;
		this.tyyppi = null;
		this.prosentit = 0.0;
		this.arvosana = 0.0;
	}

	public Olut(int olut_id, String nimi, String maa, String tyyppi, double prosentit, double arvosana) {
		super();
		this.olut_id = olut_id;
		this.nimi = nimi;
		this.maa = maa;
		this.tyyppi = tyyppi;
		this.prosentit = prosentit;
		this.arvosana = arvosana;
	}

	public Olut(String nimi, String maa, String tyyppi, double prosentit, double arvosana) {
		super();
		this.nimi = nimi;
		this.maa = maa;
		this.tyyppi = tyyppi;
		this.prosentit = prosentit;
		this.arvosana = arvosana;
	}

	public int getOlut_id() {
		return olut_id;
	}

	public void setOlut_id(int olut_id) {
		this.olut_id = olut_id;
	}

	public String getMaa() {
		return maa;
	}

	public void setMaa(String maa) {
		this.maa = maa;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getmaa() {
		return maa;
	}

	public void setmaa(String maa) {
		this.maa = maa;
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	public double getProsentit() {
		return prosentit;
	}

	public void setProsentit(double prosentit) {
		this.prosentit = prosentit;
	}
	
	public double getArvosana() {
	
		if (arvosana > 5) {
			arvosana = 5;
		}
		else if (arvosana < 0) {
			arvosana = 0;
		}
		
		return arvosana;
	}

	public void setArvosana(double arvosana) {
		this.arvosana = arvosana;
	}
	
	@Override
	public String toString() {
		return "[olut_id=" + olut_id + ", nimi=" + nimi + ", maa=" + maa + ", tyyppi=" + tyyppi + ", prosentit="
				+ prosentit + ", arvosana=" + arvosana + "]";
	}
	
}
