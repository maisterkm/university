package ua.com.foxminded.university;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.dao.FactoryDAO;
import ua.com.foxminded.university.dao.service.CampusDAO;
import ua.com.foxminded.university.dao.service.ClassroomDAO;
import ua.com.foxminded.university.dao.service.DailyScheduleDAO;
import ua.com.foxminded.university.dao.service.FacultiesDAO;
import ua.com.foxminded.university.dao.service.GroupDAO;
import ua.com.foxminded.university.dao.service.MonthlyScheduleDAO;
import ua.com.foxminded.university.dao.service.PersonDAO;
import ua.com.foxminded.university.dao.service.PositionDAO;
import ua.com.foxminded.university.dao.service.ScheduleDAO;
import ua.com.foxminded.university.dao.service.StudentDAO;
import ua.com.foxminded.university.dao.service.SubjectDAO;
import ua.com.foxminded.university.dao.service.TeacherDAO;
import ua.com.foxminded.university.domain.DailySchedule;
import ua.com.foxminded.university.domain.MonthlySchedule;
import ua.com.foxminded.university.domain.Schedule;
import ua.com.foxminded.university.domain.entity.Campus;
import ua.com.foxminded.university.domain.entity.Classroom;
import ua.com.foxminded.university.domain.entity.Faculties;
import ua.com.foxminded.university.domain.entity.Group;
import ua.com.foxminded.university.domain.entity.Person;
import ua.com.foxminded.university.domain.entity.Position;
import ua.com.foxminded.university.domain.entity.Student;
import ua.com.foxminded.university.domain.entity.Subject;
import ua.com.foxminded.university.domain.entity.Teacher;

public class App {
    public static void main(String[] args) {
        FactoryDAO factory = new FactoryDAO();

        try {
            // CampusDAO
            Campus campusTest = new Campus(10, "TEST_CAMPUS");
            CampusDAO campusDAO = (CampusDAO) factory.create(TypeOfEntity.CAMPUS);

            System.out.println("\n--- campusDAO ---");
            System.out.println("\ncampusDAO.add()");
            campusDAO.add(campusTest);

            System.out.println("\ncampusDAO.getById()");
            Campus fauculty_getById = campusDAO.getById(10);
            System.out.println(fauculty_getById);

            System.out.println("\ncampusDAO.getAll()");
            List<Campus> campusList = new ArrayList<Campus>();
            campusList = campusDAO.getAll();
            for (Campus item : campusList) {
                System.out.println(item);
            }

            System.out.println("\ncampusDAO.update()");
            campusTest.setCampus("CAMPUS_UPDATE");
            campusDAO.update(campusTest);
            campusList = campusDAO.getAll();
            for (Campus item : campusList) {
                System.out.println(item);
            }

            System.out.println("\ncampusDAO.remove()");
            campusDAO.remove(campusTest);
            campusList = campusDAO.getAll();
            for (Campus item : campusList) {
                System.out.println(item);
            }

            // PositionDAO
            Position positionTest = new Position(10, "TEST_POSITION");
            PositionDAO positionDAO = (PositionDAO) factory.create(TypeOfEntity.POSITION);

            System.out.println("\n--- PositionDAO ---");
            System.out.println("\npositionDAO.add()");
            positionDAO.add(positionTest);

            System.out.println("\npositionDAO.getById()");
            Position position_getById = positionDAO.getById(10);
            System.out.println(position_getById);

            System.out.println("\npositionDAO.getAll()");
            List<Position> positionList = new ArrayList<Position>();
            positionList = positionDAO.getAll();
            for (Position item : positionList) {
                System.out.println(item);
            }

            System.out.println("\npositionDAO.update()");
            positionTest.setPosition("POSITION_UPDATE");
            positionDAO.update(positionTest);
            positionList = positionDAO.getAll();
            for (Position item : positionList) {
                System.out.println(item);
            }

            System.out.println("\npositionDAO.remove()");
            positionDAO.remove(positionTest);
            positionList = positionDAO.getAll();
            for (Position item : positionList) {
                System.out.println(item);
            }

            // FacultyDAO
            Faculties facultyTest = new Faculties(10, "NEW_FACULTY");
            FacultiesDAO facultiesDAO = (FacultiesDAO) factory.create(TypeOfEntity.FACULTIES);

            System.out.println("\n--- FacultiesDAO ---");
            System.out.println("\nfacultiesDAO.add()");
            facultiesDAO.add(facultyTest);

            System.out.println("\nfacultiesDAO.getById()");
            Faculties fauculties_getById = facultiesDAO.getById(10);
            System.out.println(fauculties_getById);

            System.out.println("\nFacultiesDAO.getAll()");
            List<Faculties> facultyList = new ArrayList<Faculties>();
            facultyList = facultiesDAO.getAll();
            for (Faculties item : facultyList) {
                System.out.println(item);
            }

            System.out.println("\nfacultyDAO.update()");
            facultyTest.setFaculty("FACULTY_UPDATE");
            facultiesDAO.update(facultyTest);
            facultyList = facultiesDAO.getAll();
            for (Faculties item : facultyList) {
                System.out.println(item);
            }

            System.out.println("\nfacultyDAO.remove()");
            facultiesDAO.remove(facultyTest);
            facultyList = facultiesDAO.getAll();
            for (Faculties item : facultyList) {
                System.out.println(item);
            }

            // GroupDAO
            Faculties faculty_1 = new Faculties(20, "FACULTY_TEST_1");
            facultiesDAO.add(faculty_1);
            Faculties faculty_2 = new Faculties(30, "UPDATE_FACULTY_OF_COMPUTER_SCIENCE");
            facultiesDAO.add(faculty_2);
            Group groupTest = new Group(10, "GR_TEST_1", faculty_1);

            GroupDAO groupDAO = (GroupDAO) factory.create(TypeOfEntity.GROUP);

            System.out.println("\n--- GroupDAO ---");
            System.out.println("\ngroupDAO.add()");
            groupDAO.add(groupTest);

            System.out.println("\ngroupDAO.getById()");
            Group group_getById = groupDAO.getById(10);
            System.out.println(group_getById.displayGroup());

            System.out.println("\ngroupDAO.getAll()");
            List<Group> groupList = new ArrayList<Group>();
            groupList = groupDAO.getAll();
            for (Group item : groupList) {
                System.out.println(item.displayGroup());
            }

            System.out.println("\ngroupDAO.update()");
            groupTest.setGroupNumber("GROUP_UPDATE");
            groupTest.setFaculty(faculty_2);
            groupDAO.update(groupTest);
            groupList = groupDAO.getAll();
            for (Group item : groupList) {
                System.out.println(item.displayGroup());
            }

            System.out.println("\ngroupDAO.remove()");
            groupDAO.remove(groupTest);
            groupList = groupDAO.getAll();
            for (Group item : groupList) {
                System.out.println(item.displayGroup());
            }

            // SubjectDAO
            Subject subjectTest = new Subject(10, "NEW_SUBJECT");
            SubjectDAO subjectDAO = (SubjectDAO) factory.create(TypeOfEntity.SUBJECT);

            System.out.println("\n--- SubjectDAO ---");
            System.out.println("\nsubjectService.add()");
            subjectDAO.add(subjectTest);

            System.out.println("\nsubjectDAO.getById()");
            Subject subject_getById = subjectDAO.getById(10);
            System.out.println(subject_getById.toString());

            System.out.println("\nSubjectDAO.getAll()");
            List<Subject> subjectList = new ArrayList<Subject>();
            subjectList = subjectDAO.getAll();
            for (Subject item : subjectList) {
                System.out.println(item.toString());
            }

            System.out.println("\nsubjectService.update()");
            subjectTest.setSubject("SUBJECT_UPDATE");
            subjectDAO.update(subjectTest);
            subjectList = subjectDAO.getAll();
            for (Subject item : subjectList) {
                System.out.println(item.toString());
            }

            System.out.println("\nsubjectDAO.remove()");
            subjectDAO.remove(subjectTest);
            subjectList = subjectDAO.getAll();
            for (Subject item : subjectList) {
                System.out.println(item.toString());
            }

            // PersonDAO
            Person personTest = new Person(10, "FirstName_Test", "LastName_Test", 28, 02, 1955, 01, 01, 2019);
            PersonDAO personDAO = (PersonDAO) factory.create(TypeOfEntity.PERSON);

            System.out.println("\n--- PersonDAO ---");
            System.out.println("\npersonDAO.add()");
            personDAO.add(personTest);

            System.out.println("\npersonDAO.getAll()");
            List<Person> personList = new ArrayList<Person>();
            personList = personDAO.getAll();
            for (Person item : personList) {
                System.out.println(item);
            }

            System.out.println("\npersonDAO.getById()");
            Person person_getById = personDAO.getById(10);
            System.out.println(person_getById);

            System.out.println("\npersonDAO.update()");
            personTest.setFirstName("FIRSTNAME_UPDATE");
            personTest.setLastName("LASTNAME_UPDATE");
            personDAO.update(personTest);
            personList = personDAO.getAll();
            for (Person item : personList) {
                System.out.println(item);
            }

            System.out.println("\npersonDAO.remove()");
            personDAO.remove(personTest);
            personList = personDAO.getAll();
            for (Person item : personList) {
                System.out.println(item);
            }

            // TeacherDAO
            Position position_1 = positionDAO.getById(1);
            Teacher teacherTest = new Teacher(333, "FIRSTNAME_TEST333", "LASTNAME_TEST333", 30, 9, 1988, 21, 9, 2011,
                    position_1, 3333);
            TeacherDAO teacherDAO = (TeacherDAO) factory.create(TypeOfEntity.TEACHER);

            System.out.println("\n--- TeacherDAO ---");
            System.out.println("\nteacherDAO.add()");
            teacherDAO.add(teacherTest);

            System.out.println("\nteacherDAO.getAll()");
            List<Teacher> teacherList = new ArrayList<Teacher>();
            teacherList = teacherDAO.getAll();
            for (Teacher item : teacherList) {
                System.out.println(item);
            }

            System.out.println("\nteacherDAO.getById()");
            Teacher teacher_getById = teacherDAO.getById(333);
            System.out.println(teacher_getById);

            System.out.println("\nteacherDAO.update()");
            teacherTest.setSalary(1000000);
            Position position_3 = new Position(20, "TEST_POSITION_§");
            positionDAO.add(position_3);
            teacherTest.setPosition(position_3);
            teacherDAO.update(teacherTest);
            teacherList = teacherDAO.getAll();
            for (Teacher item : teacherList) {
                System.out.println(item);
            }

            System.out.println("\nteacherDAO.remove()");
            teacherDAO.remove(teacherTest);
            teacherList = teacherDAO.getAll();
            for (Teacher item : teacherList) {
                System.out.println(item);
            }

            // StudentDAO
            Student studentTest = new Student(100, "STUDENT_TEST", "STUDENT_TEST", 30, 9, 1988, 21, 9, 2011);
            studentTest.setMatriculationnumber(100000);
            Group group2 = new Group(30, "GR_TEST_2", faculty_1);
            groupDAO.add(group2);
            studentTest.setGroup(group2);
            StudentDAO studentDAO = (StudentDAO) factory.create(TypeOfEntity.STUDENT);

            System.out.println("\n--- StudentDAO ---");
            System.out.println("\nstudentDAO.add()");
            studentDAO.add(studentTest);

            System.out.println("\nstudentDAO.getAll()");
            List<Student> studentList = new ArrayList<Student>();
            studentList = studentDAO.getAll();
            for (Student item : studentList) {
                System.out.println(item);
            }

            System.out.println("\nstudentDAO.getById()");
            Student student_getById = studentDAO.getById(100);
            System.out.println(student_getById);

            System.out.println("\nstudentDAO.update()");
            studentTest.setMatriculationnumber(999999);
            studentTest.setGroup(group2);
            studentDAO.update(studentTest);
            studentList = studentDAO.getAll();
            for (Student item : studentList) {
                System.out.println(item);
            }

            System.out.println("\nstudentDAO.remove()");
            studentDAO.remove(studentTest);
            studentList = studentDAO.getAll();
            for (Student item : studentList) {
                System.out.println(item);
            }

            // ClassroomDAO
            Campus campus2 = new Campus(20, "CAMPUS_TEST_2");
            campusDAO.add(campus2);
            ClassroomDAO classroomDAO = (ClassroomDAO) factory.create(TypeOfEntity.CLASSROOM);

            Classroom classroomTest = new Classroom();
            classroomTest.setCampus(campus2);
            classroomTest.setRoomNumber("room_test");
            classroomTest.setCapacity(70);

            System.out.println("\n--- ClassroomService ---");
            System.out.println("\nclassroomService.add()");
            classroomDAO.add(classroomTest);

            System.out.println("\nclassroomDAO.getAll()");
            List<Classroom> classroomList = new ArrayList<Classroom>();
            classroomList = classroomDAO.getAll();
            for (Classroom item : classroomList) {
                System.out.println(item);
            }

            System.out.println("\nclassroomDAO.getById()");
            Classroom classroom_getById = classroomDAO.getById(20, "room_test");
            System.out.println(classroom_getById);

            System.out.println("\nclassroomDAO.update()");
            classroomTest.setCapacity(350);
            classroomDAO.update(classroomTest);
            classroomList = classroomDAO.getAll();
            for (Classroom item : classroomList) {
                System.out.println(item);
            }

            System.out.println("\nclassroomDAO.remove()");
            classroomDAO.remove(classroomTest);
            classroomList = classroomDAO.getAll();
            for (Classroom item : classroomList) {
                System.out.println(item);
            }

            // ScheduleDAO
            ScheduleDAO scheduleDAO = (ScheduleDAO) factory.create(TypeOfEntity.SCHEDULE);
            Schedule scheduleTest = new Schedule();
            scheduleTest.setSchedule_id(10);
            scheduleTest.setDescription("TEST_DESCRIPTION");

            System.out.println("\n--- ScheduleDAO ---");
            System.out.println("\nscheduleDAO.add()");
            scheduleDAO.add(scheduleTest);

            System.out.println("\nscheduleDAO.getAll()");
            List<Schedule> scheduleList = new ArrayList<Schedule>();
            scheduleList = scheduleDAO.getAll();
            for (Schedule item : scheduleList) {
                System.out.println(item);
            }

            System.out.println("\nscheduleDAO.getById()");
            Schedule schedule_getById = scheduleDAO.getById(10);
            System.out.println(schedule_getById);

            System.out.println("\nscheduleDAO.update()");
            scheduleTest.setDescription("UPDATE_DESCRIPTION");
            scheduleDAO.update(scheduleTest);
            scheduleList = scheduleDAO.getAll();
            for (Schedule item : scheduleList) {
                System.out.println(item);
            }

            System.out.println("\nscheduleDAO.remove()");
            scheduleDAO.remove(scheduleTest);
            scheduleList = scheduleDAO.getAll();
            for (Schedule item : scheduleList) {
                System.out.println(item);
            }

            // MonthlyScheduleDAO
            MonthlySchedule monthlyScheduleTest = new MonthlySchedule();
            monthlyScheduleTest.setMonthlySchedule_id(10);
            monthlyScheduleTest.setSchedule_id(2);
            monthlyScheduleTest.setDescription("TEST_DESCRIPTION");
            MonthlyScheduleDAO monthlyScheduleDAO = (MonthlyScheduleDAO) factory.create(TypeOfEntity.MONTHLYSHCEDULE);

            System.out.println("\n--- MonthlyScheduleDAO ---");
            System.out.println("\nmonthlyScheduleDAO.add()");
            monthlyScheduleDAO.add(monthlyScheduleTest);

            System.out.println("\nmonthlyScheduleDAO.getAll()");
            List<MonthlySchedule> monthlyScheduleList = new ArrayList<MonthlySchedule>();
            monthlyScheduleList = monthlyScheduleDAO.getAll();
            for (MonthlySchedule item : monthlyScheduleList) {
                System.out.println(item);
            }

            System.out.println("\nmonthlyScheduleDAO.getById()");
            MonthlySchedule monthlySchedule_getById = monthlyScheduleDAO.getById(10, 2);
            System.out.println(monthlySchedule_getById);

            System.out.println("\nmonthlyScheduleDAO.update()");
            monthlyScheduleTest.setDescription("UPDATE_DESCRIPTION");
            monthlyScheduleDAO.update(monthlyScheduleTest);
            monthlyScheduleList = monthlyScheduleDAO.getAll();
            for (MonthlySchedule item : monthlyScheduleList) {
                System.out.println(item);
            }

            System.out.println("\nmonthlyScheduleDAO.remove()");
            monthlyScheduleDAO.remove(monthlyScheduleTest);
            monthlyScheduleList = monthlyScheduleDAO.getAll();
            for (MonthlySchedule item : monthlyScheduleList) {
                System.out.println(item);
            }

            // DailyScheduleDAO
            DailySchedule dailyScheduleTest = new DailySchedule();
            dailyScheduleTest.setDailySchedule_id(10);
            dailyScheduleTest.setMonthlySchedule_id(2);
            dailyScheduleTest.setSchedule_id(1);
            dailyScheduleTest.setDescription("TEST_DESCRIPTION");
            DailyScheduleDAO dailyScheduleDAO = (DailyScheduleDAO) factory.create(TypeOfEntity.DAILYSCHEDULE);

            System.out.println("\n--- DailyScheduleService ---");
            System.out.println("\ndailyScheduleDAO.add()");
            dailyScheduleDAO.add(dailyScheduleTest);

            System.out.println("\ndailyScheduleDAO.getAll()");
            List<DailySchedule> dailyScheduleList = new ArrayList<DailySchedule>();
            dailyScheduleList = dailyScheduleDAO.getAll();
            for (DailySchedule item : dailyScheduleList) {
                System.out.println(item);
            }

            System.out.println("\ndailyScheduleDAO.getById()");
            DailySchedule dailySchedule_getById = dailyScheduleDAO.getById(10, 2, 1);
            System.out.println(dailySchedule_getById);

            System.out.println("\ndailyScheduleDAO.update()");
            dailyScheduleTest.setDescription("UPDATE_DESCRIPTION");
            dailyScheduleDAO.update(dailyScheduleTest);
            dailyScheduleList = dailyScheduleDAO.getAll();
            for (DailySchedule item : dailyScheduleList) {
                System.out.println(item);
            }

            System.out.println("\ndailyScheduleDAO.remove()");
            dailyScheduleDAO.remove(dailyScheduleTest);
            dailyScheduleList = dailyScheduleDAO.getAll();
            for (DailySchedule item : dailyScheduleList) {
                System.out.println(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

//      Campus campusTest = new Campus(1, "CAMPUS_TEST");
//      Classroom classroomTest = new Classroom(campusTest, "room_101", 40);
//      Lesson lessonTest = new Lesson(10, classroomTest, subject2, 16, 0, 12, 12, 2019, 17, 30, 12, 12, 2019);
//
//      lessonTest.setLesson_id(10);
//
//      Schedule scheduleTest = new Schedule();
//      scheduleTest.setSchedule_id(1);
//      scheduleTest.setDescription("###TEST_DESCRIPTION###");
//
//      MonthlySchedule monthlyScheduleTest = new MonthlySchedule();
//      monthlyScheduleTest.setMonthlySchedule_id(1);
//      monthlyScheduleTest.setSchedule_id(1);
//      monthlyScheduleTest.setDescription("###TEST_DESCRIPTION###");
//
//      DailySchedule dailyScheduleTest = new DailySchedule();
//      dailyScheduleTest.setDailySchedule_id(1);
//      dailyScheduleTest.setMonthlySchedule_id(1);
//      dailyScheduleTest.setSchedule_id(1);
//
//      lessonTest.setSchedule(scheduleTest);
//      lessonTest.setMonthlySchedule(monthlyScheduleTest);
//      lessonTest.setDailySchedule(dailyScheduleTest);
//
//      LessonService lessonService = new LessonService();
//      try {
//          System.out.println("\n--- LessonService ---");
//          System.out.println("\nlessonService.add()");
//          lessonService.add(lessonTest);
//
//          System.out.println("\nlessonService.getAll()");
//          List<Lesson> lessonList = new ArrayList<Lesson>();
//          lessonList = lessonService.getAll();
//          for (Lesson item : lessonList) {
//              System.out.println(item.displayClass());
//          }
//
//          System.out.println("\nlessonService.getById()");
//          Lesson lesson_getById = lessonService.getById(10);
//          System.out.println(lesson_getById.displayClass());
//
//          System.out.println("\nlessonService.update()");
//          Campus updateCampus = new Campus();
//          updateCampus.setCampus_id(20);
//          updateCampus.setCampus("UPDATE_CAMPUS");
//          CampusService campusService = new CampusService();
//          campusService.add(updateCampus);
//
//          updateCampus.setCampus("UPDATE_CAMPUS");
//          Classroom updateClassroom = new Classroom();
//          updateClassroom.setCampus(updateCampus);
//          updateClassroom.setRoomNumber("room_555");
//          updateClassroom.setCapacity(200);
//          ClassroomService classroomService = new ClassroomService();
//          classroomService.add(updateClassroom);
//          lessonTest.setClassroom(updateClassroom);
//
//          lessonService.update(lessonTest);
//          lessonList = lessonService.getAll();
//          for (Lesson item : lessonList) {
//              System.out.println(item.displayClass());
//          }
//
//          System.out.println("\nlessonService.remove()");
//          lessonService.remove(lessonTest);
//          lessonList = lessonService.getAll();
//          for (Lesson item : lessonList) {
//              System.out.println(item.displayClass());
//          }
//      } catch (SQLException e) {
//          e.printStackTrace();
//      }

//        try {
//            TeacherHasSubjectService teacherHasSubjectService = new TeacherHasSubjectService();
//            Position position = new Position();
//            position.setPosition_id(1);
//            position.setPosition("PROFESSOR");
//            Teacher teacherHasSubject = new Teacher(10, "FIRSTNAME_teacherHasSubject", "LASTNAME_teacherHasSubject", 25,
//                    8, 1982, 15, 8, 2013, position, 1100);
//          TeacherService teacherService = new TeacherService();
//          teacherService.add(teacherHasSubject);
//
//          Subject subjectHasTeacher = new Subject(10, "MATHEMATICS");
//          SubjectService subjectService = new SubjectService();
//          subjectService.add(subjectHasTeacher);
//
//          System.out.println("\n--- TeacherHasSubjectService ---");
//          System.out.println("\nteacherHasSubjectService.add()");
//          teacherHasSubjectService.add(teacherHasSubject, subjectHasTeacher);
//      } catch (SQLException e) {
//          e.printStackTrace();
//      }

//        Position position_1 = new Position();
//        Position position_2 = new Position();
//        Position position_3 = new Position();
//        position_1.setPosition_id(1);
//        position_1.setPosition("PROFESSOR");
//        position_2.setPosition_id(2);
//        position_2.setPosition("ASSOCIATE_PROFESSOR");
//        position_3.setPosition_id(3);
//        position_3.setPosition("PROFESSOR");
//        Teacher teacher1 = new Teacher(1, "Joe", "Black", 25, 10, 1965, 12, 11, 2001, position_1, 5000);
//        Teacher teacher2 = new Teacher(2, "Martin", "Seal", 2, 5, 1976, 9, 3, 2011, position_3, 2500);
//        Teacher teacher3 = new Teacher(2, "firstName_3", "lastName_3", 12, 10, 1958, 1, 8, 1987, position_1, 6000);
//        System.out.println(teacher1.toString());
//        System.out.println(teacher2.toString());
//        System.out.println(teacher3.toString());
//
//        Student student1 = new Student(1, "Eric", "Moore", 7, 2, 1999, 1, 9, 2016);
//        Student student2 = new Student(2, "Whilliam", "Hill", 19, 6, 1999, 1, 9, 2016);
//        Student student3 = new Student(3, "firstName_3", "lastName_3", 3, 2, 1999, 1, 9, 2016);
//        Student student4 = new Student(4, "firstName_4", "lastName_4", 10, 3, 1999, 1, 9, 2016);
//        Student student5 = new Student(5, "firstName_5", "lastName_5", 29, 7, 1999, 1, 9, 2016);
//        Student student6 = new Student(6, "firstName_6", "lastName_6", 11, 3, 1999, 1, 9, 2016);
//        Student student7 = new Student(7, "firstName_7", "lastName_7", 4, 2, 1999, 1, 9, 2016);
//        System.out.println();
//        System.out.println(student1.toString());
//        System.out.println(student2.toString());
//        System.out.println(student3.toString());
//        System.out.println(student4.toString());
//        System.out.println(student5.toString());
//        System.out.println(student6.toString());
//        System.out.println(student7.toString());
//        System.out.println();
//
//        Faculties faculty_1 = new Faculties();
//        Faculties faculty_2 = new Faculties();
//        faculty_1.setFaculty_id(1);
//        faculty_1.setFaculty("FACULTY_OF_MATHEMATICS");
//        faculty_2.setFaculty_id(2);
//        faculty_2.setFaculty("FACULTY_OF_COMPUTER_SCIENCE");
//
//        Group group1 = new Group();
//        group1.setGroupNumber("mt-1");
//        group1.setFaculty(faculty_1);
//        group1.addStudent(student1);
//        group1.addStudent(student2);
//        group1.addStudent(student3);
//        group1.addStudent(student4);
//        System.out.println();
//        group1.displayGroup();
//
//        Group group2 = new Group();
//        group2.setGroupNumber("cs-1");
//        group2.setFaculty(faculty_2);
//        group2.addStudent(student5);
//        group2.addStudent(student6);
//        group2.addStudent(student7);
//        System.out.println();
//        group2.displayGroup();
//
//        Subject subject1 = new Subject(1, "MATHEMATICS");
//        Subject subject2 = new Subject(2, "PHYSICS");
//        Subject subject3 = new Subject(3, "STATISTICS");
//        System.out.println();
//        System.out.println(subject1.toString());
//        System.out.println(subject2.toString());
//        System.out.println(subject3.toString());
//
//        Campus campus_1 = new Campus();
//        Campus campus_2 = new Campus();
//        Campus campus_3 = new Campus();
//        campus_1.setCampus("CAMPUS_A");
//        campus_2.setCampus("CAMPUS_B");
//        campus_3.setCampus("CAMPUS_C");
//
//        Classroom room1 = new Classroom(campus_1, "101", 30);
//        Classroom room2 = new Classroom(campus_1, "202", 40);
//        Classroom room3 = new Classroom(campus_1, "303", 60);
//        System.out.println();
//        System.out.println(room1.toString());
//        System.out.println(room2.toString());
//        System.out.println(room3.toString());
//
//        System.out.println("\nAdd group to student");
//        student1.setGroup(group1);
//        student2.setGroup(group1);
//        student3.setGroup(group2);
//        student4.setGroup(group2);
//        System.out.println(student1.toString());
//        System.out.println(student2.toString());
//        System.out.println(student3.toString());
//        System.out.println(student4.toString());
//
//        Lesson mathClass_seminar = new Lesson(1, room1, subject1, 8, 0, 1, 9, 2019, 9, 30, 1, 9, 2019);
//        Lesson mathClass_lecture = new Lesson(2, room3, subject1, 10, 0, 2, 9, 2019, 11, 30, 2, 9, 2019);
//        Lesson physicClass_seminar = new Lesson(3, room2, subject2, 10, 0, 1, 9, 2019, 11, 30, 1, 9, 2019);
//        Lesson physicClass_lecture = new Lesson(4, room3, subject2, 13, 0, 2, 9, 2019, 14, 30, 2, 9, 2019);
//        Lesson statisticClass_seminar = new Lesson(5, room1, subject3, 10, 0, 4, 9, 2019, 11, 30, 4, 9, 2019);
//        Lesson statisticClass_lecture = new Lesson(6, room3, subject3, 12, 0, 4, 9, 2019, 13, 30, 4, 9, 2019);
//        Lesson statisticClass_lecture_II = new Lesson(7, room3, subject3, 7, 0, 1, 9, 2019, 8, 30, 1, 9, 2019);
//        System.out.println();
//        mathClass_seminar.displayClass();
//        mathClass_lecture.displayClass();
//        physicClass_seminar.displayClass();
//        physicClass_lecture.displayClass();
//        statisticClass_seminar.displayClass();
//        statisticClass_lecture.displayClass();
//        statisticClass_lecture_II.displayClass();
//
//        Schedule schedule = new Schedule();
//        schedule.addClass(statisticClass_lecture);
//        schedule.addClass(physicClass_seminar);
//        schedule.addClass(mathClass_seminar);
//        schedule.addClass(mathClass_lecture);
//        schedule.addClass(physicClass_lecture);
//        schedule.addClass(statisticClass_seminar);
//        schedule.addClass(statisticClass_lecture_II);
//        System.out.println("\n---------- Display Month ----------");
//        schedule.displayMonth(9);
//        System.out.println("\n---------- Display Day ----------");
//        schedule.displayDay(9, 1);
//
//        schedule.removeClass(statisticClass_seminar);
//        schedule.removeClass(statisticClass_lecture);
//        System.out.println("\n---------- Display Month ----------");
//        schedule.displayMonth(9);
//
//        System.out.println("\nAdd classes to student's schedule");
//        student1.addClassToSchedule(mathClass_seminar);
//        student1.addClassToSchedule(mathClass_lecture);
//        student1.addClassToSchedule(statisticClass_seminar);
//        student1.addClassToSchedule(statisticClass_lecture);
//        System.out.println("\n---------- Display Month ----------");
//        student1.displayMonthSchedule(9);
//        System.out.println("\nRemove classes from student's schedule");
//        student1.removeClassFromSchedule(mathClass_lecture);
//        student1.removeClassFromSchedule(statisticClass_lecture);
//        System.out.println("\n---------- Display Month ----------");
//        student1.displayMonthSchedule(9);
//        System.out.println("\n---------- Display Day ----------");
//        student1.displayDaySchedule(9, 1);
    }
}
