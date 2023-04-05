package view_model;

public class QLDongSP {
    private String ma;
    private String ten;

    public QLDongSP(){

    }
    public QLDongSP(String ma, String ten){
        this.ma = ma;
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
