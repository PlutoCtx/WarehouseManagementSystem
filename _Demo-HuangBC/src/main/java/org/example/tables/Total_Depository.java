package org.example.tables;

/**
 * @author chent
 */
public class Total_Depository {//总仓
    private int id;
    private String pno;
    private int num;
    private double price;
    private double sum_price;

    public Total_Depository(int id,
                            String pno,
                            int num,
                            double price,
                            double sum_price) {
        this.id=id;
        this.pno=pno;
        this.num=num;
        this.price=price;
        this.sum_price=sum_price;
    }
    public void setId(int id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public double getSum_price() {
        return sum_price;
    }

    public double getPrice() {
        return price;
    }

    public String getPno() {
        return pno;
    }
}
