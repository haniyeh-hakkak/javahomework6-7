package model.entity;

public class CarEnt {
    private long id;
    private String name;
    private String color;
    private int price;
    private String gearbox;

    public long getId() {
        return id;
    }

    public CarEnt setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CarEnt setName(String name) {
        this.name = name;
        return this;
    }

    public String getColor() {
        return color;
    }

    public CarEnt setColor(String color) {
        this.color = color;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public CarEnt setprice(int price) {
        this.price = price;
        return this;
    }

    public String getGearbox() {
        return gearbox;
    }

    public CarEnt setGearbox(String gearbox) {
        this.gearbox = gearbox;
        return this;
    }
}