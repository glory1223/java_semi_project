package GloryMart;

class Product implements Order {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void addToCart() {
        System.out.println(name + "을 장바구니에 담았습니다.");
    }

    @Override
    public void calculateTotal() {
        System.out.println(name + "의 가격은 " + price + "원 입니다.");
    }



    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}