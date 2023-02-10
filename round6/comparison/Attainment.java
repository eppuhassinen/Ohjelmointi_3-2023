
import java.util.Comparator;

public class Attainment implements Comparable<Attainment>{
    
    public static final Comparator<Attainment> CODE_STUDENT_CMP = new Comparator<Attainment>() {
        @Override
        public int compare(Attainment a, Attainment b) {
        int cmp = a.getCourseCode().compareTo(b.getCourseCode());
        if (cmp == 0) {
            cmp = a.getStudentNumber().compareTo(b.getStudentNumber());
        }
        return cmp;
        }
    };
    
    public static final Comparator<Attainment> CODE_GRADE_CMP = new Comparator<Attainment>() {
        @Override
        public int compare(Attainment a, Attainment b) {
        int cmp = a.getCourseCode().compareTo(b.getCourseCode());
        if (cmp == 0) {
            cmp = Integer.compare(b.getGrade(), a.getGrade());
        }
        return cmp;
        }
    };
    
    @Override
    public int compareTo(Attainment o){
        int cmp = this.studentNumber.compareTo(o.getStudentNumber());
        if(cmp == 0) {
            cmp = this.courseCode.compareTo(o.getCourseCode());
        }
        return cmp;

    }
        
    

    private int grade = 0;
    private String courseCode = null;
    private String studentNumber = null;
    
    public Attainment(String courseCode, String studentNumber, int grade) {
        this.grade = grade;
        this.courseCode = courseCode;
        this.studentNumber = studentNumber;
    }

    public int getGrade() {
        return grade;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    @Override
    public String toString() {
        return this.courseCode + " " + this.studentNumber + " " + this.grade;
    }
    
    
    
}
