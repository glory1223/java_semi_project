package project.school.report;

import project.grade.BasicEvaluation;
import project.grade.GradeEvaluation;
import project.grade.MajorEvaluation;
import project.school.School;
import project.school.Score;
import project.school.Student;
import project.school.Subject;
import project.utils.Define;

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
    public String getReport() {
        ArrayList<Subject> subjectList = school.getSubjectsList(); //과목리스트

        for (Subject subject : subjectList) {
            makeHeader(subject);
            makeBody(subject);
            makeFooter();
        }
        return buffer.toString(); //StringBuffer 타입의 데이터를 String 타입으로 바꿔준다.
    }

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
            buffer.append(student.getStudentName()); //학생이름
            buffer.append(" | ");
            buffer.append(student.getStudentId()); //학번
            buffer.append(" | ");
            buffer.append(student.getMajorSubject().getSubjectName()); //학생 필수과목
            buffer.append(" | ");

            //학생별, 수강과목의 점수, 학점 계산
            getScoreGrade(student, subject.getSubjectId());
                buffer.append("\n");
                buffer.append(LINE);

        }
    }

    public void makeFooter() {
        buffer.append("\n");
    }

    //학생의 수강과목 점수와 학점을 얻는 메소드
    public void getScoreGrade(Student student, int subjectId) {
        //해당 학생이 수강한 과목의 점수리스트 (국어, 수학)
        ArrayList<Score> scoreList = student.getScoreList();

        //해당 학생의 필수과목의 과목코드
        int majorId = student.getMajorSubject().getSubjectId();

        //GradeEvaluation gradeEvaluations = new BasicEvaluation(); 자동타입변환
        //GradeEvaluation gradeEvaluations = new MajorEvaluation(); 자동타입변환
        GradeEvaluation[] gradeEvaluations = {new BasicEvaluation(), new MajorEvaluation()}; //배열안에는 어떠한 타입도 담을수 있음.

        for (int i = 0; i < scoreList.size(); i++) {
            Score score = scoreList.get(i); //해당 과목의 점수를 받아온다.

            //과목코드가 같은지 확인 (원하는과목의학점을 얻기위해)
            if(score.getSubject().getSubjectId() == subjectId) {
                String grade; // 학점

                //필수과목일때 학점 산출
                if(score.getSubject().getSubjectId() == majorId) {
                    grade = gradeEvaluations[Define.SAB_TYPE].getGrade(score.getPoint()); // new MajorEvaluation()
                } else { //일반과목일때 학점 산출
                    grade = gradeEvaluations[Define.AB_TYPE].getGrade(score.getPoint()); // new BasicEvaluation()
                }
                buffer.append(score.getPoint());
                buffer.append(":");
                buffer.append(grade);
                buffer.append(" | ");


            }
        }
    }
}
