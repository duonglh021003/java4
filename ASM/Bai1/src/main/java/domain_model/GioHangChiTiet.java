package domain_model;

import jakarta.persistence.*;

@Entity
@Table(name = "GioHangChiTiet")
public class GioHangChiTiet {
    @Id
    @Column(name = "IdGioHang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String IdGioHang;

    @Column(name = "IdChiTietSP")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String IdChiTietSP;

    @Column(name = "SoLuong")
    private String SoLuong;

    @Column(name = "DonGia")
    private String DonGia;

    @Column(name = "DonGiaKhiGiam")
    private String DonGiaKhiGiam;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(String idGioHang, String idChiTietSP, String soLuong, String donGia, String donGiaKhiGiam) {
        IdGioHang = idGioHang;
        IdChiTietSP = idChiTietSP;
        SoLuong = soLuong;
        DonGia = donGia;
        DonGiaKhiGiam = donGiaKhiGiam;
    }

    public String getIdGioHang() {
        return IdGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        IdGioHang = idGioHang;
    }

    public String getIdChiTietSP() {
        return IdChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        IdChiTietSP = idChiTietSP;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String soLuong) {
        SoLuong = soLuong;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String donGia) {
        DonGia = donGia;
    }

    public String getDonGiaKhiGiam() {
        return DonGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(String donGiaKhiGiam) {
        DonGiaKhiGiam = donGiaKhiGiam;
    }
}
