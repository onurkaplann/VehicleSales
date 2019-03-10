package proje4;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Guncelle extends javax.swing.JFrame {

  
    public Guncelle() {
        initComponents();

    }

    private void guncelle() {
        
        
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
        try {
            String bos = "";

    
            if (!txtarabamarka.getText().equals(bos)) {
                PreparedStatement uygula1 = baglanti.prepareStatement("update Tbl_Araba set Araba_Marka=? where ArabaID=?");
                uygula1.setString(1, txtarabamarka.getText());
                uygula1.setString(2, txtarabaid.getText());
                int donut1 = uygula1.executeUpdate();
                if (donut1 > 0) {
                    JOptionPane.showMessageDialog(null, "Guncelleme1 Başarı İle Yapılmıştır.");
                } else {
                    JOptionPane.showMessageDialog(null, "Bir Sorun1 Oluştu.");
                }
            }
         
            if (!txtarabamodel.getText().equals(bos)) {
                PreparedStatement uygula2 = baglanti.prepareStatement("update Tbl_Araba set Araba_Model=? where ArabaID=?");
                uygula2.setString(1,txtarabamodel.getText() );
                uygula2.setString(2, txtarabaid.getText());
                int donut2 = uygula2.executeUpdate();
                if (donut2 > 0) {
                    JOptionPane.showMessageDialog(null, "Guncelleme2 Başarı İle Yapılmıştır.");
                } else {
                    JOptionPane.showMessageDialog(null, "Bir Sorun2 Oluştu.");
                }
            }

         
            if (txtarabavitesturuid.getSelectedIndex() != 0) {
                PreparedStatement uygula3 = baglanti.prepareStatement("update Tbl_Araba set Araba_VitesTuruID=? where ArabaID=?");
                uygula3.setInt(1, Integer.valueOf(txtarabavitesturuid.getSelectedIndex() ));
                uygula3.setString(2, txtarabaid.getText());
                int donut3 = uygula3.executeUpdate();
                if (donut3 > 0) {
                    JOptionPane.showMessageDialog(null, "Guncelleme3 Başarı İle Yapılmıştır.");
                } else {
                    JOptionPane.showMessageDialog(null, "Bir Sorun3 Oluştu.");
                }
            }
         
            if (txtarabayakitturuid.getSelectedIndex() != 0) {
                PreparedStatement uygula4 = baglanti.prepareStatement("update Tbl_Araba set Araba_YakitTuruID=? where ArabaID=?");
                uygula4.setInt(1, Integer.valueOf(txtarabayakitturuid.getSelectedIndex() ));
                uygula4.setString(2, txtarabaid.getText());
                int donut4 = uygula4.executeUpdate();
                if (donut4 > 0) {
                    JOptionPane.showMessageDialog(null, "Guncelleme4 Başarı İle Yapılmıştır.");
                } else {
                    JOptionPane.showMessageDialog(null, "Bir Sorun4 Oluştu.");
                }
            }
        
            if (txtarabarenkid.getSelectedIndex() != 0) {
                PreparedStatement uygula5 = baglanti.prepareStatement("update Tbl_Araba set Araba_RenkID=? where ArabaID=?");
                uygula5.setInt(1, Integer.valueOf(txtarabarenkid.getSelectedIndex()));
                uygula5.setString(2, txtarabaid.getText());
                int donut5 = uygula5.executeUpdate();
                if (donut5 > 0) {
                    JOptionPane.showMessageDialog(null, "Guncelleme5 Başarı İle Yapılmıştır.");
                } else {
                    JOptionPane.showMessageDialog(null, "Bir Sorun5 Oluştu.");
                }
            }
        
            if (!txtilanadi.getText().equals(bos)) {
                PreparedStatement uygula6 = baglanti.prepareStatement("update tbl_duyuru set Ilan_Adi=? where Ilan_ArabaID=? ");
                uygula6.setString(1, txtilanadi.getText());
                uygula6.setString(2, txtarabaid.getText());
                int donut6 = uygula6.executeUpdate();
                if (donut6 > 0) {
                    JOptionPane.showMessageDialog(null, "Guncelleme6 Başarı İle Yapılmıştır.");
                } else {
                    JOptionPane.showMessageDialog(null, "Bir Sorun6 Oluştu.");
                }
            }
          
            if (!txtilanfiyat.getText().equals(bos)) {
                PreparedStatement uygula7 = baglanti.prepareStatement("update tbl_duyuru set Ilan_Fiyat=? where Ilan_ArabaID=? ");
                uygula7.setInt(1, Integer.valueOf(txtilanfiyat.getText()));
                uygula7.setString(2, txtarabaid.getText());
                int donut7 = uygula7.executeUpdate();
                if (donut7 > 0) {
                    JOptionPane.showMessageDialog(null, "Guncelleme7 Başarı İle Yapılmıştır.");
                } else {
                    JOptionPane.showMessageDialog(null, "Bir Sorun7 Oluştu.");
                }
            }
         
            if (!txtkm.getText().equals(bos)) {
                PreparedStatement uygula8 = baglanti.prepareStatement("update tbl_duyuru set Ilan_Km=? where Ilan_ArabaID=? ");
                uygula8.setInt(1, Integer.valueOf(txtkm.getText()));
                uygula8.setString(2, txtarabaid.getText());
                int donut8 = uygula8.executeUpdate();
                if (donut8 > 0) {
                    JOptionPane.showMessageDialog(null, "Guncelleme8 Başarı İle Yapılmıştır.");
                } else {
                    JOptionPane.showMessageDialog(null, "Bir Sorun8 Oluştu.");
                }
            }
           
            if (!txttarih.getText().equals(bos)) {
                PreparedStatement uygula9 = baglanti.prepareStatement("update tbl_duyuru set Ilan_Tarih=? where Ilan_ArabaID=? ");
                uygula9.setString(1, txttarih.getText());
                uygula9.setString(2, txtarabaid.getText());
                int donut9 = uygula9.executeUpdate();
                if (donut9 > 0) {
                    JOptionPane.showMessageDialog(null, "Guncelleme9 Başarı İle Yapılmıştır.");
                } else {
                    JOptionPane.showMessageDialog(null, "Bir Sorun9 Oluştu.");
                }
            }
           
            if (txtsehirid.getSelectedIndex() != 0) {
                PreparedStatement uygula10 = baglanti.prepareStatement("update tbl_duyuru set Ilan_SehirID=? where Ilan_ArabaID=? ");
                uygula10.setInt(1, Integer.valueOf(txtsehirid.getSelectedIndex() ));
                uygula10.setString(2, txtarabaid.getText());
                int donut10 = uygula10.executeUpdate();
                if (donut10 > 0) {
                    JOptionPane.showMessageDialog(null, "Guncelleme10 Başarı İle Yapılmıştır.");
                } else {
                    JOptionPane.showMessageDialog(null, "Bir Sorun10 Oluştu.");
                }
            }
        

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Guncelleme Sırasında Hata : " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtarabarenkid = new javax.swing.JComboBox<>();
        txtarabavitesturuid = new javax.swing.JComboBox<>();
        txtarabayakitturuid = new javax.swing.JComboBox<>();
        txtsehirid = new javax.swing.JComboBox<>();
        txtilanadi = new javax.swing.JTextField();
        txtilanfiyat = new javax.swing.JTextField();
        txtarabaid = new javax.swing.JTextField();
        txtarabamarka = new javax.swing.JTextField();
        txtarabamodel = new javax.swing.JTextField();
        txtkm = new javax.swing.JTextField();
        txttarih = new javax.swing.JTextField();
        btnguncelle = new javax.swing.JToggleButton();
        aracadonbtn = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GÜNCELLEME");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ArabaID :");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("İlan Adı :");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fiyat :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Araba Marka :");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Araba RenkID :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Araba VitesTürüID :");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Araba YakıtTürüID :");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Km :");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tarih :");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ŞehirID :");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Araba Model :");

        txtarabarenkid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Bej", "Beyaz", "Bordo", "Füme", "Gri", "Gümüş Gri", "Kahverengi", "Kırmızı", "Lacivert", "Mavi", "Mor", "Pembe", "Sarı", "Siyah", "Şampanya", "Turkuaz", "Turuncu", "Yeşil" }));

        txtarabavitesturuid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Manuel", "Otomatik", "Yarı-Otomatik" }));

        txtarabayakitturuid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Benzin", "Lpg", "Diesel", "Elektrik", "Hibrit" }));

        txtsehirid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Adana ", "Adiyaman ", "Afyonkarahisar ", "Agri ", "Amasya ", "Ankara ", "Antalya ", "Artvin ", "Aydin ", "Balikesir ", "Bilecik ", "Bingöl ", "Bitlis ", "Bolu ", "Burdur ", "Bursa ", "Çanakkale ", "Çankiri ", "Çorum ", "Denizli ", "Diyarbakir ", "Edirne ", "Elazig ", "Erzincan ", "Erzurum ", "Eskisehir ", "Gaziantep ", "Giresun ", "Gümüshane ", "Hakkari ", "Hatay ", "Isparta ", "Mersin ", "Istanbul ", "Izmir ", "Kars ", "Kastamonu ", "Kayseri ", "Kirklareli ", "Kirsehir ", "Kocaeli ", "Konya ", "Kütahya ", "Malatya ", "Manisa ", "K.maras ", "Mardin ", "Mugla ", "Mus ", "Nevsehir ", "Nigde ", "Ordu ", "Rize ", "Sakarya ", "Samsun ", "Siirt ", "Sinop ", "Sivas ", "Tekirdag ", "Tokat ", "Trabzon ", "Tunceli ", "Sanliurfa ", "Usak ", "Van ", "Yozgat ", "Zonguldak ", "Aksaray ", "Bayburt ", "Karaman ", "Kirikkale ", "Batman ", "Sirnak ", "Bartin ", "Ardahan ", "Igdir ", "Yalova ", "Karabük ", "Kilis ", "Osmaniye ", "Düzce" }));

        btnguncelle.setText("Güncelle");
        btnguncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguncelleActionPerformed(evt);
            }
        });

        aracadonbtn.setText("Geri Dön");
        aracadonbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aracadonbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aracadonbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(97, 97, 97)
                        .addComponent(txtilanfiyat))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel5)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(33, 33, 33)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtarabavitesturuid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtarabayakitturuid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtsehirid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtarabamarka)
                            .addComponent(txtarabamodel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtkm)
                            .addComponent(txttarih, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtarabarenkid, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtilanadi)
                            .addComponent(txtarabaid, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(139, 139, 139))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtarabaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtilanadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtilanfiyat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtarabamarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtarabamodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtarabarenkid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtarabavitesturuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtarabayakitturuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txttarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtsehirid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnguncelle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aracadonbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguncelleActionPerformed
        //if(guncelleKontrol())
        guncelle();
    }//GEN-LAST:event_btnguncelleActionPerformed

    private void aracadonbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aracadonbtnMouseClicked
        Arac g = new Arac();
        g.setVisible(true);
        dispose();
    }//GEN-LAST:event_aracadonbtnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Guncelle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton aracadonbtn;
    private javax.swing.JToggleButton btnguncelle;
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
