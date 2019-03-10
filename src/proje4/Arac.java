package proje4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.ir.TryNode;

/**
 *
 * @author ABRA
 */
public class Arac extends javax.swing.JFrame {

    /**
     * Creates new form Arac
     */
    public Arac() {
        initComponents();
    }
    private void ekle(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Driverda Hata : "+e.getMessage());
        }
        Connection baglanti = null;
        try {
            baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bağlantıda Hata : "+e.getMessage());
        }
        try {
            PreparedStatement uygula = baglanti.prepareStatement("insert into Tbl_Araba(ArabaID,Araba_Marka,Araba_Model,Araba_VitesTuruID,Araba_YakitTuruID,Araba_RenkID) values(?,?,?,?,?,?) ");
            
            uygula.setString(1, txtarabaid.getText());
            uygula.setString(2, txtarabamarka.getText());
            uygula.setString(3,txtarabamodel.getText());
            uygula.setInt(4,Integer.valueOf(txtarabavitesturuid.getSelectedIndex()));
            uygula.setInt(5,Integer.valueOf(txtarabayakitturuid.getSelectedIndex()));
            uygula.setInt(6,Integer.valueOf(txtarabarenkid.getSelectedIndex()));
            
            PreparedStatement uygula2 = baglanti.prepareStatement("insert into tbl_duyuru(Ilan_Adi,Ilan_Fiyat,Ilan_Km,Ilan_Tarih,Ilan_ArabaID,Ilan_SehirID) values(?,?,?,?,?,?) ");
                      
            
            uygula2.setString(1, txtilanadi.getText());
            uygula2.setInt(2,Integer.valueOf(txtilanfiyat.getText()));
            uygula2.setInt(3,Integer.valueOf(txtkm.getText()));
            uygula2.setString(4, txttarih.getText());
            uygula2.setString(5, txtarabaid.getText());
            uygula2.setInt(6,Integer.valueOf(txtsehirid.getSelectedIndex()));
            
            
            int donut=uygula.executeUpdate();
            
            if(donut>0)JOptionPane.showMessageDialog(null, "Kayıt Başarı İle Yapılmıştır.");
            else JOptionPane.showMessageDialog(null, "Bir Sorun Oluştu.");
            
            int donut2=uygula2.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ekleme Sırasında Hata : "+e.getMessage());
        }
    }
   
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtilanadi = new javax.swing.JTextField();
        txtilanfiyat = new javax.swing.JTextField();
        txtarabaid = new javax.swing.JTextField();
        txtarabamarka = new javax.swing.JTextField();
        txtarabamodel = new javax.swing.JTextField();
        txtkm = new javax.swing.JTextField();
        txttarih = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnsil = new javax.swing.JToggleButton();
        txtarabarenkid = new javax.swing.JComboBox<>();
        txtarabavitesturuid = new javax.swing.JComboBox<>();
        txtarabayakitturuid = new javax.swing.JComboBox<>();
        txtsehirid = new javax.swing.JComboBox<>();
        btnekle = new javax.swing.JToggleButton();
        btnguncelle = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Araba Marka :");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Araba Model :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Araba VitesTürüID :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Araba YakıtTürüID :");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Araba RenkID :");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("İlan Adı :");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ArabaID :");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fiyat :");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Km :");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tarih :");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ŞehirID :");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("YENİ GİRİŞ");

        btnsil.setText("Sil");
        btnsil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsilMouseClicked(evt);
            }
        });
        btnsil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsilActionPerformed(evt);
            }
        });

        txtarabarenkid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Bej", "Beyaz", "Bordo", "Fume", "Gri", "Gumus Gri", "Kahverengi", "Kirmizi", "Lacivert", "Mavi", "Mor", "Pembe", "Sari", "Siyah", "Sampanya", "Turkuaz", "Turuncu", "Yesil" }));

        txtarabavitesturuid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Manuel", "Otomatik", "Yari-Otomatik" }));

        txtarabayakitturuid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Benzin", "LPG", "Diesel", "Elektrik", "Hibrit" }));

        txtsehirid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Adana ", "Adiyaman ", "Afyonkarahisar ", "Agri ", "Amasya ", "Ankara ", "Antalya ", "Artvin ", "Aydin ", "Balikesir ", "Bilecik ", "Bingöl ", "Bitlis ", "Bolu ", "Burdur ", "Bursa ", "Çanakkale ", "Çankiri ", "Çorum ", "Denizli ", "Diyarbakir ", "Edirne ", "Elazig ", "Erzincan ", "Erzurum ", "Eskisehir ", "Gaziantep ", "Giresun ", "Gümüshane ", "Hakkari ", "Hatay ", "Isparta ", "Mersin ", "Istanbul ", "Izmir ", "Kars ", "Kastamonu ", "Kayseri ", "Kirklareli ", "Kirsehir ", "Kocaeli ", "Konya ", "Kütahya ", "Malatya ", "Manisa ", "K.maras ", "Mardin ", "Mugla ", "Mus ", "Nevsehir ", "Nigde ", "Ordu ", "Rize ", "Sakarya ", "Samsun ", "Siirt ", "Sinop ", "Sivas ", "Tekirdag ", "Tokat ", "Trabzon ", "Tunceli ", "Sanliurfa ", "Usak ", "Van ", "Yozgat ", "Zonguldak ", "Aksaray ", "Bayburt ", "Karaman ", "Kirikkale ", "Batman ", "Sirnak ", "Bartin ", "Ardahan ", "Igdir ", "Yalova ", "Karabük ", "Kilis ", "Osmaniye ", "Düzce" }));

        btnekle.setText("Kayıt Ekle");
        btnekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnekleActionPerformed(evt);
            }
        });

        btnguncelle.setText("Güncelle");
        btnguncelle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguncelleMouseClicked(evt);
            }
        });

        jToggleButton1.setText("Geri Dön");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel11))
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(33, 33, 33))))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtilanadi)
                                    .addComponent(txtilanfiyat)
                                    .addComponent(txtarabaid)
                                    .addComponent(txtarabamarka)
                                    .addComponent(txtarabamodel)
                                    .addComponent(txtkm)
                                    .addComponent(txttarih)
                                    .addComponent(txtarabarenkid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtarabavitesturuid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtarabayakitturuid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtsehirid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnsil, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnekle, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnguncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel12)))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtilanadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtilanfiyat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtarabaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtarabamarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtarabamodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtarabarenkid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtarabavitesturuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtarabayakitturuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txttarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtsehirid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnekle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguncelle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addContainerGap(21, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnekleActionPerformed
       ekle();
        
    }//GEN-LAST:event_btnekleActionPerformed

    private void btnsilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsilActionPerformed
      
    }//GEN-LAST:event_btnsilActionPerformed

    private void btnguncelleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguncelleMouseClicked
       Guncelle g = new Guncelle();
       g.setVisible(true);
       dispose();
    }//GEN-LAST:event_btnguncelleMouseClicked

    private void btnsilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsilMouseClicked
        Sil g = new Sil();
        g.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnsilMouseClicked

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        Giris g = new Giris();
        g.setVisible(true);
        dispose();
    }//GEN-LAST:event_jToggleButton1MouseClicked

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
            java.util.logging.Logger.getLogger(Arac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Arac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Arac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Arac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Arac().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnekle;
    private javax.swing.JToggleButton btnguncelle;
    private javax.swing.JToggleButton btnsil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txtarabaid;
    private javax.swing.JTextField txtarabamarka;
    private javax.swing.JTextField txtarabamodel;
    private javax.swing.JComboBox<String> txtarabarenkid;
    private javax.swing.JComboBox<String> txtarabavitesturuid;
    private javax.swing.JComboBox<String> txtarabayakitturuid;
    private javax.swing.JTextField txtilanadi;
    private javax.swing.JTextField txtilanfiyat;
    private javax.swing.JTextField txtkm;
    private javax.swing.JComboBox<String> txtsehirid;
    private javax.swing.JTextField txttarih;
    // End of variables declaration//GEN-END:variables
}
