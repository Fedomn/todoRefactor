package com.fedomn.todoRefactor.WindowObserver;

import java.util.Observable;

public class Subject extends Observable {

    private String start = "0";
    private String end = "0";
    private String length = "0";

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
        this.setChanged();
        this.notifyObservers();
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
        this.setChanged();
        this.notifyObservers();
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
        this.setChanged();
        this.notifyObservers();
    }

    void calculateLength() {
        try {
            int start = Integer.parseInt(getStart());
            int end = Integer.parseInt(getEnd());
            int length = end - start;
            this.setLength(String.valueOf(length));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Unexpected Number Format Error");
        }
    }

    void calculateEnd() {
        try {
            int start = Integer.parseInt(getStart());
            int length = Integer.parseInt(getLength());
            int end = start + length;
            this.setEnd(String.valueOf(end));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Unexpected Number Format Error");
        }
    }

}
