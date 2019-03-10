/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje4;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
/**
 *
 * @author ABRA
 */
public class Sorgu extends javax.swing.JFrame {

    /**
     * Creates new form Sorgu
     */
    public Sorgu() {
        initComponents();
        show_user();
    }
    
    public ArrayList<User> userList(){
        ArrayList<User> usersList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Driverda Hata : " + e.getMessage());
        }
        Connection baglanti = null;
        try {
            baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bağlantıda Hata : " + e.getMessage());
        }
        
        String aracMarka = "%";
        String aracModel = "%";
        String fiyatMins = "0";
        String fiyatMaxs = "99999999";
        String ilanAdi = "%";
        String ilanTarihi = "%";
        String ilanKmmins = "0";
        String ilanKmmaxs = "99999999";
        Integer ilanSehirID;
        String ilanSehirIDs = "%";
        Integer yakitTuruID;
        String yakitTuruIDs = "%";
        Integer vitesTuruID;
        String vitesTuruIDs = "%";
        Integer aracRenkID;
        String aracRenkIDs = "%";

        if (!txtarabamarka.getText().equalsIgnoreCase("")) {
            aracMarka = txtarabamarka.getText();
        }

        if (!txtarabamodel.getText().equalsIgnoreCase("")) {
            aracModel = txtarabamodel.getText();
        }

        if (!txtfiyatmin.getText().equalsIgnoreCase("")) {
            fiyatMins = txtfiyatmin.getText();
        }

        if (!txtfiyatmax.getText().equalsIgnoreCase("")) {
            fiyatMaxs = txtfiyatmax.getText();
        }

        if (!txtilanadi.getText().equalsIgnoreCase("")) {
            ilanAdi = txtilanadi.getText();
        }

        if (!txttarih.getText().equalsIgnoreCase("")) {
            ilanTarihi = txttarih.getText();
        }

        if (!txtkmmin.getText().equalsIgnoreCase("")) {
            ilanKmmins = txtkmmin.getText();
        }

        if (!txtkmmax.getText().equalsIgnoreCase("")) {
            ilanKmmaxs = txtkmmax.getText();
        }

        if (txtsehirid.getSelectedIndex() != 0) {
            ilanSehirID = txtsehirid.getSelectedIndex();
            ilanSehirIDs = ilanSehirID.toString();
        }

        if (txtarabayakitturuid.getSelectedIndex() != 0) {
            yakitTuruID = txtarabayakitturuid.getSelectedIndex();
            yakitTuruIDs = yakitTuruID.toString();
        }

        if (txtarabavitesturuid.getSelectedIndex() != 0) {
            vitesTuruID = txtarabavitesturuid.getSelectedIndex();
            vitesTuruIDs = vitesTuruID.toString();
        }

        if (txtarabarenkid.getSelectedIndex() != 0) {
            aracRenkID = txtarabarenkid.getSelectedIndex();
            aracRenkIDs = aracRenkID.toString();
        }
        
         String cbilanAdi="";
            if(jCBilanAdi.isSelected()==true){
                cbilanAdi="Ilan_Adi";
            }
        try {
            String sql = "SELECT * FROM tbl_araba,tbl_duyuru,tbl_sehir,tbl_renk,tbl_vitesturu,tbl_yakitturu WHERE "
                    +"(tbl_duyuru.Ilan_ArabaID=tbl_araba.ArabaID) AND"
                    +"(tbl_araba.Araba_RenkID=tbl_renk.RenkID )AND "
                    +"(tbl_araba.Araba_VitesTuruID=tbl_vitesturu.VitesTuruID)AND"
                    +"(tbl_araba.Araba_YakitTuruID=tbl_yakitturu.YakitTuruID)AND"
                    +"(tbl_duyuru.Ilan_SehirID=tbl_sehir.SehirID)AND"
                    +"("
                    +"(SELECT Sehir FROM tbl_sehir WHERE SehirID = tbl_duyuru.Ilan_SehirID ) like (SELECT Sehir FROM tbl_Sehir WHERE SehirID='" + ilanSehirIDs + "')"
                    + "AND  (tbl_duyuru.Ilan_Adi like '" + ilanAdi + "')"
                    + "AND  (tbl_duyuru.Ilan_Fiyat between '" + fiyatMins + "' AND '" + fiyatMaxs + "')"
                    + "AND  (tbl_duyuru.Ilan_Km between '" + ilanKmmins + "' AND '" + ilanKmmaxs + "')"
                    + "AND tbl_araba.Araba_Marka in (SELECT Araba_Marka FROM tbl_araba WHERE Araba_Marka like '" + aracMarka + "')"
                    + "AND tbl_araba.Araba_Model in (SELECT Araba_Model FROM tbl_araba WHERE Araba_Model like '" + aracModel + "')" 
                    + "AND ( (SELECT Renk FROM tbl_renk WHERE RenkID = tbl_araba.Araba_RenkID) like (SELECT Renk FROM tbl_renk WHERE RenkID= '"+aracRenkIDs+"')) "
                    + "AND ( (SELECT Vites_Turu FROM tbl_vitesturu WHERE VitesTuruID = tbl_araba.Araba_VitesTuruID) like (SELECT Vites_Turu FROM tbl_vitesturu WHERE VitesTuruID= '"+vitesTuruIDs+"'))"
                    + "AND ( (SELECT Yakit_Turu FROM tbl_yakitturu WHERE YakitTuruID = tbl_araba.Araba_YakitTuruID) like (SELECT Yakit_Turu FROM tbl_yakitturu WHERE YakitTuruID= '"+yakitTuruIDs+"')) ) ORDER BY '"+cbilanAdi+"'";
                    
            
            Statement stmt = null;
            stmt = (Statement) baglanti.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            
            User user;
            while(rs.next()){
                user=new User (rs.getInt("Araba_YakitTuruID"),rs.getInt("Araba_VitesTuruID"),rs.getInt("Araba_RenkID"),rs.getInt("Ilan_Fiyat"),rs.getInt("Ilan_Km"),rs.getInt("Ilan_SehirID"),rs.getString("ArabaID"),rs.getString("Araba_Marka"),rs.getString("Araba_Model"),rs.getString("Ilan_Adi"),rs.getString("Ilan_Tarih"));
                usersList.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Arama Sırasında Hata : " + e.getMessage());
        }
        return usersList;
    }
    
    private  DefaultTableModel model;
   
    public void show_user(){
        ArrayList<User> list = userList();
        DefaultTableModel model =(DefaultTableModel) txttablo.getModel();
        Object[] row = new Object [11];
        for(int i = 0 ;i<list.size();i++){
            row[0]=list.get(i).getIlanAdi();
            row[1]=list.get(i).getIlanFiyat();
            row[2]=list.get(i).getMarka();
            row[3]=list.get(i).getModel();
            row[4]=list.get(i).getRenk();
            row[5]=list.get(i).getVitesTuru();
            row[6]=list.get(i).getYakitTuru();
            row[7]=list.get(i).getIlanKM();
            row[8]=list.get(i).getTarih();
            row[9]=list.get(i).getIlanSehir();
            row[10]=list.get(i).getPlaka();
            model.addRow(row);
        }
        
    }
    
   
  void reset() {
    ArrayList<User> list = userList();
        DefaultTableModel model =(DefaultTableModel) txttablo.getModel();
        Object[] row = new Object [11];
        for(int i = 0 ;i<list.size();i++){
            row[0]=list.get(i).getIlanAdi();
            row[1]=list.get(i).getIlanFiyat();
            row[2]=list.get(i).getMarka();
            row[3]=list.get(i).getModel();
            row[4]=list.get(i).getRenk();
            row[5]=list.get(i).getVitesTuru();
            row[6]=list.get(i).getYakitTuru();
            row[7]=list.get(i).getIlanKM();
            row[8]=list.get(i).getTarih();
            row[9]=list.get(i).getIlanSehir();
            row[10]=list.get(i).getPlaka();
            model.addRow(row);
        }
        
      model.setRowCount(0);
}
    
    
    
    
    
    
    
    
    private void sorgula() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Driverda Hata : " + e.getMessage());
        }
        Connection baglanti = null;
        try {
            baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bağlantıda Hata : " + e.getMessage());
        }

        String aracMarka = "%";
        String aracModel = "%";
        String fiyatMins = "0";
        String fiyatMaxs = "99999999";
        String ilanAdi = "%";
        String ilanTarihi = "%";
        String ilanKmmins = "0";
        String ilanKmmaxs = "99999999";
        Integer ilanSehirID;
        String ilanSehirIDs = "%";
        Integer yakitTuruID;
        String yakitTuruIDs = "%";
        Integer vitesTuruID;
        String vitesTuruIDs = "%";
        Integer aracRenkID;
        String aracRenkIDs = "%";

        if (!txtarabamarka.getText().equalsIgnoreCase("")) {
            aracMarka = txtarabamarka.getText();
        }

        if (!txtarabamodel.getText().equalsIgnoreCase("")) {
            aracModel = txtarabamodel.getText();
        }

        if (!txtfiyatmin.getText().equalsIgnoreCase("")) {
            fiyatMins = txtfiyatmin.getText();
        }

        if (!txtfiyatmax.getText().equalsIgnoreCase("")) {
            fiyatMaxs = txtfiyatmax.getText();
        }

        if (!txtilanadi.getText().equalsIgnoreCase("")) {
            ilanAdi = txtilanadi.getText();
        }

        if (!txttarih.getText().equalsIgnoreCase("")) {
            ilanTarihi = txttarih.getText();
        }

        if (!txtkmmin.getText().equalsIgnoreCase("")) {
            ilanKmmins = txtkmmin.getText();
        }

        if (!txtkmmax.getText().equalsIgnoreCase("")) {
            ilanKmmaxs = txtkmmax.getText();
        }

        if (txtsehirid.getSelectedIndex() != 0) {
            ilanSehirID = txtsehirid.getSelectedIndex();
            ilanSehirIDs = ilanSehirID.toString();
        }

        if (txtarabayakitturuid.getSelectedIndex() != 0) {
            yakitTuruID = txtarabayakitturuid.getSelectedIndex();
            yakitTuruIDs = yakitTuruID.toString();
        }

        if (txtarabavitesturuid.getSelectedIndex() != 0) {
            vitesTuruID = txtarabavitesturuid.getSelectedIndex();
            vitesTuruIDs = vitesTuruID.toString();
        }

        if (txtarabarenkid.getSelectedIndex() != 0) {
            aracRenkID = txtarabarenkid.getSelectedIndex();
            aracRenkIDs = aracRenkID.toString();
        }
        
         String cbilanAdi="";
            if(jCBilanAdi.isSelected()==true){
                cbilanAdi="Ilan_Fiyat";
            }
        try {
             
             ArrayList<String> ilanAdiList = new ArrayList<String>();           //While da donen her ad buna eklenir
             ArrayList<String> ilanAdiList2 = new ArrayList<String>();          //While da donen her farklı adi bir kez tutar
             
             ArrayList<String> ilanFiyatList = new ArrayList<String>();           
             ArrayList<String> ilanFiyatList2 = new ArrayList<String>();
             
             ArrayList<String> aracMarkaList = new ArrayList<String>();           
             ArrayList<String> aracMarkaList2 = new ArrayList<String>();
             
             ArrayList<String> aracModelList = new ArrayList<String>();           
             ArrayList<String> aracModelList2 = new ArrayList<String>();
             
             ArrayList<String> ilanKmList = new ArrayList<String>();           
             ArrayList<String> ilanKmList2 = new ArrayList<String>();
             
             ArrayList<String> ilanSehirList = new ArrayList<String>();           
             ArrayList<String> ilanSehirList2 = new ArrayList<String>();
             
             ArrayList<String> ilanTarihList = new ArrayList<String>();           
             ArrayList<String> ilanTarihList2 = new ArrayList<String>();
             
             ArrayList<String> aracRenkList = new ArrayList<String>();           
             ArrayList<String> aracRenkList2 = new ArrayList<String>();
             
             ArrayList<String> aracVitesTuruList = new ArrayList<String>();           
             ArrayList<String> aracVitesTuruList2 = new ArrayList<String>();
             
             ArrayList<String> aracYakitTuruList = new ArrayList<String>();           
             ArrayList<String> aracYakitTuruList2 = new ArrayList<String>();
             
             ArrayList<String> ilanArabaIDList = new ArrayList<String>();           
             ArrayList<String> ilanArabaIDList2 = new ArrayList<String>();
             
             
             
            String sql = "SELECT * FROM tbl_araba,tbl_duyuru,tbl_sehir,tbl_renk WHERE "
                    + "tbl_duyuru.Ilan_ArabaID=tbl_araba.ArabaID AND("
                    +"(SELECT Sehir FROM tbl_sehir WHERE SehirID = tbl_duyuru.Ilan_SehirID ) like (SELECT Sehir FROM tbl_Sehir WHERE SehirID='" + ilanSehirIDs + "')"
                    + "AND  (tbl_duyuru.Ilan_Adi like '" + ilanAdi + "')"
                    + "AND  (tbl_duyuru.Ilan_Fiyat between '" + fiyatMins + "' AND '" + fiyatMaxs + "')"
                    + "AND  (tbl_duyuru.Ilan_Km between '" + ilanKmmins + "' AND '" + ilanKmmaxs + "')"
                    + "AND tbl_araba.Araba_Marka in (SELECT Araba_Marka FROM tbl_araba WHERE Araba_Marka like '" + aracMarka + "')"
                    + "AND tbl_araba.Araba_Model in (SELECT Araba_Model FROM tbl_araba WHERE Araba_Model like '" + aracModel + "')" 
                    + "AND ( (SELECT Renk FROM tbl_renk WHERE RenkID = tbl_araba.Araba_RenkID) like (SELECT Renk FROM tbl_renk WHERE RenkID= '"+aracRenkIDs+"')) "
                    + "AND ( (SELECT Vites_Turu FROM tbl_vitesturu WHERE VitesTuruID = tbl_araba.Araba_VitesTuruID) like (SELECT Vites_Turu FROM tbl_vitesturu WHERE VitesTuruID= '"+vitesTuruIDs+"'))"
                    + "AND ( (SELECT Yakit_Turu FROM tbl_yakitturu WHERE YakitTuruID = tbl_araba.Araba_YakitTuruID) like (SELECT Yakit_Turu FROM tbl_yakitturu WHERE YakitTuruID= '"+yakitTuruIDs+"')) ) ORDER BY '"+cbilanAdi+"'";
                    
                    
            Statement stmt = null;
            stmt = (Statement) baglanti.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
           
            while (rs.next()) {
                ilanAdiList.add(rs.getString("Ilan_Adi"));
                ilanFiyatList.add(rs.getString("Ilan_Fiyat"));
                aracMarkaList.add(rs.getString("Araba_Marka"));
                aracModelList.add(rs.getString("Araba_Model"));
                ilanSehirList.add(rs.getString("Ilan_SehirID"));
                aracRenkList.add(rs.getString("Araba_RenkID"));
                aracVitesTuruList.add(rs.getString("Araba_VitesTuruID"));
                ilanArabaIDList.add(rs.getString("Ilan_ArabaID"));
                aracYakitTuruList.add(rs.getString("Araba_YakitTuruID"));
                ilanKmList.add(rs.getString("Ilan_Km"));
                aracModelList.add(rs.getString("Araba_YakitTuruID"));
                ilanTarihList.add(rs.getString("Araba_YakitTuruID"));
            }
            
            /*sql ="SELECT Vites_Turu FROM tbl_vitesturu WHERE VitesTuruID='"+aracVitesTuruList2.get(0)+"'";
            ResultSet rs2 = stmt.executeQuery(sql);
            
            while (rs2.next()){
            aracVitesTuruList3.add(rs.getString("Vites_Turu"));
            }*/
            
            ilanAdiList2.add(ilanAdiList.get(0));                           //Yazdirilacak ilan adlarini ilanAdiList2 ye atma
            ilanFiyatList2.add(ilanFiyatList.get(0));
            aracMarkaList2.add(aracMarkaList.get(0));
            ilanSehirList2.add(ilanSehirList.get(0));
            aracRenkList2.add(aracRenkList.get(0));
            aracVitesTuruList2.add(aracVitesTuruList.get(0));
            ilanArabaIDList2.add(ilanArabaIDList.get(0));
            aracYakitTuruList2.add(aracYakitTuruList.get(0));
            ilanKmList2.add(ilanKmList.get(0));
            aracModelList2.add(aracModelList.get(0));
            ilanTarihList2.add(ilanTarihList.get(0));
            
            
            int sayac=0;                                                    //Yazdirilacak ilan adlarini ilanAdiList2 ye atma
            for(int i=1;i<ilanAdiList.size();i++){                          //Yazdirilacak ilan adlarini ilanAdiList2 ye atma
                for(int j=0;j<ilanAdiList2.size();j++){                     //Yazdirilacak ilan adlarini ilanAdiList2 ye atma
                    if(ilanArabaIDList.get(i).equals( ilanArabaIDList2.get(j) ) ){  //Yazdirilacak ilan adlarini ilanAdiList2 ye atma
                        sayac++;                                            //Yazdirilacak ilan adlarini ilanAdiList2 ye atma
                    }
                }
                if(sayac==0){                                               //Yazdirilacak ilan adlarini ilanAdiList2 ye atma
                    ilanAdiList2.add(ilanAdiList.get(i));                   //Yazdirilacak ilan adlarini ilanAdiList2 ye atma
                    ilanFiyatList2.add(ilanFiyatList.get(i));
                    aracMarkaList2.add(aracMarkaList.get(i));
                    ilanSehirList2.add(ilanSehirList.get(i));
                    aracRenkList2.add(aracRenkList.get(i));
                    aracVitesTuruList2.add(aracVitesTuruList.get(i));
                    ilanArabaIDList2.add(ilanArabaIDList.get(i));
                    aracYakitTuruList2.add(aracYakitTuruList.get(i));
                    ilanKmList2.add(ilanKmList.get(i));
                    aracModelList2.add(aracModelList.get(i));
                    ilanTarihList2.add(ilanTarihList.get(i));
                }
            }
            
            for(int i=0;i<ilanAdiList2.size();i++){ //Sorgudan dönenlerin ilan adını yazdırma
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("İlan adi"+(i+1)+" : "+ilanAdiList2.get(i));
                System.out.println("İlan fiyatı"+(i+1)+" : "+ilanFiyatList2.get(i));
                System.out.println("Arac markası"+(i+1)+" : "+aracMarkaList2.get(i));
                System.out.println("Arac modeli"+(i+1)+" : "+aracModelList2.get(i));
                System.out.println("İlan sehir"+(i+1)+" : "+ilanSehirList2.get(i));
                System.out.println("Arac renk"+(i+1)+" : "+aracRenkList2.get(i));
                System.out.println("Arac vites"+(i+1)+" : "+aracVitesTuruList2.get(i));
                System.out.println("Arac plaka "+(i+1)+" : "+ilanArabaIDList2.get(i));
                System.out.println("Arac yakit "+(i+1)+" : "+aracYakitTuruList2.get(i));
                System.out.println("İlan km "+(i+1)+" : "+ilanKmList2.get(i));
                System.out.println("İlan tarih "+(i+1)+" : "+ilanTarihList2.get(i));
                
                System.out.println("--------------------------------------------------------------------------------");
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Arama Sırasında Hata : " + e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtilanadi = new javax.swing.JTextField();
        txtarabamarka = new javax.swing.JTextField();
        txtarabamodel = new javax.swing.JTextField();
        txtarabarenkid = new javax.swing.JComboBox<>();
        txtarabavitesturuid = new javax.swing.JComboBox<>();
        txtarabayakitturuid = new javax.swing.JComboBox<>();
        txttarih = new javax.swing.JTextField();
        txtsehirid = new javax.swing.JComboBox<>();
        txtfiyatmin = new javax.swing.JTextField();
        txtfiyatmax = new javax.swing.JTextField();
        txtkmmin = new javax.swing.JTextField();
        txtkmmax = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jCBilanAdi = new javax.swing.JCheckBox();
        jCBfiyat = new javax.swing.JCheckBox();
        jCBmarka = new javax.swing.JCheckBox();
        jCBmodel = new javax.swing.JCheckBox();
        jCBtarih = new javax.swing.JCheckBox();
        jCBsehir = new javax.swing.JCheckBox();
        jCBkm = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txttablo = new javax.swing.JTable();
        jToggleButton3 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("İlan Adı :");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fiyat :");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Araba Marka :");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Araba Model :");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Araba RenkID :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Araba VitesTürüID :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Araba YakıtTürüID :");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Km :");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tarih :");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ŞehirID :");

        txtarabarenkid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Bej", "Beyaz", "Bordo", "Fume", "Gri", "Gumus Gri", "Kahverengi", "Kirmizi", "Lacivert", "Mavi", "Mor", "Pembe", "Sari", "Siyah", "Sampanya", "Turkuaz", "Turuncu", "Yesil" }));

        txtarabavitesturuid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Manuel", "Otomatik", "Yari-Otomatik" }));

        txtarabayakitturuid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Benzin", "LPG", "Diesel", "Elektrik", "Hibrit" }));

        txtsehirid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Adana ", "Adiyaman ", "Afyonkarahisar ", "Agri ", "Amasya ", "Ankara ", "Antalya ", "Artvin ", "Aydin ", "Balikesir ", "Bilecik ", "Bingöl ", "Bitlis ", "Bolu ", "Burdur ", "Bursa ", "Çanakkale ", "Çankiri ", "Çorum ", "Denizli ", "Diyarbakir ", "Edirne ", "Elazig ", "Erzincan ", "Erzurum ", "Eskisehir ", "Gaziantep ", "Giresun ", "Gümüshane ", "Hakkari ", "Hatay ", "Isparta ", "Mersin ", "Istanbul ", "Izmir ", "Kars ", "Kastamonu ", "Kayseri ", "Kirklareli ", "Kirsehir ", "Kocaeli ", "Konya ", "Kütahya ", "Malatya ", "Manisa ", "K.maras ", "Mardin ", "Mugla ", "Mus ", "Nevsehir ", "Nigde ", "Ordu ", "Rize ", "Sakarya ", "Samsun ", "Siirt ", "Sinop ", "Sivas ", "Tekirdag ", "Tokat ", "Trabzon ", "Tunceli ", "Sanliurfa ", "Usak ", "Van ", "Yozgat ", "Zonguldak ", "Aksaray ", "Bayburt ", "Karaman ", "Kirikkale ", "Batman ", "Sirnak ", "Bartin ", "Ardahan ", "Igdir ", "Yalova ", "Karabük ", "Kilis ", "Osmaniye ", "Düzce" }));

        txtfiyatmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfiyatminActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Geri Dön");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });

        jToggleButton2.setText("Arama");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Min :");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Max :");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Max :");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Min :");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("FİLTRELE");

        jCBilanAdi.setText("jCheckBox1");
        jCBilanAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBilanAdiActionPerformed(evt);
            }
        });

        jCBfiyat.setText("jCheckBox2");

        jCBmarka.setText("jCheckBox3");

        jCBmodel.setText("jCheckBox4");

        jCBtarih.setText("jCheckBox5");

        jCBsehir.setText("jCheckBox6");

        jCBkm.setText("jCheckBox7");

        txttablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "İlan Adi", "Fiyat", "Marka", "Model", "Renk", "Vites Turu", "Yakit Turu", "KM", "Tarih", "Sehir", "Plaka"
            }
        ));
        jScrollPane1.setViewportView(txttablo);

        jToggleButton3.setText("Tabloyu Temizle");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBkm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jCBtarih, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCBmodel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCBmarka, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jCBilanAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jCBfiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                                .addComponent(jCBsehir, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel14))
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtarabayakitturuid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txttarih)
                                            .addComponent(txtsehirid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtarabavitesturuid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtkmmin)))
                                    .addComponent(txtarabarenkid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(76, 76, 76)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtfiyatmin, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtilanadi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtarabamarka, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtarabamodel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton3)
                            .addComponent(txtfiyatmax, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtkmmax, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jCBilanAdi)
                            .addComponent(txtilanadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7)
                                .addComponent(jCBfiyat))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtfiyatmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(txtfiyatmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCBmarka)
                                .addComponent(txtarabamarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtarabamodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jCBmodel)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtarabarenkid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtarabavitesturuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtarabayakitturuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtkmmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkmmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jCBkm))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jCBtarih))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtsehirid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBsehir))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jToggleButton3)
                        .addGap(27, 27, 27)))
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfiyatminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfiyatminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfiyatminActionPerformed

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        Giris g = new Giris();
        g.setVisible(true);
        dispose();
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
       // sorgula();
        userList();
        show_user();
       // 
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jCBilanAdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBilanAdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBilanAdiActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        reset();
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sorgu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sorgu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sorgu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sorgu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sorgu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCBfiyat;
    private javax.swing.JCheckBox jCBilanAdi;
    private javax.swing.JCheckBox jCBkm;
    private javax.swing.JCheckBox jCBmarka;
    private javax.swing.JCheckBox jCBmodel;
    private javax.swing.JCheckBox jCBsehir;
    private javax.swing.JCheckBox jCBtarih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JTextField txtarabamarka;
    private javax.swing.JTextField txtarabamodel;
    private javax.swing.JComboBox<String> txtarabarenkid;
    private javax.swing.JComboBox<String> txtarabavitesturuid;
    private javax.swing.JComboBox<String> txtarabayakitturuid;
    private javax.swing.JTextField txtfiyatmax;
    private javax.swing.JTextField txtfiyatmin;
    private javax.swing.JTextField txtilanadi;
    private javax.swing.JTextField txtkmmax;
    private javax.swing.JTextField txtkmmin;
    private javax.swing.JComboBox<String> txtsehirid;
    private javax.swing.JTable txttablo;
    private javax.swing.JTextField txttarih;
    // End of variables declaration//GEN-END:variables
}



