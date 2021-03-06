package ua.com.foxminded.university.dao;

import ua.com.foxminded.university.TypeOfEntity;

public class FactoryDAO {
    public Dao<?> create(TypeOfEntity entity) {
        switch (entity) {
        case CAMPUS:
            return new CampusDAO();
        case CLASSROOM:
            return new ClassroomDAO();
        case FACULTIES:
            return new FacultiesDAO();
        case GROUP:
            return new GroupDAO();
        case LESSON:
            return new LessonDAO();
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
        case DAILYSCHEDULE:
            return new DailyScheduleDAO();
        case MONTHLYSHCEDULE:
            return new MonthlyScheduleDAO();
        default:
            return null;
        }
    }
}