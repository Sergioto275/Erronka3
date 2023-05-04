package DB;

public class Langile {
	protected String izena;
	protected String abizena;
	protected int id;
	protected String email;
	protected String kontratatze_data;
	protected String telefonoa;
	protected int idNagusia;
	protected double soldata;
	
	public Langile() {}

	public Langile(String izena, String abizena, int id, String email, String kontratatze_data, String telefonoa,
			int idNagusia, double soldata) {
		super();
		this.izena = izena;
		this.abizena = abizena;
		this.id = id;
		this.email = email;
		this.kontratatze_data = kontratatze_data;
		this.telefonoa = telefonoa;
		this.idNagusia = idNagusia;
		this.soldata = soldata;
	}



	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKontratatze_data() {
		return kontratatze_data;
	}

	public void setKontratatze_data(String kontratatze_data) {
		this.kontratatze_data = kontratatze_data;
	}

	public String getTelefonoa() {
		return telefonoa;
	}

	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}

	public int getIdNagusia() {
		return idNagusia;
	}

	public void setIdNagusia(int idNagusia) {
		this.idNagusia = idNagusia;
	}

	public double getSoldata() {
		return soldata;
	}

	public void setSoldata(double soldata) {
		this.soldata = soldata;
	}

	@Override
	public String toString() {
		return "Langile [izena=" + izena + ", abizena=" + abizena + ", id=" + id + ", email=" + email
				+ ", kontratatze_data=" + kontratatze_data + ", telefonoa=" + telefonoa + ", idNagusia=" + idNagusia
				+ "]";
	}
	
	
}
