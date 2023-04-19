package DB;

public class Bulegaria extends Langile {
	private String lanpostua;
	
	public Bulegaria() {
		super();
	}

	public Bulegaria(String izena, String abizena, String id, String email, String kontratatze_data, String telefonoa, String idNagusia,
			String lanpostua) {
		super(izena, abizena, id,email, kontratatze_data, telefonoa, idNagusia);
		this.lanpostua = lanpostua;
	}

	public String getLanpostua() {
		return this.lanpostua;
	}

	public void setLanpostua(String lanpostua) {
		this.lanpostua = lanpostua;
	}

	@Override
	public String toString() {
		return "Bulegaria [lanpostua=" + lanpostua + ", izena=" + izena + ", abizena=" + abizena + ", id=" + id
				+ ", email=" + email + ", kontratatze_data=" + kontratatze_data + ", telefonoa=" + telefonoa
				+ ", idNagusia=" + idNagusia + "]";
	}
	
	
}
