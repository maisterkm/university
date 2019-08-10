package ua.com.foxminded.university.dao;

import ua.com.foxminded.university.TypeOfEntity;
import ua.com.foxminded.university.dao.service.CampusDAO;

public class FactoryDAO {
    public DAO<?> create(TypeOfEntity entity) {
        switch (entity) {
        case CAMPUS:
            return new CampusDAO();
//        case CLASSROOM:
//            return new ClassroomService();
//        case FACULTIES:
//            return new FacultiesService();
//        case GROUP:
//            return new GroupService();
//        case LESSON:
//            return new LessonService();
//        case PERSON:
//            return new PersonService();
//        case POSITION:
//            return new PositionService();
//        case STUDENT:
//            return new StudentService();
//        case SUBJECT:
//            return new SubjectService();
//        case TEACHER:
//            return new TeacherService();
//        case SCHEDULE:
//            return new ScheduleService();
//        case DAILYSCHEDULE:
//            return new DailyScheduleService();
//        case MONTHLYSHCEDULE:
//            return new MonthlyScheduleService();
        default:
            return null;
        }
    }
}