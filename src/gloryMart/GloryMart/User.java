package GloryMart;

import java.util.Scanner;

class User {
    private String username;
    private int balance; // 사용자의 금액을 나타내는 변수
    private boolean isMember; // 멤버쉽 여부

    private static User instance;

    // private 생성자
    private User(String username, int initialBalance) {
        this.username = username;
        this.balance = initialBalance;
        this.isMember = false;
    }

   //싱글톤
    public static User getInstance(String username, int initialBalance) {
        if (instance == null) {
            instance = new User(username, initialBalance);
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public int getBalance() {
        return balance;
    }

    public void chargeBalance(int amount) {
        balance += amount;
        System.out.println(amount + "원이 충전되었습니다. 현재 잔액: " + balance + "원");
    }

    public boolean becomeMember() {
        System.out.println("멤버쉽 회원 가입을 원하시면 5000원을 결제해주세요. 아니오 선택시 일반회원입니다. (네 / 아니오)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        if (choice.equals("네") && balance >= 5000) {
            balance -= 5000;
            isMember = true;
            System.out.println("멤버쉽 회원으로 등록되었습니다. 현재 잔액: " + balance + "원");
            return true;
        } else if (choice.equals("아니오")) {
            System.out.println("멤버쉽 회원 등록이 취소되었습니다. 현재 잔액: " + balance + "원");
            return false;
        }
        return false;
    }

    public boolean isMember() {
        return isMember;
    }

    // 잔액 설정 메서드 추가
    public void setBalance(int newBalance) {
        this.balance = newBalance;
    }

    public void setMember(boolean b) {
    }
}