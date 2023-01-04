create database `quan_li_sinh_vien`;
use quan_li_sinh_vien;
create table `class`(
id int not null,
`name` varchar(40) not null,
primary key(id)
);
create table `Teacher`(
id int primary key not null,
`name` varchar(40) not null,
age int not null,
country varchar(45)
);