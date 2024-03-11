package GloryMart;

public interface Order {
    void addToCart();
    void calculateTotal();
    int getPrice();
    String getName();
}
