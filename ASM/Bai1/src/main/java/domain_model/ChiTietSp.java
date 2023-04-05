package domain_model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "ChiTietSp")


public class ChiTietSp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Id",columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWID()")
    private int Id;

    @Column(name = "NamBH")
    private Integer NamBH;

    @Column(name = "MoTa")
    private String MoTa;

    @Column(name = "SoLuongTon")
    private Integer SoLuongTon;

    @Column(name = "GiaNhap")
    private Double GiaNhap;

    @Column(name = "GiaBan")
    private Double GiaBan;

    @ManyToOne()
    @JoinColumn(
            name = "IdSP",
            referencedColumnName = "Id"
    )
    private SanPham sp;

    @ManyToOne()
    @JoinColumn(
            name = "IdNsx",
            referencedColumnName = "Id"
    )
    private Nsx nsx;


    @ManyToOne()
    @JoinColumn(
            name = "IdMauSac",
            referencedColumnName = "Id"
    )
    private MauSac ms;

    @ManyToOne()
    @JoinColumn(
            name = "IdDongSP",
            referencedColumnName = "Id"
    )
    private DongSp dongsp;



    public ChiTietSp() {
    }



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Integer getNamBH() {
        return NamBH;
    }

    public void setNamBH(Integer namBH) {
        NamBH = namBH;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public Integer getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        SoLuongTon = soLuongTon;
    }

    public Double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        GiaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(Double giaBan) {
        GiaBan = giaBan;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public Nsx getNsx() {
        return nsx;
    }

    public void setNsx(Nsx nsx) {
        this.nsx = nsx;
    }

    public MauSac getMs() {
        return ms;
    }

    public void setMs(MauSac ms) {
        this.ms = ms;
    }

    public DongSp getDongsp() {
        return dongsp;
    }

    public void setDongsp(DongSp dongsp) {
        this.dongsp = dongsp;
    }
}
