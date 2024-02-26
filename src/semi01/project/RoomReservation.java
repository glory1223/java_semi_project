package semi01.project;

public class RoomReservation {

    public String name;//예약자명
    int reservationDay;//예약일수
    String reservationRoom;//예약할룸
    int people; //인원
    String roomType; //ROOM
    int rangePeople; //제한인원
    int price; //가격
    double PercentSail; //할인율(3박이상)
    String serveBreakfast; //조식여부

    public RoomReservation(String name, int reservationDay, String reservationRoom, int people) {

     this.name = name;
     this.reservationDay = reservationDay;
     this.reservationRoom = reservationRoom;
     this.people = people;
 inputRoom();
 }

 // 방의 정보초기화
 void inputRoom() {
        roomType ="Single룸";
price = 10;
rangePeople = 1;
PercentSail = 0;
serveBreakfast = "없음";
    }

    //룸예약
    public void reserve() {
        if (people > rangePeople) {
            System.out.println("제한 인원보다 많습니다.");
        } else {
            System.out.println("룸 예약이 완료되었습니다.");
        }
    }



    //예약후 지불해야할 금액과 예약 내역
    public void payRoomInfo() {
        System.out.println(" <" + roomType + "> " + "가격: " + ( price *10000 )+ " 원 " +  " 조식제공여부: " + serveBreakfast);
        System.out.println("지불할 금액: " + (price * reservationDay) * people * 10000 + "원");
    }


    //해당 룸의 정보
    public void showRoomInfo() {
        if(serveBreakfast != null) System.out.println(" <" + roomType + "> " + "가격: " + (price * 10000)+ " 원 " + "인원제한: " + rangePeople +"명 " + " 조식제공여부: " + serveBreakfast);
         else System.out.println(" <" + roomType + "> " + "가격: " + (price * 10000) + " 원 " + "인원제한: " + rangePeople +"명 " + " 조식제공여부: 없음");
    }

    //해당! 고객의 예약 정보
        public void showCustomerInfo() {
        if(serveBreakfast != null) System.out.println("<" + roomType  + "> " + "예약일수: " + reservationDay + " 조식제공여부: " + serveBreakfast);
        else System.out.println("<" + roomType  + "> " + "예약일수: " + rangePeople + " 조식제공여부: 없음");

    }



 }





