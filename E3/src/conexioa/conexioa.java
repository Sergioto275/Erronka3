package conexioa;

import java.sql.*;
import java.util.Arrays;

import javax.swing.*;

import DB.*;

public class conexioa{
      private Connection c;
      private String url;
      private String erabiltzailea;       
      private String pasahitza;
      
      public conexioa(){}

      public conexioa(String url, String erabiltzailea, String pasahitza){
         this.url = url;
         this.erabiltzailea = erabiltzailea;
         this.pasahitza = pasahitza;
         try{
            this.c = DriverManager.getConnection(url, erabiltzailea, pasahitza);
         }catch(Exception e){
            String mensaje = ""+e;
            JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
         }
      }
//ERABILTZAILEA ----------------------------------------------------------------------------------------------------------------------------------------------
      public Saltzailea erabiltzaileKontsulta(String erab) {
    	  Saltzailea s = null;
    	  try {
    		  String Kontsulta = "SELECT L.IZENA, L.ABIZENA, L.ID, L.EMAILA, L.KONTRATAZIO_DATA, L.TELEFONOA, L.ID_NAGUSI, S.ERABILTZAILEA, S.PASAHITZA FROM LANGILE L, SALTZAILE S WHERE ERABILTZAILEA = ? AND L.ID = S.ID";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setString(1, erab);
    		  ResultSet rt = st.executeQuery();
    		  rt.next();
    		  s = new Saltzailea(rt.getString("IZENA"),rt.getString("ABIZENA"),rt.getInt("ID"),rt.getString("EMAILA"),rt.getString("KONTRATAZIO_DATA"),rt.getString("TELEFONOA"),rt.getInt("ID_NAGUSI"),rt.getDouble("SOLDATA"),rt.getString("ERABILTZAILEA"),rt.getString("PASAHITZA"));
    		  rt.close();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
    	  return s;
      }
//BEZEROAK ----------------------------------------------------------------------------------------------------------------------------------------------
      public BezeroDB bezeroKontsulta() {
    	  BezeroDB bdb = new BezeroDB();
    	  try {
    		  Statement st = this.c.createStatement();
    		  String kontsulta = "SELECT * FROM BEZERO B, BEZERO_TELEFONO BT WHERE B.ID = BT.ID_BEZERO ORDER BY B.ID ASC";
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  Bezeroa b = new Bezeroa(rt.getString("IZENA"),rt.getString("ABIZENA"),rt.getString("HELBIDEA"),rt.getInt("ID"),rt.getString("EMAILA"),rt.getString("ZENBAKIA"));
    			  bdb.addBezero(b);
    		  }
    		  rt.close();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return bdb;
      }
      
      public void bezeroInsert(int id, String izena, String abizena, String email, String helbidea, String telefonoa) {
    	  try {
    		  String Kontsulta = "INSERT INTO BEZERO VALUES (?,?,?,?,?)";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.setString(2, izena);
    		  st.setString(3, abizena);
    		  st.setString(4, helbidea);
    		  st.setString(5, email);
    		  st.executeQuery();
    		  st.close();
    		  String Kontsulta2 = "INSERT INTO BEZERO_TELEFONO VALUES(1,?,?)";
    		  PreparedStatement st2 = this.c.prepareStatement(Kontsulta2);
    		  st2.setInt(1, id);
    		  st2.setString(2, telefonoa);
    		  st2.executeQuery();
    		  st2.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
      public void bezeroUpdate(int id, String izena, String abizena, String email, String helbidea, String telefonoa) {
    	  try {
    		  String Kontsulta = "UPDATE BEZERO SET IZENA = ?, ABIZENA = ?, EMAILA = ?, HELBIDEA = ? WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setString(1, izena);
    		  st.setString(2, abizena);
    		  st.setString(3, email);
    		  st.setString(4, helbidea);
    		  st.setInt(5, id);
    		  st.executeUpdate();
    		  st.close();
    		  String Kontsulta2 = "UPDATE BEZERO_TELEFONO SET ZENBAKIA = ? WHERE ID = ?";
    		  PreparedStatement st2 = this.c.prepareStatement(Kontsulta2);
    		  st2.setString(1, telefonoa);
    		  st2.setInt(2, id);
    		  st2.executeUpdate();
    		  st2.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
      public void bezeroDelete(int id) {
    	  try {
    		  String Kontsulta = "DELETE FROM BEZERO WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
//PRODUKTUAK ----------------------------------------------------------------------------------------------------------------------------------------------

      public ProduktuDB produktuKontsulta() {
    	  ProduktuDB pdb = new ProduktuDB();
    	  try {
    		  Statement st = this.c.createStatement();
    		  String kontsulta = "SELECT P.ID, P.IZENA, P.DESKRIBAPENA, P.BALIOA, P.SALNEURRIA, K.IZENA AS KIZENA FROM PRODUKTU P, KATEGORIA K WHERE P.ID_KATEGORIA = K.ID ORDER BY P.ID ASC";
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  Produktu p = new Produktu(rt.getInt("ID"),rt.getString("IZENA"),rt.getString("DESKRIBAPENA"),rt.getDouble("BALIOA"),rt.getDouble("SALNEURRIA"),rt.getString("KIZENA"),produktuInbKontsulta(rt.getInt("ID")));
    			  pdb.addProduktua(p);
    		  }
    		  rt.close();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return pdb;
      }
      
      public Inbentario[] produktuInbKontsulta(int idProd) {
    	  Inbentario[] i = new Inbentario[0];
    	  try {
    		  String kontsulta = "SELECT ID_BILTEGI, KOPURUA FROM INBENTARIO WHERE ID_PRODUKTU = ? ORDER BY ID_BILTEGI ASC";
    		  PreparedStatement st = this.c.prepareStatement(kontsulta);
    		  st.setInt(1, idProd);
    		  ResultSet rt = st.executeQuery();
    		  while(rt.next()) {
    			  Inbentario inb = new Inbentario(rt.getInt("ID_BILTEGI"),rt.getInt("KOPURUA"));
    			  i = Arrays.copyOf(i, i.length+1);
    			  i[i.length-1]=inb;
    		  }
    		  rt.close();
    		  st.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return i;
      }
      
      public String[] produktuKatKontsulta() {
    	  String[] i = new String[0];
    	  try {
    		  String kontsulta = "SELECT IZENA FROM KATEGORIA ORDER BY ID";
    		  Statement st = this.c.createStatement();
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  String kat = rt.getString("IZENA");
    			  i = Arrays.copyOf(i, i.length+1);
    			  i[i.length-1]=kat;
    		  }
    		  rt.close();
    		  st.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return i;
      }
      
      public void produktuDelete(int id) {
    	  try {
    		  String Kontsulta = "DELETE FROM PRODUKTU WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
      public void produktuUpdate(int id, String izena, String deskribapena, double balioa, double salneurria, String kategoria) {
    	  try {
    		  String Kontsulta = "UPDATE PRODUKTU SET IZENA = ?, DESKRIBAPENA = ?, BALIOA = ?, SALNEURRIA = ?, ID_KATEGORIA = (SELECT ID FROM KATEGORIA WHERE IZENA = ?) WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setString(1, izena);
    		  st.setString(2, deskribapena);
    		  st.setDouble(3, balioa);
    		  st.setDouble(4, salneurria);
    		  st.setString(5, kategoria);
    		  st.setInt(6, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
      public void produktuInsert(int id, String izena, String deskribapena, double balioa, double salneurria, String kategoria) {
    	  try {
    		  String Kontsulta = "INSERT INTO PRODUKTU SELECT ?,?,?,?,?,ID FROM KATEGORIA WHERE IZENA = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.setString(2, izena);
    		  st.setString(3, deskribapena);
    		  st.setDouble(4, balioa);
    		  st.setDouble(5, salneurria);
    		  st.setString(6, kategoria);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
      public void inbentarioDelete(int idProd,int idBiltegi) {
    	  try {
    		  String Kontsulta = "DELETE FROM INBENTARIO WHERE ID_PRODUKTU = ? AND ID_BILTEGI = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, idProd);
    		  st.setInt(1, idBiltegi);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
      public void inbentarioUpdate(int kopurua, int idProd,int idBiltegi) {
    	  try {
    		  String Kontsulta = "UPDATE INBENTARIO SET KOPURUA = ? WHERE ID_PRODUKTU = ? AND ID_BILTEGI = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1,kopurua );
    		  st.setInt(2, idProd);
    		  st.setInt(3, idBiltegi);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
      public void inbentarioInsert(int kopurua, int idProd,int idBiltegi) {
    	  try {
    		  String Kontsulta = "INSERT INTO INBENTARIO VALUES (?,?,?)";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  System.out.println(idProd);
    		  st.setInt(1, idProd);
    		  System.out.println(idBiltegi);

    		  st.setInt(2, idBiltegi);
    		  System.out.println(kopurua);

    		  st.setInt(3, kopurua);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
//ESKARIAK ----------------------------------------------------------------------------------------------------------------------------------------------
      public EskariDB eskariKontsulta() {
    	  EskariDB edb = new EskariDB();
    	  try {
    		  Statement st = this.c.createStatement();
    		  String kontsulta = "SELECT E.ID, E.ID_BEZERO, EG.DESKRIBAPENA, E.ID_SALTZAILE, TO_CHAR(E.ESKAERA_DATA,'YYYY/MM/DD') AS ESKAERA_DATA FROM ESKARI E, ESKARI_EGOERA EG WHERE E.ID_EGOERA = EG.ID ORDER BY E.ID ASC";
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  Eskaria e = new Eskaria(rt.getInt("ID"),rt.getInt("ID_BEZERO"),rt.getInt("ID_SALTZAILE"),rt.getString("DESKRIBAPENA"),rt.getString("ESKAERA_DATA"),eskariInfoKontsulta(rt.getInt("ID")));
    			  edb.addEskaria(e);
    		  }
    		  rt.close();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return edb;
      }
      
      public Eskari_Info[] eskariInfoKontsulta(int idEsk) {
    	  Eskari_Info[] esk = new Eskari_Info[0];
    	  try {
    		  String kontsulta = "SELECT ID_LERRO, ID_PRODUKTU, KOPURUA, SALNEURRIA FROM ESKARI_LERRO WHERE ID_ESKARI = ? ORDER BY ID_LERRO ASC";
    		  PreparedStatement st = this.c.prepareStatement(kontsulta);
    		  st.setInt(1,idEsk);
    		  ResultSet rt = st.executeQuery();
    		  while(rt.next()) {
    			  Eskari_Info e = new Eskari_Info(rt.getInt("ID_LERRO"),rt.getInt("ID_PRODUKTU"),rt.getInt("KOPURUA"),rt.getDouble("SALNEURRIA"));
    			  esk = Arrays.copyOf(esk, esk.length+1);
    			  esk[esk.length-1]= e;
    		  }
    		  rt.close();
    		  st.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return esk;
      }
      
      public void eskariDelete(int id) {
    	  try {
    		  String Kontsulta = "DELETE FROM ESKARI WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
      public void eskariUpdate(int id, int id_bez, int id_saltzaile, String data, String deskribapena) {
    	  try {
    		  String Kontsulta = "UPDATE ESKARI SET ID_BEZERO = ?, ID_SALTZAILE = ?, ESKAERA_DATA = TO_DATE(?,'YYYY/MM/DD'), ID_EGOERA = (SELECT ID FROM ESKARI_EGOERA WHERE DESKRIBAPENA = ?) WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id_bez);
    		  st.setInt(2, id_saltzaile);
    		  st.setString(3, data);
    		  st.setString(4, deskribapena);
    		  st.setInt(5, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
      public void eskariInsert(int id, int id_bez, int id_saltzaile, String data, String deskribapena) {
    	  try {
    		  String Kontsulta = "INSERT INTO ESKARI SELECT ?,?,ID,?,TO_DATE(?,'YYYY/MM/DD') FROM ESKARI_EGOERA WHERE DESKRIBAPENA = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.setInt(2, id_bez);
    		  st.setInt(3, id_saltzaile);
    		  st.setString(4, data);
    		  st.setString(5, deskribapena);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
      public String[] eskariEgKontsulta() {
    	  String[] i = new String[0];
    	  try {
    		  String kontsulta = "SELECT DESKRIBAPENA FROM ESKARI_EGOERA ORDER BY ID";
    		  Statement st = this.c.createStatement();
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  String eg = rt.getString("DESKRIBAPENA");
    			  i = Arrays.copyOf(i, i.length+1);
    			  i[i.length-1]=eg;
    		  }
    		  rt.close();
    		  st.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return i;
      }
      
      public void eskariInfoDelete(int idEsk,int id) {
    	  try {
    		  String Kontsulta = "DELETE FROM ESKARI_LERRO WHERE ID_ESKARI = ? AND ID_LERRO = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, idEsk);
    		  st.setInt(1, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
      public void eskariInfoUpdate(int idEsk,int id, int idProd, int kopurua, Double salneurria) {
    	  try {
    		  String Kontsulta = "UPDATE ESKARI_LERRO SET ID_PRODUKTU = ?, SALNEURRIA = ?,KOPURUA = ? WHERE ID_ESKARI = ? AND ID_LERRO = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1,idProd);
    		  st.setDouble(2, salneurria);
    		  st.setInt(3, kopurua);
    		  st.setInt(4, idEsk);
    		  st.setInt(5, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
// SALTZAILEAK ------------------------------------------------------------------------------------------------------------------------------------------------------
      public SaltzaileDB saltzaileakKontsulta() {
    	  SaltzaileDB sdb = new SaltzaileDB();
    	  try {
    		  Statement st = this.c.createStatement();
    		  String kontsulta = "SELECT L.IZENA, L.ABIZENA, L.ID, L.EMAILA, TO_CHAR(L.KONTRATAZIO_DATA,'YYYY/MM/DD') AS KONTRATAZIO_DATA, L.TELEFONOA, L.ID_NAGUSI, L.SOLDATA,  S.ERABILTZAILEA, S.PASAHITZA FROM LANGILE L, SALTZAILE S WHERE L.ID = S.ID ORDER BY L.ID ASC";
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  Saltzailea s = new Saltzailea(rt.getString("IZENA"),rt.getString("ABIZENA"),rt.getInt("ID"),rt.getString("EMAILA"),rt.getString("KONTRATAZIO_DATA"),rt.getString("TELEFONOA"),rt.getInt("ID_NAGUSI"),rt.getDouble("SOLDATA"),rt.getString("ERABILTZAILEA"),rt.getString("PASAHITZA"));
    			  sdb.addSaltzailea(s);
    		  }
    		  rt.close();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREAK",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return sdb;
      }
      
      public void saltzaileInsert(int id, String izena, String abizena, String email, String k_data, String telefonoa, int id_nagusia,double soldata, String erabiltzailea, String pasahitza) {
    	  try {
    		  String Kontsulta = "INSERT INTO LANGILE VALUES (?,?,?,?,?,TO_DATE(?,'YYYY/MM/DD'),?,?)";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.setString(2, izena);
    		  st.setString(3, abizena);
    		  st.setString(4, email);
    		  st.setString(5, telefonoa);
    		  st.setString(6, k_data);
    		  st.setInt(7, id_nagusia);
    		  st.setDouble(8, soldata);
    		  st.executeQuery();
    		  st.close();
    		  String Kontsulta2 = "INSERT INTO SALTZAILE VALUES(?,?,?)";
    		  PreparedStatement st2 = this.c.prepareStatement(Kontsulta2);
    		  st2.setInt(1, id);
    		  st2.setString(2, erabiltzailea);
    		  st2.setString(3, pasahitza);
    		  st2.executeQuery();
    		  st2.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
      public void saltzaileUpdate(int id, String izena, String abizena, String email, String k_data, String telefonoa, int id_nagusia,double soldata, String erabiltzailea, String pasahitza) {
    	  try {
    		  String Kontsulta = "UPDATE LANGILE SET IZENA = ?, ABIZENA = ?, EMAILA = ?, KONTRATAZIO_DATA = TO_DATE(?,'YYYY/MM/DD'), TELEFONOA = ?, ID_NAGUSI = ?, SOLDATA = ? WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setString(1, izena);
    		  st.setString(2, abizena);
    		  st.setString(3, email);
    		  st.setString(4, k_data);
    		  st.setString(5, telefonoa);
    		  st.setInt(6, id_nagusia);
    		  st.setDouble(7, soldata);
    		  st.setInt(8, id);
    		  st.executeUpdate();
    		  st.close();
    		  String Kontsulta2 = "UPDATE SALTZAILE SET ERABILTZAILEA = ?, PASAHITZA = ? WHERE ID = ?";
    		  PreparedStatement st2 = this.c.prepareStatement(Kontsulta2);
    		  st2.setString(1, erabiltzailea);
    		  st2.setString(2, pasahitza);
    		  st2.setInt(3, id);
    		  st2.executeUpdate();
    		  st2.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
      
      public void saltzaileDelete(int id) {
    	  try {
    		  String Kontsulta = "DELETE FROM LANGILE WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
      }
// BULEGARIAK ------------------------------------------------------------------------------------------------------------------------------------------------------
      
// BILTEGIAK ------------------------------------------------------------------------------------------------------------------------------------------------------
}