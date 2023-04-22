package org.example.Example02.biao;

public class Inventory {//盘点
    private int id;
    private String cname;
    private String pno;
    private int num;

    public Inventory(int id,String cname,String pno,int num)
    {
        this.id=id;
        this.cname=cname;
        this.pno=pno;
        this.num=num;
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
