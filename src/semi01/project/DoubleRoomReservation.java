package semi01.project;

public class DoubleRoomReservation extends RoomReservation{


    public DoubleRoomReservation(String name, int reservationDay, String reservationRoom, int people) {
        super(name, reservationDay, reservationRoom, people); //super 부모한테 있는 생성자 호출
        roomType ="Double룸";
        price = 20;
        rangePeople = 2;
        PercentSail = 0;
        serveBreakfast = "없음" ;
    }

    @Override
    public void payRoomInfo() {
        if (reservationDay >= 3) {
            System.out.println(" <" + roomType + "> " + "가격: " + price + " 만원 " + " 조식제공여부: " + serveBreakfast);
            System.out.println("지불할 금액: " + ((int) (price * reservationDay) * people * 0.95) + "만원");
        } else this.showRoomInfo();

    }
}
