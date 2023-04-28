package DB;

public class Eskari_Info {
	private int id;
	private int idProd;
	private int kopurua;
	private double salneurria;
	
	public Eskari_Info(int id, int idProd, int kopurua, double salneurria) {
		this.id = id;
		this.idProd = idProd;
		this.kopurua = kopurua;
		this.salneurria = salneurria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public int getKopurua() {
		return kopurua;
	}

	public void setKopurua(int kopurua) {
		this.kopurua = kopurua;
	}

	public double getSalneurria() {
		return salneurria;
	}

	public void setSalneurria(double salneurria) {
		this.salneurria = salneurria;
	}

	@Override
	public String toString() {
		return "Eskari_Info [id=" + id + ", idProd=" + idProd + ", kopurua=" + kopurua + ", salneurria=" + salneurria
				+ "]";
	}
	
	
}
