package org.example.Example02.biao;

public class Depository {//本仓
    private int id;
    private String cname;
    private String pno;
    private int num;
    private double price;
    private double sum_price;
    public Depository(int id,String cname,String pno,int num,double price,double sum_price)
    {
        this.id=id;
        this.cname=cname;
        this.pno=pno;
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
    public void setSum_price(double sum_price) {
        this.sum_price = sum_price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }
    public int getId() {
        return id;
    }
    public String getPno() {
        return pno;
    }
    public String getCname() {
        return cname;
    }
    public double getSum_price() {
        return sum_price;
    }
    public double getPrice() {
        return price;
    }
}
