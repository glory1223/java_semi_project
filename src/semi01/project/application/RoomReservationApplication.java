package semi01.project.application;

import semi01.project.*;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomReservationApplication {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<RoomReservation> roomList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1.룸예약하기 | 2.지불금액 | 3.룸정보 | 4.예약정보 | 5. 예약자명으로정보찾기");
            int inputFunc = scanner.nextInt();

            System.out.println("예약자명: ");
            String name = scanner.next();

            System.out.println("예약일수: ");
            int reservationDay = scanner.nextInt();

            System.out.println("-------------------------");
            System.out.println("single | double | twin | sweet");
            System.out.println("-------------------------");
            System.out.println("예약할룸: ");
            String reservationRoom = scanner.next();

            System.out.println("인원: ");
            int people = scanner.nextInt();

            switch (reservationRoom) {
                case "single":
                    RoomReservation reservationSingle = new RoomReservation(name, reservationDay, reservationRoom, people);
                    roomList.add(reservationSingle); //0: 싱글
                    break;
                case "double":
                    RoomReservation reservationDouble = new DoubleRoomReservation(name, reservationDay, reservationRoom, people);
                    roomList.add(reservationDouble); //1: 더블
                    break;
                case "twin":
                    RoomReservation reservationTwin = new TwinRoomReservation(name, reservationDay, reservationRoom, people);
                    roomList.add(reservationTwin); //2: 트윈
                    break;
                case "sweet":
                    RoomReservation reservationSweet = new SweetRoomReservation(name, reservationDay, reservationRoom, people);
                    roomList.add(reservationSweet); //3: 스윗
                    break;
                default:
                    System.out.println("유효하지 않은 객실 유형");
                    return;
            }

            // 예약 정보 출력
            for (RoomReservation roomReservation : roomList) {
                switch (inputFunc) {
                    case 1:
                        // 룸 예약 정보 출력
                        roomReservation.reserve();
                        break;
                    case 2:
                        // 지불 금액 정보 출력
                        roomReservation.payRoomInfo();
                        break;
                    case 3:
                        // 룸 정보 출력
                        roomReservation.showRoomInfo();
                        break;
                    case 4:
                        // 고객 정보 출력
                        roomReservation.showCustomerInfo();
                        break;
                }
            }
        }
    }
}

