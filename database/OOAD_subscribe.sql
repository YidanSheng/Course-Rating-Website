create table subscribe
(
  course_id int         not null,
  user_id   int         not null,
  username  varchar(20) not null,
  primary key (course_id, user_id)
);