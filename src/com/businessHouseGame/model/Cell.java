package com.businessHouseGame.model;

public abstract class Cell {
    private int cellId;
    public abstract void execute(Player player);

    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }
}
