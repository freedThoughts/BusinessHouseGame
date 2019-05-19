package com.businessHouseGame.model;

public class Treasure extends Cell {
    public int getTreasureAmount() {
        return treasureAmount;
    }

    public void setTreasureAmount(int treasureAmount) {
        this.treasureAmount = treasureAmount;
    }

    private int treasureAmount;

    @Override
    public void execute(Player player) {
        player.addAmount(this.treasureAmount);
    }
}
