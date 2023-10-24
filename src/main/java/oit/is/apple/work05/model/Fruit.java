package oit.is.apple.work05.model;

public class Fruit {
    int id;
    String name;
    int price;

    public Fruit() {
    }

    public Fruit(int id, String name, int price) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
