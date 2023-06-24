insert into user_details(id, birth_date, name)
values (10001, current_date(), 'Ali');

insert into post(id, description, user_id)
values (20001, 'I want to learn system design', 10001)