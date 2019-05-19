package com.businessHouseGame.model;

import static com.businessHouseGame.constant.HOTEL_RENT;
import static com.businessHouseGame.constant.HOTEL_WORTH;

public class Hotel extends Cell {
    private final int hotelWorth = HOTEL_WORTH;
    private final int hotelRent = HOTEL_RENT;
    private Player owner;

    @Override
    public void execute(Player player) {
        if (player.equals(owner)) return;
        if (this.owner == null && player.getWorth() >= this.hotelWorth) {
            player.deductAmount(this.hotelWorth);
            this.owner = player;
            player.boughtHotel(this);
            return;
        }

        player.deductAmount(this.hotelRent);
        if (owner != null)
            owner.addAmount(this.hotelRent);
    }
}
