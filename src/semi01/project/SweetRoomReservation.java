package semi01.project;

public class SweetRoomReservation extends  RoomReservation{
    public SweetRoomReservation(String name, int reservationDay, String reservationRoom, int people) {
        super(name, reservationDay, reservationRoom, people);  // 부모생성자 호출

        roomType ="Sweet룸";
        price = 50;
        PercentSail = 0.2;
        serveBreakfast = "있음";
    }

    @Override
    public void reserve() {
        System.out.println("예약되었습니다.");
    }

    @Override
    public void payRoomInfo() {
        if (reservationDay >= 3) {
            System.out.println(" <" + roomType + "> " + "가격: " + price + " 만원 " +  " 조식제공여부: " + serveBreakfast);
            System.out.println("지불할 금액: " + ((int)(price * reservationDay) * people * 0.8  )+ "만원");
        }
        else this.showRoomInfo();

    }
}
