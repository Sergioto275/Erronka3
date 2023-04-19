package DB;

import java.util.Arrays;

public class Produktu {
		private int id;
		private String kategoria;
		private String izena;
		private String deskribapena;
		private double balioa;
		private double salneurria;
		private Inbentario [] inbentario;
		
		public Produktu() {}

		public Produktu(int id, String kategoria, String izena, String deskribapena, double balioa, double salneurria) {
			super();
			this.id = id;
			this.kategoria = kategoria;
			this.izena = izena;
			this.deskribapena = deskribapena;
			this.balioa = balioa;
			this.salneurria = salneurria;
			this.inbentario = new Inbentario[0];
		}

		public int getProd_kodea() {
			return this.id;
		}

		public void setProd_kodea(int prod_kodea) {
			this.id = prod_kodea;
		}

		public String getKategoria() {
			return this.kategoria;
		}

		public void setKategoria(String kategoria) {
			this.kategoria = kategoria;
		}

		public String getIzena() {
			return this.izena;
		}

		public void setIzena(String izena) {
			this.izena = izena;
		}

		public String getDeskribapena() {
			return this.deskribapena;
		}

		public void setDeskribapena(String deskribapena) {
			this.deskribapena = deskribapena;
		}

		public double getBalioa() {
			return this.balioa;
		}

		public void setBalioa(double balioa) {
			this.balioa = balioa;
		}

		public double getUneko_salneurria() {
			return this.salneurria;
		}

		public void setUneko_salneurria(double uneko_salneurria) {
			this.salneurria = uneko_salneurria;
		}

		public Inbentario[] getInbentario() {
			return inbentario;
		}

		public void setInbentario(Inbentario[] inbentario) {
			this.inbentario = inbentario;
		}
		
		public void addInbentario(Inbentario inbentario) {
			this.inbentario = Arrays.copyOf(this.inbentario, this.inbentario.length+1);
			this.inbentario[this.inbentario.length-1] = inbentario;
		}

		@Override
		public String toString() {
			return "Produktu [id=" + id + ", kategoria=" + kategoria + ", izena=" + izena + ", deskribapena="
					+ deskribapena + ", balioa=" + balioa + ", salneurria=" + salneurria + ", inbentario="
					+ Arrays.toString(inbentario) + "]";
		}
		
		
}
