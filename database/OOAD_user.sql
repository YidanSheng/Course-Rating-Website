CREATE TABLE OOAD.user
(
    user_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username varchar(20) NOT NULL,
    password varchar(20) NOT NULL,
    email varchar(30) NOT NULL,
    role int(11) NOT NULL
);
CREATE UNIQUE INDEX user_user_id_uindex ON OOAD.user (user_id);
CREATE UNIQUE INDEX user_username_uindex ON OOAD.user (username);
CREATE UNIQUE INDEX user_email_uindex ON OOAD.user (email);
INSERT INTO OOAD.user (user_id, username, password, email, role) VALUES (1, 'gaozheng', '111111', 'zxg170430@utdallas.edu', 1);
INSERT INTO OOAD.user (user_id, username, password, email, role) VALUES (2, 'xiaohuang', '111111', 'zzz@utdallas.edu', 0);
INSERT INTO OOAD.user (user_id, username, password, email, role) VALUES (3, 'aaa', '111111', 'dfsdxz@utdallas.edu', 0);
INSERT INTO OOAD.user (user_id, username, password, email, role) VALUES (8, 'gaozheng11', '1111111111', '2222222@utdallas.edu', 0);
INSERT INTO OOAD.user (user_id, username, password, email, role) VALUES (9, 'gaozheng222', '11111111', 'zhjsd@utdallas.edu', 0);
INSERT INTO OOAD.user (user_id, username, password, email, role) VALUES (10, 'gaozheng11111', '11111111', '22zzz@utdallas.edu', 0);
INSERT INTO OOAD.user (user_id, username, password, email, role) VALUES (11, 'ggggggg', '00000000', '2344442@utdallas.edu', 0);
INSERT INTO OOAD.user (user_id, username, password, email, role) VALUES (12, 'abc', '11111111', 'jsdkfs@utdallas.edu', 0);
INSERT INTO OOAD.user (user_id, username, password, email, role) VALUES (13, 'Tianrou', '88888888', 'txc123344@utdallas.edu', 1);
INSERT INTO OOAD.user (user_id, username, password, email, role) VALUES (14, 'LittleSheep', '11223344', 'lxs@utdallas.edu', 0);
INSERT INTO OOAD.user (user_id, username, password, email, role) VALUES (15, 'Hai', '11111111', 'dsfg@utdallas.edu', 0);
INSERT INTO OOAD.user (user_id, username, password, email, role) VALUES (16, 'testme', '111111', 'dsf@utdallas.edu', 0);