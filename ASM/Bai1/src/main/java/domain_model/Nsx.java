package domain_model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "NSX")
public class Nsx {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Id",columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWID()")
    private int Id;


    @Column(name = "Ma")
    private String Ma;

    @Column(name = "Ten")
    private String Ten;

    @OneToMany(
            mappedBy = "nsx",
            fetch = FetchType.LAZY
    )
    private List<ChiTietSp> listCtsp;

    public Nsx() {

    }



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public List<ChiTietSp> getListCtsp() {
        return listCtsp;
    }

    public void setListCtsp(List<ChiTietSp> listCtsp) {
        this.listCtsp = listCtsp;
    }

}
