package com.androidpprog2.tres_en_raya.model;

public class Player {
    private String symbol;
    private boolean status;

    public Player(String symbol, boolean status) {
        this.symbol = symbol;
        this.status = status;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
