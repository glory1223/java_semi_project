package gloryMarket.project;

public class Person {
    private String name; //사람이름

    Person(String name) {
        this.name = name; // 자식클래스 User의 생성자로부터 매개변수를 받아 호출
    }

    public String getName() {
        return name; // 사람이름 반환 메소드 (외부에서 name속성에 접근하는 것이 아닌 getName()메소드로 이름 반환)
    }
}
