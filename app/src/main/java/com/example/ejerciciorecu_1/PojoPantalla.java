package com.example.ejerciciorecu_1;

public class PojoPantalla {

    private String cuantas, desc, num;

    public PojoPantalla(String cuantas, String desc, String num) {
        this.cuantas = cuantas;
        this.desc = desc;
        this.num = num;
    }

    public String getCuantas() {
        return cuantas;
    }

    public void setCuantas(String cuantas) {
        this.cuantas = cuantas;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
