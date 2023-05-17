package org.example.tables;

public class Standing_Book {//台账
    private int id;
    private String cname;
    private String pno;
    private int bj;
    private int num;
    private double price;
    private double sum_price;
    private int d_num;
    private double d_price;
    private double d_sum_price;

    public Standing_Book(int id,
                         String cname,
                         String pno,
                         int bj,
                         int num,
                         double price,
                         double sum_price,
                         int d_num,
                         double d_price,
                         double d_sum_price) {
        this.id=id;
        this.bj=bj;
        this.d_price=d_price;
        this.cname=cname;
        this.pno=pno;
        this.d_num=d_num;
        this.d_sum_price=d_sum_price;
        this.num=num;
        this.price=price;
        this.sum_price=sum_price;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public void setPno(String pno) {
        this.pno = pno;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setBj(int bj) {
        this.bj = bj;
    }
    public void setSum_price(double sum_price) {
        this.sum_price = sum_price;
    }
    public void setD_price(double d_price) {
        this.d_price = d_price;
    }
    public void setD_sum(int d_sum) {
        this.d_num = d_sum;
    }
    public void setD_sum_price(double d_sum_price) {
        this.d_sum_price = d_sum_price;
    }

    public int getNum() {
        return num;
    }
    public int getId() {
        return id;
    }
    public int getBj() {
        return bj;
    }
    public int getD_num() {
        return d_num;
    }
    public String getPno() {
        return pno;
    }
    public String getCname() {
        return cname;
    }
    public double getPrice() {
        return price;
    }
    public double getSum_price() {
        return sum_price;
    }
    public double getD_price() {
        return d_price;
    }
    public double getD_sum_price() {
        return d_sum_price;
    }

}
