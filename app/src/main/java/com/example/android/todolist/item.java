package com.example.android.todolist;

public class item {
    String iID; // item id
    String iname;  // item name
    boolean iChecked; // item statue

    public String getiID() {
        return iID;
    }

    public void setiID(String iID) {
        this.iID = iID;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public boolean isiChecked() {
        return iChecked;
    }

    public void setiChecked(boolean iChecked) {
        this.iChecked = iChecked;
    }
}
