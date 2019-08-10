package ua.com.foxminded.university.dao;

import ua.com.foxminded.university.TypeOfEntity;
import ua.com.foxminded.university.dao.service.CampusDAO;
import ua.com.foxminded.university.dao.service.ClassroomDAO;
import ua.com.foxminded.university.dao.service.FacultiesDAO;
import ua.com.foxminded.university.dao.service.GroupDAO;
import ua.com.foxminded.university.dao.service.MonthlyScheduleDAO;
import ua.com.foxminded.university.dao.service.PersonDAO;
import ua.com.foxminded.university.dao.service.PositionDAO;
import ua.com.foxminded.university.dao.service.ScheduleDAO;
import ua.com.foxminded.university.dao.service.StudentDAO;
import ua.com.foxminded.university.dao.service.SubjectDAO;
import ua.com.foxminded.university.dao.service.TeacherDAO;

public class FactoryDAO {
    public DAO<?> create(TypeOfEntity entity) {
        switch (entity) {
        case CAMPUS:
            return new CampusDAO();
        case CLASSROOM:
            return new ClassroomDAO();
        case FACULTIES:
            return new FacultiesDAO();
        case GROUP:
            return new GroupDAO();
//        case LESSON:
//            return new LessonDAO();
        case PERSON:
            return new PersonDAO();
        case POSITION:
            return new PositionDAO();
        case STUDENT:
            return new StudentDAO();
        case SUBJECT:
            return new SubjectDAO();
        case TEACHER:
            return new TeacherDAO();
        case SCHEDULE:
            return new ScheduleDAO();
//        case DAILYSCHEDULE:
//            return new DailyScheduleService();
        case MONTHLYSHCEDULE:
            return new MonthlyScheduleDAO();
        default:
            return null;
        }
    }
}