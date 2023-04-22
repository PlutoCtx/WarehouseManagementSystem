package org.example.Example02.biao;

public class In_Record {//进货 退货
    private int id;
    private String cname;
    private String pno;
    private int num;
    private double price;
    private double sum_price;
    private int bj;
    private int vs;
    private int checked;

    public In_Record(int id,String cname,String pno,int num,double price,double sum_price,int bj,int vs,int checked)
    {
        this.id=id;
        this.cname=cname;
        this.pno=pno;
        this.num=num;
        this.price=price;
        this.sum_price=sum_price;
        this.bj=bj;
        this.vs=vs;
        this.checked=checked;
    }
    public In_Record(String id,String cname,String pno,String num,String price,String sum_price,String bj,String vs,String checked)
    {
        this.id=Integer.parseInt(id.trim());
        this.cname=cname;
        this.pno=pno;
        this.num=Integer.parseInt(num.trim());
        this.price=Double.parseDouble(price.trim());
        this.sum_price=Double.parseDouble(sum_price.trim());
        this.bj=Integer.parseInt(bj.trim());;
        this.vs=Integer.parseInt(vs.trim());;
        this.checked=Integer.parseInt(checked.trim());;
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
    public void setSum_price(double sum_price) {
        this.sum_price = sum_price;
    }
    public void setBj(int bj) {
        this.bj = bj;
    }
    public void setVs(int vs) {
        this.vs = vs;
    }
    public void setChecked(int checked) {
        this.checked = checked;
    }

    public int getVs() {
        return vs;
    }

    public double getPrice() {
        return price;
    }
    public double getSum_price() {
        return sum_price;
    }
    public int getBj() {
        return bj;
    }
    public int getChecked() {
        return checked;
    }
    public int getId() {
        return id;
    }
    public int getNum() {
        return num;
    }
    public String getCname() {
        return cname;
    }
    public String getPno() {
        return pno;
    }
}
