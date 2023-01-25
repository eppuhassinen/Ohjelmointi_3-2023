
import java.util.ArrayList;


public class Student {

    private final String name;
    private final String StudentNumber;
    private final ArrayList<Attainment> attainments;
    

    
    public Student(String name, String studentNumber) {
        this.name = name;
        this.StudentNumber = studentNumber;
        this.attainments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return StudentNumber;
    }
    
    public void addAttainment(Attainment att) {
        this.attainments.add(att);
    }

    public ArrayList<Attainment> getAttainments() {
        return attainments;
    }

    
    
}
