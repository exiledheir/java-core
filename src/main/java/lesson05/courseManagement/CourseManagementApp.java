package lesson05.courseManagement;

import lesson05.courseManagement.model.Course;
import lesson05.courseManagement.model.Student;
import lesson05.courseManagement.model.Tutor;
import lesson05.courseManagement.service.CourseManagementService;
import lesson05.courseManagement.service.impl.CourseManagementServiceImpl;

public class CourseManagementApp {
    public static void main(String[] args) {
        CourseManagementService service = new CourseManagementServiceImpl();

        System.out.println("=== CREATING COURSES ===");
        Course javaCourse = service.createCourse("Java");
        Course pythonCourse = service.createCourse("Python");

        Tutor javaTutor = new Tutor("John Smith", "10 years of Java experience", 4.8);
        Tutor pythonTutor = new Tutor("Sarah Johnson", "Expert in Python and ML", 4.9);

        System.out.println("\n=== TUTORS ===");
        javaTutor.introduce();
        pythonTutor.introduce();

        javaTutor.assignCourse(javaCourse);
        pythonTutor.assignCourse(pythonCourse);

        Student student1 = new Student("Alice Brown", "Computer Science major", 85);
        Student student2 = new Student("Bob Wilson", "Software Engineering student", 78);
        Student student3 = new Student("Carol Davis", "IT enthusiast", 92);

        System.out.println("\n=== STUDENTS ===");
        student1.introduce();
        student2.introduce();
        student3.introduce();

        System.out.println("\n=== ENROLLING STUDENTS ===");
        service.addStudent(javaCourse, student1);
        service.addStudent(javaCourse, student2);
        service.addStudent(javaCourse, student3);

        service.addStudent(pythonCourse, student1);
        service.addStudent(pythonCourse, student3);

        System.out.println("\n=== MARKING ATTENDANCE ===");
        service.markAttendance(javaCourse, student1, true);
        service.markAttendance(javaCourse, student2, true);
        service.markAttendance(javaCourse, student3, false);
        System.out.println("Week 1 attendance marked");

        service.markAttendance(javaCourse, student1, true);
        service.markAttendance(javaCourse, student2, false);
        service.markAttendance(javaCourse, student3, true);
        System.out.println("Week 2 attendance marked");

        service.getAttendanceList(javaCourse);

        System.out.println("\n=== SETTING GRADES ===");
        service.setGrade(javaCourse, student1, 95);
        service.setGrade(javaCourse, student2, 82);
        service.setGrade(javaCourse, student3, 88);

        System.out.println("\n=== COURSE SUMMARY ===");
        System.out.println("Course: " + javaCourse.getName());
        System.out.println("Tutor: " + javaCourse.getTutor().getFio());
        System.out.println("Total Students: " + javaCourse.getStudents().size());

        System.out.println("\nCourse: " + pythonCourse.getName());
        System.out.println("Tutor: " + pythonCourse.getTutor().getFio());
        System.out.println("Total Students: " + pythonCourse.getStudents().size());

        // Interactive attendance checking
        System.out.println("\n=== INTERACTIVE ATTENDANCE (Week 3) ===");
        service.checkAttendance(javaCourse);

        service.getAttendanceList(javaCourse);
    }

}