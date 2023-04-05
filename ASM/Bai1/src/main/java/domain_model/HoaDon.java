package domain_model;

import jakarta.persistence.*;

@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;

    @Column(name = "IdKH")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String IdKH;

    @Column(name = "IdNV")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String IdNV;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "NgayTao")
    private String NgayTao;

    @Column(name = "NgayThanhToan")
    private String NgayThanhToan;

    @Column(name = "NgayShip")
    private String NgayShip;

    @Column(name = "NgayNhan")
    private String NgayNhan;

    @Column(name = "TinhTrang")
    private String TinhTrang;

    @Column(name = "TenNguoiNhan")
    private String TenNguoiNhan;

    @Column(name = "DiaChi")
    private String DiaChi;

    @Column(name = "Sdt")
    private String Sdt;

    public HoaDon() {
    }

    public HoaDon(String id, String idKH, String idNV, String ma, String ngayTao, String ngayThanhToan, String ngayShip, String ngayNhan, String tinhTrang, String tenNguoiNhan, String diaChi, String sdt) {
        Id = id;
        IdKH = idKH;
        IdNV = idNV;
        Ma = ma;
        NgayTao = ngayTao;
        NgayThanhToan = ngayThanhToan;
        NgayShip = ngayShip;
        NgayNhan = ngayNhan;
        TinhTrang = tinhTrang;
        TenNguoiNhan = tenNguoiNhan;
        DiaChi = diaChi;
        Sdt = sdt;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIdKH() {
        return IdKH;
    }

    public void setIdKH(String idKH) {
        IdKH = idKH;
    }

    public String getIdNV() {
        return IdNV;
    }

    public void setIdNV(String idNV) {
        IdNV = idNV;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String ngayTao) {
        NgayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        NgayThanhToan = ngayThanhToan;
    }

    public String getNgayShip() {
        return NgayShip;
    }

    public void setNgayShip(String ngayShip) {
        NgayShip = ngayShip;
    }

    public String getNgayNhan() {
        return NgayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        NgayNhan = ngayNhan;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public String getTenNguoiNhan() {
        return TenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        TenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }
}
