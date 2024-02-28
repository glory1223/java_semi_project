package studentInfo.project.school.report;

import studentInfo.project.school.School;
import studentInfo.project.school.Student;
import studentInfo.project.school.Subject;

import java.util.ArrayList;

// 학점에 대한 결과를 생성해주는 클래스
public class GenerateGradeReport {

    School school = School.getInstance();

    public static final String TITLE = "수강생 학점 \t\t\n ";
    public static final String HEADER = "이름 | 학번 | 필수과목 | 점수 \n ";
    public static final String LINE = "===================== \n ";


    // 문자열 연산을 빈번하게 하는 경우에는 메모리 효율을 위해 StringBuffer를 사용한다.
    private StringBuffer buffer = new StringBuffer(); // String buffer = ""

   //성적 산출 결과의 헤더, 몸통, 푸터를 합쳐준다
    public String getReport() {}

    public void makeHeader(Subject subject) {
        //buffer =LINE + TITLE; 문자열 연결 연산자 대신 append를 사용해 문자열 연결
        buffer.append(GenerateGradeReport.LINE); //=====================
        buffer.append("\t" + subject.getSubjectName());
        buffer.append(GenerateGradeReport.TITLE); //수학수강생학점
        buffer.append(GenerateGradeReport.HEADER); // 이름 | 학번 | 필수과목 | 점수
        buffer.append(GenerateGradeReport.LINE); //=====================
    }

    public void makeBody(Subject subject) {
        ArrayList<Student> studentList = subject.getStudentList();

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i); // 해당과목을 수강신청한 학생을 한명씩 가져온다.
        }
    }

    public void makeFooter() {
        buffer.append("\n");
    }

    //학생의 수강과목 점수와 학점을 얻는 메소드
    public void getScoreGrader() {}
}
