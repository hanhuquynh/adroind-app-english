package com.example.englishvocabulary.domains;

public class Tense {
    private String id;
    private String tenThi;
    private String congThuc;
    private String cachSuDung;
    private String dauHieu;
    private String viDu;

    public Tense(String id, String tenThi, String congThuc, String cachSuDung, String dauHieu, String viDu) {
        this.id = id;
        this.tenThi = tenThi;
        this.congThuc = congThuc;
        this.cachSuDung = cachSuDung;
        this.dauHieu = dauHieu;
        this.viDu = viDu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenThi() {
        return tenThi;
    }

    public void setTenThi(String tenThi) {
        this.tenThi = tenThi;
    }

    public String getCongThuc() {
        return congThuc;
    }

    public void setCongThuc(String congThuc) {
        this.congThuc = congThuc;
    }

    public String getCachSuDung() {
        return cachSuDung;
    }

    public void setCachSuDung(String cachSuDung) {
        this.cachSuDung = cachSuDung;
    }

    public String getDauHieu() {
        return dauHieu;
    }

    public void setDauHieu(String dauHieu) {
        this.dauHieu = dauHieu;
    }

    public String getViDu() {
        return viDu;
    }

    public void setViDu(String viDu) {
        this.viDu = viDu;
    }
}
