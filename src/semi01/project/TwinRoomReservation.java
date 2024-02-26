package semi01.project;

public class TwinRoomReservation extends RoomReservation{
    public TwinRoomReservation(String name, int reservationDay, String reservationRoom, int people) {
        super(name, reservationDay, reservationRoom, people); // 부모생성자 호출

        roomType ="Twin룸";
        price = 25;
        rangePeople = 3;
        PercentSail = 0.1; serveBreakfast= "없음";
  }

    @Override
    public void payRoomInfo() {
        if (reservationDay >= 3) {
            System.out.println(" <" + roomType + "> " + "가격: " + (price * 10000 ) + " 원 " +  " 조식제공여부: " + serveBreakfast);
            System.out.println("지불할 금액: " + ((int)(price * reservationDay) * people * 0.9 ) * 10000+ "원");
        }
        else  this.showRoomInfo();

    }

}
