package Menu;

public abstract class Item {
    public String description;
    public int id;
    public double price;

    public abstract int getID();

    public abstract double getPrice();

    public abstract String getDesc();

    public abstract void updatePrice(double newPrice);

    public abstract void updateDesc(String newDesc);
}
