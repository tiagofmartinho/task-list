CREATE DATABASE IF NOT EXISTS test;
USE test;
create table if not exists task
(
	id int auto_increment,
	description varchar(50) not null,
	constraint task_pk
		primary key (id)
);