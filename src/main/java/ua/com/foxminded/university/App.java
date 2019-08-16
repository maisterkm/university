package ua.com.foxminded.university;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.dao.CampusDAO;
import ua.com.foxminded.university.dao.ClassroomDAO;
import ua.com.foxminded.university.dao.DailyScheduleDAO;
import ua.com.foxminded.university.dao.FactoryDAO;
import ua.com.foxminded.university.dao.FacultiesDAO;
import ua.com.foxminded.university.dao.GroupDAO;
import ua.com.foxminded.university.dao.LessonDAO;
import ua.com.foxminded.university.dao.MonthlyScheduleDAO;
import ua.com.foxminded.university.dao.PersonDAO;
import ua.com.foxminded.university.dao.PositionDAO;
import ua.com.foxminded.university.dao.ScheduleDAO;
import ua.com.foxminded.university.dao.StudentDAO;
import ua.com.foxminded.university.dao.SubjectDAO;
import ua.com.foxminded.university.dao.TeacherDAO;
import ua.com.foxminded.university.domain.DailySchedule;
import ua.com.foxminded.university.domain.MonthlySchedule;
import ua.com.foxminded.university.domain.Schedule;
import ua.com.foxminded.university.domain.entity.Campus;
import ua.com.foxminded.university.domain.entity.Classroom;
import ua.com.foxminded.university.domain.entity.Faculties;
import ua.com.foxminded.university.domain.entity.Group;
import ua.com.foxminded.university.domain.entity.Lesson;
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
            Campus campusTest = new Campus(77, "CAMPUS_77");
            CampusDAO campusDAO = (CampusDAO) factory.create(TypeOfEntity.CAMPUS);

            System.out.println("\n--- campusDAO ---");
            System.out.println("\ncampusDAO.add()");
            campusDAO.create(campusTest);

            System.out.println("\ncampusDAO.getById()");
            Campus fauculty_getById = campusDAO.readById(77);
            System.out.println(fauculty_getById);

            System.out.println("\ncampusDAO.getAll()");
            List<Campus> campusList = new ArrayList<Campus>();
            campusList = campusDAO.read();
            for (Campus item : campusList) {
                System.out.println(item);
            }

            System.out.println("\ncampusDAO.update()");
            campusTest.setCampus("CAMPUS_UPDATE");
            campusDAO.update(campusTest);
            campusList = campusDAO.read();
            for (Campus item : campusList) {
                System.out.println(item);
            }

            System.out.println("\ncampusDAO.remove()");
            campusDAO.delete(campusTest);
            campusList = campusDAO.read();
            for (Campus item : campusList) {
                System.out.println(item);
            }

            // PositionDAO
            Position positionTest = new Position(10, "TEST_POSITION");
            PositionDAO positionDAO = (PositionDAO) factory.create(TypeOfEntity.POSITION);

            System.out.println("\n--- PositionDAO ---");
            System.out.println("\npositionDAO.add()");
            positionDAO.create(positionTest);

            System.out.println("\npositionDAO.getById()");
            Position position_getById = positionDAO.readById(10);
            System.out.println(position_getById);

            System.out.println("\npositionDAO.getAll()");
            List<Position> positionList = new ArrayList<Position>();
            positionList = positionDAO.read();
            for (Position item : positionList) {
                System.out.println(item);
            }

            System.out.println("\npositionDAO.update()");
            positionTest.setPosition("POSITION_UPDATE");
            positionDAO.update(positionTest);
            positionList = positionDAO.read();
            for (Position item : positionList) {
                System.out.println(item);
            }

            System.out.println("\npositionDAO.remove()");
            positionDAO.delete(positionTest);
            positionList = positionDAO.read();
            for (Position item : positionList) {
                System.out.println(item);
            }

            // FacultyDAO
            Faculties facultyTest = new Faculties(10, "NEW_FACULTY");
            FacultiesDAO facultiesDAO = (FacultiesDAO) factory.create(TypeOfEntity.FACULTIES);

            System.out.println("\n--- FacultiesDAO ---");
            System.out.println("\nfacultiesDAO.add()");
            facultiesDAO.create(facultyTest);

            System.out.println("\nfacultiesDAO.getById()");
            Faculties fauculties_getById = facultiesDAO.readById(10);
            System.out.println(fauculties_getById);

            System.out.println("\nFacultiesDAO.getAll()");
            List<Faculties> facultyList = new ArrayList<Faculties>();
            facultyList = facultiesDAO.read();
            for (Faculties item : facultyList) {
                System.out.println(item);
            }

            System.out.println("\nfacultyDAO.update()");
            facultyTest.setFaculty("FACULTY_UPDATE");
            facultiesDAO.update(facultyTest);
            facultyList = facultiesDAO.read();
            for (Faculties item : facultyList) {
                System.out.println(item);
            }

            System.out.println("\nfacultyDAO.remove()");
            facultiesDAO.delete(facultyTest);
            facultyList = facultiesDAO.read();
            for (Faculties item : facultyList) {
                System.out.println(item);
            }

            // GroupDAO
            Faculties faculty_1 = new Faculties(20, "FACULTY_TEST_1");
            facultiesDAO.create(faculty_1);
            Faculties faculty_2 = new Faculties(30, "UPDATE_FACULTY_OF_COMPUTER_SCIENCE");
            facultiesDAO.create(faculty_2);
            Group groupTest = new Group(10, "GR_TEST_1", faculty_1);

            GroupDAO groupDAO = (GroupDAO) factory.create(TypeOfEntity.GROUP);

            System.out.println("\n--- GroupDAO ---");
            System.out.println("\ngroupDAO.add()");
            groupDAO.create(groupTest);

            System.out.println("\ngroupDAO.getById()");
            Group group_getById = groupDAO.readById(10);
            System.out.println(group_getById.toString());

            System.out.println("\ngroupDAO.getAll()");
            List<Group> groupList = new ArrayList<Group>();
            groupList = groupDAO.read();
            for (Group item : groupList) {
                System.out.println(item.toString());
            }

            System.out.println("\ngroupDAO.update()");
            groupTest.setGroupNumber("GROUP_UPDATE");
            groupTest.setFaculty(faculty_2);
            groupDAO.update(groupTest);
            groupList = groupDAO.read();
            for (Group item : groupList) {
                System.out.println(item.toString());
            }

            System.out.println("\ngroupDAO.remove()");
            groupDAO.delete(groupTest);
            groupList = groupDAO.read();
            for (Group item : groupList) {
                System.out.println(item.toString());
            }

            // SubjectDAO
            Subject subjectTest = new Subject(10, "NEW_SUBJECT");
            SubjectDAO subjectDAO = (SubjectDAO) factory.create(TypeOfEntity.SUBJECT);

            System.out.println("\n--- SubjectDAO ---");
            System.out.println("\nsubjectService.add()");
            subjectDAO.create(subjectTest);

            System.out.println("\nsubjectDAO.getById()");
            Subject subject_getById = subjectDAO.readById(10);
            System.out.println(subject_getById.toString());

            System.out.println("\nSubjectDAO.getAll()");
            List<Subject> subjectList = new ArrayList<Subject>();
            subjectList = subjectDAO.read();
            for (Subject item : subjectList) {
                System.out.println(item.toString());
            }

            System.out.println("\nsubjectService.update()");
            subjectTest.setSubject("SUBJECT_UPDATE");
            subjectDAO.update(subjectTest);
            subjectList = subjectDAO.read();
            for (Subject item : subjectList) {
                System.out.println(item.toString());
            }

            System.out.println("\nsubjectDAO.remove()");
            subjectDAO.delete(subjectTest);
            subjectList = subjectDAO.read();
            for (Subject item : subjectList) {
                System.out.println(item.toString());
            }

            // PersonDAO
            Person personTest = new Person(10, "FirstName_Test", "LastName_Test", 28, 02, 1955, 01, 01, 2019);
            PersonDAO personDAO = (PersonDAO) factory.create(TypeOfEntity.PERSON);

            System.out.println("\n--- PersonDAO ---");
            System.out.println("\npersonDAO.add()");
            personDAO.create(personTest);

            System.out.println("\npersonDAO.getAll()");
            List<Person> personList = new ArrayList<Person>();
            personList = personDAO.read();
            for (Person item : personList) {
                System.out.println(item);
            }

            System.out.println("\npersonDAO.getById()");
            Person person_getById = personDAO.readById(10);
            System.out.println(person_getById);

            System.out.println("\npersonDAO.update()");
            personTest.setFirstName("FIRSTNAME_UPDATE");
            personTest.setLastName("LASTNAME_UPDATE");
            personDAO.update(personTest);
            personList = personDAO.read();
            for (Person item : personList) {
                System.out.println(item);
            }

            System.out.println("\npersonDAO.remove()");
            personDAO.delete(personTest);
            personList = personDAO.read();
            for (Person item : personList) {
                System.out.println(item);
            }

            // TeacherDAO
            Position position_1 = positionDAO.readById(1);
            Teacher teacherTest = new Teacher(333, "FIRSTNAME_TEST333", "LASTNAME_TEST333", 30, 9, 1988, 21, 9, 2011,
                    position_1, 3333);
            TeacherDAO teacherDAO = (TeacherDAO) factory.create(TypeOfEntity.TEACHER);

            System.out.println("\n--- TeacherDAO ---");
            System.out.println("\nteacherDAO.add()");
            teacherDAO.create(teacherTest);

            System.out.println("\nteacherDAO.getAll()");
            List<Teacher> teacherList = new ArrayList<Teacher>();
            teacherList = teacherDAO.read();
            for (Teacher item : teacherList) {
                System.out.println(item);
            }

            System.out.println("\nteacherDAO.getById()");
            Teacher teacher_getById = teacherDAO.readById(333);
            System.out.println(teacher_getById);

            System.out.println("\nteacherDAO.update()");
            teacherTest.setSalary(1000000);
            Position position_3 = new Position(20, "TEST_POSITION_§");
            positionDAO.create(position_3);
            teacherTest.setPosition(position_3);
            teacherDAO.update(teacherTest);
            teacherList = teacherDAO.read();
            for (Teacher item : teacherList) {
                System.out.println(item);
            }

            System.out.println("\nteacherDAO.remove()");
            teacherDAO.delete(teacherTest);
            teacherList = teacherDAO.read();
            for (Teacher item : teacherList) {
                System.out.println(item);
            }

            // StudentDAO
            Student studentTest = new Student(100, "STUDENT_TEST", "STUDENT_TEST", 30, 9, 1988, 21, 9, 2011);
            studentTest.setMatriculationnumber(100000);
            Group group2 = new Group(30, "GR_TEST_2", faculty_1);
            groupDAO.create(group2);
            studentTest.setGroup(group2);
            StudentDAO studentDAO = (StudentDAO) factory.create(TypeOfEntity.STUDENT);

            System.out.println("\n--- StudentDAO ---");
            System.out.println("\nstudentDAO.add()");
            studentDAO.create(studentTest);

            System.out.println("\nstudentDAO.getAll()");
            List<Student> studentList = new ArrayList<Student>();
            studentList = studentDAO.read();
            for (Student item : studentList) {
                System.out.println(item);
            }

            System.out.println("\nstudentDAO.getById()");
            Student student_getById = studentDAO.readById(100);
            System.out.println(student_getById);

            System.out.println("\nstudentDAO.update()");
            studentTest.setMatriculationnumber(999999);
            studentTest.setGroup(group2);
            studentDAO.update(studentTest);
            studentList = studentDAO.read();
            for (Student item : studentList) {
                System.out.println(item);
            }

            System.out.println("\nstudentDAO.remove()");
            studentDAO.delete(studentTest);
            studentList = studentDAO.read();
            for (Student item : studentList) {
                System.out.println(item);
            }

            // ClassroomDAO
            Campus campus2 = new Campus(20, "CAMPUS_TEST_2");
            campusDAO.create(campus2);
            ClassroomDAO classroomDAO = (ClassroomDAO) factory.create(TypeOfEntity.CLASSROOM);

            Classroom classroomTest = new Classroom();
            classroomTest.setCampus(campus2);
            classroomTest.setRoomNumber("room_test");
            classroomTest.setCapacity(70);

            System.out.println("\n--- ClassroomService ---");
            System.out.println("\nclassroomService.add()");
            classroomDAO.create(classroomTest);

            System.out.println("\nclassroomDAO.getAll()");
            List<Classroom> classroomList = new ArrayList<Classroom>();
            classroomList = classroomDAO.read();
            for (Classroom item : classroomList) {
                System.out.println(item);
            }

            System.out.println("\nclassroomDAO.getById()");
            Classroom classroom_getById = classroomDAO.getById(20, "room_test");
            System.out.println(classroom_getById);

            System.out.println("\nclassroomDAO.update()");
            classroomTest.setCapacity(350);
            classroomDAO.update(classroomTest);
            classroomList = classroomDAO.read();
            for (Classroom item : classroomList) {
                System.out.println(item);
            }

            System.out.println("\nclassroomDAO.remove()");
            classroomDAO.delete(classroomTest);
            classroomList = classroomDAO.read();
            for (Classroom item : classroomList) {
                System.out.println(item);
            }

            // ScheduleDAO
            ScheduleDAO scheduleDAO = (ScheduleDAO) factory.create(TypeOfEntity.SCHEDULE);
            Schedule scheduleTest = new Schedule();
            scheduleTest.setScheduleId(10);
            scheduleTest.setDescription("TEST_DESCRIPTION");

            System.out.println("\n--- ScheduleDAO ---");
            System.out.println("\nscheduleDAO.add()");
            scheduleDAO.create(scheduleTest);

            System.out.println("\nscheduleDAO.getAll()");
            List<Schedule> scheduleList = new ArrayList<Schedule>();
            scheduleList = scheduleDAO.read();
            for (Schedule item : scheduleList) {
                System.out.println(item);
            }

            System.out.println("\nscheduleDAO.getById()");
            Schedule schedule_getById = scheduleDAO.readById(10);
            System.out.println(schedule_getById);

            System.out.println("\nscheduleDAO.update()");
            scheduleTest.setDescription("UPDATE_DESCRIPTION");
            scheduleDAO.update(scheduleTest);
            scheduleList = scheduleDAO.read();
            for (Schedule item : scheduleList) {
                System.out.println(item);
            }

            System.out.println("\nscheduleDAO.remove()");
            scheduleDAO.delete(scheduleTest);
            scheduleList = scheduleDAO.read();
            for (Schedule item : scheduleList) {
                System.out.println(item);
            }

            // MonthlyScheduleDAO
            MonthlySchedule monthlyScheduleTest = new MonthlySchedule();
            monthlyScheduleTest.setMonthlyScheduleId(10);
            monthlyScheduleTest.setScheduleId(2);
            monthlyScheduleTest.setDescription("TEST_DESCRIPTION");
            MonthlyScheduleDAO monthlyScheduleDAO = (MonthlyScheduleDAO) factory.create(TypeOfEntity.MONTHLYSHCEDULE);

            System.out.println("\n--- MonthlyScheduleDAO ---");
            System.out.println("\nmonthlyScheduleDAO.add()");
            monthlyScheduleDAO.create(monthlyScheduleTest);

            System.out.println("\nmonthlyScheduleDAO.getAll()");
            List<MonthlySchedule> monthlyScheduleList = new ArrayList<MonthlySchedule>();
            monthlyScheduleList = monthlyScheduleDAO.read();
            for (MonthlySchedule item : monthlyScheduleList) {
                System.out.println(item);
            }

            System.out.println("\nmonthlyScheduleDAO.getById()");
            MonthlySchedule monthlySchedule_getById = monthlyScheduleDAO.getById(10, 2);
            System.out.println(monthlySchedule_getById);

            System.out.println("\nmonthlyScheduleDAO.update()");
            monthlyScheduleTest.setDescription("UPDATE_DESCRIPTION");
            monthlyScheduleDAO.update(monthlyScheduleTest);
            monthlyScheduleList = monthlyScheduleDAO.read();
            for (MonthlySchedule item : monthlyScheduleList) {
                System.out.println(item);
            }

            System.out.println("\nmonthlyScheduleDAO.remove()");
            monthlyScheduleDAO.delete(monthlyScheduleTest);
            monthlyScheduleList = monthlyScheduleDAO.read();
            for (MonthlySchedule item : monthlyScheduleList) {
                System.out.println(item);
            }

            // DailyScheduleDAO
            DailySchedule dailyScheduleTest = new DailySchedule();
            dailyScheduleTest.setDailyScheduleId(10);
            dailyScheduleTest.setMonthlyScheduleId(2);
            dailyScheduleTest.setScheduleId(1);
            dailyScheduleTest.setDescription("TEST_DESCRIPTION");
            DailyScheduleDAO dailyScheduleDAO = (DailyScheduleDAO) factory.create(TypeOfEntity.DAILYSCHEDULE);

            System.out.println("\n--- DailyScheduleService ---");
            System.out.println("\ndailyScheduleDAO.add()");
            dailyScheduleDAO.create(dailyScheduleTest);

            System.out.println("\ndailyScheduleDAO.getAll()");
            List<DailySchedule> dailyScheduleList = new ArrayList<DailySchedule>();
            dailyScheduleList = dailyScheduleDAO.read();
            for (DailySchedule item : dailyScheduleList) {
                System.out.println(item);
            }

            System.out.println("\ndailyScheduleDAO.getById()");
            DailySchedule dailySchedule_getById = dailyScheduleDAO.getById(10, 2, 1);
            System.out.println(dailySchedule_getById);

            System.out.println("\ndailyScheduleDAO.update()");
            dailyScheduleTest.setDescription("UPDATE_DESCRIPTION");
            dailyScheduleDAO.update(dailyScheduleTest);
            dailyScheduleList = dailyScheduleDAO.read();
            for (DailySchedule item : dailyScheduleList) {
                System.out.println(item);
            }

            System.out.println("\ndailyScheduleDAO.remove()");
            dailyScheduleDAO.delete(dailyScheduleTest);
            dailyScheduleList = dailyScheduleDAO.read();
            for (DailySchedule item : dailyScheduleList) {
                System.out.println(item);
            }

            // LessonDAO
            Campus campus30 = new Campus(30, "CAMPUS_TEST_2");
            campusDAO.create(campus30);

            Classroom classroom40 = new Classroom();
            classroom40.setCampus(campus30);
            classroom40.setRoomNumber("room_test_444");
            classroom40.setCapacity(170);
            classroomDAO.create(classroom40);
            Subject subject40 = new Subject(40, "NEW_SUBJECT_40");
            subjectDAO.create(subject40);

            Lesson lessonTest = new Lesson(10, classroom40, subject40, 17, 0, 12, 12, 2019, 18, 30, 12, 12, 2019);

            Schedule scheduleTest2 = new Schedule();
            scheduleTest2.setScheduleId(10);
            scheduleTest2.setDescription("###TEST_DESCRIPTION###");
            scheduleDAO.create(scheduleTest2);

            MonthlySchedule monthlyScheduleTest2 = new MonthlySchedule();
            monthlyScheduleTest2.setMonthlyScheduleId(10);
            monthlyScheduleTest2.setScheduleId(10);
            monthlyScheduleTest2.setDescription("###TEST_DESCRIPTION###");
            monthlyScheduleDAO.create(monthlyScheduleTest2);

            DailySchedule dailyScheduleTest2 = new DailySchedule();
            dailyScheduleTest2.setDailyScheduleId(10);
            dailyScheduleTest2.setMonthlyScheduleId(10);
            dailyScheduleTest2.setScheduleId(10);
            dailyScheduleDAO.create(dailyScheduleTest2);

            lessonTest.setSchedule(scheduleTest);
            lessonTest.setMonthlySchedule(monthlyScheduleTest);
            lessonTest.setDailySchedule(dailyScheduleTest);

            LessonDAO lessonDAO = (LessonDAO) factory.create(TypeOfEntity.LESSON);

            System.out.println("\n--- LessonDAO ---");
            System.out.println("\nlessonDAO.add()");
            lessonDAO.create(lessonTest);

            System.out.println("\nlessonDAO.getAll()");
            List<Lesson> lessonList = new ArrayList<Lesson>();
            lessonList = lessonDAO.read();
            for (Lesson item : lessonList) {
                System.out.println(item.displayClass());
            }

            System.out.println("\nlessonDAO.getById()");
            Lesson lesson_getById = lessonDAO.readById(10);
            System.out.println(lesson_getById.displayClass());

            System.out.println("\nlessonDAO.update()");
            Campus updateCampus = new Campus();
            updateCampus.setCampusId(20);
            updateCampus.setCampus("UPDATE_CAMPUS");
            campusDAO.create(updateCampus);

            updateCampus.setCampus("UPDATE_CAMPUS");
            Classroom updateClassroom = new Classroom();
            updateClassroom.setCampus(updateCampus);
            updateClassroom.setRoomNumber("room_555");
            updateClassroom.setCapacity(200);
            classroomDAO.create(updateClassroom);
            lessonTest.setClassroom(updateClassroom);

            lessonDAO.update(lessonTest);
            lessonList = lessonDAO.read();
            for (Lesson item : lessonList) {
                System.out.println(item.displayClass());
            }

            System.out.println("\nlessonDAO.remove()");
            lessonDAO.delete(lessonTest);
            lessonList = lessonDAO.read();
            for (Lesson item : lessonList) {
                System.out.println(item.displayClass());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
