package view_model;

public class QLChucVu {
    private String ma;
    private String ten;

    public QLChucVu(){

    }
    public QLChucVu(String ma,String ten){
        this.ma =ma;
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
