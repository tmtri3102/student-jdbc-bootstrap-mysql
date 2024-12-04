create database student_management;
use student_management;
select * from student;

create table Class (
	id int auto_increment primary key,
    name varchar(50)
);

insert into class (name) values
	('Java Fullstack'),
    ('Java Part-time'),
    ('PHP Online');

create table Student (
	id int auto_increment primary key,
    name varchar(20),
    class_id int,
    foreign key (class_id) references Class (id)
);

insert into student (name, class_id) values
	('Ada', 1),
	('James', 2),
	('Tim', 3),
	('John', 1);
    
    
    
delimiter $
create procedure list_students()
begin
	select * from student;
end $
delimiter ;



delimiter $
create procedure add_student(
    in in_name varchar(20),
    in in_class_id int
)
begin
	insert into student (name, class_id) values
		(in_name, in_class_id);
end $
delimiter ;




delimiter $
create procedure update_student(
	in in_id int,
	in in_name varchar(20),
    in in_class_id int
)
begin
	update student
    set 
		name = in_name,
        class_id = in_class_id
	where id = in_id;
end $
delimiter ;





delimiter $
create procedure delete_student (in in_id int)
begin
	delete from student
    where id = in_id;
end $
delimiter ;





delimiter $
create procedure find_student (in in_id int)
begin
	select name, class_id 
    from student
    where id = in_id;
end $
delimiter ;





delimiter $
create procedure list_classes ()
begin
	select * from class;
end $
delimiter ;














