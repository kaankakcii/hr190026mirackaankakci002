package com.hr190026.mirac_kaan_kakci_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GezegenModel {

    @SerializedName("GezegenAdi")
    @Expose
    private String gezegenAdi;
    @SerializedName("Capi")
    @Expose
    private String capi;
    @SerializedName("GunUzunlugu")
    @Expose
    private String gunUzunlugu;
    @SerializedName("Turu")
    @Expose
    private String turu;
    @SerializedName("Tan\u0131m")
    @Expose
    private String tanM;
    @SerializedName("ResimUrl")
    @Expose
    private String resimUrl;
    @SerializedName("KapakResim")
    @Expose
    private String kapakResim;

    public String getGezegenAdi() {
        return gezegenAdi;
    }

    public void setGezegenAdi(String gezegenAdi) {
        this.gezegenAdi = gezegenAdi;
    }

    public String getCapi() {
        return capi;
    }

    public void setCapi(String capi) {
        this.capi = capi;
    }

    public String getGunUzunlugu() {
        return gunUzunlugu;
    }

    public void setGunUzunlugu(String gunUzunlugu) {
        this.gunUzunlugu = gunUzunlugu;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public String getTanM() {
        return tanM;
    }

    public void setTanM(String tanM) {
        this.tanM = tanM;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }

    public String getKapakResim() {
        return kapakResim;
    }

    public void setKapakResim(String kapakResim) {
        this.kapakResim = kapakResim;
    }



}
