import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class StudentRegister {

    private final TreeMap<String, Student> students;
    private final TreeMap<String, Course> courses;

    public StudentRegister() {
        this.students = new TreeMap<>();
        this.courses = new TreeMap<>();
    }

    public ArrayList<Course> getCourses() {
        ArrayList<Course> coursesList = new ArrayList<>();
        for (Map.Entry<String, Course> c : this.courses.entrySet()) {
            coursesList.add(c.getValue());
        }
        
        coursesList.sort((a,b) -> {
                    String aName = 
                            this.courses.get(a.getCode()).getName();
                    String bName = 
                            this.courses.get(b.getCode()).getName();
                    
                    return aName.compareTo(bName);
        });
        
        return coursesList;
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> studentsList = new ArrayList<>();
        for (Map.Entry<String, Student> s : this.students.entrySet()) {
            studentsList.add(s.getValue());
        }
        
        studentsList.sort((a,b) -> {
            return a.getName().compareTo(b.getName());
        });
        
        return studentsList;
    }
    
    public void addStudent(Student student) {
        this.students.put(student.getStudentNumber(), student);
    }
    
    public void addCourse(Course course) {
        this.courses.put(course.getCode(), course);
    }
    
    public void addAttainment(Attainment att) {
        
        this.students.get(att.getStudentNumber()).addAttainment(att);
        }
        
    
    
    public void printStudentAttainments(String studentNumber, String ... order) {
        
        if (!this.students.containsKey(studentNumber)) {
            System.out.println("Unknown student number: " + studentNumber);
            return;
        } 
        ArrayList<Attainment> sorted;
        
        sorted = this.students.get(studentNumber).getAttainments();
        
        if (order.length == 0) {this.printAttainments(sorted); return;}
         
        switch(order[0]) {
            case "by name":
                sorted.sort((a,b) -> {
                    String aName = 
                            this.courses.get(a.getCourseCode()).getName();
                    String bName = 
                            this.courses.get(b.getCourseCode()).getName();
                    
                    return aName.compareTo(bName);
        });
                
                break;
                
            case "by code":
            default:
                
                sorted.sort((a,b) -> {
                    
                    return a.getCourseCode().compareTo(b.getCourseCode());
        });
                
                break;
        }
        this.printAttainments(sorted);
        
    }

    
    private void printAttainments(ArrayList<Attainment> att) {
        
        System.out.println(this.students.get(att.get(0).getStudentNumber()).getName() + 
                " (" + att.get(0).getStudentNumber()+ "):");
        
        for (Attainment at : att) {
            System.out.println("  " + at.getCourseCode() + " " + 
                    this.courses.get(at.getCourseCode()).getName() + 
                    ": " + at.getGrade());
        }
    }
}
