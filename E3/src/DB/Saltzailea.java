package DB;

public class Saltzailea extends Langile{
	private String erabiltzaile;
	private String pasahitza;
	
	public Saltzailea() {}
	
	public Saltzailea(String izena, String abizena, String id, String email, String kontratatze_data, String telefonoa,
			String idNagusia, String erabiltzaile, String pasahitza) {
		super(izena, abizena, id, email, kontratatze_data, telefonoa, idNagusia);
		this.erabiltzaile = erabiltzaile;
		this.pasahitza = pasahitza;
	}
	
	public String getErabiltzaile() {
		return this.erabiltzaile;
	}
	
	public void setErabiltzaile(String erabiltzaile) {
		this.erabiltzaile = erabiltzaile;
	}
	
	public String getPasahitza() {
		return this.pasahitza;
	}
	
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	
	@Override	
	public String toString() {
		return "Saltzailea [erabiltzaile=" + this.erabiltzaile + ", pasahitza=" + this.pasahitza + ", izena=" + this.izena
				+ ", abizena=" + this.abizena + ", NAN=" + this.id +", email= "+this.email+", Kontratatze_data=" + this.kontratatze_data + ", telefonoa="
				+ this.telefonoa + ", IdNagusia=" + this.idNagusia + "]";
	}	
}
