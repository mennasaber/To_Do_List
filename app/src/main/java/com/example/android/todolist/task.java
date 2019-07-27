package com.example.android.todolist;

public class task  {
    int tID; //track ID
    String tname;//track name
    boolean tchecked;//track checked
    int tPriority; //track priority
    String tTime; //track time

    public task(String tname, boolean tChecked, int tPriority, String tTime) {
        this.tname=tname;
        this.tchecked=tChecked;
        this.tPriority = tPriority;
        this.tTime = tTime;
    }

    public int gettID() {
        return tID;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public boolean isTchecked() {
        return tchecked;
    }

    public void setTchecked(boolean tchecked) {
        this.tchecked = tchecked;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public int gettPriority() {
        return tPriority;
    }

    public void settPriority(int tPriority) {
        this.tPriority = tPriority;
    }

    public String gettTime() {
        return tTime;
    }

    public void settTime(String tTime) {
        this.tTime = tTime;
    }
}
