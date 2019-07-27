package com.example.android.todolist;

public class item {
    int iID; // item id
    String iname;  // item name
    boolean iChecked; // item statue

    public item(String iname, boolean iChecked) {
        this.iname = iname;
        this.iChecked = iChecked;
    }
    public item(int iID,String iname, boolean iChecked) {
        this.iname = iname;
        this.iChecked = iChecked;
        this.iID=iID;
    }

    public int getiID() {
        return iID;
    }

    public void setiID(int iID) {
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
