package model.entity;

public class CarpetEnt {
    private long id;
    private String model;
    private int tarakom;
    private int shaane;
    private int price;

    public long getId() {
        return id;
    }

    public CarpetEnt setId(long id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarpetEnt setModel(String model) {
        this.model = model;
        return this;
    }

    public int getTarakom() {
        return tarakom;
    }

    public CarpetEnt setTarakom(int tarakom) {
        this.tarakom = tarakom;
        return this;
    }

    public int getShaane() {
        return shaane;
    }

    public CarpetEnt setShaane(int shaane) {
        this.shaane = shaane;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public CarpetEnt setPrice(int price) {
        this.price = price;
        return this;
    }
}
