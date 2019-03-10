/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje4;

/**
 *
 * @author ABRA
 */
class User {
    private int Araba_YakitTuru,Araba_VitesTuru,Araba_RenkID,Ilan_Fiyat,Ilan_Km,Ilan_SehirID;
    private String ArabaID,Araba_Marka,Araba_Model,Ilan_Adi,Ilan_Tarih;
    
    public User(int Araba_YakitTuru,int Araba_VitesTuru,int Araba_RenkID,int Ilan_Fiyat,int Ilan_Km,int Ilan_Sehir,String ArabaID,String Araba_Marka,String Araba_Model,String Ilan_Adi,String Ilan_Tarih){
        this.Araba_YakitTuru=Araba_YakitTuru;
        this.Araba_VitesTuru=Araba_VitesTuru;
        this.Araba_RenkID=Araba_RenkID;
        this.Ilan_Fiyat=Ilan_Fiyat;
        this.Ilan_Km=Ilan_Km;
        this.Ilan_SehirID=Ilan_SehirID;
        this.ArabaID=ArabaID;
        this.Araba_Marka=Araba_Marka;
        this.Araba_Model=Araba_Model;
        this.Ilan_Adi=Ilan_Adi;
        this.Ilan_Tarih=Ilan_Tarih;
    }
    public int getYakitTuru(){
        return Araba_YakitTuru;
    }
    public int getVitesTuru(){
        return Araba_VitesTuru;
    }
    public int getRenk(){
        return Araba_RenkID;
    }
    public int getIlanFiyat(){
        return Ilan_Fiyat;
    }
    public int getIlanKM(){
        return Ilan_Km;
    }
    public int getIlanSehir(){
        return Ilan_SehirID;
    }
    
    public String getPlaka(){
        return ArabaID;
    }
    public String getMarka(){
        return Araba_Marka;
    }
    public String getModel(){
        return Araba_Model;
    }
    public String getIlanAdi(){
        return Ilan_Adi;
    }
    public String getTarih(){
        return Ilan_Tarih;
    }
}
