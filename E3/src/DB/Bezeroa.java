package DB;

import java.util.Arrays;

public class Bezeroa {
	private String izena;
	private String abizena;
	private String helbidea;
	private String id;
	private String email;
	private String[] telefonoa;
	
	public Bezeroa() {}
	
	public Bezeroa(String izena, String abizena, String helbidea, String nan, String email, String[] telefonoa) {
		this.izena = izena;
		this.abizena = abizena;
		this.helbidea = helbidea;
		this.id = nan;
		this.email = email;
		this.telefonoa = telefonoa;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizena() {
		return this.abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getHelbidea() {
		return this.helbidea;
	}

	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String nan) {
		this.id = nan;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String[] getTelefonoa() {
		return this.telefonoa;
	}

	public void setTelefonoa(String[] telefonoa) {
		this.telefonoa = telefonoa;
	}

	@Override
	public String toString() {
		return "Bezeroa [izena=" + this.izena + ", abizena=" + this.abizena + ", helbidea=" + this.helbidea + ", Id=" + this.id
				+ ", email=" + this.email + ", telefonoa=" + Arrays.toString(this.telefonoa) + "]";
	}
	
	
}
