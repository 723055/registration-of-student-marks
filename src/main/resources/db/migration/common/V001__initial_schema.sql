CREATE SEQUENCE student_id_seq;

CREATE TABLE STUDENT(
  id                      BIGINT         NOT NULL,
  name                    VARCHAR(255) NOT NULL,
  phone                   NUMBER          NOT NULL,
  email                   VARCHAR(255) NOT NULL,
  courseList              VARCHAR(255)  NULL,

    ADD CONSTRAINT STUDENT_ID_PK PRIMARY KEY (id);
);
--
--ALTER TABLE STUDENT

CREATE SEQUENCE course_id_seq;

CREATE TABLE COURSE(
  id                      BIGINT            NOT NULL,
  name                    VARCHAR(255)      NOT NULL,
  dateStart               VARCHAR(255)      NOT NULL,
  dateFinish              VARCHAR(255)      NOT NULL,
  courseList              VARCHAR(255)      NULL,
lengthCourse              BIGINT            NOT NULL,
numberOfStudents          BIGINT             NULL,

    ADD CONSTRAINT COURSE_ID_PK PRIMARY KEY (id);
);