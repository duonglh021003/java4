package domain_model;

import jakarta.persistence.*;

@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @Column(name = "IdHoaDon")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String IdHoaDon;

    @Column(name = "IdChiTietSP")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String IdChiTietSP;

    @Column(name = "SoLuong")
    private String SoLuong;

    @Column(name = "DonGia")
    private String DonGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHoaDon, String idChiTietSP, String soLuong, String donGia) {
        IdHoaDon = idHoaDon;
        IdChiTietSP = idChiTietSP;
        SoLuong = soLuong;
        DonGia = donGia;
    }

    public String getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        IdHoaDon = idHoaDon;
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
}
