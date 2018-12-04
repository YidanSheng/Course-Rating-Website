create table notification
(
  course_id int not null,
  user_id   int not null,
  constraint course_id
  unique (course_id, user_id)
);

alter table notification
  add primary key (course_id, user_id);