package com.businessHouseGame.model;

import static com.businessHouseGame.constant.JAIL_BAIL_AMOUNT;

public class Jail extends Cell {
    private final int bailAmount = JAIL_BAIL_AMOUNT;


    @Override
    public void execute(Player player) {
        player.deductAmount(this.bailAmount);
    }
}
