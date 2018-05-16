package com.vdb.javagb.Entity;

public class OpCode {
    private String[] code;
    private Boolean selected = false;
    private Boolean checking = false;
    private int address = -1;
    private int position = -1;

    public OpCode(){}

    public OpCode(String[] str) {
        this.code = str;
    }

    public String[] getCode() {
        return code;
    }

    public void setCode(String[] code) {
        this.code = code;
    }

    public void toggle(){
        selected = (selected) ? false : true;
    }

    public void setSelected(Boolean b){
        selected = b;
    }

    public boolean isSelected(){
        return selected;
    }

    public void setChecking(Boolean b){
        checking = b;
    }

    public boolean isChecking(){
        return checking;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}
