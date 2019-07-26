package com.example.android.todolist;

public class task extends item {
    String tID; //track ID
    int iPriority; //item priority
    String iTime; //item time

    public String gettID() {
        return tID;
    }

    public void settID(String tID) {
        this.tID = tID;
    }

    public int getiPriority() {
        return iPriority;
    }

    public void setiPriority(int iPriority) {
        this.iPriority = iPriority;
    }

    public String getiTime() {
        return iTime;
    }

    public void setiTime(String iTime) {
        this.iTime = iTime;
    }
}
