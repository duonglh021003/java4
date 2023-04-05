package view_model;

public class QLChiTietSP {
    private String id;
    private String idSP;
    private String idNsx;
    private String idMS;
    private String idDongSP;
    private String nam_bh;
    private String mo_ta;
    private String slton;
    private String gia_nhap;
    private String gia_ban;

    public QLChiTietSP() {
    }

    public QLChiTietSP(String id, String idSP, String idNsx, String idMS, String idDongSP, String nam_bh, String mo_ta, String slton, String gia_nhap, String gia_ban) {
        this.id = id;
        this.idSP = idSP;
        this.idNsx = idNsx;
        this.idMS = idMS;
        this.idDongSP = idDongSP;
        this.nam_bh = nam_bh;
        this.mo_ta = mo_ta;
        this.slton = slton;
        this.gia_nhap = gia_nhap;
        this.gia_ban = gia_ban;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdNsx() {
        return idNsx;
    }

    public void setIdNsx(String idNsx) {
        this.idNsx = idNsx;
    }

    public String getIdMS() {
        return idMS;
    }

    public void setIdMS(String idMS) {
        this.idMS = idMS;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public String getNam_bh() {
        return nam_bh;
    }

    public void setNam_bh(String nam_bh) {
        this.nam_bh = nam_bh;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public String getSlton() {
        return slton;
    }

    public void setSlton(String slton) {
        this.slton = slton;
    }

    public String getGia_nhap() {
        return gia_nhap;
    }

    public void setGia_nhap(String gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public String getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(String gia_ban) {
        this.gia_ban = gia_ban;
    }



}
