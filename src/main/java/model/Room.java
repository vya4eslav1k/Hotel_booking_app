package model;

public class Room {
    private int number;
    private String type;
    private double pricePerNight;
    private boolean isAvailable;

    public Room(int number, String type, double pricePerNight, boolean isAvailable) {
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
