package com.businessHouseGame.model;

import java.util.HashSet;
import java.util.Set;

import static com.businessHouseGame.constant.HOTEL_WORTH;
import static com.businessHouseGame.constant.INITIAL_PLAYER_WORTH;

public class Player {
    private final String name;
    private int worth;
    private Set<Cell> hotels = new HashSet<Cell>();
    private Cell currentCell;

    public Player(String name, Cell cell) {
        this.name = name;
        this.worth = INITIAL_PLAYER_WORTH;
        this.currentCell = cell;
    }

    public int getCellId() {
        return this.currentCell.getCellId();
    }

    public int getTotalWorth() {
        return this.worth + this.hotels.size() * HOTEL_WORTH;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public String getName() {
        return name;
    }

    public void deductAmount(int amount) {
        this.worth -= amount;
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }

    public Set<Cell> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Cell> hotels) {
        this.hotels = hotels;
    }

    public void addAmount(int amount) {
        this.worth += amount;
    }

    public void boughtHotel(Hotel hotel) {
        this.hotels.add(hotel);
    }

    public void execute() {
        this.currentCell.execute(this);
    }
}
