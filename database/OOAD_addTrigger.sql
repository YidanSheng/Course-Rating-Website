DELIMITER //
DROP TRIGGER IF EXISTS check_new_comment;
create trigger check_new_comment
  after INSERT
  on comment
  for each row
  begin
    insert ignore into notification (course_id, user_id)
    SELECT course_id, user_id
    from subscribe where course_id = NEW.course_id;
  end//
  
  
DELIMITER //

DROP TRIGGER IF EXISTS delete_notification;
create trigger delete_notification
  after DELETE
  on subscribe
  for each row
  begin
    delete
    from notification
    where OLD.user_id = notification.user_id
      and OLD.course_id = notification.course_id;
  end//
  
  