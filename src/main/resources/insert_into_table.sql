-- 1
INSERT INTO FACULTIES (faculty)
VALUES
  ('FACULTY_OF_MATHEMATICS'),
  ('FACULTY_OF_PHYSICS'),
  ('FACULTY_OF_COMPUTER_SCIENCE');
  
-- 2
INSERT INTO GRUP (groupNumber, faculty_id)
VALUES
  ('MATH_1', 1),
  ('PH_1', 2),
  ('CS_1', 3);
  
-- 3
INSERT INTO POSITIONS (position)
VALUES
  ('PROFESSOR'),
  ('ASSOCIATE_PROFESSOR'),
  ('ASSISTANT_PROFESSOR'),
  ('LECTURER');
  
-- 4
INSERT INTO SUBJECTS (subject)
VALUES
  ('MATHEMATICS'),
  ('STATISTICS'),
  ('PHYSICS');
  
-- 5
INSERT INTO SCHEDULE (description)
VALUES
  ('###description###'),
  ('###description###');
  
-- 6
INSERT INTO MONTHLYSCHEDULE (schedule_id, description)
VALUES
  (1, '###description###'),
  (1, '###description###'),
  (2, '###description###');
  
-- 7
INSERT INTO DAILYSCHEDULE (monthlyschedule_id, schedule_id, description)
VALUES
  (1, 1, '###description###'),
  (2, 1, '###description###'),
  (2, 1,'###description###');
  
-- 8
INSERT INTO CAMPUS (campus)
VALUES
  ('CAMPUS_A'),
  ('CAMPUS_B'),
  ('CAMPUS_C');
  
-- 9
INSERT INTO CLASSROOM (campus_id, roomnumber, capacity)
VALUES
  (1 ,'room_101', 40),
  (2 ,'room_201', 150),
  (3 ,'room_301', 60);
  
-- 10
INSERT INTO LESSON (campus_id, roomnumber, beginTime, endTIme, subject_id, dailyschedule_id, monthlyschedule_id, schedule_id)
VALUES
  (1, 'room_101', '2019-01-09 08:00:00', '2019-01-09 09:30:00', 1, 1, 1, 1),
  (2, 'room_201', '2019-01-09 11:00:00', '2019-01-09 12:30:00', 2, 1, 1, 1),
  (3, 'room_301', '2019-02-09 14:00:00', '2019-02-09 15:30:00', 3, 2, 2, 1);
  
-- 11
INSERT INTO PERSON (firstName, lastName, dateOfBirth, enrollmentDate)
VALUES
  ('firstName_1', 'lastName_1', '1975-03-15', '2008-08-21'),
  ('firstName_2', 'lastName_2', '1968-01-27', '1999-09-10'),
  ('firstName_3', 'lastName_3', '2001-06-11', '2009-08-01'),
  ('firstName_4', 'lastName_4', '2001-02-23', '2009-08-01');
  
-- 12
INSERT INTO TEACHER (teacher_id, salary, position_id, teacherSchedule_id)
VALUES
  (1, 3200, 1, 1),
  (2, 3800, 2, 2);
  
-- 13
INSERT INTO STUDENT (student_id, matriculationNumber, group_id, studentSchedule_id)
VALUES
  (3, 11111, 1, 1),
  (4, 11112, 2, 1);
  
-- 14
INSERT INTO TEACHER_SUBJECT (teacher_id, subject_id)
VALUES
  (1, 1),
  (2, 3);
