package ua.com.foxminded.university.dao;

import ua.com.foxminded.university.TypeOfEntity;
import ua.com.foxminded.university.dao.service.CampusService;
import ua.com.foxminded.university.dao.service.ClassroomService;
import ua.com.foxminded.university.dao.service.DailyScheduleService;
import ua.com.foxminded.university.dao.service.FacultiesService;
import ua.com.foxminded.university.dao.service.GroupService;
import ua.com.foxminded.university.dao.service.LessonService;
import ua.com.foxminded.university.dao.service.MonthlyScheduleService;
import ua.com.foxminded.university.dao.service.PersonService;
import ua.com.foxminded.university.dao.service.PositionService;
import ua.com.foxminded.university.dao.service.ScheduleService;
import ua.com.foxminded.university.dao.service.StudentService;
import ua.com.foxminded.university.dao.service.SubjectService;
import ua.com.foxminded.university.dao.service.TeacherService;

public class FactoryDAO {
    public DAO createService(TypeOfEntity entity) {
        switch (entity) {
        case CAMPUS:
            return new CampusService();
        case CLASSROOM:
            return new ClassroomService();
        case FACULTIES:
            return new FacultiesService();
        case GROUP:
            return new GroupService();
        case LESSON:
            return new LessonService();
        case PERSON:
            return new PersonService();
        case POSITION:
            return new PositionService();
        case STUDENT:
            return new StudentService();
        case SUBJECT:
            return new SubjectService();
        case TEACHER:
            return new TeacherService();
        case SCHEDULE:
            return new ScheduleService();
        case DAILYSCHEDULE:
            return new DailyScheduleService();
        case MONTHLYSHCEDULE:
            return new MonthlyScheduleService();
        default:
            return null;
        }
    }
}