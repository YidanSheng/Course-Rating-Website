CREATE TABLE OOAD.teach
(
    teach_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    course_id int(11) NOT NULL,
    professor_name varchar(50) NOT NULL,
    professor_link varchar(1000) NOT NULL
);
CREATE UNIQUE INDEX teach_teach_id_uindex ON OOAD.teach (teach_id);
INSERT INTO OOAD.teach (teach_id, course_id, professor_name, professor_link) VALUES (1, 1, 'Mehra Nouroz Borazjany', 'https://www.utdallas.edu');
INSERT INTO OOAD.teach (teach_id, course_id, professor_name, professor_link) VALUES (2, 2, 'Cuneyt Akcora', 'https://www.utdallas.edu');
INSERT INTO OOAD.teach (teach_id, course_id, professor_name, professor_link) VALUES (3, 2, 'William Semper
', 'https://www.utdallas.edu');
INSERT INTO OOAD.teach (teach_id, course_id, professor_name, professor_link) VALUES (4, 6, 'Nargar', 'https://www.utdallas.edu');
INSERT INTO OOAD.teach (teach_id, course_id, professor_name, professor_link) VALUES (5, 4, 'Nurcan Yuruk', 'https://www.utdallas.edu');
INSERT INTO OOAD.teach (teach_id, course_id, professor_name, professor_link) VALUES (6, 5, 'Dan Moldovan', 'https://www.utdallas.edu');
INSERT INTO OOAD.teach (teach_id, course_id, professor_name, professor_link) VALUES (7, 7, 'Cong Liu', 'https://www.utdallas.edu');