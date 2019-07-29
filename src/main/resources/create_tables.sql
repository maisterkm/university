-- 1 
CREATE TABLE IF NOT EXISTS FACULTIES(
	faculty_id SERIAL PRIMARY KEY,
	faculty VARCHAR(255) NOT NULL
);

-- 2
CREATE TABLE IF NOT EXISTS GRUP (
	group_id SERIAL PRIMARY KEY,
	groupNumber VARCHAR(255) NOT NULL,
	faculty_id INTEGER NOT NULL,
	FOREIGN KEY (faculty_id) REFERENCES FACULTIES (faculty_id)
);

-- 3
CREATE TABLE IF NOT EXISTS POSITIONS(
	position_id SERIAL PRIMARY KEY,
	position VARCHAR(255) NOT NULL
);

-- 4
CREATE TABLE IF NOT EXISTS SUBJECTS (
	subject_id SERIAL PRIMARY KEY,
	subject VARCHAR(255) NOT NULL
);

-- 5
CREATE TABLE IF NOT EXISTS CAMPUS (
	campus_id SERIAL PRIMARY KEY,
	campus VARCHAR(255) NOT NULL
);

-- 6 Weak entity
CREATE TABLE IF NOT EXISTS CLASSROOM (
	campus_id INTEGER NOT NULL,
	roomnumber VARCHAR(255) NOT NULL,
	capacity INTEGER NOT NULL,
	PRIMARY KEY(roomnumber, campus_id),
	FOREIGN KEY (campus_id) REFERENCES CAMPUS (campus_id) ON DELETE CASCADE
);

-- 7
CREATE TABLE IF NOT EXISTS LESSON (
	lesson_id SERIAL NOT NULL,
	campus_id INTEGER NOT NULL,
	roomnumber VARCHAR(255) NOT NULL,
	beginTime TIMESTAMP,
	endTIme TIMESTAMP,
	subject_id INTEGER REFERENCES SUBJECTS (subject_id),
	PRIMARY KEY(lesson_id),
	CONSTRAINT fk_lesson 
		FOREIGN KEY (campus_id, roomnumber) 
		REFERENCES CLASSROOM (campus_id, roomnumber) 
		ON DELETE CASCADE
);

-- 8
CREATE TABLE IF NOT EXISTS DAILYSCHEDULE (
	dailyschedule_id SERIAL PRIMARY KEY,
	description VARCHAR(255),
	lesson_id INTEGER REFERENCES LESSON(lesson_id)
);

-- 9 Weak entity
CREATE TABLE IF NOT EXISTS MONTHLYSCHEDULE (
	monthlyschedule_id SERIAL NOT NULL,
	dailyschedule_id INTEGER REFERENCES DAILYSCHEDULE (dailyschedule_id) ON DELETE CASCADE,
	description VARCHAR(255),
	PRIMARY KEY (monthlyschedule_id, dailyschedule_id)
);

-- 10 Weak entity
CREATE TABLE IF NOT EXISTS SCHEDULE (
	schedule_id SERIAL NOT NULL,
	dailyschedule_id INTEGER NOT NULL,
	monthlyschedule_id INTEGER NOT NULL,
	description VARCHAR(255),
	PRIMARY KEY (schedule_id),
	CONSTRAINT fk_schedule
		FOREIGN KEY (dailyschedule_id, monthlyschedule_id) 
		REFERENCES MONTHLYSCHEDULE (dailyschedule_id, monthlyschedule_id) 
		ON DELETE CASCADE
);

-- 11
CREATE TABLE IF NOT EXISTS PERSON (
  person_id   SERIAL PRIMARY KEY,
  firstName        VARCHAR(255) UNIQUE NOT NULL,
  lastName        VARCHAR(255) UNIQUE NOT NULL,
  dateOfBirth TIMESTAMP,
  enrollmentDate TIMESTAMP
);

-- 12
CREATE TABLE IF NOT EXISTS TEACHER (
  teacher_id INTEGER NOT NULL,
  salary INTEGER,
  position_id INTEGER NOT NULL,
  teacherSchedule_id INTEGER NOT NULL,
  PRIMARY KEY (teacher_id),
  FOREIGN KEY (teacher_id) REFERENCES PERSON (person_id) ON DELETE CASCADE,
  FOREIGN KEY (position_id) REFERENCES POSITIONS (position_id),
  FOREIGN KEY (teacherSchedule_id) REFERENCES SCHEDULE (schedule_id)
);

-- 13
CREATE TABLE IF NOT EXISTS STUDENT (
  student_id INTEGER NOT NULL,
  matriculationNumber INTEGER,
  group_id INTEGER NOT NULL,
  studentSchedule_id INTEGER NOT NULL, 
  PRIMARY KEY (student_id),
  FOREIGN KEY (student_id) REFERENCES PERSON (person_id)  ON DELETE CASCADE,
  FOREIGN KEY (group_id) REFERENCES GRUP (group_id),
  FOREIGN KEY (studentSchedule_id) REFERENCES SCHEDULE (schedule_id)
 );

-- 14 
CREATE TABLE IF NOT EXISTS GROUP_HAS_STUDENT (
	group_id INTEGER REFERENCES GRUP (group_id) ON DELETE CASCADE,
	student_id INTEGER REFERENCES STUDENT (student_id) ON DELETE CASCADE,
	PRIMARY KEY (student_id, group_id)
);

-- 15 
CREATE TABLE IF NOT EXISTS TEACHER_SUBJECT (
	teacher_id INTEGER REFERENCES TEACHER (teacher_id) ON DELETE CASCADE,
	subject_id INTEGER REFERENCES SUBJECTS (subject_id) ON DELETE CASCADE,
	PRIMARY KEY (teacher_id, subject_id)
);