package domain_model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ChucVu")
public class ChucVu {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Id",columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWID()")
    private int Id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(
            mappedBy = "cv",
            fetch = FetchType.LAZY
    )
    private List<NhanVien> listNv;

    public ChucVu() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public List<NhanVien> getListNv() {
        return listNv;
    }

    public void setListNv(List<NhanVien> listNv) {
        this.listNv = listNv;
    }

    @Override
    public String toString() {
        return  ten ;
    }
}
