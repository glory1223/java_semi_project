package gloryMarket.project.application;

import gloryMarket.project.GloryMarket;
import gloryMarket.project.Product;
import gloryMarket.project.User;

public class Gmarket {
    public static void main(String[] args) {
        //프로그램 실행
        GloryMarket gloryMarket = GloryMarket.getInstance();

        //제품 등록
        Product laptop = new Product("Laptop", 12000000);
        Product car = new Product("Car", 1000000000);

        //유저등록
        User user1 = new User("glory");


        System.out.println("User: " + user1.getName());

    }
}
