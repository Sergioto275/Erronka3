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
    		  s = new Saltzailea(rt.getString("IZENA"),rt.getString("ABIZENA"),rt.getString("ID"),rt.getString("EMAILA"),rt.getString("KONTRATAZIO_DATA"),rt.getString("TELEFONOA"),rt.getString("ID_NAGUSI"),rt.getString("ERABILTZAILEA"),rt.getString("PASAHITZA"));
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

}