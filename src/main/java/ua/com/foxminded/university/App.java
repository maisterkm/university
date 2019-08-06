package ua.com.foxminded.university;

import java.sql.SQLException;

import ua.com.foxminded.university.dao.service.ScheduleService;
import ua.com.foxminded.university.domain.Schedule;
import ua.com.foxminded.university.domain.entity.Campus;
import ua.com.foxminded.university.domain.entity.Class;
import ua.com.foxminded.university.domain.entity.Classroom;
import ua.com.foxminded.university.domain.entity.Faculties;
import ua.com.foxminded.university.domain.entity.Group;
import ua.com.foxminded.university.domain.entity.Position;
import ua.com.foxminded.university.domain.entity.Student;
import ua.com.foxminded.university.domain.entity.Subject;
import ua.com.foxminded.university.domain.entity.Teacher;

public class App {
    public static void main(String[] args) {

        Position position_1 = new Position();
        Position position_2 = new Position();
        Position position_3 = new Position();
        position_1.setPosition_id(1);
        position_1.setPosition("PROFESSOR");
        position_2.setPosition_id(2);
        position_2.setPosition("ASSOCIATE_PROFESSOR");
        position_3.setPosition_id(3);
        position_3.setPosition("PROFESSOR");
        Teacher teacher1 = new Teacher(1, "Joe", "Black", 25, 10, 1965, 12, 11, 2001, position_1, 5000);
        Teacher teacher2 = new Teacher(2, "Martin", "Seal", 2, 5, 1976, 9, 3, 2011, position_3, 2500);
        Teacher teacher3 = new Teacher(2, "firstName_3", "lastName_3", 12, 10, 1958, 1, 8, 1987, position_1, 6000);
        System.out.println(teacher1.toString());
        System.out.println(teacher2.toString());
        System.out.println(teacher3.toString());

        Student student1 = new Student(1, "Eric", "Moore", 7, 2, 1999, 1, 9, 2016);
        Student student2 = new Student(2, "Whilliam", "Hill", 19, 6, 1999, 1, 9, 2016);
        Student student3 = new Student(3, "firstName_3", "lastName_3", 3, 2, 1999, 1, 9, 2016);
        Student student4 = new Student(4, "firstName_4", "lastName_4", 10, 3, 1999, 1, 9, 2016);
        Student student5 = new Student(5, "firstName_5", "lastName_5", 29, 7, 1999, 1, 9, 2016);
        Student student6 = new Student(6, "firstName_6", "lastName_6", 11, 3, 1999, 1, 9, 2016);
        Student student7 = new Student(7, "firstName_7", "lastName_7", 4, 2, 1999, 1, 9, 2016);
        System.out.println();
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());
        System.out.println(student5.toString());
        System.out.println(student6.toString());
        System.out.println(student7.toString());
        System.out.println();

        Faculties faculty_1 = new Faculties();
        Faculties faculty_2 = new Faculties();
        faculty_1.setFaculty_id(1);
        faculty_1.setFaculty("FACULTY_OF_MATHEMATICS");
        faculty_2.setFaculty_id(2);
        faculty_2.setFaculty("FACULTY_OF_COMPUTER_SCIENCE");

        Group group1 = new Group();
        group1.setGroupNumber("mt-1");
        group1.setFaculty(faculty_1);
        group1.addStudent(student1);
        group1.addStudent(student2);
        group1.addStudent(student3);
        group1.addStudent(student4);
        System.out.println();
        group1.displayGroup();

        Group group2 = new Group();
        group2.setGroupNumber("cs-1");
        group2.setFaculty(faculty_2);
        group2.addStudent(student5);
        group2.addStudent(student6);
        group2.addStudent(student7);
        System.out.println();
        group2.displayGroup();

        Subject subject1 = new Subject(1, "MATHEMATICS");
        Subject subject2 = new Subject(2, "PHYSICS");
        Subject subject3 = new Subject(3, "STATISTICS");
        System.out.println();
        System.out.println(subject1.toString());
        System.out.println(subject2.toString());
        System.out.println(subject3.toString());

        Campus campus_1 = new Campus();
        Campus campus_2 = new Campus();
        Campus campus_3 = new Campus();
        campus_1.setCampus("CAMPUS_A");
        campus_2.setCampus("CAMPUS_B");
        campus_3.setCampus("CAMPUS_C");

        Classroom room1 = new Classroom(campus_1, "101", 30);
        Classroom room2 = new Classroom(campus_1, "202", 40);
        Classroom room3 = new Classroom(campus_1, "303", 60);
        System.out.println();
        System.out.println(room1.toString());
        System.out.println(room2.toString());
        System.out.println(room3.toString());

        System.out.println("\nAdd group to student");
        student1.setGroup(group1);
        student2.setGroup(group1);
        student3.setGroup(group2);
        student4.setGroup(group2);
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());

        Class mathClass_seminar = new Class(room1, teacher1, subject1, 8, 0, 1, 9, 2019, 9, 30, 1, 9, 2019);
        Class mathClass_lecture = new Class(room3, teacher1, subject1, 10, 0, 2, 9, 2019, 11, 30, 2, 9, 2019);
        Class physicClass_seminar = new Class(room2, teacher2, subject2, 10, 0, 1, 9, 2019, 11, 30, 1, 9, 2019);
        Class physicClass_lecture = new Class(room3, teacher2, subject2, 13, 0, 2, 9, 2019, 14, 30, 2, 9, 2019);
        Class statisticClass_seminar = new Class(room1, teacher3, subject3, 10, 0, 4, 9, 2019, 11, 30, 4, 9, 2019);
        Class statisticClass_lecture = new Class(room3, teacher3, subject3, 12, 0, 4, 9, 2019, 13, 30, 4, 9, 2019);
        Class statisticClass_lecture_II = new Class(room3, teacher3, subject3, 7, 0, 1, 9, 2019, 8, 30, 1, 9, 2019);
        System.out.println();
        mathClass_seminar.displayClass();
        mathClass_lecture.displayClass();
        physicClass_seminar.displayClass();
        physicClass_lecture.displayClass();
        statisticClass_seminar.displayClass();
        statisticClass_lecture.displayClass();
        statisticClass_lecture_II.displayClass();

        Schedule schedule = new Schedule();
        schedule.addClass(statisticClass_lecture);
        schedule.addClass(physicClass_seminar);
        schedule.addClass(mathClass_seminar);
        schedule.addClass(mathClass_lecture);
        schedule.addClass(physicClass_lecture);
        schedule.addClass(statisticClass_seminar);
        schedule.addClass(statisticClass_lecture_II);
        System.out.println("\n---------- Display Month ----------");
        schedule.displayMonth(9);
        System.out.println("\n---------- Display Day ----------");
        schedule.displayDay(9, 1);

        schedule.removeClass(statisticClass_seminar);
        schedule.removeClass(statisticClass_lecture);
        System.out.println("\n---------- Display Month ----------");
        schedule.displayMonth(9);

        System.out.println("\nAdd classes to student's schedule");
        student1.addClassToSchedule(mathClass_seminar);
        student1.addClassToSchedule(mathClass_lecture);
        student1.addClassToSchedule(statisticClass_seminar);
        student1.addClassToSchedule(statisticClass_lecture);
        System.out.println("\n---------- Display Month ----------");
        student1.displayMonthSchedule(9);
        System.out.println("\nRemove classes from student's schedule");
        student1.removeClassFromSchedule(mathClass_lecture);
        student1.removeClassFromSchedule(statisticClass_lecture);
        System.out.println("\n---------- Display Month ----------");
        student1.displayMonthSchedule(9);
        System.out.println("\n---------- Display Day ----------");
        student1.displayDaySchedule(9, 1);

        // GroupService
//        Group groupTest = new Group();
//        groupTest.setGroup_id(10);
//        groupTest.setGroupNumber("NEW_GROUP");
//        groupTest.setFaculty(faculty_1);
//        GroupService groupService = new GroupService();
//        try {
//            System.out.println("\n--- GroupService ---");
//            System.out.println("\nGroupService.add()");
//            groupService.add(groupTest);
//
//            System.out.println("\nGroupService.getById()");
//            Group group_getById = groupService.getById(10);
//            System.out.println("id=" + group_getById.getGroup_id() + " groupNumber=" + group_getById.getGroupNumber() + " facultyId=" + group_getById.getFaculty_id());
//
//            System.out.println("\nGroupService.getAll()");
//            List<Group> groupList = new ArrayList<Group>();
//            groupList = groupService.getAll();
//            for (Group item : groupList) {
//                System.out.println("id=" + item.getGroup_id() + " groupNumber=" + item.getGroupNumber() + " facultyId=" + item.getFaculty().getFaculty_id());
//            }
//
//            System.out.println("\nGroupService.update()");
//            groupTest.setGroupNumber("GROUP_UPDATE");
//            groupTest.setFaculty(faculty_2);
//            groupService.update(groupTest);
//            groupList = groupService.getAll();
//            for (Group item : groupList) {
//                System.out.println("id=" + item.getGroup_id() + " groupNumber=" + item.getGroupNumber() + " facultyId=" + item.getFaculty_id());
//            }
//
//            System.out.println("\nGroupService.remove()");
//            groupService.remove(groupTest);
//            groupList = groupService.getAll();
//            for (Group item : groupList) {
//                System.out.println("id=" + item.getGroup_id() + " groupNumber=" + item.getGroupNumber() + " facultyId=" + item.getFaculty_id());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        // GroupService
//        Subject subjectTest = new Subject(10, "NEW_SUBJECT");
//        SubjectService subjectService = new SubjectService();
//        try {
//            System.out.println("\n--- SubjectService ---");
//            System.out.println("\nSubjectService.add()");
//            subjectService.add(subjectTest);
//
//            System.out.println("\nSubjectService.getById()");
//            Subject subject_getById = subjectService.getById(10);
//            System.out.println("id=" + subject_getById.getSubject_id() + " subject=" + subject_getById.getSubject());
//
//            System.out.println("\nSubjectService.getAll()");
//            List<Subject> subjectList = new ArrayList<Subject>();
//            subjectList = subjectService.getAll();
//            for (Subject item : subjectList) {
//                System.out.println("id=" + item.getSubject_id() + " subject=" + item.getSubject());
//            }
//
//            System.out.println("\nSubjectService.update()");
//            subjectTest.setSubject("SUBJECT_UPDATE");
//            subjectService.update(subjectTest);
//            subjectList = subjectService.getAll();
//            for (Subject item : subjectList) {
//                System.out.println("id=" + item.getSubject_id() + " subject=" + item.getSubject());
//            }
//
//            System.out.println("\nSubjectService.remove()");
//            subjectService.remove(subjectTest);
//            subjectList = subjectService.getAll();
//            for (Subject item : subjectList) {
//                System.out.println("id=" + item.getSubject_id() + " subject=" + item.getSubject());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        Person personTest = new Person(10, "FirstName_Test", "LastName_Test", 28, 02, 1955, 01, 01, 2019);
//        PersonService personService = new PersonService();
//        try {
//            System.out.println("\n--- PersonService ---");
//            System.out.println("\nPersonService.add()");
//            personService.add(personTest);
//
//            System.out.println("\nGroupService.getAll()");
//            List<Person> personList = new ArrayList<Person>();
//            personList = personService.getAll();
//            for (Person item : personList) {
//                System.out.println("id=" + item.getPerson_id() + " firstname=" + item.getFirstName() + " lastname="
//                        + item.getLastName() + " dateOfBirth= " + item.getDateOfBirth() + " enrollmentDate="
//                        + item.getEnrollmentDate());
//            }
//
//            System.out.println("\nPersonService.getById()");
//            Person person_getById = personService.getById(10);
//            System.out.println("id=" + person_getById.getPerson_id() + " firstname=" + person_getById.getFirstName()
//                    + " lastname=" + person_getById.getLastName() + " dateOfBirth= " + person_getById.getDateOfBirth()
//                    + " enrollmentDate=" + person_getById.getEnrollmentDate());
//
//            System.out.println("\nPersonService.update()");
//            personTest.setFirstName("FIRSTNAME_UPDATE");
//            personTest.setLastName("LASTNAME_UPDATE");
//            personService.update(personTest);
//            personList = personService.getAll();
//            for (Person item : personList) {
//                System.out.println("id=" + item.getPerson_id() + " firstname=" + item.getFirstName() + " lastname="
//                        + item.getLastName() + " dateOfBirth= " + item.getDateOfBirth() + " enrollmentDate="
//                        + item.getEnrollmentDate());
//            }
//
//            System.out.println("\nPersonService.remove()");
//            personService.remove(personTest);
//            personList = personService.getAll();
//            for (Person item : personList) {
//                System.out.println("id=" + item.getPerson_id() + " firstname=" + item.getFirstName() + " lastname="
//                        + item.getLastName() + " dateOfBirth= " + item.getDateOfBirth() + " enrollmentDate="
//                        + item.getEnrollmentDate());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        Teacher teacherTest = new Teacher(333, "FIRSTNAME_TEST333", "LASTNAME_TEST333", 30, 9, 1988, 21, 9, 2011,
//                position_1, 3333);
//        TeacherService teacherService = new TeacherService();
//        try {
//            System.out.println("\n--- TeacherService ---");
//            System.out.println("\nTeacherService.add()");
//            teacherService.add(teacherTest);
//
//            System.out.println("\nGroupService.getAll()");
//            List<Teacher> teacherList = new ArrayList<Teacher>();
//            teacherList = teacherService.getAll();
//            for (Teacher item : teacherList) {
//                System.out.println(item);
//            }
//
//            System.out.println("\nTeacherService.getById()");
//            Teacher teacher_getById = teacherService.getById(333);
//            System.out.println(teacher_getById);
//
//            System.out.println("\nTeacherService.update()");
//            teacherTest.setSalary(1000000);
//            teacherTest.setPosition(position_3);
//            teacherService.update(teacherTest);
//            teacherList = teacherService.getAll();
//            for (Teacher item : teacherList) {
//                System.out.println(item);
//            }
//
//            System.out.println("\nTeacherService.remove()");
//            teacherService.remove(teacherTest);
//            teacherList = teacherService.getAll();
//            for (Teacher item : teacherList) {
//                System.out.println(item);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        Student studentTest = new Student(100, "STUDENT_TEST", "STUDENT_TEST", 30, 9, 1988, 21, 9, 2011);
//        studentTest.setMatriculationnumber(100000);
//        group2.setGroup_id(2);
//        studentTest.setGroup(group2);
//        StudentService studentService = new StudentService();
//        try {
//            System.out.println("\n--- StudentService ---");
//            System.out.println("\nStudentService.add()");
//            studentService.add(studentTest);
//
//            System.out.println("\nStudentService.getAll()");
//            List<Student> studentList = new ArrayList<Student>();
//            studentList = studentService.getAll();
//            for (Student item : studentList) {
//                System.out.println(item);
//            }
//
//            System.out.println("\nStudentService.getById()");
//            Student student_getById = studentService.getById(100);
//            System.out.println(student_getById);
//
//            System.out.println("\nStudentService.update()");
//            studentTest.setMatriculationnumber(999999);
//            studentTest.setGroup(group2);
//            studentTest.setStudentSchedule(schedule);
//            studentService.update(studentTest);
//            studentList = studentService.getAll();
//            for (Student item : studentList) {
//                System.out.println(item);
//            }
//
//            System.out.println("\nstudentService.remove()");
//            studentService.remove(studentTest);
//            studentList = studentService.getAll();
//            for (Student item : studentList) {
//                System.out.println(item);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        Campus campusTest = new Campus();
//        campusTest.setCampus_id(10);
//        campusTest.setCampus("CAMPUS_TEST");
//        CampusService campusService = new CampusService();
//
//        Classroom classroomTest = new Classroom();
//        classroomTest.setCampus(campusTest);
//        classroomTest.setRoomNumber("room_test");
//        classroomTest.setCapacity(70);
//
//        ClassroomService classroomService = new ClassroomService();
//        try {
//            System.out.println("\n--- ClassroomService ---");
//            System.out.println("\nclassroomService.add()");
//
//            campusService.add(campusTest);
//
//            classroomService.add(classroomTest);
//
//            System.out.println("\nclassroomService.getAll()");
//            List<Classroom> classroomList = new ArrayList<Classroom>();
//            classroomList = classroomService.getAll();
//            for (Classroom item : classroomList) {
//                System.out.println(item);
//            }
//
//            System.out.println("\nclassroomService.getById()");
//            Classroom classroom_getById = classroomService.getById(10, "room_test");
//            System.out.println(classroom_getById);
//
//            System.out.println("\nClassroomService.update()");
//            classroomTest.setCapacity(120);
//            classroomService.update(classroomTest);
//            classroomList = classroomService.getAll();
//            for (Classroom item : classroomList) {
//                System.out.println(item);
//            }
//
//            System.out.println("\nclassroomService.remove()");
//            classroomService.remove(classroomTest);
//            classroomList = classroomService.getAll();
//            for (Classroom item : classroomList) {
//                System.out.println(item);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Schedule scheduleTest = new Schedule();
        scheduleTest.setSchedule_id(10);
        scheduleTest.setDescription("TEST_DESCRIPTION");
        ScheduleService scheduleService = new ScheduleService();
        try {
            System.out.println("\n--- ScheduleService ---");
            System.out.println("\nscheduleService.add()");
            scheduleService.add(scheduleTest);

//            System.out.println("\nclassroomService.getAll()");
//            List<Classroom> classroomList = new ArrayList<Classroom>();
//            classroomList = classroomService.getAll();
//            for (Classroom item : classroomList) {
//                System.out.println(item);
//            }
//
//            System.out.println("\nclassroomService.getById()");
//            Classroom classroom_getById = classroomService.getById(10, "room_test");
//            System.out.println(classroom_getById);
//
//            System.out.println("\nClassroomService.update()");
//            classroomTest.setCapacity(120);
//            classroomService.update(classroomTest);
//            classroomList = classroomService.getAll();
//            for (Classroom item : classroomList) {
//                System.out.println(item);
//            }
//
//            System.out.println("\nclassroomService.remove()");
//            classroomService.remove(classroomTest);
//            classroomList = classroomService.getAll();
//            for (Classroom item : classroomList) {
//                System.out.println(item);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
