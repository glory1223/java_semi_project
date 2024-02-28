package studentInfo.project.utils;

//프로그램 전반적으로 사용하는 상수(static final)들 정의하는 클래스 ->이렇게 하는 이유는 상수들의 사용, 수정,관리가 용이하다.
public class Define {
    //과목코드
    public static final int KOREA = 1001; // 국어
    public static final int MATH = 2001; // 수학

    //학점 산출 방식
    public static final int AB_TYPE = 0; //A,B,... 일반과목 산출방식
    public static final int SAB_TYPE = 1; //S,A,B,... 필수과목 산출방식
}
