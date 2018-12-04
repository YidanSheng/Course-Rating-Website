CREATE TABLE OOAD.course
(
    course_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    course_name varchar(50) NOT NULL,
    course_number varchar(20) NOT NULL,
    description varchar(200),
    track varchar(30),
    comment_number mediumtext NOT NULL
);
CREATE UNIQUE INDEX course_course_id_uindex ON OOAD.course (course_id);
CREATE UNIQUE INDEX course_course_name_uindex ON OOAD.course (course_name);
CREATE UNIQUE INDEX course_course_number_uindex ON OOAD.course (course_number);
INSERT INTO OOAD.course (course_id, course_name, course_number, description, track, comment_number) VALUES (1, 'Object-Oriented Analysis and Design', '6359', ':)', '', '2');
INSERT INTO OOAD.course (course_id, course_name, course_number, description, track, comment_number) VALUES (2, 'Statistical Methods for Data Science', '6313', ' Statistical methods for data science. ', 'DS', '2');
INSERT INTO OOAD.course (course_id, course_name, course_number, description, track, comment_number) VALUES (4, 'Web Programming Languages', '6314', 'Advanced understanding of web architecture, standards, protocols, tools, and technologies.', '', '1');
INSERT INTO OOAD.course (course_id, course_name, course_number, description, track, comment_number) VALUES (5, 'Natural Language Processing', '6320', 'This course covers state-of-the-art methods for natural language processing. ', 'IS', '0');
INSERT INTO OOAD.course (course_id, course_name, course_number, description, track, comment_number) VALUES (6, 'Big Data Management and Analytics', '6350', 'This course focuses on scalable data management and mining algorithms for analyzing very large amounts of data.', 'DS', '1');
INSERT INTO OOAD.course (course_id, course_name, course_number, description, track, comment_number) VALUES (7, 'Real-Time Systems', '6395', 'Introduction to real-time applications and concepts. Real-time operating systems and resource management.', 'SYS', '0');