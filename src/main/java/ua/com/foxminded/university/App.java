package ua.com.foxminded.university;

public class App 
{
    public static void main( String[] args )
    {
        
        Teacher teacher1 = new Teacher(1, "Joe", "Black", "25-10-1965", "12-11-2001", Position.PROFESSOR, 5000);
        Teacher teacher2 = new Teacher(2, "Martin", "Seal", "02-05-1976", "09-03-2011", Position.LECTURER, 2500);
        Teacher teacher3 = new Teacher(2, "firstName_3", "lastName_3", "12-16-58", "01-08-1987", Position.PROFESSOR, 6000);
        System.out.println(teacher1.toString());
        System.out.println(teacher2.toString());
        
        Student student1 = new Student(1, "Eric", "Moore", "07-02-1999", "01-09-2016", 111111);
        Student student2 = new Student(2, "Whilliam", "Hill", "19-06-1999", "01-09-2016", 111112);
        Student student3 = new Student(3, "firstName_3", "lastName_3", "03-02-1999", "01-09-2016", 111113);
        Student student4 = new Student(4, "firstName_4", "lastName_4", "10-03-1999", "01-09-2016", 111114);
        Student student5 = new Student(5, "firstName_5", "lastName_5", "29-07-1999", "01-09-2016", 111115);
        Student student6 = new Student(6, "firstName_6", "lastName_6", "11-03-1999", "01-09-2016", 111116);
        Student student7 = new Student(7, "firstName_7", "lastName_7", "04-02-1999", "01-09-2016", 111117);
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        
        Group group1 = new Group("mt-1", Faculties.FACULTY_OF_MATHEMATICS);
        group1.addStudent(student1);
        group1.addStudent(student2);
        group1.addStudent(student3);
        group1.addStudent(student4);
        System.out.println("\n" + group1.toString());
        
        
        Group group2 = new Group("cs-1", Faculties.FACULTY_OF_COMPUTER_SCIENCE);
        group2.addStudent(student5);
        group2.addStudent(student6);
        group2.addStudent(student7);
        System.out.println("\n" + group2.toString());
    }
    
}
