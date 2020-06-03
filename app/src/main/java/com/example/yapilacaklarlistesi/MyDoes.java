package com.example.yapilacaklarlistesi;

public class MyDoes {

    String baslik, aciklama, tarih;
    String keydoes;


    public MyDoes( ) {
    }

    public MyDoes(String baslik, String aciklama, String tarih, String keydoes) {
        this.baslik = baslik;
        this.aciklama = aciklama;
        this.tarih = tarih;
        this.keydoes = keydoes;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getKeydoes() {
        return keydoes;
    }

    public void setKeydoes(String keydoes) {
        this.keydoes = keydoes;
    }
}
