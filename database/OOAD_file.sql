CREATE TABLE OOAD.file
(
    file_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    path varchar(200),
    create_time datetime DEFAULT '1970-01-01 00:00:00' NOT NULL,
    comment_id int(11)
);
CREATE UNIQUE INDEX file_file_id_uindex ON OOAD.file (file_id);
CREATE UNIQUE INDEX file_name_uindex ON OOAD.file (name);
INSERT INTO OOAD.file (file_id, name, path, create_time, comment_id) VALUES (1, 'slides', null, '2018-09-26 19:53:38', 1);
INSERT INTO OOAD.file (file_id, name, path, create_time, comment_id) VALUES (2, 'answers', null, '2018-09-26 20:06:58', 1);
INSERT INTO OOAD.file (file_id, name, path, create_time, comment_id) VALUES (3, 'books-1', null, '2018-10-01 04:40:51', 3);
INSERT INTO OOAD.file (file_id, name, path, create_time, comment_id) VALUES (4, 'books-2', null, '2018-06-22 07:37:53', 3);