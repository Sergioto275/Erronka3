package DB;

public class Langile {
	protected String izena;
	protected String abizena;
	protected String id;
	protected String email;
	protected String kontratatze_data;
	protected String telefonoa;
	protected String idNagusia;
	
	public Langile() {}

	public Langile(String izena, String abizena, String id, String email, String kontratatze_data, String telefonoa,
			String idNagusia) {
		super();
		this.izena = izena;
		this.abizena = abizena;
		this.id = id;
		this.email = email;
		this.kontratatze_data = kontratatze_data;
		this.telefonoa = telefonoa;
		this.idNagusia = idNagusia;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getIdNagusia() {
		return idNagusia;
	}

	public void setIdNagusia(String idNagusia) {
		this.idNagusia = idNagusia;
	}

	@Override
	public String toString() {
		return "Langile [izena=" + izena + ", abizena=" + abizena + ", id=" + id + ", email=" + email
				+ ", kontratatze_data=" + kontratatze_data + ", telefonoa=" + telefonoa + ", idNagusia=" + idNagusia
				+ "]";
	}
	
	
}
