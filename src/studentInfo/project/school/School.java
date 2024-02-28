package studentInfo.project.school;

import java.util.ArrayList;

//School은 싱글룸으로 구현 -> 하나의 School 객체만 공유하도록 만든다.
public class School {
    private static String SCHOOL_NAME = "Good School"; // 학교이름

    private ArrayList<Student> studentList = new ArrayList<>(); // 학교에 등록한 학생들
    private ArrayList<Subject> subjectsList = new ArrayList<>(); // 학교에 개설한 과목


    //1. 싱글톤으로 사용할 객체를 private static 키워드로 붙여서 선언한다 (해당클래스의 static에서만 공유)
    private static School instance = null; //아무것도참조하지않음(객체를 참조하지않음)

    //2. 싱글톤은 생성자에 private ?? -> 외부클래스에서  School 객체를 생성할수 없게 만든다,
    private School() {}

    //3. 싱글톤 객체를 생성하는 메소드 구현
    public static School getInstance( ) {

        if( instance == null) { //처음 school객체가 생성될때 실행
            instance = new School(); //맨처음엔 null 이라객체 생성
        }

        // 1번쨰 이후 school객체가 생성될떄 실행
        return instance; //첫번쨰 이후부턴 이제 사용된 school객체 리턴
    }


    //학생 입학
    public void addStudent(Student student) {
    studentList.add(student); //학생 객체를 저장
    }

    //학생 리스트 리턴
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    //과목개설
    public void addSubject(Subject subject) {
    subjectsList.add(subject);
    }

    //과목 리스트 리턴
    public ArrayList<Subject> getSubjectsList() {
        return subjectsList;
    }
}
